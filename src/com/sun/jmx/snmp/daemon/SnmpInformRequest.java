/*
 *
 * Copyright (c) 2007, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
// Copyright (c) 1995-96 by Cisco Systems, Inc.

package com.sun.jmx.snmp.daemon;

// JAVA imports
//
import java.net.InetAddress;
import java.util.Date;
import java.util.logging.Level;

// JMX imports
//
import static com.sun.jmx.defaults.JmxProperties.SNMP_ADAPTOR_LOGGER;
import com.sun.jmx.snmp.SnmpMessage;
import com.sun.jmx.snmp.SnmpVarBind;
import com.sun.jmx.snmp.SnmpPduFactory;
import com.sun.jmx.snmp.SnmpPduPacket;
import com.sun.jmx.snmp.SnmpPduRequest;
import com.sun.jmx.snmp.SnmpDefinitions;
import com.sun.jmx.snmp.SnmpStatusException;
import com.sun.jmx.snmp.SnmpTooBigException;
import com.sun.jmx.snmp.SnmpVarBindList;
import com.sun.jmx.snmp.SnmpPdu;
import com.sun.jmx.snmp.SnmpPduRequestType;

/**
 * This class is used by the {@link com.sun.jmx.snmp.daemon.SnmpAdaptorServer SNMP adaptor server} to send inform requests
 * to an SNMP manager and receive inform responses.
 * <P>
 * This class provides basic functions that enable you to fire inform requests,
 * handle retries, timeouts, and process responses from the manager.
 * <BR>
 * The SNMP adaptor server specifies the destination of the inform request and controls
 * the size of a single inform request/response to fit into its <CODE>bufferSize</CODE>.
 * It specifies the maximum number of tries and the timeout to be used for the inform requests.
 * It also provides resources such as the authentication mechanism (using its PDU factory),
 * controlling all inform requests created by it, and finally the inform response to the user.
 * <P>
 * Each inform request, when ready to be sent, is assigned a unique identifier which helps
 * in identifying the inform request with matching inform responses to the protocol engine
 * lying transparently underneath. The engine does the job of retrying the inform requests
 * when the timer expires and calls the SNMP adaptor server when a timeout occurs after exhausting
 * the maximum number of tries.
 * <P>
 * The inform request object provides the method, {@link #waitForCompletion waitForCompletion(long time)},
 * which enables a user to operate in a synchronous mode with an inform request.
 * This is done by blocking the user thread for the desired time interval.
 * The user thread gets notified whenever a request reaches completion, independently of the status of the response.
 * <P>
 * If an {@link com.sun.jmx.snmp.daemon.SnmpInformHandler inform callback} is provided when sending the inform request,
 * the user operates in an asynchronous mode with the inform request. The user thread is not blocked
 * and the specific inform callback implementation provided by the user is invoked when the inform response is received.
 *
 * <P>
 * <B>Note:</B>
 * <BR>From RFC 1905, the SNMP inform request is defined as a request generated and transmitted
 * by an SNMPv2 entity acting in a manager role to another SNMPv2 entity also acting in a manager role.
 * The mechanisms to implement this behaviour are defined in the SNMP manager API.
 * <BR>
 * Nevertheless, this feature has derived and in some documentations, the inform request appears
 * like an SNMPv2 trap that gets responded.
 * <BR>The <CODE>SnmpInformRequest</CODE> class is used to fullfill this latter case.
 * <p><b>This API is a Sun Microsystems internal API  and is subject
 * to change without notice.</b></p>
 */

public class SnmpInformRequest implements SnmpDefinitions {

    // VARIABLES
    //----------

    /**
     * This object maintains a global counter for the inform request ID.
     */
    private static SnmpRequestCounter requestCounter = new SnmpRequestCounter();

    /**
     * This contains a list of <CODE>SnmpVarBind</CODE> objects for making the SNMP inform requests.
     */
    private SnmpVarBindList varBindList = null;

    /**
     * The error status associated with the inform response packet.
     */
    int errorStatus = 0;

    /**
     * The index in <CODE>SnmpVarBindList</CODE> that caused the exception.
     */
    int errorIndex = 0;

    //private SnmpVarBind internalVarBind[] = null;
    SnmpVarBind internalVarBind[] = null;

    //private String reason = null;
    String reason = null;

    /**
     * The SNMP adaptor associated with this inform request.
     */
    private transient SnmpAdaptorServer adaptor;

    /**
     * The session object associated with this inform request.
     */
    private transient SnmpSession informSession;

    /**
     * The user implementation of the callback interface for this request.
     */
    private SnmpInformHandler callback = null;

    /**
     * The inform request PDU.
     */
    //private SnmpPduPacket requestPdu;
    SnmpPdu requestPdu;

    /**
     * The inform response PDU.
     */
    //private SnmpPduRequest responsePdu;
    SnmpPduRequestType responsePdu;

    /**
     * Base status of an inform request.
     */
    final static private int stBase             = 1;

    /**
     * Status of an inform request: in progress.
     */
    final static public int stInProgress                = stBase;

    /**
     * Status of an inform request: waiting to be sent.
     */
    final static public int stWaitingToSend     = (stBase << 1) | stInProgress;

    /**
     * Status of an inform request: waiting for reply.
     */
    final static public int stWaitingForReply   = (stBase << 2) | stInProgress;

    /**
     * Status of an inform request: reply received.
     */
    final static public int stReceivedReply     = (stBase << 3) | stInProgress;

    /**
     * Status of an inform request: request aborted.
     */
    final static public int stAborted                   = (stBase << 4);

    /**
     * Status of an inform request: timeout.
     */
    final static public int stTimeout                   = (stBase << 5);

    /**
     * Status of an inform request: internal error occured.
     */
    final static public int stInternalError     = (stBase << 6);

    /**
     * Status of an inform request: result available for the request.
     */
    final static public int stResultsAvailable  = (stBase << 7);

    /**
     * Status of an inform request: request never used.
     */
    final static public int stNeverUsed                 = (stBase << 8);

    /**
     * Number of tries performed for the current polling operation.
     */
    private int numTries = 0;

    /**
     * Timeout.
     * The default amount of time is 3000 millisec.
     */
    private int timeout = 3 * 1000; // 3 seconds.

    /**
     */
    private int reqState = stNeverUsed;

    // Polling control parameters.
    private long  prevPollTime = 0;     // value of 0 means poll never happened.
    private long  nextPollTime = 0;
    private long  waitTimeForResponse;
    private Date debugDate = new Date();

    /**
     * The request ID for an active inform request.
     */
    private int requestId = 0;

    private int port = 0;

    private InetAddress address = null;
    private String communityString = null;

    // CONSTRUCTORS
    //-------------

    /**
     * For SNMP Runtime internal use only.
     * Constructor for creating new inform request. This object can be created only by an SNMP adaptor object.
     * @param session <CODE>SnmpSession</CODE> object for this inform request.
     * @param adp <CODE>SnmpAdaptorServer</CODE> object for this inform request.
     * @param addr The <CODE>InetAddress</CODE> destination for this inform request.
     * @param cs The community string to be used for the inform request.
     * @param requestCB Callback interface for the inform request.
     * @exception SnmpStatusException SNMP adaptor is not ONLINE or session is dead.
     */
    SnmpInformRequest(SnmpSession session,
                      SnmpAdaptorServer adp,
                      InetAddress addr,
                      String cs,
                      int p,
                      SnmpInformHandler requestCB)
        throws SnmpStatusException {

        informSession = session;
        adaptor = adp;
        address = addr;
        communityString = cs;
        port = p;
        callback = requestCB;
        informSession.addInformRequest(this);  // add to adaptor queue.
        setTimeout(adaptor.getTimeout()) ;
    }

    // PUBLIC METHODS
    //---------------

    /**
     * Gets the request id (invoke identifier) of the current inform request.
     * @return The request id.
     */
    final public synchronized int getRequestId () {
        return requestId;
    }

    /**
     * Gets the destination address of the current inform request.
     * @return The destination address.
     */
    synchronized InetAddress getAddress() {
        return address;
    }

    /**
     * Gets the current status of the inform request.
     * @return The current status of the inform request.
     */
    final public synchronized int getRequestStatus() {
        return reqState ;
    }

    /**
     * Indicates whether or not the inform request was aborted.
     * @return <CODE>true</CODE> if the inform request was aborted, <CODE>false</CODE> otherwise.
     */
    final public synchronized boolean isAborted() {
        return ((reqState & stAborted) == stAborted);
    }

    /**
     * Indicates whether or not the inform request is in progress.
     * @return <CODE>true</CODE> if the inform request is in progress, <CODE>false</CODE> otherwise.
     */
    final public synchronized boolean inProgress() {
        return ((reqState & stInProgress) == stInProgress);
    }

    /**
     * Indicates whether or not the inform request result is available.
     * @return <CODE>true</CODE> if the inform request result is available, <CODE>false</CODE> otherwise.
     */
    final public synchronized boolean isResultAvailable() {
        return (reqState == stResultsAvailable);
    }

    /**
     * Gets the status associated with the <CODE>SnmpVarBindList</CODE>.
     * @return The error status.
     */
    final public synchronized int getErrorStatus() {
        return errorStatus;
    }

    /**
     * Gets the index.
     * <P>NOTE: this value is equal to the <CODE>errorIndex</CODE> field minus 1.
     * @return The error index.
     */
    final public synchronized int getErrorIndex() {
        return errorIndex;
    }

    /**
     * Gets the maximum number of tries before declaring that the manager is not responding.
     * @return The maximum number of times an inform request should be tried.
     */
    final public int getMaxTries() {
        return adaptor.getMaxTries();
    }

    /**
     * Gets the number of tries performed for the current inform request.
     * @return The number of tries performed.
     */
    final public synchronized int getNumTries() {
        return numTries ;
    }

    /**
     * For SNMP Runtime internal use only.
     */
    final synchronized void setTimeout(int value) {
        timeout = value ;
    }

    /**
     * Gets absolute time in milliseconds (based on epoch time) when the next
     * polling activity will begin.
     * @return The absolute time when polling will begin.
     */
    final public synchronized long getAbsNextPollTime () {
        return nextPollTime ;
    }

    /**
     * Gets absolute time in milliseconds (based on epoch time) before which an inform
     * response is expected from a manager.
     * @return The absolute time within which an inform response is expected.
     */
    final public synchronized long getAbsMaxTimeToWait() {
        if (prevPollTime == 0) {
            return System.currentTimeMillis() ;  // should never happen.
        } else {
            return waitTimeForResponse ;
        }
    }

    /**
     * Gets the <CODE>SnmpVarBindList</CODE> of the inform response.
     * It returns a null value if the inform request is in progress.
     * This ensures accidental manipulation does not occur when a request is in progress.
     * In case of an error, <CODE>SnmpVarBindList</CODE> is the copy
     * of the original <CODE>SnmpVarBindList</CODE> at the time of making the inform request.
     * @return The list of <CODE>SnmpVarBind</CODE> objects returned by the manager or the null value if the request
     * is in progress.
     */
    public final synchronized SnmpVarBindList getResponseVarBindList() {
        if (inProgress())
            return null;
        return varBindList;
    }

    /**
     * Used in synchronous mode only.
     * Provides a hook that enables a synchronous operation on a previously sent inform request.
     * Only one inform request can be in synchronous mode on a given thread.
     * The blocked thread is notified when the inform request state reaches completion.
     * If the inform request is not active, the method returns immediately.
     * The user must get the error status of the inform request to determine the
     * exact status of the request.
     *
     * @param time The amount of time to wait. Zero means block until complete.
     * @return <CODE>true</CODE> if the inform request has completed, <CODE>false</CODE> if it is still active.
     */
    final public boolean waitForCompletion(long time) {

        if (! inProgress())     // check if request is in progress.
            return true;

        if (informSession.thisSessionContext()) {
            // We can manipulate callback safely as we are in session thread.
            //
            SnmpInformHandler savedCallback = callback;
            callback = null;
            informSession.waitForResponse(this, time);
            callback = savedCallback;
        } else {
            // This is being done from a different thread. So notifyClient will do the notification.
            //
            synchronized (this) {
                SnmpInformHandler savedCallback = callback ;
                try {
                    callback = null ;
                    this.wait(time) ;
                } catch (InterruptedException e) {
                }
                callback = savedCallback ;
            }
        }

        return (! inProgress()); // true if request completed.
    }

    /**
     * Cancels the active inform request and removes itself from the polling list.
     */
    final public void cancelRequest() {
        errorStatus = snmpReqAborted;
        stopRequest();
        deleteRequest();
        notifyClient();
    }

    /**
     * Notifies the registered client about the completion of an operation.
     */
    final public synchronized void notifyClient() {
        this.notifyAll();
    }

    /**
     * Finalizer of the <CODE>SnmpInformRequest</CODE> objects.
     * This method is called by the garbage collector on an object
     * when garbage collection determines that there are no more references to the object.
     * <P>Sets all the references to this SNMP inform request object to <CODE>null</CODE>.
     */
    @Override
    protected void finalize() {
        callback = null;
        varBindList = null;
        internalVarBind = null;
        adaptor = null;
        informSession = null;
        requestPdu = null;
        responsePdu = null;
    }

    /**
     * Returns the <CODE>String</CODE> representation of an error code.
     * @param errcode The error code as an integer.
     * @return The error code as a <CODE>String</CODE>.
     */
    public static String snmpErrorToString(int errcode) {
        switch (errcode) {
        case snmpRspNoError :
            return "noError" ;
        case snmpRspTooBig :
            return "tooBig" ;
        case snmpRspNoSuchName :
            return "noSuchName" ;
        case snmpRspBadValue :
            return "badValue" ;
        case snmpRspReadOnly :
            return "readOnly" ;
        case snmpRspGenErr :
            return "genErr" ;
        case snmpRspNoAccess :
            return "noAccess" ;
        case snmpRspWrongType :
            return "wrongType" ;
        case snmpRspWrongLength :
            return "wrongLength" ;
        case snmpRspWrongEncoding :
            return "wrongEncoding" ;
        case snmpRspWrongValue :
            return "wrongValue" ;
        case snmpRspNoCreation :
            return "noCreation" ;
        case snmpRspInconsistentValue :
            return "inconsistentValue" ;
        case snmpRspResourceUnavailable :
            return "resourceUnavailable" ;
        case snmpRspCommitFailed :
            return "commitFailed" ;
        case snmpRspUndoFailed :
            return "undoFailed" ;
        case snmpRspAuthorizationError :
            return "authorizationError" ;
        case snmpRspNotWritable :
            return "notWritable" ;
        case snmpRspInconsistentName :
            return "inconsistentName" ;
        case snmpReqTimeout :
            return "reqTimeout" ;
        case snmpReqAborted :
            return "reqAborted" ;
        case snmpRspDecodingError :
            return "rspDecodingError" ;
        case snmpReqEncodingError :
            return "reqEncodingError" ;
        case snmpReqPacketOverflow :
            return "reqPacketOverflow" ;
        case snmpRspEndOfTable :
            return "rspEndOfTable" ;
        case snmpReqRefireAfterVbFix :
            return "reqRefireAfterVbFix" ;
        case snmpReqHandleTooBig :
            return "reqHandleTooBig" ;
        case snmpReqTooBigImpossible :
            return "reqTooBigImpossible" ;
        case snmpReqInternalError :
            return "reqInternalError" ;
        case snmpReqSocketIOError :
            return "reqSocketIOError" ;
        case snmpReqUnknownError :
            return "reqUnknownError" ;
        case snmpWrongSnmpVersion :
            return "wrongSnmpVersion" ;
        case snmpUnknownPrincipal:
            return "snmpUnknownPrincipal";
        case snmpAuthNotSupported:
            return "snmpAuthNotSupported";
        case snmpPrivNotSupported:
            return "snmpPrivNotSupported";
        case snmpBadSecurityLevel:
            return "snmpBadSecurityLevel";
        case snmpUsmBadEngineId:
            return "snmpUsmBadEngineId";
        case snmpUsmInvalidTimeliness:
            return "snmpUsmInvalidTimeliness";
        }
        return "Unknown Error = " + errcode;
    }

    // PRIVATE AND PACKAGE METHODS
    //----------------------------

    /**
     * For SNMP Runtime internal use only.
     * Starts an inform request in asynchronous mode. The callback interface
     * is used to notify the user upon request completion.
     * @param vblst The list of <CODE>SnmpVarBind</CODE> to be used.
     * @exception SnmpStatusException This inform request is already in progress.
     */
    synchronized void start(SnmpVarBindList vblst) throws SnmpStatusException {
        if (inProgress())
            throw  new SnmpStatusException("Inform request already in progress.");
        setVarBindList(vblst);
        initializeAndFire();
    }

    private synchronized void initializeAndFire() {
        requestPdu = null;
        responsePdu = null;
        reason = null;
        startRequest(System.currentTimeMillis());
        setErrorStatusAndIndex(0, 0);
    }

    /**
     * This method submits the inform request for polling and marks the request
     * active. It does nothing if the request is already active.
     * The poll will be scheduled to happen immediately.
     * @param starttime The start time for polling.
     */
    private synchronized void startRequest(long starttime) {
        nextPollTime = starttime;
        prevPollTime = 0;
        schedulePoll();
    }

    /**
     * This method creates a new request ID. The ID is submitted to the poll server for scheduling.
     */
    private void schedulePoll() {
        numTries = 0;
        initNewRequest();
        setRequestStatus(stWaitingToSend);
        informSession.getSnmpQManager().addRequest(this);
    }

    /**
     * This method determines whether the inform request is to be retried. This is used if the
     * peer did not respond to a previous request. If the request exceeds
     * the maxTries limit, a timeout is signaled.
     */
    void action() {
        if (inProgress() == false)
            return;
        while (true) {
            try {
                if (numTries == 0) {
                    invokeOnReady();
                } else if (numTries < getMaxTries()) {
                    invokeOnRetry();
                } else {
                    invokeOnTimeout();
                }
                return ;
            } catch (OutOfMemoryError omerr) {
                // Consider it as a try !
                //
                numTries++;
                if (SNMP_ADAPTOR_LOGGER.isLoggable(Level.FINEST)) {
                    SNMP_ADAPTOR_LOGGER.logp(Level.FINEST, SnmpInformRequest.class.getName(),
                        "action", "Inform request hit out of memory situation...");
                }
                Thread.yield();
            }
        }
    }

    private void invokeOnReady() {
        if (requestPdu == null) {
            requestPdu = constructPduPacket();
        }
        if (requestPdu != null) {
            if (sendPdu() == false)
                queueResponse();
        }
    }

    private void invokeOnRetry() {
        invokeOnReady();
    }

    private void invokeOnTimeout() {
        errorStatus = snmpReqTimeout;
        queueResponse();
    }

    private void queueResponse() {
        informSession.addResponse(this);
    }

    /**
     * Constructs an inform request PDU.
     */
    synchronized SnmpPdu constructPduPacket() {
        SnmpPduPacket reqpdu = null;
        Exception excep = null;
        try {
            reqpdu = new SnmpPduRequest();
            reqpdu.port = port;
            reqpdu.type = pduInformRequestPdu;
            reqpdu.version = snmpVersionTwo;
            reqpdu.community = communityString.getBytes("8859_1");
            reqpdu.requestId = getRequestId();
            reqpdu.varBindList = internalVarBind;

            if (SNMP_ADAPTOR_LOGGER.isLoggable(Level.FINER)) {
                SNMP_ADAPTOR_LOGGER.logp(Level.FINER, SnmpInformRequest.class.getName(),
                    "constructPduPacket", "Packet built");
            }

        } catch (Exception e) {
            excep = e;
            errorStatus = snmpReqUnknownError;
            reason = e.getMessage();
        }
        if (excep != null) {
            if (SNMP_ADAPTOR_LOGGER.isLoggable(Level.FINEST)) {
                SNMP_ADAPTOR_LOGGER.logp(Level.FINEST, SnmpInformRequest.class.getName(),
                    "constructPduPacket", "Got unexpected exception", excep);
            }
            reqpdu = null;
            queueResponse();
        }
        return reqpdu;
    }

    boolean sendPdu() {
        try {
            responsePdu = null;

            SnmpPduFactory pduFactory = adaptor.getPduFactory();
            SnmpMessage msg = (SnmpMessage)pduFactory.encodeSnmpPdu((SnmpPduPacket)requestPdu, adaptor.getBufferSize().intValue());

            if (msg == null) {
                if (SNMP_ADAPTOR_LOGGER.isLoggable(Level.FINEST)) {
                    SNMP_ADAPTOR_LOGGER.logp(Level.FINEST, SnmpInformRequest.class.getName(),
                        "sendPdu", "pdu factory returned a null value");
                }
                throw new SnmpStatusException(snmpReqUnknownError);
                // This exception will caught hereafter and reported as an snmpReqUnknownError
                // FIXME: may be it's not the best behaviour ?
            }

            int maxPktSize = adaptor.getBufferSize().intValue();
            byte[] encoding = new byte[maxPktSize];
            int encodingLength = msg.encodeMessage(encoding);

            if (SNMP_ADAPTOR_LOGGER.isLoggable(Level.FINER)) {
                SNMP_ADAPTOR_LOGGER.logp(Level.FINER, SnmpInformRequest.class.getName(),
                    "sendPdu", "Dump : \n" + msg.printMessage());
            }

            sendPduPacket(encoding, encodingLength);
            return true;
        } catch (SnmpTooBigException ar) {

            if (SNMP_ADAPTOR_LOGGER.isLoggable(Level.FINEST)) {
                SNMP_ADAPTOR_LOGGER.logp(Level.FINEST, SnmpInformRequest.class.getName(),
                    "sendPdu", "Got unexpected exception", ar);
            }

            setErrorStatusAndIndex(snmpReqPacketOverflow, ar.getVarBindCount());
            requestPdu = null;
            reason = ar.getMessage();
            if (SNMP_ADAPTOR_LOGGER.isLoggable(Level.FINEST)) {
                SNMP_ADAPTOR_LOGGER.logp(Level.FINEST, SnmpInformRequest.class.getName(),
                    "sendPdu", "Packet Overflow while building inform request");
            }
        } catch (java.io.IOException ioe) {
            setErrorStatusAndIndex(snmpReqSocketIOError, 0);
            reason = ioe.getMessage();
        } catch (Exception e) {
            if (SNMP_ADAPTOR_LOGGER.isLoggable(Level.FINEST)) {
                SNMP_ADAPTOR_LOGGER.logp(Level.FINEST, SnmpInformRequest.class.getName(),
                    "sendPdu", "Got unexpected exception", e);
            }
            setErrorStatusAndIndex(snmpReqUnknownError, 0);
            reason = e.getMessage();
        }
        return false;
    }

    /**
     * Sends the prepared PDU packet to the manager and updates the data structure
     * to expect a response. It acquires a lock on the socket to prevent a case
     * where a response arrives before this thread could insert the
     * request into the wait queue.
     * @exception IOException Signals that an I/O exception of some sort has occurred.
     */
    final void sendPduPacket(byte[] buffer, int length) throws java.io.IOException {

        if (SNMP_ADAPTOR_LOGGER.isLoggable(Level.FINER)) {
            SNMP_ADAPTOR_LOGGER.logp(Level.FINER, SnmpInformRequest.class.getName(),
                "sendPduPacket", "Send to peer. Peer/Port : " + address.getHostName() +
                 "/" + port + ". Length = " +  length + "\nDump : \n" +
                 SnmpMessage.dumpHexBuffer(buffer,0, length));
        }
        SnmpSocket theSocket = informSession.getSocket();
        synchronized (theSocket) {
            theSocket.sendPacket(buffer, length, address, port);
            setRequestSentTime(System.currentTimeMillis());
        }
    }

    /**
     * For SNMP Runtime internal use only.
     */
    final void processResponse() {

        if (SNMP_ADAPTOR_LOGGER.isLoggable(Level.FINER)) {
            SNMP_ADAPTOR_LOGGER.logp(Level.FINER, SnmpInformRequest.class.getName(),
                "processResponse", "errstatus = " + errorStatus);
        }

        if (inProgress() == false) {  // check if this request is still alive.
            responsePdu = null;
            return;  // the request may have  cancelled.
        }

        if (errorStatus >= snmpReqInternalError) {
            handleInternalError("Internal Error...");
            return;
        }

        try {
            parsePduPacket(responsePdu);
            //responsePdu = null;

            // At this point the errorIndex is rationalized to start with 0.
            switch (errorStatus) {
            case snmpRspNoError :
                handleSuccess();
                return;
            case snmpReqTimeout :
                handleTimeout();
                return;
            case snmpReqInternalError :
                handleInternalError("Unknown internal error.  deal with it later!");
                return;
            case snmpReqHandleTooBig :
                setErrorStatusAndIndex(snmpRspTooBig, 0);
                handleError("Cannot handle too-big situation...");
                return;
            case snmpReqRefireAfterVbFix :
                // Refire request after fixing varbindlist.
                initializeAndFire();
                return;
            default :
                handleError("Error status set in packet...!!");
                return;
            }
        } catch (Exception e) {
            if (SNMP_ADAPTOR_LOGGER.isLoggable(Level.FINEST)) {
                SNMP_ADAPTOR_LOGGER.logp(Level.FINEST, SnmpInformRequest.class.getName(),
                    "processResponse", "Got unexpected exception", e);
            }
            reason = e.getMessage();
        }
        handleInternalError(reason);
    }

    /**
     * Parses the inform response packet. If the agent responds with error set,
     * it does not parse any further.
     */
    synchronized void parsePduPacket(SnmpPduRequestType rpdu) {

        if (rpdu == null)
            return;

        errorStatus = rpdu.getErrorStatus();
        errorIndex = rpdu.getErrorIndex();

        if (errorStatus == snmpRspNoError) {
            updateInternalVarBindWithResult(((SnmpPdu)rpdu).varBindList);
            return;
        }

        if (errorStatus != snmpRspNoError)
            --errorIndex;  // rationalize for index to start with 0.

        if (SNMP_ADAPTOR_LOGGER.isLoggable(Level.FINER)) {
            SNMP_ADAPTOR_LOGGER.logp(Level.FINER, SnmpInformRequest.class.getName(),
                "parsePduPacket", "received inform response. ErrorStatus/ErrorIndex = "
                + errorStatus + "/" + errorIndex);
        }
    }

    /**
     * Calls the user implementation of the <CODE>SnmpInformHandler</CODE> interface.
     */
    private void handleSuccess() {

        setRequestStatus(stResultsAvailable);

        if (SNMP_ADAPTOR_LOGGER.isLoggable(Level.FINER)) {
            SNMP_ADAPTOR_LOGGER.logp(Level.FINER, SnmpInformRequest.class.getName(),
                "handleSuccess", "Invoking user defined callback...");
        }

        deleteRequest();  // delete only non-poll request.
        notifyClient();

        requestPdu = null;
        //responsePdu = null;
        internalVarBind = null;

        try {  // catch all user exception which may happen in callback.
            if (callback != null)
                callback.processSnmpPollData(this, errorStatus, errorIndex, getVarBindList());
        } catch (Exception e) {
            if (SNMP_ADAPTOR_LOGGER.isLoggable(Level.FINEST)) {
                SNMP_ADAPTOR_LOGGER.logp(Level.FINEST, SnmpInformRequest.class.getName(),
                    "handleSuccess", "Exception generated by user callback", e);
            }
        } catch (OutOfMemoryError ome) {
            if (SNMP_ADAPTOR_LOGGER.isLoggable(Level.FINEST)) {
                SNMP_ADAPTOR_LOGGER.logp(Level.FINEST, SnmpInformRequest.class.getName(),
                    "handleSuccess", "OutOfMemory Error generated by user callback", ome);
            }
            Thread.yield();
        }
    }

    /**
     * Calls the user implementation of the <CODE>SnmpInformHandler</CODE> interface.
     */
    private void handleTimeout() {

        setRequestStatus(stTimeout);

        if (SNMP_ADAPTOR_LOGGER.isLoggable(Level.FINEST)) {
            SNMP_ADAPTOR_LOGGER.logp(Level.FINEST, SnmpInformRequest.class.getName(),
                "handleTimeout", "Snmp error/index = " + snmpErrorToString(errorStatus)
                 + "/" + errorIndex + ". Invoking timeout user defined callback...");
        }
        deleteRequest();
        notifyClient();

        requestPdu = null;
        responsePdu = null;
        internalVarBind = null;

        try {
            if (callback != null)
                callback.processSnmpPollTimeout(this);
        } catch (Exception e) {  // catch any exception a user might not handle.
            if (SNMP_ADAPTOR_LOGGER.isLoggable(Level.FINEST)) {
                SNMP_ADAPTOR_LOGGER.logp(Level.FINEST, SnmpInformRequest.class.getName(),
                    "handleTimeout", "Exception generated by user callback", e);
            }
        } catch (OutOfMemoryError ome) {
            if (SNMP_ADAPTOR_LOGGER.isLoggable(Level.FINEST)) {
                SNMP_ADAPTOR_LOGGER.logp(Level.FINEST, SnmpInformRequest.class.getName(),
                    "handleTimeout", "OutOfMemory Error generated by user callback", ome);
            }
            Thread.yield();
        }
    }

    /**
     * Calls the user implementation of the <CODE>SnmpInformHandler</CODE> interface.
     */
    private void handleError(String msg) {

        setRequestStatus(stResultsAvailable);

        if (SNMP_ADAPTOR_LOGGER.isLoggable(Level.FINEST)) {
            SNMP_ADAPTOR_LOGGER.logp(Level.FINEST, SnmpInformRequest.class.getName(),
                "handleError", "Snmp error/index = " + snmpErrorToString(errorStatus) + "/" +
                  errorIndex + ". Invoking error user defined callback...\n" + getVarBindList());
        }
        deleteRequest();
        notifyClient();

        requestPdu = null;
        responsePdu = null;
        internalVarBind = null;

        try {
            if (callback != null)
                callback.processSnmpPollData(this, getErrorStatus(), getErrorIndex(), getVarBindList());
        } catch (Exception e) {  // catch any exception a user might not handle.
            if (SNMP_ADAPTOR_LOGGER.isLoggable(Level.FINEST)) {
                SNMP_ADAPTOR_LOGGER.logp(Level.FINEST, SnmpInformRequest.class.getName(),
                    "handleError", "Exception generated by user callback", e);
            }
        } catch (OutOfMemoryError ome) {
            if (SNMP_ADAPTOR_LOGGER.isLoggable(Level.FINEST)) {
                SNMP_ADAPTOR_LOGGER.logp(Level.FINEST, SnmpInformRequest.class.getName(),
                    "handleError", "OutOfMemory Error generated by user callback", ome);
            }
            Thread.yield();
        }
    }

    /**
     * Calls the user implementation of the <CODE>SnmpInformHandler</CODE> interface.
     */
    private void handleInternalError(String msg) {

        setRequestStatus(stInternalError);
        if (reason == null)
            reason = msg;

        if (SNMP_ADAPTOR_LOGGER.isLoggable(Level.FINEST)) {
            SNMP_ADAPTOR_LOGGER.logp(Level.FINEST, SnmpInformRequest.class.getName(),
                "handleInternalError", "Snmp error/index = " + snmpErrorToString(errorStatus) +
                 "/" + errorIndex + ". Invoking internal error user defined callback...\n" +
                 getVarBindList());
        }

        deleteRequest();
        notifyClient();

        requestPdu = null;
        responsePdu = null;
        internalVarBind = null;

        try {
            if (callback != null)
                callback.processSnmpInternalError(this, reason);
        } catch (Exception e) {  // catch any exception a user might not handle.
            if (SNMP_ADAPTOR_LOGGER.isLoggable(Level.FINEST)) {
                SNMP_ADAPTOR_LOGGER.logp(Level.FINEST, SnmpInformRequest.class.getName(),
                    "handleInternalError", "Exception generated by user callback", e);
            }
        } catch (OutOfMemoryError ome) {
            if (SNMP_ADAPTOR_LOGGER.isLoggable(Level.FINEST)) {
                SNMP_ADAPTOR_LOGGER.logp(Level.FINEST, SnmpInformRequest.class.getName(),
                    "handleInternalError", "OutOfMemory Error generated by user callback", ome);
            }
            Thread.yield();
        }
    }

    void updateInternalVarBindWithResult(SnmpVarBind[] list) {

        if ((list == null) || (list.length == 0))
            return;

        int idx = 0;

        for(int i = 0; i < internalVarBind.length && idx < list.length; i++) {
            SnmpVarBind avar = internalVarBind[i];
            if (avar == null)
                continue;

            SnmpVarBind res = list[idx];
            avar.setSnmpValue(res.getSnmpValue());
            idx++;
        }
    }

    /**
     * For SNMP Runtime internal use only.
     */
    final void invokeOnResponse(Object resp) {
        if (resp != null) {
            if (resp instanceof SnmpPduRequestType)
                responsePdu = (SnmpPduRequestType) resp;
            else
                return;
        }
        setRequestStatus(stReceivedReply);
        queueResponse();
    }

    /**
     * This method cancels an active inform request and removes it from the polling list.
     */
    private void stopRequest() {

        // Remove the clause synchronized of the stopRequest method.
        // Synchronization is isolated as possible to avoid thread lock.
        // Note: the method removeRequest from SendQ is synchronized.
        // fix bug jaw.00392.B
        //
        synchronized(this) {
            setRequestStatus(stAborted);
        }
        informSession.getSnmpQManager().removeRequest(this);
        synchronized(this) {
            requestId = 0;
        }
    }

    final synchronized void deleteRequest() {
        informSession.removeInformRequest(this);
    }

    /**
     * For SNMP Runtime internal use only.
     * Gets the active <CODE>SnmpVarBindList</CODE>. The contents of it
     * are not guaranteed to be consistent when the inform request is active.
     * @return The list of <CODE>SnmpVarBind</CODE> objects.
     */
    final synchronized SnmpVarBindList getVarBindList() {
        return varBindList;
    }

    /**
     * For SNMP Runtime internal use only.
     * You should specify the <CODE>SnmpVarBindList</CODE> at SnmpInformRequest creation time.
     * You cannot modify it during the life-time of the object.
     */
    final synchronized void setVarBindList(SnmpVarBindList newvblst) {
        varBindList = newvblst;
        if (internalVarBind == null || internalVarBind.length != varBindList.size()) {
            internalVarBind = new SnmpVarBind[varBindList.size()];
        }
        varBindList.copyInto(internalVarBind);
    }

    /**
     * For SNMP Runtime internal use only.
     */
    final synchronized void setErrorStatusAndIndex(int stat, int idx) {
        errorStatus = stat;
        errorIndex = idx;
    }

    /**
     * For SNMP Runtime internal use only.
     */
    final synchronized void setPrevPollTime(long prev) {
        prevPollTime = prev;
    }

    /**
     * For SNMP Runtime internal use only.
     */
    final  void setRequestSentTime(long sendtime) {
        numTries++;
        setPrevPollTime(sendtime);
        waitTimeForResponse = prevPollTime + timeout*numTries;
        setRequestStatus(stWaitingForReply);

        if (SNMP_ADAPTOR_LOGGER.isLoggable(Level.FINER)) {
            SNMP_ADAPTOR_LOGGER.logp(Level.FINER, SnmpInformRequest.class.getName(),
                "setRequestSentTime", "Inform request Successfully sent");
        }

        informSession.getSnmpQManager().addWaiting(this);
    }

    /**
     * Initializes the request id from the request counter.
     */
    final synchronized void initNewRequest() {
        requestId = requestCounter.getNewId();
    }

    /**
     * For SNMP Runtime internal use only.
     */
    long timeRemainingForAction(long currtime) {
        switch (reqState) {
        case stWaitingToSend :
            return nextPollTime - currtime;
        case stWaitingForReply :
            return waitTimeForResponse - currtime;
        default :
            return -1;
        }
    }

    /**
     * Returns the string state corresponding to the specified integer state.
     * @param state The integer state.
     * @return The string state.
     */
    static String statusDescription(int state) {
        switch (state) {
        case stWaitingToSend :
            return "Waiting to send.";
        case stWaitingForReply :
            return "Waiting for reply.";
        case stReceivedReply :
            return "Response arrived.";
        case stAborted  :
            return "Aborted by user.";
        case stTimeout :
            return "Timeout Occured.";
        case stInternalError :
            return "Internal error.";
        case stResultsAvailable :
            return "Results available";
        case stNeverUsed :
            return "Inform request in createAndWait state";
        }
        return "Unknown inform request state.";
    }

    /**
     * Sets the request status to the specified value.
     * @param reqst The new status request.
     */
    final synchronized void setRequestStatus(int reqst) {
        reqState = reqst;
    }

    /**
     * Gives a status report of the request.
     * @return The status report of the request.
     */
    @Override
    public synchronized String toString() {
        StringBuffer s = new StringBuffer(300) ;
        s.append(tostring()) ;
        s.append("\nPeer/Port : " + address.getHostName() + "/" + port) ;

        return s.toString() ;
    }

    private synchronized String tostring() {
        StringBuffer s = new StringBuffer("InformRequestId = " + requestId);
        s.append("   " + "Status = " + statusDescription(reqState));
        s.append("  Timeout/MaxTries/NumTries = " + timeout*numTries + "/" +
                 + getMaxTries() + "/" + numTries);

        if (prevPollTime > 0) {
            debugDate.setTime(prevPollTime);
            s.append("\nPrevPolled = " + debugDate.toString());
        } else
            s.append("\nNeverPolled");
        s.append(" / RemainingTime(millis) = " +
                 timeRemainingForAction(System.currentTimeMillis()));

        return s.toString();
    }


}
