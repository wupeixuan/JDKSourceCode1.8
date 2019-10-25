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

package com.sun.corba.se.impl.orb ;

import java.net.InetAddress ;

import java.util.Properties ;

import org.omg.CORBA.INTERNAL ;
import org.omg.CORBA.CompletionStatus ;

public class NormalDataCollector extends DataCollectorBase {
    private String[] args ;

    public NormalDataCollector( String[] args, Properties props,
        String localHostName, String configurationHostName )
    {
        super( props, localHostName, configurationHostName ) ;
        this.args = args ;
    }

    public boolean isApplet()
    {
        return false ;
    }

    protected void collect()
    {
        checkPropertyDefaults() ;

        findPropertiesFromFile() ;
        findPropertiesFromSystem() ;
        findPropertiesFromProperties() ;
        findPropertiesFromArgs( args ) ;
    }
}
