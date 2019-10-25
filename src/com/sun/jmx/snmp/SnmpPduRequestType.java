/*
 * Copyright (c) 2001, 2003, Oracle and/or its affiliates. All rights reserved.
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
 * Interface implemented by classes modelizing request pdu.
 * <p><b>This API is a Sun Microsystems internal API  and is subject
 * to change without notice.</b></p>
 * @since 1.5
 */
public interface SnmpPduRequestType extends SnmpAckPdu {
    /**
     * Error index setter. Remember that SNMP indices start from 1.
     * Thus the corresponding <CODE>SnmpVarBind</CODE> is
     * <CODE>varBindList[errorIndex-1]</CODE>.
     * @param i Error index.
     */
    public void setErrorIndex(int i);
    /**
     * Error status setter. Statuses are defined in
     * {@link com.sun.jmx.snmp.SnmpDefinitions SnmpDefinitions}.
     * @param i Error status.
     */
    public void setErrorStatus(int i);
    /**
     * Error index getter. Remember that SNMP indices start from 1.
     * Thus the corresponding <CODE>SnmpVarBind</CODE> is
     * <CODE>varBindList[errorIndex-1]</CODE>.
     * @return Error index.
     */
    public int getErrorIndex();
    /**
     * Error status getter. Statuses are defined in
     * {@link com.sun.jmx.snmp.SnmpDefinitions SnmpDefinitions}.
     * @return Error status.
     */
    public int getErrorStatus();
}
