/*
 *
 * Copyright (c) 2007, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
// Copyright (c) 1995-96 by Cisco Systems, Inc.

package com.sun.jmx.snmp;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.Objects;

import com.sun.jmx.snmp.SnmpDefinitions;
import com.sun.jmx.snmp.SnmpStatusException;


/**
 * Contains a set of resources that are used by while sending or receiving
 * packets to and from an <CODE>SnmpPeer</CODE>. An <CODE>SnmpPeer</CODE> can
 * be configured explicitly to use a specific <CODE>SnmpParameter</CODE>.
 * A number of <CODE>SnmpPeer</CODE> objects can share a single parameter
 * object.
 * <P>
 * <B>Note</B>: Changing values for an <CODE>SnmpParameter</CODE> object
 * affects all <CODE>SnmpPeer</CODE> objects that share the parameter object.
 *
 * @see com.sun.jmx.snmp.SnmpPeer
 *
 * <p><b>This API is a Sun Microsystems internal API  and is subject
 * to change without notice.</b></p>
 */


public class SnmpParameters extends SnmpParams implements Cloneable, Serializable {
    private static final long serialVersionUID = -1822462497931733790L;

    /**
     * Creates an <CODE>SnmpParameters</CODE> object with defaults set up.
     * By default, <CODE>set</CODE> operations are not allowed, the read community and
     * the inform community strings to use is "public" and the SNMP version is V1.
     */
    public SnmpParameters() {
        _readCommunity = defaultRdCommunity ;
        _informCommunity = defaultRdCommunity ;
    }

    /**
     * Creates an <CODE>SnmpParameters</CODE> object.
     * This constructor allows the specification of the read/write community strings.
     * The inform community string to use is "public".
     *
     * @param rdc community string to use for <CODE>get</CODE> operations.
     * @param wrc community string to use for <CODE>set</CODE> operations.
     */
    public SnmpParameters(String rdc, String wrc) {
        _readCommunity = rdc ;
        _writeCommunity = wrc ;
        _informCommunity = defaultRdCommunity ;
    }

    /**
     * Creates an <CODE>SnmpParameters</CODE> object.
     * This constructor allows the specification of the read/write/inform community strings.
     *
     * @param rdc community string to use for <CODE>get</CODE> operations.
     * @param wrc community string to use for <CODE>set</CODE> operations.
     * @param inform community string to use for <CODE>inform</CODE> requests.
     */
    public SnmpParameters(String rdc, String wrc, String inform) {
        _readCommunity = rdc ;
        _writeCommunity = wrc ;
        _informCommunity = inform ;
    }

    /**
     * Gets the community to be used when issuing <CODE>get</CODE> operations.
     * @return The community string.
     */
    public String getRdCommunity() {
        return _readCommunity ;
    }

    /**
     * Sets the community string to use when performing <CODE>get</CODE> operations.
     * @param read The community string.
     */
    public synchronized void setRdCommunity(String read) {
        if (read == null)
            _readCommunity = defaultRdCommunity ;
        else
            _readCommunity = read ;
    }

    /**
     * Gets the community to be used when issuing <CODE>set</CODE> operations.
     * @return The community string.
     */
    public String getWrCommunity() {
        return _writeCommunity ;
    }

    /**
     * Sets the community to be used when issuing <CODE>set</CODE> operations.
     * @param write The community string.
     */
    public void setWrCommunity(String write) {
        _writeCommunity = write;
    }

    /**
     * Gets the community to be used when issuing <CODE>inform</CODE> requests.
     * @return The community string.
     */
    public String getInformCommunity() {
        return _informCommunity ;
    }

    /**
     * Sets the community string to use when performing <CODE>inform</CODE> requests.
     * @param inform The community string.
     */
    public void setInformCommunity(String inform) {
        if (inform == null)
            _informCommunity = defaultRdCommunity ;
        else
            _informCommunity = inform ;
    }

    /**
     * Checks whether parameters are in place for an SNMP <CODE>set</CODE> operation.
     * @return <CODE>true</CODE> if parameters are in place, <CODE>false</CODE> otherwise.
     */
    public boolean allowSnmpSets() {
        return _writeCommunity != null ;
    }

    /**
     * Compares two objects.
     * Two <CODE>SnmpParameters</CODE> are equal if they correspond to the same protocol version,
     * read community and write community.
     * @param obj The object to compare <CODE>this</CODE> with.
     * @return <CODE>true</CODE> if <CODE>this</CODE> and the specified object are equal, <CODE>false</CODE> otherwise.
     */
    @Override
    public synchronized boolean equals(Object obj) {
        if (!( obj instanceof SnmpParameters))
            return false;

        if (this == obj)
            return true ;
        SnmpParameters param = (SnmpParameters) obj ;
        if (_protocolVersion == param._protocolVersion)
            if (_readCommunity.equals(param._readCommunity))
                return true ;
        return false ;
    }

    @Override
    public synchronized int hashCode() {
        return (_protocolVersion * 31) ^ Objects.hashCode(_readCommunity);
    }

    /**
     * Clones the object and its content.
     * @return The object clone.
     */
    public synchronized Object clone() {
        SnmpParameters par = null ;
        try {
            par = (SnmpParameters) super.clone() ;
            //par._retryPolicy = _retryPolicy ;
            par._readCommunity = _readCommunity ;
            par._writeCommunity = _writeCommunity ;
            par._informCommunity = _informCommunity ;
        } catch (CloneNotSupportedException e) {
            throw new InternalError() ; // VM bug.
        }
        return par ;
    }

    /**
     * For SNMP Runtime internal use only.
     */
    public byte[] encodeAuthentication(int snmpCmd)
        throws SnmpStatusException {
        //
        // Returns the community string associated to the specified command.
        //
        try {
            if (snmpCmd == pduSetRequestPdu)
                return _writeCommunity.getBytes("8859_1");
            else if (snmpCmd == pduInformRequestPdu)
                return _informCommunity.getBytes("8859_1") ;
            else
                return _readCommunity.getBytes("8859_1") ;
        }catch(UnsupportedEncodingException e) {
            throw new SnmpStatusException(e.getMessage());
        }
    }

    /**
     * Specify the default community string to use for <CODE>get</CODE> operations.
     * By default, the value is "public".
     */
    final static String defaultRdCommunity = "public" ;

    /**
     * The protocol version.
     * By default, the value is SNMP version 1.
     * @serial
     */
    private int         _protocolVersion = snmpVersionOne ;
    /**
     * The community to be used when issuing <CODE>get</CODE> operations.
     * @serial
     */
    private String      _readCommunity ;
    /**
     * The community to be used when issuing <CODE>set</CODE> operations.
     * @serial
     */
    private String      _writeCommunity ;
    /**
     * The community to be used when issuing <CODE>inform</CODE> requests.
     * @serial
     */
    private String      _informCommunity ;
    /**
     */
    //private int               _retryPolicy ;  // not implemented as yet.
}
