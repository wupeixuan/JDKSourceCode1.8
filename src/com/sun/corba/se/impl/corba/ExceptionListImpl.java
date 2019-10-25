/*
 * Copyright (c) 1996, 2002, Oracle and/or its affiliates. All rights reserved.
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
/*
 * Licensed Materials - Property of IBM
 * RMI-IIOP v1.0
 * Copyright IBM Corp. 1998 1999  All Rights Reserved
 *
 */

package com.sun.corba.se.impl.corba;

import java.util.Vector;

import org.omg.CORBA.Bounds;
import org.omg.CORBA.ExceptionList;
import org.omg.CORBA.TypeCode;
import org.omg.CORBA.ORB;


public class ExceptionListImpl extends ExceptionList {

    private final int    INITIAL_CAPACITY       = 2;
    private final int    CAPACITY_INCREMENT     = 2;

    private Vector _exceptions;

    public ExceptionListImpl() {
        _exceptions = new Vector(INITIAL_CAPACITY, CAPACITY_INCREMENT);
    }

    public int count()
    {
        return _exceptions.size();
    }

    public void add(TypeCode tc)
    {
        _exceptions.addElement(tc);
    }

    public TypeCode item(int index)
        throws Bounds
    {
        try {
            return (TypeCode) _exceptions.elementAt(index);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new Bounds();
        }
    }

    public void remove(int index)
        throws Bounds
    {
        try {
            _exceptions.removeElementAt(index);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new Bounds();
        }
    }

}
