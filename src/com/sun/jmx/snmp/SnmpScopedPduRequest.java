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
 * Is used to represent <CODE>get</CODE>, <CODE>get-next</CODE>, <CODE>set</CODE>, <CODE>response</CODE> SNMP V3 scoped PDUs.
 *
 * <p><b>This API is a Sun Microsystems internal API  and is subject
 * to change without notice.</b></p>
 * @since 1.5
 */
public class SnmpScopedPduRequest extends SnmpScopedPduPacket
    implements SnmpPduRequestType {
    private static final long serialVersionUID = 6463060973056773680L;

    int errorStatus=0 ;

    int errorIndex=0 ;

    /**
     * Error index setter. Remember that SNMP indices start from 1.
     * Thus the corresponding <CODE>SnmpVarBind</CODE> is
     * <CODE>varBindList[errorIndex-1]</CODE>.
     * @param i Error index.
     */
    public void setErrorIndex(int i) {
        errorIndex = i;
    }
    /**
     * Error status setter. Statuses are defined in
     * {@link com.sun.jmx.snmp.SnmpDefinitions SnmpDefinitions}.
     * @param s Error status.
     */
    public void setErrorStatus(int s) {
        errorStatus = s;
    }

    /**
     * Error index getter. Remember that SNMP indices start from 1.
     * Thus the corresponding <CODE>SnmpVarBind</CODE> is
     * <CODE>varBindList[errorIndex-1]</CODE>.
     * @return Error index.
     */
    public int getErrorIndex() { return errorIndex; }
    /**
     * Error status getter. Statuses are defined in
     * {@link com.sun.jmx.snmp.SnmpDefinitions SnmpDefinitions}.
     * @return Error status.
     */
    public int getErrorStatus() { return errorStatus; }

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
