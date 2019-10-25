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
package com.sun.corba.se.impl.naming.namingutil;

import org.omg.CORBA.CompletionStatus;
import java.util.StringTokenizer;

/**
 *  This class is the entry point to parse different types of INS URL's.
 *
 *  @Author Hemanth
 */

public class INSURLHandler {

    private static INSURLHandler insURLHandler = null;

    // Length of corbaloc:
    private static final int CORBALOC_PREFIX_LENGTH = 9;

    // Length of corbaname:
    private static final int CORBANAME_PREFIX_LENGTH = 10;

    private INSURLHandler( ) {
    }

    public synchronized static INSURLHandler getINSURLHandler( ) {
        if( insURLHandler == null ) {
            insURLHandler = new INSURLHandler( );
        }
        return insURLHandler;
    }

    public INSURL parseURL( String aUrl ) {
        String url = aUrl;
        if ( url.startsWith( "corbaloc:" ) == true ) {
            return new CorbalocURL( url.substring( CORBALOC_PREFIX_LENGTH ) );
        } else if ( url.startsWith ( "corbaname:" ) == true ) {
            return new CorbanameURL( url.substring( CORBANAME_PREFIX_LENGTH ) );
        }
        return null;
    }
}
