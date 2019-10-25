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

package com.sun.corba.se.spi.resolver ;

import java.io.File ;

import com.sun.corba.se.impl.resolver.LocalResolverImpl ;
import com.sun.corba.se.impl.resolver.ORBInitRefResolverImpl ;
import com.sun.corba.se.impl.resolver.ORBDefaultInitRefResolverImpl ;
import com.sun.corba.se.impl.resolver.BootstrapResolverImpl ;
import com.sun.corba.se.impl.resolver.CompositeResolverImpl ;
import com.sun.corba.se.impl.resolver.INSURLOperationImpl ;
import com.sun.corba.se.impl.resolver.SplitLocalResolverImpl ;
import com.sun.corba.se.impl.resolver.FileResolverImpl ;

import com.sun.corba.se.spi.orb.ORB ;
import com.sun.corba.se.spi.orb.Operation ;
import com.sun.corba.se.spi.orb.StringPair ;

/** Utility class that provides factory methods for all of the
 * standard resolvers that we provide.
 */
public class ResolverDefault {
    /** Return a local resolver that simply stores bindings in a map.
    */
    public static LocalResolver makeLocalResolver( )
    {
        return new LocalResolverImpl() ;
    }

    /** Return a resolver that relies on configured values of ORBInitRef for data.
    */
    public static Resolver makeORBInitRefResolver( Operation urlOperation,
        StringPair[] initRefs )
    {
        return new ORBInitRefResolverImpl( urlOperation, initRefs ) ;
    }

    public static Resolver makeORBDefaultInitRefResolver( Operation urlOperation,
        String defaultInitRef )
    {
        return new ORBDefaultInitRefResolverImpl( urlOperation,
            defaultInitRef ) ;
    }

    /** Return a resolver that uses the proprietary bootstrap protocol
    * to implement a resolver.  Obtains the necessary host and port
    * information from the ORB.
    */
    public static Resolver makeBootstrapResolver( ORB orb, String host, int port )
    {
        return new BootstrapResolverImpl( orb, host, port ) ;
    }

    /** Return a resolver composed of the two given resolvers.  result.list() is the
    * union of first.list() and second.list().  result.resolve( name ) returns
    * first.resolve( name ) if that is not null, otherwise returns the result of
    * second.resolve( name ).
    */
    public static Resolver makeCompositeResolver( Resolver first, Resolver second )
    {
        return new CompositeResolverImpl( first, second ) ;
    }

    public static Operation makeINSURLOperation( ORB orb, Resolver bootstrapResolver )
    {
        return new INSURLOperationImpl(
            (com.sun.corba.se.spi.orb.ORB)orb, bootstrapResolver ) ;
    }

    public static LocalResolver makeSplitLocalResolver( Resolver resolver,
        LocalResolver localResolver )
    {
        return new SplitLocalResolverImpl( resolver, localResolver ) ;
    }

    public static Resolver makeFileResolver( ORB orb, File file )
    {
        return new FileResolverImpl( orb, file ) ;
    }
}
