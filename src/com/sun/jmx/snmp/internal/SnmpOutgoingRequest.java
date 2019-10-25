/*
 * Copyright (c) 2001, 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */

package com.sun.jmx.snmp.internal;

import java.net.InetAddress;

import com.sun.jmx.snmp.SnmpSecurityException;
import com.sun.jmx.snmp.SnmpTooBigException;
import com.sun.jmx.snmp.SnmpStatusException;
import com.sun.jmx.snmp.SnmpPdu;
import com.sun.jmx.snmp.SnmpMsg;

import com.sun.jmx.snmp.internal.SnmpSecurityCache;
import com.sun.jmx.snmp.SnmpUnknownSecModelException;
import com.sun.jmx.snmp.SnmpBadSecurityLevelException;
/**
 * <P> An <CODE>SnmpOutgoingRequest</CODE> handles the marshalling of the message to send.</P>
 * <p><b>This API is a Sun Microsystems internal API  and is subject
 * to change without notice.</b></p>
 * @since 1.5
 */

public interface SnmpOutgoingRequest {
    /**
     * Returns the cached security data used when marshalling the call as a secure one.
     * @return The cached data.
     */
    public SnmpSecurityCache getSecurityCache();
    /**
     * Encodes the message to send and puts the result in the specified byte array.
     *
     * @param outputBytes An array to receive the resulting encoding.
     *
     * @exception ArrayIndexOutOfBoundsException If the result does not fit
     *                                           into the specified array.
     */
    public int encodeMessage(byte[] outputBytes)
        throws SnmpStatusException,
               SnmpTooBigException, SnmpSecurityException,
               SnmpUnknownSecModelException, SnmpBadSecurityLevelException;
  /**
     * Initializes the message to send with the passed Pdu.
     * <P>
     * If the encoding length exceeds <CODE>maxDataLength</CODE>,
     * the method throws an exception.</P>
     *
     * @param p The PDU to be encoded.
     * @param maxDataLength The maximum length permitted for the data field.
     *
     * @exception SnmpStatusException If the specified PDU <CODE>p</CODE> is
     *    not valid.
     * @exception SnmpTooBigException If the resulting encoding does not fit
     *    into <CODE>maxDataLength</CODE> bytes.
     * @exception ArrayIndexOutOfBoundsException If the encoding exceeds
     *    <CODE>maxDataLength</CODE>.
     */
    public SnmpMsg encodeSnmpPdu(SnmpPdu p,
                                 int maxDataLength)
        throws SnmpStatusException, SnmpTooBigException;
    /**
     * Returns a stringified form of the message to send.
     * @return The message state string.
     */
    public String printMessage();
}
