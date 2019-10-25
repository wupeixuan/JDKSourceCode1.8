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

package com.sun.corba.se.impl.dynamicany;

import org.omg.CORBA.TypeCode;
import org.omg.CORBA.TCKind;
import org.omg.CORBA.Any;
import org.omg.CORBA.TypeCodePackage.BadKind;
import org.omg.CORBA.TypeCodePackage.Bounds;
import org.omg.DynamicAny.*;
import org.omg.DynamicAny.DynAnyPackage.TypeMismatch;
import org.omg.DynamicAny.DynAnyPackage.InvalidValue;
import org.omg.DynamicAny.DynAnyFactoryPackage.InconsistentTypeCode;

import com.sun.corba.se.spi.orb.ORB ;
import com.sun.corba.se.spi.logging.CORBALogDomains ;
import com.sun.corba.se.impl.logging.ORBUtilSystemException ;

public class DynStructImpl extends DynAnyComplexImpl implements DynStruct
{
    //
    // Constructors
    //

    private DynStructImpl() {
        this(null, (Any)null, false);
    }

    protected DynStructImpl(ORB orb, Any any, boolean copyValue) {
        // We can be sure that typeCode is of kind tk_struct
        super(orb, any, copyValue);
        // Initialize components lazily, on demand.
        // This is an optimization in case the user is only interested in storing Anys.
    }

    protected DynStructImpl(ORB orb, TypeCode typeCode) {
        // We can be sure that typeCode is of kind tk_struct
        super(orb, typeCode);
        // For DynStruct, the operation sets the current position to -1
        // for empty exceptions and to zero for all other TypeCodes.
        // The members (if any) are (recursively) initialized to their default values.
        index = 0;
    }

    //
    // Methods differing from DynValues
    //

    public org.omg.DynamicAny.NameValuePair[] get_members () {
        if (status == STATUS_DESTROYED) {
            throw wrapper.dynAnyDestroyed() ;
        }
        checkInitComponents();
        return nameValuePairs;
    }

    public org.omg.DynamicAny.NameDynAnyPair[] get_members_as_dyn_any () {
        if (status == STATUS_DESTROYED) {
            throw wrapper.dynAnyDestroyed() ;
        }
        checkInitComponents();
        return nameDynAnyPairs;
    }
}
