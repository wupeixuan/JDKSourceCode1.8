/*
 * Copyright (c) 1998, 2004, Oracle and/or its affiliates. All rights reserved.
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


package org.omg.CORBA;

/**
 * The <code>DynUnion</code> interface represents a <code>DynAny</code> object
 * that is associated with an IDL union.
 * Union values can be traversed using the operations defined in <code>DynAny</code>.
 * The first component in the union corresponds to the discriminator;
 * the second corresponds to the actual value of the union.
 * Calling the method <code>next()</code> twice allows you to access both components.
 * @deprecated Use the new <a href="../DynamicAny/DynUnion.html">DynUnion</a> instead
 */
@Deprecated
public interface DynUnion extends org.omg.CORBA.Object, org.omg.CORBA.DynAny
{
    /**
     * Determines whether the discriminator associated with this union has been assigned
     * a valid default value.
     * @return <code>true</code> if the discriminator has a default value;
     * <code>false</code> otherwise
     */
    public boolean set_as_default();

    /**
    * Determines whether the discriminator associated with this union gets assigned
    * a valid default value.
    * @param arg <code>true</code> if the discriminator gets assigned a default value
    */
    public void set_as_default(boolean arg);

    /**
    * Returns a DynAny object reference that must be narrowed to the type
    * of the discriminator in order to insert/get the discriminator value.
    * @return a <code>DynAny</code> object reference representing the discriminator value
    */
    public org.omg.CORBA.DynAny discriminator();

    /**
    * Returns the TCKind object associated with the discriminator of this union.
    * @return the <code>TCKind</code> object associated with the discriminator of this union
    */
    public org.omg.CORBA.TCKind discriminator_kind();

    /**
    * Returns a DynAny object reference that is used in order to insert/get
    * a member of this union.
    * @return the <code>DynAny</code> object representing a member of this union
    */
    public org.omg.CORBA.DynAny member();

    /**
    * Allows for the inspection of the name of this union member
    * without checking the value of the discriminator.
    * @return the name of this union member
    */
    public String member_name();

    /**
    * Allows for the assignment of the name of this union member.
    * @param arg the new name of this union member
    */
    public void member_name(String arg);

    /**
    * Returns the TCKind associated with the member of this union.
    * @return the <code>TCKind</code> object associated with the member of this union
    */
    public org.omg.CORBA.TCKind member_kind();
}
