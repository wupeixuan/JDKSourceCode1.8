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

public class DynValueBoxImpl extends DynValueCommonImpl implements DynValueBox
{
    //
    // Constructors
    //

    private DynValueBoxImpl() {
        this(null, (Any)null, false);
    }

    protected DynValueBoxImpl(ORB orb, Any any, boolean copyValue) {
        super(orb, any, copyValue);
    }

    protected DynValueBoxImpl(ORB orb, TypeCode typeCode) {
        super(orb, typeCode);
    }

    //
    // DynValueBox methods
    //

    public Any get_boxed_value()
        throws org.omg.DynamicAny.DynAnyPackage.InvalidValue
    {
        if (isNull) {
            throw new InvalidValue();
        }
        checkInitAny();
        return any;
    }

    public void set_boxed_value(org.omg.CORBA.Any boxed)
        throws org.omg.DynamicAny.DynAnyPackage.TypeMismatch
    {
        if ( ! isNull && ! boxed.type().equal(this.type())) {
            throw new TypeMismatch();
        }
        clearData();
        any = boxed;
        representations = REPRESENTATION_ANY;
        index = 0;
        isNull = false;
    }

    public DynAny get_boxed_value_as_dyn_any()
        throws org.omg.DynamicAny.DynAnyPackage.InvalidValue
    {
        if (isNull) {
            throw new InvalidValue();
        }
        checkInitComponents();
        return components[0];
    }

    public void set_boxed_value_as_dyn_any(DynAny boxed)
        throws org.omg.DynamicAny.DynAnyPackage.TypeMismatch
    {
        if ( ! isNull && ! boxed.type().equal(this.type())) {
            throw new TypeMismatch();
        }
        clearData();
        components = new DynAny[] {boxed};
        representations = REPRESENTATION_COMPONENTS;
        index = 0;
        isNull = false;
    }

    protected boolean initializeComponentsFromAny() {
        try {
            components = new DynAny[] {DynAnyUtil.createMostDerivedDynAny(any, orb, false)};
        } catch (InconsistentTypeCode ictc) {
            return false; // impossible
        }
        return true;
    }

    protected boolean initializeComponentsFromTypeCode() {
        try {
            any = DynAnyUtil.createDefaultAnyOfType(any.type(), orb);
            components = new DynAny[] {DynAnyUtil.createMostDerivedDynAny(any, orb, false)};
        } catch (InconsistentTypeCode ictc) {
            return false; // impossible
        }
        return true;
    }

    protected boolean initializeAnyFromComponents() {
        any = getAny(components[0]);
        return true;
    }
}
