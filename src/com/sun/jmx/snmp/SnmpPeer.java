/*
 *
 * Copyright (c) 2007, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
// Copyright (c) 1995-96 by Cisco Systems, Inc.

package com.sun.jmx.snmp;

// java imports
//
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.io.Serializable;

/**
 * Holds information about an SNMP agent. This information is used to communicate with the agent.
 * These are the IP address, port number, SNMP parameters, and peer channel parameters
 * (such as the maximum request packet size, maximum number of variable bindings in a packet, retries, and timeouts).
 * Changing these would affect all active requests.
 * <P>
 * The class contains the following properties:
 * <UL>
 * <LI><B>destPort</B>: port number of the destination host.
 * <BR>The default port is <B>161</B>.
 *
 * <LI><B>maxVarBindLimit</B>: maximum number of OIDs which can be encoded in a single request packet.
 * This is set by the user.
 * <BR>A request which contains more than this limit will be automatically split into multiple requests.
 * Typically used when multiplexing requests.
 * <BR>The default value is 25.
 *
 * <LI><B>maxSnmpPacketSize</B>: maximum packet size of the request PDU.
 * This can be set by the user.
 * <BR> If the request crosses this limit while encoding, the request is automatically split into
 * multiple small requests. Each of these requests will again be within this limit.
 * <BR>The default value is (2 * 1024).
 *
 * <LI><B>maxTries</B>: number of times to try before giving up.
 * <BR>The default number is <B>3</B>.
 *
 * <LI><B>timeout</B>: amount of time to wait for a response from the
 * peer.  If this amount of time passes without a response, and if the
 * <B>maxTries</B> value has not been exceeded, the request will be
 * resent.  <BR>The default amount of time is <B>3000
 * milliseconds</B>.
 *
 * <LI><B>snmpParameters</B>: SNMP parameters to be used when communicating with the agent.
 * The parameters contain the protocol version and security information (the parameters can be shared amongst several peers).
 *
 *</UL>
 * JavaBean compliant getters and setters allow the properties listed above to be modified.
 *
 * <p><b>This API is a Sun Microsystems internal API  and is subject
 * to change without notice.</b></p>
 * @see com.sun.jmx.snmp.SnmpParameters
 */

public class SnmpPeer implements Serializable {
    private static final long serialVersionUID = -5554565062847175999L;

    // PUBLIC VARIABLES
    //-----------------

    /**
     * The default SNMP packet size of an SNMP request (2 * 1024).
     * <BR>The maximum size is initially set to Ethernet maximum transfer unit (MTU).
     */

    public static final int defaultSnmpRequestPktSize = 2 * 1024 ;

    /**
     * The default SNMP packet size of an SNMP response (8 * 1024).
     * <BR>This will be the default size that the session socket uses when receiving a packet.
     */
    public static final int defaultSnmpResponsePktSize = 8 * 1024 ;


    // PRIVATE VARIABLES
    //------------------

    /**
     * The maximum number of variable bindings that can be packed into a request.
     * The default value is 25.
     */
    private int maxVarBindLimit = 25 ;

    /**
     * Port number of the destination host.
     * The default port is 161.
     */
    private int portNum = 161 ;

    /**
     * Number of times to try before giving up.
     * The default number is 3.
     */
    private int maxTries = 3 ;

    /**
     * The amount of time to wait for a response from the peer.
     * The default amount of time is 3000 millisec.
     */
    private int timeout = 3000;

    /**
     * The PDU factory. The default factory is an instance of <CODE>SnmpPduFactoryBER</CODE>.
     */
    private SnmpPduFactory pduFactory = new SnmpPduFactoryBER() ;

    /**
     * The maximum round trip time for a packet with the peer.
     */
    private long _maxrtt ;
    /**
     * The minimum round trip time for a packet with the peer.
     */
    private long _minrtt ;
    /**
     * The average round trip time for a packet with the peer.
     */
    private long _avgrtt ;

    /**
     * SNMP parameters for this peer are valid for all requests using this peer.
     * @see com.sun.jmx.snmp.SnmpParameters
     */
    private SnmpParams _snmpParameter = new SnmpParameters() ;

    /**
     * Internet address of the peer to be used when communicating with the peer.
     */
    private InetAddress _devAddr = null ;

    /**
     * Maximum packet size of the request PDU.  This can be set by the user.
     * If the request crosses this limit while encoding, the request is automatically split
     * into multiple small request. Each of these requests will again be within this limit.
     * The default value is (2 * 1024).
     */
    private int maxSnmpPacketSize = defaultSnmpRequestPktSize ;

    /**
     * List of alternate addresses.
     */
    InetAddress _devAddrList[] = null ;

    /**
     * The index of address currently being used.
     */
    int _addrIndex = 0 ;


    private boolean customPduFactory = false;

    // CONSTRUCTORS
    //-------------

    /**
     * Creates an SNMP peer object for a device. The default port is 161.
     * @param host The peer name.
     * @exception UnknownHostException If the host name cannot be resolved.
     */
    public SnmpPeer(String host) throws UnknownHostException {
        this(host, 161) ;
    }

    /**
     * Creates an SNMP peer object for a device. The default port is 161.
     * @param netaddr The peer <CODE>InetAddress</CODE>.
     * @param port The port number.
     */
    public SnmpPeer(InetAddress netaddr, int port) {
        _devAddr = netaddr ;
        portNum = port;
   }

    /**
     * Creates an SNMP peer object for a device. The default port is 161.
     * @param netaddr The peer <CODE>InetAddress</CODE>.
     */
    public SnmpPeer(InetAddress netaddr) {
        _devAddr = netaddr ;
     }

    /**
     * Creates an SNMP peer object for a device with the specified port.
     * @param host The peer name.
     * @param port The port number.
     * @exception UnknownHostException If the host name cannot be resolved.
     */
    public SnmpPeer(String host, int port) throws UnknownHostException {
        useIPAddress(host) ;
        portNum = port;
    }


    // PUBLIC METHODS
    //---------------

    /**
     * Sets a specific IP address to which the peer will communicate.
     * Typically used to set an alternate IP address or a specific address which is known to respond to requests.
     * The IP address <CODE>String</CODE> can either be a machine name, such as <CODE>ibiza</CODE>,
     * or a <CODE>String</CODE> representing its IP address, such as "206.26.48.100".
     * @param ipaddr Dot formatted IP address or logical host name.
     * @exception UnknownHostException If the host name cannot be resolved.
     */
    final public synchronized void useIPAddress(String ipaddr) throws UnknownHostException {
        _devAddr = InetAddress.getByName(ipaddr) ;
    }

    /**
     * Returns the dot-formatted IP address string (for example 171.69.220.224).
     * Useful when you want to know which IP address is used
     * when the address was resolved using a DNS name.
     * @return The dot-formatted IP address being used.
     */
    final public synchronized String ipAddressInUse() {
        byte [] adr = _devAddr.getAddress() ;
        return
            (adr[0]&0xFF) + "." + (adr[1]&0xFF) + "." +
            (adr[2]&0xFF) + "." + (adr[3]&0xFF);
    }

    /**
     * Specifies the list of addresses to be used.  When a host is not responding
     * the user can switch to the next address by calling <CODE>useNextAddress</CODE>.
     * @param adrList The list of <CODE>InetAddresses</CODE>.
     */
    final public synchronized void useAddressList(InetAddress adrList[]) {
        _devAddrList = (adrList != null) ? adrList.clone() : null;
        _addrIndex = 0 ;
        useNextAddress() ;
    }

    /**
     * Causes all subsequent requests to go to the new address
     * obtained from the specified list of alternate addresses.
     * If it reaches the end of list, it starts again at the first address.
     */
    final public synchronized void useNextAddress() {
        if (_devAddrList == null)
            return ;
/* NPCTE fix for bug 4486059, esc 0 MR 03-August-2001 */
/*      if (_addrIndex > _devAddrList.length) */
        if (_addrIndex > _devAddrList.length-1)
/* end of NPCTE fix for bugid 4486059 */
            _addrIndex = 0 ;
        _devAddr = _devAddrList[_addrIndex++] ;
    }

    /**
     * Determines whether an SNMP <CODE>set</CODE> operation is allowed with this
     * peer object. For now it just makes sure a parameter is configured for a write operation.
     * @return <CODE>true</CODE> if SNMP <CODE>set</CODE> is allowed and the parameter is configured,
     * <CODE>false</CODE> otherwise.
     */
    public boolean allowSnmpSets() {
        return _snmpParameter.allowSnmpSets() ;
    }

    /**
     * Gets the list of alternate <CODE>InetAddress</CODE> configured for this peer.
     * @return The <CODE>InetAddress</CODE> of the peer.
     */
    final public InetAddress[] getDestAddrList() {
        return _devAddrList == null ? null : _devAddrList.clone();
    }

    /**
     * Gets the <CODE>InetAddress</CODE> object for this peer.
     * @return The <CODE>InetAddress</CODE> of the peer.
     */
    final public InetAddress getDestAddr() {
        return _devAddr ;
    }

    /**
     * Gets the destination port number of the peer to which SNMP requests are to be sent.
     * @return The destination port number.
     */
    final public int getDestPort() {
        return portNum ;
    }

    /**
     * Changes the port address of the destination for the request.
     * @param newPort The destination port.
     */
    final public synchronized void setDestPort(int newPort) {
        portNum = newPort ;
    }

    /**
     * Gets the timeout to wait for a response from the peer.
     * @return The value of the timeout property.
     */
    final public int getTimeout() {
        return timeout;
    }

    /**
     * Changes the timeout to wait for a response from the peer.
     * @param newTimeout The timeout (in milliseconds).
     */
    final public synchronized void setTimeout(int newTimeout) {
        if (newTimeout < 0)
            throw new IllegalArgumentException();
        timeout= newTimeout;
    }

    /**
     * Gets the number of times to try before giving up.
     * @return The maximun number of tries.
     */
    final public int getMaxTries() {
        return maxTries;
    }

    /**
     * Changes the maximun number of times to try before giving up.
     * @param newMaxTries The maximun number of tries.
     */
    final public synchronized void setMaxTries(int newMaxTries) {
        if (newMaxTries < 0)
            throw new IllegalArgumentException();
        maxTries= newMaxTries;
    }

    /**
     * Gets the name specified in the constructor while creating this object.
     * @return The name of the host as specified while creating this object.
     */
    final public String getDevName() {
        return getDestAddr().getHostName() ;
    }

    /**
     * Returns the <CODE>String</CODE> representation for this <CODE>SnmpPeer</CODE>.
     * @return The <CODE>String</CODE> representation.
     */
    @Override
    public String toString() {
        // For security and performance reasons we don't call getHostName here
        // Use getDevName() explicitly when necessary.
        return "Peer/Port : " + getDestAddr().getHostAddress() + "/" + getDestPort() ;
    }

    /**
     * Gets the maximum number of variable bindings that can be sent to a peer.
     * @return The maximum variable bindings that can be encoded into a request packet.
     */
    final public synchronized int getVarBindLimit() {
        return maxVarBindLimit ;
    }

    /**
     * Configures the maximum number of variable bindings that can be sent to a peer.
     * @param limit The desired limit.
     */
    final public synchronized void setVarBindLimit(int limit) {
        maxVarBindLimit = limit ;
    }

    /**
     * Sets the <CODE>SnmpParams</CODE> object associated with the peer.
     * @param params The desired parameters.
     */
    public void setParams(SnmpParams params) {
        _snmpParameter = params;
    }
    /**
     * Gets the <CODE>SnmpParams</CODE> object associated with the peer.
     * @return The associated parameters.
     */
    public SnmpParams getParams() {
        return _snmpParameter;
    }

    /**
     * Gets the maximum request packet size that is currently used.
     * @return The maximum request packet size.
     */
    final public int getMaxSnmpPktSize() {
        return maxSnmpPacketSize ;
    }

    /**
     * Configures the maximum packet size that can be used when generating an SNMP request.
     * @param newsize The desired packet size.
     */
    final public synchronized void setMaxSnmpPktSize(int newsize) {
        maxSnmpPacketSize = newsize ;
    }

    boolean isCustomPduFactory() {
        return customPduFactory;
    }

    /**
     * Finalizer of the <CODE>SnmpPeer</CODE> objects.
     * This method is called by the garbage collector on an object
     * when garbage collection determines that there are no more references to the object.
     * <P>Sets all the references to this SNMP peer object to <CODE>null</CODE>.
     */
    @Override
    protected void finalize() {
        _devAddr = null ;
        _devAddrList = null ;
        _snmpParameter = null ;
    }

    /**
     * Gets the minimum round trip time for a packet with the peer.
     * @return The minimum round trip time for a packet with the peer.
     */
    public long getMinRtt() {
        return _minrtt ;
    }

    /**
     * Gets the maximum round trip time for a packet with the peer.
     * @return The maximum round trip time for a packet with the peer.
     */
    public long getMaxRtt() {
        return _maxrtt ;
    }

    /**
     * Gets the average round trip time for a packet with the peer.
     * @return The average round trip time for a packet with the peer.
     */
    public long getAvgRtt() {
        return _avgrtt ;
    }


    // PRIVATE METHODS
    //----------------

    private void updateRttStats(long tm) {
        if (_minrtt > tm)
            _minrtt = tm ;
        else if (_maxrtt < tm)
            _maxrtt = tm ;
        else
            _avgrtt = tm ;  // to do later.
    }
}
