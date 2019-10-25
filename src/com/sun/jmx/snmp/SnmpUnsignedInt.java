/*
 * Copyright (c) 1997, 2007, Oracle and/or its affiliates. All rights reserved.
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
 * Is the base for all SNMP syntaxes based on unsigned integers.
 *
 * <p><b>This API is a Sun Microsystems internal API  and is subject
 * to change without notice.</b></p>
 */

public abstract class SnmpUnsignedInt extends SnmpInt {

    /**
     * The largest value of the type <code>unsigned int</code> (2^32 - 1).
     */
    public static final long   MAX_VALUE = 0x0ffffffffL;

    // CONSTRUCTORS
    //-------------
    /**
     * Constructs a new <CODE>SnmpUnsignedInt</CODE> from the specified integer value.
     * @param v The initialization value.
     * @exception IllegalArgumentException The specified value is negative
     * or larger than {@link #MAX_VALUE SnmpUnsignedInt.MAX_VALUE}.
     */
    public SnmpUnsignedInt(int v) throws IllegalArgumentException {
        super(v);
    }

    /**
     * Constructs a new <CODE>SnmpUnsignedInt</CODE> from the specified <CODE>Integer</CODE> value.
     * @param v The initialization value.
     * @exception IllegalArgumentException The specified value is negative
     * or larger than {@link #MAX_VALUE SnmpUnsignedInt.MAX_VALUE}.
     */
    public SnmpUnsignedInt(Integer v) throws IllegalArgumentException {
        super(v);
    }

    /**
     * Constructs a new <CODE>SnmpUnsignedInt</CODE> from the specified long value.
     * @param v The initialization value.
     * @exception IllegalArgumentException The specified value is negative
     * or larger than {@link #MAX_VALUE SnmpUnsignedInt.MAX_VALUE}.
     */
    public SnmpUnsignedInt(long v) throws IllegalArgumentException {
        super(v);
    }

    /**
     * Constructs a new <CODE>SnmpUnsignedInt</CODE> from the specified <CODE>Long</CODE> value.
     * @param v The initialization value.
     * @exception IllegalArgumentException The specified value is negative
     * or larger than {@link #MAX_VALUE SnmpUnsignedInt.MAX_VALUE}.
     */
    public SnmpUnsignedInt(Long v) throws IllegalArgumentException {
        super(v);
    }

    // PUBLIC METHODS
    //---------------
    /**
     * Returns a textual description of the type object.
     * @return ASN.1 textual description.
     */
    public String getTypeName() {
        return name ;
    }

    /**
     * This method has been defined to allow the sub-classes
     * of SnmpInt to perform their own control at intialization time.
     */
    boolean isInitValueValid(int v) {
        if ((v < 0) || (v > SnmpUnsignedInt.MAX_VALUE)) {
            return false;
        }
        return true;
    }

    /**
     * This method has been defined to allow the sub-classes
     * of SnmpInt to perform their own control at intialization time.
     */
    boolean isInitValueValid(long v) {
        if ((v < 0) || (v > SnmpUnsignedInt.MAX_VALUE)) {
            return false;
        }
        return true;
    }

    // VARIABLES
    //----------
    /**
     * Name of the type.
     */
    final static String name = "Unsigned32" ;
}
