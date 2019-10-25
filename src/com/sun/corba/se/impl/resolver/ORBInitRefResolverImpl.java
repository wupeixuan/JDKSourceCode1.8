/*
 * Copyright (c) 2002, 2003, Oracle and/or its affiliates. All rights reserved.
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

import com.sun.corba.se.spi.resolver.Resolver ;

import com.sun.corba.se.spi.orb.ORB ;

import com.sun.corba.se.spi.orb.Operation ;
import com.sun.corba.se.spi.orb.StringPair ;

public class ORBInitRefResolverImpl implements Resolver {
    Operation urlHandler ;
    java.util.Map orbInitRefTable ;

    public ORBInitRefResolverImpl( Operation urlHandler, StringPair[] initRefs )
    {
        this.urlHandler = urlHandler ;
        orbInitRefTable = new java.util.HashMap() ;

        for( int i = 0; i < initRefs.length ; i++ ) {
            StringPair sp = initRefs[i] ;
            orbInitRefTable.put( sp.getFirst(), sp.getSecond() ) ;
        }
    }

    public org.omg.CORBA.Object resolve( String ident )
    {
        String url = (String)orbInitRefTable.get( ident ) ;
        if (url == null)
            return null ;

        org.omg.CORBA.Object result =
            (org.omg.CORBA.Object)urlHandler.operate( url ) ;
        return result ;
    }

    public java.util.Set list()
    {
        return orbInitRefTable.keySet() ;
    }
}
