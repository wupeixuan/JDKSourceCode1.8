/*
 *
 * Copyright (c) 2007, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
// Copyright (c) 1995-96 by Cisco Systems, Inc.

package com.sun.jmx.snmp;

/**
 * Contains an <CODE>SnmpTimeTick</CODE> value which
 * has units of 1/100th of a second.
 *
 * <p><b>This API is a Sun Microsystems internal API  and is subject
 * to change without notice.</b></p>
 *
 */

public class SnmpTimeticks extends SnmpUnsignedInt {

    // CONSTRUCTORS
    //-------------
    /**
     * Constructs a new <CODE>SnmpTimeticks</CODE> from the specified
     * integer value.
     * @param v The initialization value.
     * @exception IllegalArgumentException The specified value is negative.
     */
    public SnmpTimeticks(int v) throws IllegalArgumentException {
        super(v) ;
    }

    /**
     * Constructs a new <CODE>SnmpTimeticks</CODE> from the specified
     * <CODE>Integer</CODE> value.
     * @param v The initialization value.
     * @exception IllegalArgumentException The specified value is negative.
     */
    public SnmpTimeticks(Integer v) throws IllegalArgumentException {
        super(v) ;
    }

    /**
     * Constructs a new <CODE>SnmpTimeticks</CODE> from the specified long
     * value.
     * <p>If the specified value is greater than {@link
     * SnmpUnsignedInt#MAX_VALUE SnmpUnsignedInt.MAX_VALUE}, the SnmpTimeTicks
     * will be initialized with <code>v%(SnmpUnsignedInt.MAX_VALUE+1)</code>.
     * @param v The initialization value.
     * @exception IllegalArgumentException if the specified value is negative.
     */
    public SnmpTimeticks(long v) throws IllegalArgumentException {
        super(((v>0)?v&SnmpUnsignedInt.MAX_VALUE:v)) ;
    }

    /**
     * Constructs a new <CODE>SnmpTimeticks</CODE> from the specified
     * <CODE>Long</CODE> value.
     * <p>If the specified value is greater than {@link
     * SnmpUnsignedInt#MAX_VALUE SnmpUnsignedInt.MAX_VALUE}, the SnmpTimeTicks
     * will be initialized with <code>v%(SnmpUnsignedInt.MAX_VALUE+1)</code>.
     * @param v The initialization value.
     * @exception IllegalArgumentException if the specified value is negative.
     */
    public SnmpTimeticks(Long v) throws IllegalArgumentException {
        this(v.longValue()) ;
    }

    // PUBLIC METHODS
    //---------------
    /**
     * Parses the specified long value with time units and
     * returns a <CODE>String</CODE> of the form <CODE>d days hh:mm:ss</CODE>.
     * @param timeticks The value to be parsed.
     * @return The <CODE>String</CODE> representation of the value.
     */
    final static public String printTimeTicks(long timeticks) {
        int seconds, minutes, hours, days;
        StringBuffer buf = new StringBuffer() ;

        timeticks /= 100;
        days = (int)(timeticks / (60 * 60 * 24));
        timeticks %= (60 * 60 * 24);

        hours = (int)(timeticks / (60 * 60)) ;
        timeticks %= (60 * 60);

        minutes = (int)(timeticks / 60) ;
        seconds = (int)(timeticks % 60) ;

        if (days == 0) {
            buf.append(hours + ":" + minutes + ":" + seconds) ;
            return buf.toString() ;
        }
        if (days == 1) {
            buf.append("1 day ") ;
        } else {
            buf.append(days + " days ") ;
        }
        buf.append(hours + ":" + minutes + ":" + seconds) ;
        return buf.toString() ;
    }

    /**
     * Converts the timeticks value to its <CODE>String</CODE> form.
     * The format of the returned <CODE>String</CODE> is <CODE>d days hh:mm:ss</CODE>.
     * <BR>Note: this method simply calls the {@link #printTimeTicks printTimeTicks} method.
     * @return The <CODE>String</CODE> representation of the value.
     */
    final public String toString() {
        return printTimeTicks(value) ;
    }

    /**
     * Returns a textual description of the type object.
     * @return ASN.1 textual description.
     */
    final public String getTypeName() {
        return name;
    }

    // VARIABLES
    //----------
    /**
     * Name of the type.
     */
    final static String name = "TimeTicks" ;
    static final private long serialVersionUID = -5486435222360030630L;
}
