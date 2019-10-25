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

import com.sun.corba.se.spi.resolver.Resolver ;

import com.sun.corba.se.spi.orb.Operation ;

public class ORBDefaultInitRefResolverImpl implements Resolver {
    Operation urlHandler ;
    String orbDefaultInitRef ;

    public ORBDefaultInitRefResolverImpl( Operation urlHandler, String orbDefaultInitRef )
    {
        this.urlHandler = urlHandler ;

        // XXX Validate the URL?
        this.orbDefaultInitRef = orbDefaultInitRef ;
    }

    public org.omg.CORBA.Object resolve( String ident )
    {
        // If the ORBDefaultInitRef is not defined simply return null
        if( orbDefaultInitRef == null ) {
            return null;
        }

        String urlString;
        // If the ORBDefaultInitDef is  defined as corbaloc: then create the
        // corbaloc String in the format
        // <ORBInitDefaultInitDef Param>/<Identifier>
        // and resolve it using resolveCorbaloc method
        if( orbDefaultInitRef.startsWith( "corbaloc:" ) ) {
            urlString = orbDefaultInitRef + "/" + ident;
        } else {
            urlString = orbDefaultInitRef + "#" + ident;
        }

        return (org.omg.CORBA.Object)urlHandler.operate( urlString ) ;
    }

    public java.util.Set list()
    {
        return new java.util.HashSet() ;
    }
}
