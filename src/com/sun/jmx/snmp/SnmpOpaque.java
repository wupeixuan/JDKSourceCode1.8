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
 * Is used to represent an SNMP value.
 * The <CODE>Opaque</CODE> type is defined in RFC 1155.
 *
 * <p><b>This API is a Sun Microsystems internal API  and is subject
 * to change without notice.</b></p>
 */

public class SnmpOpaque extends SnmpString {
    private static final long serialVersionUID = 380952213936036664L;

    // CONSTRUCTORS
    //-------------
    /**
     * Constructs a new <CODE>SnmpOpaque</CODE> from the specified bytes array.
     * @param v The bytes composing the opaque value.
     */
    public SnmpOpaque(byte[] v) {
        super(v) ;
    }

    /**
     * Constructs a new <CODE>SnmpOpaque</CODE> with the specified <CODE>Bytes</CODE> array.
     * @param v The <CODE>Bytes</CODE> composing the opaque value.
     */
    public SnmpOpaque(Byte[] v) {
        super(v) ;
    }

    /**
     * Constructs a new <CODE>SnmpOpaque</CODE> from the specified <CODE>String</CODE> value.
     * @param v The initialization value.
     */
    public SnmpOpaque(String v) {
        super(v) ;
    }

    // PUBLIC METHODS
    //---------------
    /**
     * Converts the opaque to its <CODE>String</CODE> form, that is, a string of
     * bytes expressed in hexadecimal form.
     * @return The <CODE>String</CODE> representation of the value.
     */
    public String toString() {
        StringBuffer result = new StringBuffer() ;
        for (int i = 0 ; i < value.length ; i++) {
            byte b = value[i] ;
            int n = (b >= 0) ? b : b + 256 ;
            result.append(Character.forDigit(n / 16, 16)) ;
            result.append(Character.forDigit(n % 16, 16)) ;
        }
        return result.toString() ;
    }

    /**
     * Returns a textual description of the type object.
     * @return ASN.1 textual description.
     */
    final public String getTypeName() {
        return name ;
    }

    // VARIABLES
    //----------
    /**
     * Name of the type.
     */
    final static String name = "Opaque" ;
}
