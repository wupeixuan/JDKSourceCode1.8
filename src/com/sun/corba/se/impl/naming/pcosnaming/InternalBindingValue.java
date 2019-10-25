/*
 * Copyright (c) 1999, 2003, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.corba.se.impl.naming.pcosnaming;

import org.omg.CORBA.Object;
import org.omg.CosNaming.BindingType;
import java.io.Serializable;

/**
 * Class InternalBindingKey acts as a container for two objects, namely
 * a org.omg.CosNaming::Binding and an CORBA object reference, which are the two
 * components associated with the binding.
 */
public class InternalBindingValue
                implements Serializable
{
    public BindingType theBindingType;
    // The value stores both Stringified Object Reference and
    // Non-Stringified Object Reference. This is done to avoid
    // calling orb.string_to_object( ) everytime. Instead it
    // will be set once and then the result will be used everytime.
    public String strObjectRef;
    transient private org.omg.CORBA.Object theObjectRef;

    // Default constructor
    public InternalBindingValue() {
    }

    // Normal constructor
    public InternalBindingValue(BindingType b, String o) {
        // Objectreference or Context
        theBindingType = b;
        strObjectRef = o;
    }

    public org.omg.CORBA.Object getObjectRef( )
    {
        return theObjectRef;
    }

    public void setObjectRef( org.omg.CORBA.Object ObjectRef )
    {
        theObjectRef = ObjectRef;
    }

}
