/*
 *
 * Copyright (c) 2007, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
// Copyright (c) 1995-96 by Cisco Systems, Inc.

package com.sun.jmx.snmp;

// java import
//
import java.util.Vector;

// jmx import
//
import com.sun.jmx.snmp.SnmpOidTable;
import com.sun.jmx.snmp.SnmpOidRecord;
import com.sun.jmx.snmp.SnmpStatusException;

import static com.sun.jmx.mbeanserver.Util.cast;

/**
 * Defines a set of <CODE>SnmpOidTable</CODE> objects containing metadata definitions for MIB variables.
 * Each <CODE>SnmpOidTable</CODE> should contain information on variables of one MIB.
 * It provides resolution of all MIB variables contained in the <CODE>SnmpOidTable</CODE> objects.
 * <p><b>This API is a Sun Microsystems internal API  and is subject
 * to change without notice.</b></p>
 */

public class SnmpOidDatabaseSupport implements SnmpOidDatabase {

    /**
     * Creates an empty <CODE>SnmpOidDatabaseSupport</CODE>.
     */
    public SnmpOidDatabaseSupport(){
        tables=new Vector<SnmpOidTable>();
    }

    /**
     * Creates an <CODE>SnmpOidDatabaseSupport</CODE> containing the specified <CODE>SnmpOidTable</CODE> object.
     * @param table The <CODE>SnmpOidTable</CODE> object used to initialize this <CODE>SnmpOidDatabaseSupport</CODE>.
     */
    public SnmpOidDatabaseSupport(SnmpOidTable table){
        tables=new Vector<SnmpOidTable>();
        tables.addElement(table);
    }

    /**
     * Adds a <CODE>SnmpOidTable</CODE> object in this <CODE>SnmpOidDatabase</CODE>.
     * @param table The table to add.
     */
    public void add(SnmpOidTable table) {
        if (!tables.contains(table)) {
            tables.addElement(table);
        }
    }

    /**
     * Removes a <CODE>SnmpOidTable</CODE> object from this <CODE>SnmpOidDatabase</CODE>.
     * @param table The table to be removed.
     * @exception SnmpStatusException The specified <CODE>SnmpOidTable</CODE> does not exist in this <CODE>SnmpOidDatabase</CODE>.
     */
    public void remove(SnmpOidTable table) throws SnmpStatusException {
        if (!tables.contains(table)) {
            throw new SnmpStatusException("The specified SnmpOidTable does not exist in this SnmpOidDatabase");
        }
        tables.removeElement(table);
    }

    /**
     * Searches for a MIB variable given its logical name and returns an <CODE>SnmpOidRecord</CODE>
     * object containing information on the variable.
     * @param name The name of the MIB variable.
     * @return The <CODE>SnmpOidRecord</CODE> object containing information on the variable.
     *
     * @exception SnmpStatusException The specified name does not exist in this <CODE>SnmpOidDatabase</CODE>
     */
    public SnmpOidRecord resolveVarName(String name) throws SnmpStatusException {
        for (int i=0;i<tables.size();i++) {
            try {
                return (tables.elementAt(i).resolveVarName(name));
            }
            catch (SnmpStatusException e) {
                if (i==tables.size()-1) {
                    throw new SnmpStatusException(e.getMessage());
                }
            }
        }
        return null;
    }

    /**
     * Searches for a MIB variable given its OID and returns an <CODE>SnmpOidRecord</CODE> object containing
     * information on the variable.
     * @param oid The OID of the MIB variable.
     * @return The <CODE>SnmpOidRecord</CODE> object containing information on the variable.
     * @exception SnmpStatusException The specified oid does not exist in this <CODE>SnmpOidDatabase</CODE>.
     */
    public SnmpOidRecord resolveVarOid(String oid) throws SnmpStatusException {
        for (int i=0;i<tables.size();i++) {
            try {
                return tables.elementAt(i).resolveVarOid(oid);
            }
            catch (SnmpStatusException e) {
                if (i==tables.size()-1) {
                    throw new SnmpStatusException(e.getMessage());
                }
            }
        }
        return null;
    }

    /**
     * Returns a list that can be used to traverse all the entries of the <CODE>SnmpOidTable</CODE> objects
     * of this <CODE>SnmpOidDatabase</CODE>.
     * @return A vector of <CODE>SnmpOidTable</CODE> objects containing all the elements of this <CODE>SnmpOidDatabase</CODE>.
     */
    public Vector<?> getAllEntries() {
        Vector<SnmpOidTable> res = new Vector<SnmpOidTable>();
        for (int i=0;i<tables.size();i++) {
            Vector<SnmpOidTable> tmp = cast(tables.elementAt(i).getAllEntries());
            if (tmp != null) {
                for(int ii=0; ii<tmp.size(); ii++) {
                        res.addElement(tmp.elementAt(ii));
                }
            }
        }
//      res.addAll(((SnmpOidTable)tables.elementAt(i)).getAllEntries());
        return res;
    }

    /**
     * Removes all <CODE>SnmpOidTable</CODE> objects from this <CODE>SnmpOidDatabase</CODE>.
     */
    public void removeAll(){
        tables.removeAllElements() ;
    }

    private Vector<SnmpOidTable> tables;
}
