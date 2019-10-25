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



import java.io.Serializable;

/**
 * Is an abstract representation of an SNMP Value.
 * All classes provided for dealing with SNMP types should derive from this
 * class.
 *
 * <p><b>This API is a Sun Microsystems internal API  and is subject
 * to change without notice.</b></p>
 */

public abstract class SnmpValue implements Cloneable, Serializable, SnmpDataTypeEnums {

    /**
     * Returns a <CODE>String</CODE> form containing ASN.1 tagging information.
     * @return The <CODE>String</CODE> form.
     */
    public String toAsn1String() {
        return "[" + getTypeName() + "] " + toString();
    }

    /**
     * Returns the value encoded as an OID.
     * The method is particularly useful when dealing with indexed table made of
     * several SNMP variables.
     * @return The value encoded as an OID.
     */
    public abstract SnmpOid toOid() ;

    /**
     * Returns a textual description of the object.
     * @return ASN.1 textual description.
     */
    public abstract String getTypeName() ;

    /**
     * Same as clone, but you cannot perform cloning using this object because
     * clone is protected. This method should call <CODE>clone()</CODE>.
     * @return The <CODE>SnmpValue</CODE> clone.
     */
    public abstract SnmpValue duplicate() ;

    /**
     * This method returns <CODE>false</CODE> by default and is redefined
     * in the {@link com.sun.jmx.snmp.SnmpNull} class.
     */
    public boolean isNoSuchObjectValue() {
        return false;
    }

    /**
     * This method returns <CODE>false</CODE> by default and is redefined
     * in the {@link com.sun.jmx.snmp.SnmpNull} class.
     */
    public boolean isNoSuchInstanceValue() {
        return false;
    }

    /**
     * This method returns <CODE>false</CODE> by default and is redefined
     * in the {@link com.sun.jmx.snmp.SnmpNull} class.
     */
    public boolean isEndOfMibViewValue() {
        return false;
    }
}
