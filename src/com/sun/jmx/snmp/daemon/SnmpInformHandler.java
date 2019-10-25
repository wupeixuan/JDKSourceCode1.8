/*
 * Copyright (c) 2000, 2003, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.jmx.snmp.daemon ;

// JMX imports
//
import com.sun.jmx.snmp.SnmpDefinitions;
import com.sun.jmx.snmp.SnmpVarBindList;

/**
 * Provides the callback methods that are required to be implemented by the application
 * when an inform response is received by the agent.
 * <P>
 * Each inform request can be provided with an object that implements this callback
 * interface. An application then uses the SNMP adaptor to start an SNMP inform request,
 * which marks the request as active. The methods in this callback interface
 * get invoked when any of the following happens:
 * <P>
 * <UL>
 * <LI> The agent receives the SNMP inform response.
 * <LI> The agent does not receive any response within a specified time and the number of tries
 * have exceeded the limit (timeout condition).
 * <LI> An internal error occurs while processing or parsing the inform request.
 * </UL>
 * <p><b>This API is a Sun Microsystems internal API  and is subject
 * to change without notice.</b></p>
 */

public interface SnmpInformHandler extends SnmpDefinitions {

    /**
     * This callback is invoked when a manager responds to an SNMP inform request.
     * The callback should check the error status of the inform request to determine
     * the kind of response.
     *
     * @param request The <CODE>SnmpInformRequest</CODE> associated with this callback.
     * @param errStatus The status of the request.
     * @param errIndex The index in the list that caused the error.
     * @param vblist The <CODE>Response varBind</CODE> list for the successful request.
     */
    public abstract void processSnmpPollData(SnmpInformRequest request, int errStatus, int errIndex, SnmpVarBindList vblist);

    /**
     * This callback is invoked when a manager does not respond within the
     * specified timeout value to the SNMP inform request. The number of tries have also
     * been exhausted.
     * @param request The <CODE>SnmpInformRequest</CODE> associated with this callback.
     */
    public abstract void processSnmpPollTimeout(SnmpInformRequest request);

    /**
     * This callback is invoked when any form of internal error occurs.
     * @param request The <CODE>SnmpInformRequest</CODE> associated with this callback.
     * @param errmsg The <CODE>String</CODE> describing the internal error.
     */
    public abstract void processSnmpInternalError(SnmpInformRequest request, String errmsg);
}
