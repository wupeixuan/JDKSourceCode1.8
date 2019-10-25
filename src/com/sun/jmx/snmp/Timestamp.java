/*
 *
 * Copyright (c) 2007, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
// Copyright (c) 1995-96 by Cisco Systems, Inc.

package com.sun.jmx.snmp;

// java imports
//
import java.util.Date;

/**
 * This class is used by the {@link com.sun.jmx.snmp.SnmpVarBindList SnmpVarBindList} object.
 * An <CODE>SnmpVarBindList</CODE> time stamp object represents the time stamp when the list was updated
 * with the response variables.
 * <p><b>This API is a Sun Microsystems internal API  and is subject
 * to change without notice.</b></p>
 */

public class Timestamp implements java.io.Serializable {
    private static final long serialVersionUID = -242456119149401823L;

    // PRIVATE VARIABLES
    //------------------

    /**
     * The time (in hundreds of a second) since the network management portion of the system
     * was last re-initialized.
     */
    private long sysUpTime ;

    /**
     * A <CODE>long</CODE> representing the current date.
     */
    private long crtime ;

    /**
     * The <CODE>SnmpTimeticks</CODE> object corresponding to the <CODE>TimeStamp</CODE> object.
     */
    private SnmpTimeticks uptimeCache = null ;


    // CONSTRUCTORS
    //-------------

    /**
     * The default constructor. <CODE>Sysuptime</CODE> is 0.
     * This simply indicates when this object was created.
     */
    public Timestamp() {
        crtime = System.currentTimeMillis() ;
    }

    /**
     * Creates a <CODE>TimeStamp</CODE> object using the user parameters.
     * @param uptime The time (in hundredths of a second) since the
     * network management portion of the system was last re-initialized.
     * @param when The current time.
     */
    public Timestamp(long uptime, long when) {
        sysUpTime = uptime ;
        crtime = when ;
    }

    /**
     * Creates a <CODE>TimeStamp</CODE> object using the user parameters.
     * @param uptime The time (in hundredths of a second) since the
     * network management portion of the system was last re-initialized.
     */
    public Timestamp(long uptime) {
        sysUpTime = uptime ;
        crtime = System.currentTimeMillis() ;
    }


    // GETTER/SETTER
    //--------------

    /**
     * Gets the <CODE>SnmpTimeticks</CODE> object corresponding to the <CODE>TimeStamp</CODE> object.
     * @return The <CODE>SnmpTimeticks</CODE> object.
     */
    final public synchronized SnmpTimeticks getTimeTicks() {
        if (uptimeCache == null)
            uptimeCache = new SnmpTimeticks((int)sysUpTime) ;
        return uptimeCache ;
    }

    /**
     * Gets the time (in hundredths of a second) since the network management portion of the system
     * was last re-initialized.
     * @return The <CODE>sysUpTime</CODE>.
     */
    final public long getSysUpTime() {
        return sysUpTime ;
    }

    /**
     * Gets the current date.
     * @return A <CODE>Date</CODE> object representing the current date.
     */
    final public synchronized Date getDate() {
        return new Date(crtime) ;
    }

    /**
     * Gets the current date.
     * @return A <CODE>long</CODE> representing the current date.
     */
    final public long getDateTime() {
        return crtime ;
    }

    /**
     * Returns a <CODE>String</CODE> representation of the <CODE>TimeStamp</CODE> object.
     * @return A <CODE>String</CODE> representation of the <CODE>TimeStamp</CODE> object.
     */
    final public String toString() {
        StringBuffer buf = new StringBuffer() ;
        buf.append("{SysUpTime = " + SnmpTimeticks.printTimeTicks(sysUpTime)) ;
        buf.append("} {Timestamp = " + getDate().toString() + "}") ;
        return buf.toString() ;
    }
}
