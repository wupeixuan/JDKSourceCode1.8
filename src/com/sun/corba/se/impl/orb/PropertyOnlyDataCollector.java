/*
 * Copyright (c) 2004, Oracle and/or its affiliates. All rights reserved.
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

public class PropertyOnlyDataCollector extends DataCollectorBase
{
    public PropertyOnlyDataCollector( Properties props,
        String localHostName, String configurationHostName )
    {
        super( props, localHostName, configurationHostName ) ;
    }

    public boolean isApplet()
    {
        return false ;
    }

    protected void collect()
    {
        checkPropertyDefaults() ;

        findPropertiesFromProperties() ;
    }
}
