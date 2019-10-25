/*
 * Copyright (c) 1998, 2007, Oracle and/or its affiliates. All rights reserved.
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


package com.sun.jmx.snmp;




/**
 * Defines the interface of the object in charge of encoding and decoding SNMP packets.
 * <P>
 * You will not usually need to use this interface, except if you
 * decide to replace the default implementation <CODE>SnmpPduFactoryBER</CODE>.
 * <P>
 * An <CODE>SnmpPduFactory</CODE> object is attached to an
 * {@link com.sun.jmx.snmp.daemon.SnmpAdaptorServer SNMP protocol adaptor}
 * or an {@link com.sun.jmx.snmp.SnmpPeer SnmpPeer}.
 * It is used each time an SNMP packet needs to be encoded or decoded.
 * <BR>{@link com.sun.jmx.snmp.SnmpPduFactoryBER SnmpPduFactoryBER} is the default
 * implementation.
 * It simply applies the standard ASN.1 encoding and decoding
 * on the bytes of the SNMP packet.
 * <P>
 * It's possible to implement your own <CODE>SnmpPduFactory</CODE>
 * object and to add authentication and/or encryption to the
 * default encoding/decoding process.
 *
 * <p><b>This API is a Sun Microsystems internal API  and is subject
 * to change without notice.</b></p>
 * @see SnmpPduFactory
 * @see SnmpPduPacket
 * @see SnmpMessage
 *
 */

public interface SnmpPduFactory {

    /**
     * Decodes the specified <CODE>SnmpMsg</CODE> and returns the
     * resulting <CODE>SnmpPdu</CODE>. If this method returns
     * <CODE>null</CODE>, the message will be considered unsafe
     * and will be dropped.
     *
     * @param msg The <CODE>SnmpMsg</CODE> to be decoded.
     * @return Null or a fully initialized <CODE>SnmpPdu</CODE>.
     * @exception SnmpStatusException If the encoding is invalid.
     *
     * @since 1.5
     */
    public SnmpPdu decodeSnmpPdu(SnmpMsg msg) throws SnmpStatusException ;

    /**
     * Encodes the specified <CODE>SnmpPdu</CODE> and
     * returns the resulting <CODE>SnmpMsg</CODE>. If this
     * method returns null, the specified <CODE>SnmpPdu</CODE>
     * will be dropped and the current SNMP request will be
     * aborted.
     *
     * @param p The <CODE>SnmpPdu</CODE> to be encoded.
     * @param maxDataLength The size limit of the resulting encoding.
     * @return Null or a fully encoded <CODE>SnmpMsg</CODE>.
     * @exception SnmpStatusException If <CODE>pdu</CODE> contains
     *            illegal values and cannot be encoded.
     * @exception SnmpTooBigException If the resulting encoding does not
     *            fit into <CODE>maxPktSize</CODE> bytes.
     *
     * @since 1.5
     */
    public SnmpMsg encodeSnmpPdu(SnmpPdu p, int maxDataLength)
        throws SnmpStatusException, SnmpTooBigException ;
}
