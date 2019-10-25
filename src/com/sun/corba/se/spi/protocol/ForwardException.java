/*
 * Copyright (c) 1996, 2003, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.corba.se.spi.protocol;

import org.omg.CORBA.BAD_PARAM ;

import com.sun.corba.se.impl.orbutil.ORBUtility ;

import com.sun.corba.se.spi.ior.IOR ;

import com.sun.corba.se.spi.orb.ORB ;

/**
 * Thrown to signal an OBJECT_FORWARD or LOCATION_FORWARD
 */
public class ForwardException extends RuntimeException {
    private ORB orb ;
    private org.omg.CORBA.Object obj;
    private IOR ior ;

    public ForwardException( ORB orb, IOR ior ) {
        super();

        this.orb = orb ;
        this.obj = null ;
        this.ior = ior ;
    }

    public ForwardException( ORB orb, org.omg.CORBA.Object obj) {
        super();

        // This check is done early so that no attempt
        // may be made to do a location forward to a local
        // object.  Doing this lazily would allow
        // forwarding to locals in some restricted cases.
        if (obj instanceof org.omg.CORBA.LocalObject)
            throw new BAD_PARAM() ;

        this.orb = orb ;
        this.obj = obj ;
        this.ior = null ;
    }

    public synchronized org.omg.CORBA.Object getObject()
    {
        if (obj == null) {
            obj = ORBUtility.makeObjectReference( ior ) ;
        }

        return obj ;
    }

    public synchronized IOR getIOR()
    {
        if (ior == null) {
            ior = ORBUtility.getIOR( obj ) ;
        }

        return ior ;
    }
}
