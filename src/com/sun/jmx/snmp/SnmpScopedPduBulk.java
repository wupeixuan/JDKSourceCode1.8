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
package com.sun.jmx.snmp;
/**
 * Represents a <CODE>get-bulk</CODE> PDU as defined in RFC 1448.
 * <P>
 * <P>
 * The <CODE>SnmpSocpedPduBulk</CODE> extends {@link com.sun.jmx.snmp.SnmpScopedPduPacket SnmpScopedPduPacket}
 * and defines attributes specific to the <CODE>get-bulk</CODE> PDU (see RFC 1448).
 *
 * <p><b>This API is a Sun Microsystems internal API  and is subject
 * to change without notice.</b></p>
 * @since 1.5
 */

public class SnmpScopedPduBulk extends SnmpScopedPduPacket
    implements SnmpPduBulkType {
    private static final long serialVersionUID = -1648623646227038885L;

    /**
     * The <CODE>non-repeaters</CODE> value.
     * @serial
     */
    int            nonRepeaters;


    /**
     * The <CODE>max-repetitions</CODE> value.
     * @serial
     */
    int            maxRepetitions;

    public SnmpScopedPduBulk() {
        type = pduGetBulkRequestPdu;
        version = snmpVersionThree;
    }

    /**
     * The <CODE>max-repetitions</CODE> setter.
     * @param max Maximum repetition.
     */
    public void setMaxRepetitions(int max) {
        maxRepetitions = max;
    }

    /**
     * The <CODE>non-repeaters</CODE> setter.
     * @param nr Non repeaters.
     */
    public void setNonRepeaters(int nr) {
        nonRepeaters = nr;
    }

    /**
     * The <CODE>max-repetitions</CODE> getter.
     * @return Maximum repetition.
     */
    public int getMaxRepetitions() { return maxRepetitions; }

    /**
     * The <CODE>non-repeaters</CODE> getter.
     * @return Non repeaters.
     */
    public int getNonRepeaters() { return nonRepeaters; }

    /**
     * Generates the pdu to use for response.
     * @return Response pdu.
     */
    public SnmpPdu getResponsePdu() {
        SnmpScopedPduRequest result = new SnmpScopedPduRequest();
        result.address = address ;
        result.port = port ;
        result.version = version ;
        result.requestId = requestId;
        result.msgId = msgId;
        result.msgMaxSize = msgMaxSize;
        result.msgFlags = msgFlags;
        result.msgSecurityModel = msgSecurityModel;
        result.contextEngineId = contextEngineId;
        result.contextName = contextName;
        result.securityParameters = securityParameters;
        result.type = pduGetResponsePdu ;
        result.errorStatus = SnmpDefinitions.snmpRspNoError ;
        result.errorIndex = 0 ;
        return result;
    }
}
