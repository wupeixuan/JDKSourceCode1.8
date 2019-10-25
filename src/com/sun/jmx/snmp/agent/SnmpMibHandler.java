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


package com.sun.jmx.snmp.agent;



// java imports
//
import java.util.Vector;
import java.io.IOException;

// jmx imports
//
import com.sun.jmx.snmp.SnmpOid;
import com.sun.jmx.snmp.SnmpStatusException;

/**
 * The logical link between an SNMP MIB and the SNMP communication stack.
 *
 * <p><b>This API is a Sun Microsystems internal API  and is subject
 * to change without notice.</b></p>
 */

public interface SnmpMibHandler {

    /**
     * Adds a new MIB in the SNMP MIB handler.
     * This method is called automatically by {@link com.sun.jmx.snmp.agent.SnmpMibAgent#setSnmpAdaptor(SnmpMibHandler)} and
     * {@link com.sun.jmx.snmp.agent.SnmpMibAgent#setSnmpAdaptorName(ObjectName)} and should not be called directly.
     *
     * @param mib The MIB to add.
     *
     * @return A reference on the SNMP MIB handler.
     *
     * @exception IllegalArgumentException If the parameter is null.
     */
    public SnmpMibHandler addMib(SnmpMibAgent mib) throws IllegalArgumentException;

/**
     * Adds a new MIB in the SNMP MIB handler.
     *
     * @param mib The MIB to add.
     * @param oids The array of oid used to add the mib. Each oid is a root oid for the mib.
     * @return A reference on the SNMP MIB handler.
     *
     * @exception IllegalArgumentException If the parameter is null.
     *
     * @since 1.5
     */
    public SnmpMibHandler addMib(SnmpMibAgent mib, SnmpOid[] oids) throws IllegalArgumentException;

    /**
     * Adds a new contextualized MIB in the SNMP MIB handler.
     *
     * @param mib The MIB to add.
     * @param contextName The MIB context name. If null is passed, will be registered in the default context.
     *
     * @return A reference to the SNMP MIB handler.
     *
     * @exception IllegalArgumentException If the parameter is null.
     *
     * @since 1.5
     */
    public SnmpMibHandler addMib(SnmpMibAgent mib, String contextName)
        throws IllegalArgumentException;

    /**
     * Adds a new contextualized MIB in the SNMP MIB handler.
     *
     * @param mib The MIB to add.
     * @param contextName The MIB context name. If null is passed, will be registered in the default context.
     * @param oids The array of oid used to add the mib. Each oid is a root oid for the mib.
     *
     * @return A reference to the SNMP MIB handler.
     *
     * @exception IllegalArgumentException If the parameter is null.
     *
     * @since 1.5
     */
    public SnmpMibHandler addMib(SnmpMibAgent mib, String contextName, SnmpOid[] oids)
        throws IllegalArgumentException;

    /**
     * Removes the specified MIB from the SNMP protocol adaptor.
     * This method is called automatically by {@link com.sun.jmx.snmp.agent.SnmpMibAgent#setSnmpAdaptor(SnmpMibHandler)} and
     * {@link com.sun.jmx.snmp.agent.SnmpMibAgent#setSnmpAdaptorName(ObjectName)} and should not be called directly.
     *
     * @param mib The MIB to be removed.
     *
     * @return <CODE>true</CODE> if the specified <CODE>mib</CODE> was a MIB included in the SNMP MIB handler,
     * <CODE>false</CODE> otherwise.
     */
    public boolean removeMib(SnmpMibAgent mib);
  /**
     * Removes the specified MIB from the SNMP protocol adaptor.
     * This method is called automatically by {@link com.sun.jmx.snmp.agent.SnmpMibAgent#setSnmpAdaptor(SnmpMibHandler)} and
     * {@link com.sun.jmx.snmp.agent.SnmpMibAgent#setSnmpAdaptorName(ObjectName)} and should not be called directly.
     *
     * @param mib The MIB to be removed.
     * @param oids The oid the MIB was previously registered for.
     * @return <CODE>true</CODE> if the specified <CODE>mib</CODE> was a MIB included in the SNMP MIB handler,
     * <CODE>false</CODE> otherwise.
     *
     * @since 1.5
     */
    public boolean removeMib(SnmpMibAgent mib, SnmpOid[] oids);
     /**
     * Removes the specified MIB from the SNMP protocol adaptor.
     *
     * @param mib The MIB to be removed.
     * @param contextName The context name used at registration time.
     *
     * @return <CODE>true</CODE> if the specified <CODE>mib</CODE> was a MIB included in the SNMP MIB handler,
     * <CODE>false</CODE> otherwise.
     *
     * @since 1.5
     */
    public boolean removeMib(SnmpMibAgent mib, String contextName);
     /**
     * Removes the specified MIB from the SNMP protocol adaptor.
     *
     * @param mib The MIB to be removed.
     * @param contextName The context name used at registration time.
     * @param oids The oid the MIB was previously registered for.
     * @return <CODE>true</CODE> if the specified <CODE>mib</CODE> was a MIB included in the SNMP MIB handler,
     * <CODE>false</CODE> otherwise.
     *
     * @since 1.5
     */
    public boolean removeMib(SnmpMibAgent mib, String contextName, SnmpOid[] oids);
}
