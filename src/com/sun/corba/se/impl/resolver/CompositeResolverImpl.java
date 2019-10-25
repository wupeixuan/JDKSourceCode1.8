/*
 * Copyright (c) 2002, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.corba.se.impl.resolver ;

import java.util.Set ;
import java.util.HashSet ;

import com.sun.corba.se.spi.resolver.Resolver ;

public class CompositeResolverImpl implements Resolver {
    private Resolver first ;
    private Resolver second ;

    public CompositeResolverImpl( Resolver first, Resolver second )
    {
        this.first = first ;
        this.second = second ;
    }

    public org.omg.CORBA.Object resolve( String name )
    {
        org.omg.CORBA.Object result = first.resolve( name ) ;
        if (result == null)
            result = second.resolve( name ) ;
        return result ;
    }

    public java.util.Set list()
    {
        Set result = new HashSet() ;
        result.addAll( first.list() ) ;
        result.addAll( second.list() ) ;
        return result ;
    }
}
