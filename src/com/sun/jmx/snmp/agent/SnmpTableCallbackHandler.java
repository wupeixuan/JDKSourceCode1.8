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
package com.sun.jmx.snmp.agent;

import javax.management.ObjectName;
import com.sun.jmx.snmp.SnmpStatusException;
import com.sun.jmx.snmp.SnmpOid;
import com.sun.jmx.snmp.agent.SnmpMibTable;

/**
 * This interface ensures the synchronization between Metadata table objects
 * and bean-like table objects.
 *
 * It is used between mibgen generated table meta and table classes.
 * <p><b><i>
 * You should never need to use this interface directly.
 * </p></b></i>
 *
 * <p><b>This API is a Sun Microsystems internal API  and is subject
 * to change without notice.</b></p>
 **/
public interface SnmpTableCallbackHandler {
    /**
     * This method is called by the SNMP runtime after a new entry
     * has been added to the table.
     *
     * If an SnmpStatusException is raised, the entry will be removed
     * and the operation will be aborted. In this case, the removeEntryCb()
     * callback will not be called.
     *
     * <p><b><i>
     * You should never need to use this method directly.
     * </p></b></i>
     *
     **/
    public void addEntryCb(int pos, SnmpOid row, ObjectName name,
                           Object entry, SnmpMibTable meta)
        throws SnmpStatusException;

    /**
     * This method is called by the SNMP runtime after a new entry
     * has been removed from the table.
     *
     * If raised, SnmpStatusException will be ignored.
     *
     * <p><b><i>
     * You should never need to use this method directly.
     * </p></b></i>
     *
     **/
    public void removeEntryCb(int pos, SnmpOid row, ObjectName name,
                              Object entry, SnmpMibTable meta)
        throws SnmpStatusException;
}
