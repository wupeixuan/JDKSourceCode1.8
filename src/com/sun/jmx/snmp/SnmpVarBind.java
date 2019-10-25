/*
 *
 * Copyright (c) 2007, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
// Copyright (c) 1995-96 by Cisco Systems, Inc.

package com.sun.jmx.snmp;

// java imports
//
import java.io.Serializable;

/**
 * This class holds information for a MIB variable contained in an {@link com.sun.jmx.snmp.SnmpVarBindList}.
 * An <CODE>SnmpVarBind</CODE> consists of three parts:<P>
 * <DL>
 * <DD>- The corresponding OID object for the MIB variable.
 * <DD>- The value part associated with that OID instance.
 * If present, it determines the MIB syntax for the object.
 * <DD>- The status of the <CODE>SnmpVarBind</CODE> which specifies whether the agent responded with an
 * exception condition for this variable such as <CODE>noSuchInstance</CODE>, <CODE>endOfMibView</CODE>,
 * or <CODE>noSuchObject</CODE>.
 * </DL>
 * <p><b>This API is a Sun Microsystems internal API  and is subject
 * to change without notice.</b></p>
 */

public class SnmpVarBind implements SnmpDataTypeEnums, Cloneable, Serializable {
    private static final long serialVersionUID = 491778383240759376L;

    // PUBLIC VARIABLES
    //-----------------

    /**
     * Keeps the legend for the value part of the <CODE>SnmpVarBind</CODE>.
     */
    static final private String statusLegend[] = { "Status Mapper", "Value not initialized",
                                                  "Valid Value", "No such object",
                                                  "No such Instance", "End of Mib View" } ;

    /**
     * Useful constant indicating that the status of the <CODE>SnmpVarBind</CODE> object is not initialized.
     */
    static final public int stValueUnspecified = 1 ;

    /**
     * Useful constant indicating that the status of the <CODE>SnmpVarBind</CODE> object is valid.
     */
    static final public int stValueOk = 2 ;

    /**
     * Useful constant indicating that the status of the <CODE>SnmpVarBind</CODE> object is <CODE>noSuchObject</CODE>.
     * Status of <CODE>SnmpVarBind</CODE> as returned by the SNMPv2 agent.
     */
    static final public int stValueNoSuchObject = 3 ;

    /**
     * Useful constant indicating that the status of the <CODE>SnmpVarBind</CODE> object is
     * <CODE>noSuchInstance</CODE>.
     * Status of <CODE>SnmpVarBind</CODE> as returned by the SNMPv2 agent.
     * In the SNMPv1 context, this is appropriate when <CODE>noSuchName</CODE> is returned in response to the
     * <CODE>SnmpGet</CODE> request.
     */
    static final public int stValueNoSuchInstance = 4 ;

    /**
     * Useful constant indicating that the status of the <CODE>SnmpVarBind</CODE> object is <CODE>endOfMibView</CODE>.
     * Status of <CODE>SnmpVarBind</CODE> as returned by the SNMPv2 agent.
     * In the SNMPv1 context, this is appropriate when <CODE>noSuchName</CODE> is returned in response to the
     * <CODE>SnmpGetNext</CODE> request.
     */
    static final public int stValueEndOfMibView = 5 ;


    //
    // These are predefined values for SNMP V2 variables
    //
    /**
     * Error code value as defined in RFC 1448 for: <CODE>noSuchObject</CODE>.
     */
    public final static SnmpNull noSuchObject   = new SnmpNull(errNoSuchObjectTag) ;

    /**
     * Error code value as defined in RFC 1448 for: <CODE>noSuchInstance</CODE>.
     */
    public final static SnmpNull noSuchInstance = new SnmpNull(errNoSuchInstanceTag) ;

    /**
     * Error code value as defined in RFC 1448 for: <CODE>endOfMibView</CODE>.
     */
    public final static SnmpNull endOfMibView   = new SnmpNull(errEndOfMibViewTag) ;

    /**
     * The OID of the <CODE>SnmpVarBind</CODE>.
     * The default value is null.
     * <p><b>Reserved for internal use:</b><br>
     * As of Java Dynamic Management Kit 5.0, use instead <CODE>getOid</CODE> and <CODE>setOid</CODE></p>
     */
    public SnmpOid oid = null ;

    /**
     * The value of the <CODE>SnmpVarBind</CODE>.
     * The default value is null.
     * <p><b>Reserved for internal use:</b><br>
     * As of Java Dynamic Management Kit 5.0, use instead <CODE>getSnmpValue</CODE> and <CODE>setSnmpValue</CODE></p>
     */
    public SnmpValue value = null ;

    /**
     * Indicates the status of the value in this <CODE>SnmpVarBind</CODE>.
     * The default value is <CODE>stValueUnspecified</CODE>.
     * This attribute is updated internally and should not be changed otherwise.
     */
    public int status = stValueUnspecified ;


    // CONSTRUCTORS
    //-------------

    /**
     * Default constructor.
     */
    public SnmpVarBind() {
    }

    /**
     * Constructs a new <CODE>SnmpVarBind</CODE> object from the specified <CODE>SnmpOid</CODE> value.
     * @param oid The OID part of the <CODE>SnmpVarBind</CODE>.
     */
    public SnmpVarBind(SnmpOid oid) {
        this.oid = oid ;
    }

    /**
     * Constructs a new <CODE>SnmpVarBind</CODE> object from the specified <CODE>SnmpOid</CODE> and
     * <CODE>SnmpValue</CODE>.
     * @param oid The OID part of the <CODE>SnmpVarBind</CODE>.
     * @param val The value part of the <CODE>SnmpVarBind</CODE>.
     */
    public SnmpVarBind(SnmpOid oid, SnmpValue val) {
        this.oid = oid ;
        this.setSnmpValue(val) ;
    }

    /**
     * Constructs a new <CODE>SnmpVarBind</CODE> object from the specified <CODE>String</CODE> value.
     * If the name is a MIB variable, it resolves the name with the MIB database.
     * @param name The MIB variable name or a dot-formatted OID <CODE>String</CODE>.
     * @exception SnmpStatusException An error occurred while resolving the MIB variable name.
     */
    public SnmpVarBind(String name) throws SnmpStatusException {

        if (name.startsWith(".")) {
            this.oid = new SnmpOid(name) ;
        } else {
            SnmpOidRecord record;
            try {
                int index = name.indexOf('.') ;
                handleLong(name, index);
                this.oid = new SnmpOid(name);
            }
            catch(NumberFormatException e) {
                int index = name.indexOf('.') ;
                if (index <= 0) {
                    record = resolveVarName(name) ;
                    this.oid = new SnmpOid(record.getName()) ;
                } else {
                    record = resolveVarName(name.substring(0, index)) ;
                    this.oid = new SnmpOid(record.getName() + name.substring(index)) ;
                }
            }
        }
    }


    // GETTER/SETTER
    //--------------

    /**
     * Returns the complete OID part associated with this <CODE>SnmpVarBind</CODE>.
     * @return The <CODE>SnmpOid</CODE> for this variable.
     */
    final public SnmpOid getOid() {
        return this.oid ;
    }

    /**
     * Sets the <CODE>SnmpOid</CODE> part associated with this <CODE>SnmpVarBind</CODE> with the specified OID.
     * The value part of this <CODE>SnmpVarBind</CODE> will automatically be nulled.
     * @param oid The new OID.
     */
    final public void setOid(SnmpOid oid) {
        this.oid = oid ;
        clearValue() ;
    }

    /**
     * Returns the value part associated with this <CODE>SnmpVarBind</CODE>.
     * @return The <CODE>SnmpValue</CODE> for this variable.
     */
    final synchronized public SnmpValue getSnmpValue() {
        return this.value ;
    }

    /**
     * Sets the <CODE>SnmpValue</CODE> part associated with this <CODE>SnmpVarBind</CODE> with the specified value.
     * The status is updated to indicate that the value is valid.
     * @param val The new value.
     */
    final public void setSnmpValue(SnmpValue val) {
        this.value= val ;
        setValueValid();
    }

    /**
     * Returns the value part associated with this <CODE>SnmpVarBind</CODE>.
     * @return The <CODE>SnmpCounter64</CODE> value for this variable.
     * @exception ClassCastException An attempt has been made to cast an object to a subclass of which
     * it is not an instance.
     */
    final public SnmpCounter64 getSnmpCounter64Value() throws ClassCastException {
        return (SnmpCounter64)this.value ;
    }

    /**
     * Sets the <CODE>SnmpCounter64</CODE> value part associated with this <CODE>SnmpVarBind</CODE>
     * with the specified counter 64 value.
     * The status is updated to indicate that the value is valid.
     * @param val The new counter 64 value.
     * @exception IllegalArgumentException The specified value is negative or larger than <CODE>Long.MAX_VALUE</CODE>.
     * @see SnmpCounter64
     */
    final public void setSnmpCounter64Value(long val) throws IllegalArgumentException {
        clearValue() ;
        this.value = new SnmpCounter64(val) ;
        setValueValid() ;
    }

    /**
     * Returns the value part associated with this <CODE>SnmpVarBind</CODE>.
     * @return The <CODE>SnmpInt</CODE> value for this variable.
     * @exception ClassCastException An attempt has been made to cast an object to a subclass of which
     * it is not an instance.
     */
    final public SnmpInt getSnmpIntValue() throws ClassCastException {
        return (SnmpInt)this.value ;
    }

    /**
     * Sets the <CODE>SnmpInt</CODE> value part associated with this <CODE>SnmpVarBind</CODE>
     * with the specified integer value.
     * The status is updated to indicate that the value is valid.
     * @param val The new integer value.
     * @exception IllegalArgumentException The specified value is smaller than <CODE>Integer.MIN_VALUE</CODE>
     * or larger than <CODE>Integer.MAX_VALUE</CODE>.
     * @see SnmpInt
     */
    final public void setSnmpIntValue(long val) throws IllegalArgumentException {
        clearValue() ;
        this.value = new SnmpInt(val) ;
        setValueValid() ;
    }

    /**
     * Returns the value part associated with this <CODE>SnmpVarBind</CODE>.
     * @return The <CODE>SnmpCounter</CODE> value for this variable.
     * @exception ClassCastException An attempt has been made to cast an object to a subclass of which
     * it is not an instance.
     */
    final public SnmpCounter getSnmpCounterValue() throws ClassCastException {
        return (SnmpCounter)this.value ;
    }

    /**
     * Sets the <CODE>SnmpCounter</CODE> value part associated with this <CODE>SnmpVarBind</CODE>
     * with the specified counter value.
     * The status is updated to indicate that the value is valid.
     * @param val The new counter value.
     * @exception IllegalArgumentException The specified value is negative or larger than
     * <CODE>SnmpUnsignedInt.MAX_VALUE</CODE>.
     * @see SnmpCounter
     */
    final public void setSnmpCounterValue(long val) throws IllegalArgumentException {
        clearValue() ;
        this.value = new SnmpCounter(val) ;
        setValueValid() ;
    }

    /**
     * Returns the value part associated with this <CODE>SnmpVarBind</CODE>.
     * @return The <CODE>SnmpGauge</CODE> value for this variable.
     * @exception ClassCastException An attempt has been made to cast an object to a subclass of which
     * it is not an instance.
     */
    final public SnmpGauge getSnmpGaugeValue() throws ClassCastException {
        return (SnmpGauge)this.value ;
    }

    /**
     * Sets the <CODE>SnmpGauge</CODE> value part associated with this <CODE>SnmpVarBind</CODE>
     * with the specified gauge value.
     * The status is updated to indicate that the value is valid.
     * @param val The new gauge value.
     * @exception IllegalArgumentException The specified value is negative or larger than
     * <CODE>SnmpUnsignedInt.MAX_VALUE</CODE>.
     * @see SnmpGauge
     */
    final public void setSnmpGaugeValue(long val) throws IllegalArgumentException {
        clearValue() ;
        this.value = new SnmpGauge(val) ;
        setValueValid() ;
    }

    /**
     * Returns the value part associated with this <CODE>SnmpVarBind</CODE>.
     * @return The <CODE>SnmpTimeticks</CODE> value for this variable.
     * @exception ClassCastException An attempt has been made to cast an object to a subclass of which
     * it is not an instance.
     */
    final public SnmpTimeticks getSnmpTimeticksValue() throws ClassCastException {
        return (SnmpTimeticks)this.value ;
    }

    /**
     * Sets the <CODE>SnmpTimeticks</CODE> value part associated with this <CODE>SnmpVarBind</CODE>
     * with the specified timeticks value.
     * The status is updated to indicate that the value is valid.
     * @param val The new timeticks value.
     * @exception IllegalArgumentException The specified value is negative or larger than
     * <CODE>SnmpUnsignedInt.MAX_VALUE</CODE>.
     * @see SnmpTimeticks
     */
    final public void setSnmpTimeticksValue(long val) throws IllegalArgumentException {
        clearValue() ;
        this.value = new SnmpTimeticks(val) ;
        setValueValid() ;
    }

    /**
     * Returns the value part associated with this <CODE>SnmpVarBind</CODE>.
     * @return The <CODE>SnmpOid</CODE> value for this variable.
     * @exception ClassCastException An attempt has been made to cast an object to a subclass of which
     * it is not an instance.
     */
    final public SnmpOid getSnmpOidValue() throws ClassCastException {
        return (SnmpOid)this.value ;
    }

    /**
     * Sets the <CODE>SnmpOid</CODE> value part associated with this <CODE>SnmpVarBind</CODE>
     * with the specified OID value.
     * The status is updated to indicate that the value is valid.
     * @param val The new OID value.
     * @exception IllegalArgumentException The specified value is neither a numeric <CODE>String</CODE>
     * nor a <CODE>String</CODE> of the MIB database.
     * @see SnmpOid
     */
    final public void setSnmpOidValue(String val) throws IllegalArgumentException {
        clearValue() ;
        this.value = new SnmpOid(val) ;
        setValueValid() ;
    }

    /**
     * Returns the value part associated with this <CODE>SnmpVarBind</CODE>.
     * @return The <CODE>SnmpIpAddress</CODE> value for this variable.
     * @exception ClassCastException An attempt has been made to cast an object to a subclass of which
     * it is not an instance.
     */
    final public SnmpIpAddress getSnmpIpAddressValue() throws ClassCastException {
        return (SnmpIpAddress)this.value ;
    }

    /**
     * Sets the <CODE>SnmpIpAddress</CODE> value part associated with this <CODE>SnmpVarBind</CODE>
     * with the specified ipAddress value.
     * The status is updated to indicate that the value is valid.
     * @param val The new IP address value.
     * @exception IllegalArgumentException The specified value does not correspond to an IP address.
     * @see SnmpIpAddress
     */
    final public void setSnmpIpAddressValue(String val) throws IllegalArgumentException {
        clearValue() ;
        this.value = new SnmpIpAddress(val) ;
        setValueValid() ;
    }

    /**
     * Returns the value part associated with this <CODE>SnmpVarBind</CODE>.
     * @return The <CODE>SnmpString</CODE> value for this variable.
     * @exception ClassCastException An attempt has been made to cast an object to a subclass of which
     * it is not an instance.
     */
    final public SnmpString getSnmpStringValue() throws ClassCastException {
        return (SnmpString)this.value ;
    }

    /**
     * Sets the <CODE>SnmpString</CODE> value part associated with this <CODE>SnmpVarBind</CODE>
     * with the specified string value.
     * The status is updated to indicate that the value is valid.
     * @param val The new string value.
     * @see SnmpString
     */
    final public void setSnmpStringValue(String val) {
        clearValue() ;
        this.value = new SnmpString(val) ;
        setValueValid() ;
    }

    /**
     * Returns the value part associated with this <CODE>SnmpVarBind</CODE>.
     * @return The <CODE>SnmpOpaque</CODE> value for this variable.
     * @exception ClassCastException An attempt has been made to cast an object to a subclass of which
     * it is not an instance.
     */
    final public SnmpOpaque getSnmpOpaqueValue() throws ClassCastException {
        return (SnmpOpaque)this.value ;
    }

    /**
     * Sets the <CODE>SnmpOpaque</CODE> value part associated with this <CODE>SnmpVarBind</CODE>
     * with the specified bytes array values.
     * The status is updated to indicate that the value is valid.
     * @param val The new bytes array value.
     * @see SnmpOpaque
     */
    final public void setSnmpOpaqueValue(byte[] val) {
        clearValue() ;
        this.value = new SnmpOpaque(val) ;
        setValueValid() ;
    }

    /**
     * Returns the value part associated with this <CODE>SnmpVarBind</CODE>.
     * @return The <CODE>SnmpStringFixed</CODE> value for this variable.
     * @exception ClassCastException An attempt has been made to cast an object to a subclass of which
     * it is not an instance.
     */
    final public SnmpStringFixed getSnmpStringFixedValue() throws ClassCastException {
        return (SnmpStringFixed)this.value ;
    }

    /**
     * Sets the <CODE>SnmpStringFixed</CODE> value part associated with this <CODE>SnmpVarBind</CODE>
     * with the specified string value.
     * The status is updated to indicate that the value is valid.
     * @param val The new string value.
     * @see SnmpStringFixed
     */
    final public void setSnmpStringFixedValue(String val) {
        clearValue() ;
        this.value = new SnmpStringFixed(val) ;
        setValueValid() ;
    }


    // PUBLIC METHODS
    //---------------

    /**
     * Consults the MIB table storage to resolve the name to its OID type structure.
     * @param name The MIB variable name or a dot-formatted OID <CODE>String</CODE>.
     * @return The <CODE>SnmpOidRecord</CODE> object containing information on the MIB variable.
     * @exception SnmpStatusException An error occurred while resolving the MIB variable name.
     */
    public SnmpOidRecord resolveVarName(String name) throws SnmpStatusException {

        SnmpOidTable mibTable = SnmpOid.getSnmpOidTable();
        if (mibTable == null)
            throw new SnmpStatusException(SnmpStatusException.noSuchName);
        int index = name.indexOf('.');
        if (index < 0) {
            return mibTable.resolveVarName(name);
        } else {
            return mibTable.resolveVarOid(name);
        }
    }

    /**
     * Returns the status of the value associated with this <CODE>SnmpVarBind</CODE> as an integer.
     * This value is one of {@link #stValueUnspecified}, {@link #stValueOk}, {@link #stValueNoSuchObject},
     * {@link #stValueNoSuchInstance}, {@link #stValueEndOfMibView}.
     * @return The status of the associated value.
     */
    final public int getValueStatus() {
        return status ;
    }

    /**
     * Returns the status of the value associated with this <CODE>SnmpVarBind</CODE> as a <CODE>String</CODE>.
     * This value is a displayable representation of the status integer value.
     * It is one of <CODE>Value not initialized</CODE>, <CODE>Valid Value</CODE>, <CODE>No such object</CODE>,
     * <CODE>No such Instance</CODE>, <CODE>End of Mib View</CODE>.
     * @return The status of the associated value.
     */
    final public String getValueStatusLegend() {
        return statusLegend[status] ;
    }

    /**
     * Checks whether the object contains a valid accessible value.
     * @return <CODE>true</CODE> if the associated value is valid, <CODE>false</CODE> otherwise.
     */
    final public boolean isValidValue() {
        return (status == stValueOk) ;
    }

    /**
     * Checks whether the value associated with this <CODE>SnmpVarBind</CODE> is unspecified.
     * @return <CODE>true</CODE> if the status is unspecified, <CODE>false</CODE> otherwise.
     */
    final public boolean isUnspecifiedValue() {
        return (status == stValueUnspecified) ;
    }

    /**
     * Clears the value associated with this <CODE>SnmpVarBind</CODE> and sets the status to
     * <CODE>stValueUnspecified</CODE>.
     */
    final public void clearValue() {
        this.value = null ;
        status = stValueUnspecified ;
    }

    /**
     * Checks whether the OID for this variable completely matches the OID part of the specified
     * <CODE>SnmpVarBind</CODE> object.
     * @param var The object whose OID part is to be matched.
     * @return <CODE>true</CODE> if the OID part matches exactly, <CODE>false</CODE> otherwise.
     */
    final public boolean isOidEqual(SnmpVarBind var) {
        return this.oid.equals(var.oid) ;
    }

    /**
     * Adds an instance part to the OID in the <CODE>SnmpOid</CODE> object.
     * Note that there is no <CODE>getInstance</CODE> method.
     * This method will directly add the instance to the <CODE>SnmpOid</CODE> object.
     * @param inst The sub-identifier to be appended to the OID.
     */
    final public void addInstance(long inst) {
        oid.append(inst) ;
    }

    /**
     * Adds an instance part to the OID in the <CODE>SnmpOid</CODE> object.
     * Note that there is no <CODE>getInstance</CODE> method.
     * This method will directly add the instance to the <CODE>SnmpOid</CODE> object.
     * @param inst The sub-identifier array to be appended to the OID.
     * @exception SnmpStatusException An error occurred while accessing a MIB node.
     */
    final public void addInstance(long[] inst) throws SnmpStatusException {
        oid.addToOid(inst) ;
    }

    /**
     * Adds an instance part to the OID in the <CODE>SnmpOid</CODE> object.
     * Note that there is no <CODE>getInstance</CODE> method.
     * This method will directly add the instance to the <CODE>SnmpOid</CODE> object.
     * @param inst Dot-formatted sub-identifier <CODE>String</CODE> to be appended to the OID.
     * @exception SnmpStatusException An error occurred while accessing a MIB node.
     */
    final public void addInstance(String inst) throws SnmpStatusException {
        if (inst != null) {
            oid.addToOid(inst) ;
        }
        return ;
    }

    /**
     * Inserts a sub-id at the beginning of the OID of this <CODE>SnmpVarBind</CODE>.
     * @param oid The sub-id to insert.
     */
    public void insertInOid(int oid) {
        this.oid.insert(oid) ;
    }

    /**
     * Appends the specified <CODE>SnmpOid</CODE> to the end of the OID of this <CODE>SnmpVarBind</CODE>.
     * @param oid The OID to append.
     */
    public void appendInOid(SnmpOid oid) {
        this.oid.append(oid) ;
    }

    /**
     * Determines whether the <CODE>SnmpVarBind</CODE> has an SNMP exception
     * (generated by agent in response to a request).
     * @return <CODE>true</CODE> if the <CODE>SnmpVarBind</CODE> has an SNMP response exception,
     * <CODE>false</CODE> otherwise.
     */
    final public synchronized boolean hasVarBindException() {
        switch (status) {
        case  stValueUnspecified :
        case  stValueNoSuchObject :
        case  stValueNoSuchInstance :
        case  stValueEndOfMibView :
            return true ;
        }
        return false ;
    }

    /**
     * Clones and copies the OID and value part from another <CODE>SnmpVarBind</CODE> object.
     * @param var The <CODE>SnmpVarBind</CODE> clone.
     */
    public void copyValueAndOid(SnmpVarBind var) {
        setOid((SnmpOid) (var.oid.clone())) ;
        copyValue(var) ;
    }

    /**
     * Clones and copies only the value part from another <CODE>SnmpVarBind</CODE> object.
     * @param var The <CODE>SnmpVarBind</CODE> clone.
     */
    public void copyValue(SnmpVarBind var) {
        if (var.isValidValue()) {
            this.value = var.getSnmpValue().duplicate() ;
            setValueValid() ;
        } else {
            status = var.getValueStatus() ;
            if (status == stValueEndOfMibView)        value=endOfMibView;
            else if (status == stValueNoSuchObject)   value=noSuchObject;
            else if (status == stValueNoSuchInstance) value=noSuchInstance;
        }
    }

    /**
     * Clones the SNMP variable. It does not clone the value portion.
     * @return A new object with the value part set to null.
     */
    public Object cloneWithoutValue() {
        SnmpOid noid = (SnmpOid)this.oid.clone() ;
        return new SnmpVarBind(noid) ;
    }

    /**
     * Clones the SNMP variable (including value).
     * @return The SNMP variable clone.
     */
    @Override
    public SnmpVarBind clone() {
        // FindBugs will issue a warning here, because super.clone()
        // is not called. But this is actually OK because we construct
        // a brand new object.
        SnmpVarBind v = new SnmpVarBind() ;
        v.copyValueAndOid(this) ;
        return v ;
    }

    /**
     * Returns the printable ASCII representation for the corresponding variable value.
     * @return The printable ASCII representation.
     */
    final public String getStringValue() {
        return this.value.toString() ;
    }

    /**
     * Set the value to {@link #noSuchObject}. This is equivalent to
     * <code>setSnmpValue(SnmpVarBind.noSuchObject)</code>.
     **/
    final public void setNoSuchObject() {
        value=noSuchObject;
        status=stValueNoSuchObject;
    }

    /**
     * Set the value to {@link #noSuchInstance}. This is equivalent to
     * <code>setSnmpValue(SnmpVarBind.noSuchInstance)</code>.
     **/
    final public void setNoSuchInstance() {
        value=noSuchInstance;
        status=stValueNoSuchInstance;
    }

    /**
     * Set the value to {@link #endOfMibView}. This is equivalent to
     * <code>setSnmpValue(SnmpVarBind.endOfMibView)</code>.
     **/
    final public void setEndOfMibView() {
        value=endOfMibView;
        status=stValueEndOfMibView;
    }

     /**
     * Returns the printable ASCII representation of this <CODE>SnmpVarBind</CODE>.
     * @return The printable ASCII representation.
     */
    @Override
    final public String toString() {
        final StringBuilder s = new StringBuilder(400) ;
        s.append("Object ID : ").append(this.oid.toString()) ;

        if (isValidValue()) {
            s.append("  (Syntax : ").append(this.value.getTypeName()).append(")\n") ;
            s.append("Value : ").append(this.value.toString()) ;
        } else {
            s.append("\n" + "Value Exception : ").append(getValueStatusLegend()) ;
        }
        return s.toString() ;
    }


    // PRIVATE METHODS
    //----------------

    /**
     * Sets the status to indicate that the value for this <CODE>SnmpVarBind</CODE> is valid.
     */
    private void setValueValid() {
        if (value == endOfMibView)        status=stValueEndOfMibView;
        else if (value == noSuchObject)   status=stValueNoSuchObject;
        else if (value == noSuchInstance) status=stValueNoSuchInstance;
        else status = stValueOk ;
    }

    private void handleLong(String oid, int index) throws NumberFormatException, SnmpStatusException {

        String str;
        if (index >0) {
            str= oid.substring(0, index);
        } else {
            str= oid ;
        }

        // just parse the element.
        //
        Long.parseLong(str);
    }
}
