/*
 *
 * Copyright (c) 2007, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
// Copyright (c) 1995-96 by Cisco Systems, Inc.

package com.sun.jmx.snmp.daemon;

import java.util.Enumeration;
import java.util.logging.Level;
import java.util.Vector;

// import debug stuff
//
import static com.sun.jmx.defaults.JmxProperties.SNMP_ADAPTOR_LOGGER;

/**
 * This class starts a thread which picks up a session from the queue
 * and prepares the inform request protocol data unit (PDU) packet and sends
 * it to the manager. The request is then added to the wait queue and
 * marked as one that is waiting for a response.
 */

final class SnmpSendServer extends Thread {

    // VARIABLES
    //----------
    private int intervalRange = 5 * 1000;
    private Vector<SnmpInformRequest> readyPool;

    SnmpQManager snmpq = null ;

    // This boolean is used to stop handling requests while the corresponding SnmpQManager
    // is being destroyed.
    //
    boolean isBeingDestroyed = false;

    // CONSTRUCTORS
    //-------------

    public SnmpSendServer(ThreadGroup grp, SnmpQManager q) {
        super(grp, "SnmpSendServer");
        snmpq = q;
        start();
    }

    public synchronized void stopSendServer() {

        if (isAlive()) {
            interrupt();
            try {
                // Wait until the thread die.
                //
                join();
            } catch (InterruptedException e) {
                // Ignore...
            }
        }
    }

    @Override
    public void run() {
        Thread.currentThread().setPriority(Thread.NORM_PRIORITY);

        if (SNMP_ADAPTOR_LOGGER.isLoggable(Level.FINER)) {
            SNMP_ADAPTOR_LOGGER.logp(Level.FINER, SnmpSendServer.class.getName(),
                    "run", "Thread Started");
        }
        while (true) {
            try {
                prepareAndSendRequest();
                if (isBeingDestroyed == true) {
                    break;
                }
            } catch (Exception anye) {
                if (SNMP_ADAPTOR_LOGGER.isLoggable(Level.FINEST)) {
                    SNMP_ADAPTOR_LOGGER.logp(Level.FINEST, SnmpSendServer.class.getName(),
                            "run", "Exception in send server", anye);
                }
            } catch (ThreadDeath td) {
                // This is not good but Netscape does kill all threads when
                // the pagecontext changes.
                if (SNMP_ADAPTOR_LOGGER.isLoggable(Level.FINEST)) {
                    SNMP_ADAPTOR_LOGGER.logp(Level.FINEST, SnmpSendServer.class.getName(),
                            "run", "Exiting... Fatal error");
                }
                throw td;
            } catch (OutOfMemoryError ome) {
                if (SNMP_ADAPTOR_LOGGER.isLoggable(Level.FINEST)) {
                    SNMP_ADAPTOR_LOGGER.logp(Level.FINEST, SnmpSendServer.class.getName(),
                            "run", "Out of memory");
                }
            } catch (Error err) {
                if (SNMP_ADAPTOR_LOGGER.isLoggable(Level.FINEST)) {
                    SNMP_ADAPTOR_LOGGER.logp(Level.FINEST, SnmpSendServer.class.getName(),
                            "run", "Got unexpected error", err);
                }
                throw err;
            }
        }
    }

    private void prepareAndSendRequest() {

        if (readyPool == null || readyPool.isEmpty()) {
            // wait to be signaled by the an active request.
            if (SNMP_ADAPTOR_LOGGER.isLoggable(Level.FINER)) {
                SNMP_ADAPTOR_LOGGER.logp(Level.FINER, SnmpSendServer.class.getName(),
                    "prepareAndSendRequest", "Blocking for inform requests");
            }
            readyPool = snmpq.getAllOutstandingRequest(intervalRange) ;
            if (isBeingDestroyed == true)
                return;
        } else {
            if (SNMP_ADAPTOR_LOGGER.isLoggable(Level.FINEST)) {
                SNMP_ADAPTOR_LOGGER.logp(Level.FINEST, SnmpSendServer.class.getName(),
                    "prepareAndSendRequest", "Inform requests from a previous block left unprocessed. Will try again");
            }
        }

        if (SNMP_ADAPTOR_LOGGER.isLoggable(Level.FINER)) {
            SNMP_ADAPTOR_LOGGER.logp(Level.FINER, SnmpSendServer.class.getName(),
                "prepareAndSendRequest", "List of inform requests to send : " + reqListToString(readyPool));
        }

        synchronized(this) {
            if (readyPool.size() < 2) {
                // Fire all requests as independent requests.
                fireRequestList(readyPool) ;
                return ;
            }

            while (!readyPool.isEmpty()) {
                SnmpInformRequest req = readyPool.lastElement() ;
                if (req != null && req.inProgress()) {
                    fireRequest(req) ;
                }
                readyPool.removeElementAt(readyPool.size() - 1) ;
            }
            readyPool.removeAllElements() ;
        }
    }

    /**
     * This will fire the specified request.
     */
    private void fireRequest(SnmpInformRequest req) {
        if (req != null && req.inProgress()) {
            if (SNMP_ADAPTOR_LOGGER.isLoggable(Level.FINER)) {
                SNMP_ADAPTOR_LOGGER.logp(Level.FINER, SnmpSendServer.class.getName(),
                        "fireRequest", "Firing inform request directly. -> " + req.getRequestId());
            }
            req.action();
        }
    }

    private void fireRequestList(Vector<SnmpInformRequest> reqList) {
        // Fire all requests as independent requests.
        while (!reqList.isEmpty()) {
            SnmpInformRequest req = reqList.lastElement() ;
            if (req != null && req.inProgress())
                fireRequest(req) ;
            reqList.removeElementAt(reqList.size() - 1) ;
        }
    }

    private final String reqListToString(Vector<SnmpInformRequest> vec) {
        StringBuilder s = new StringBuilder(vec.size() * 100);

        Enumeration<SnmpInformRequest> dbge = vec.elements();
        while (dbge.hasMoreElements()) {
            SnmpInformRequest reqc = dbge.nextElement();
            s.append("InformRequestId -> ");
            s.append(reqc.getRequestId());
            s.append(" / Destination -> ");
            s.append(reqc.getAddress());
            s.append(". ");
        }
        String str = s.toString();
        return str;
    }

}
