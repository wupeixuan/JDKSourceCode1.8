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

package com.sun.corba.se.impl.ior.iiop;

import org.omg.CORBA.BAD_PARAM ;

import org.omg.CORBA_2_3.portable.InputStream ;
import org.omg.CORBA_2_3.portable.OutputStream ;

import com.sun.corba.se.spi.orb.ORB ;

import com.sun.corba.se.spi.logging.CORBALogDomains ;

import com.sun.corba.se.impl.logging.IORSystemException ;

/**
 * @author
 */
public final class IIOPAddressImpl extends IIOPAddressBase
{
    private ORB orb ;
    private IORSystemException wrapper ;
    private String host;
    private int port;

    public IIOPAddressImpl( ORB orb, String host, int port )
    {
        this.orb = orb ;
        wrapper = IORSystemException.get( orb,
            CORBALogDomains.OA_IOR ) ;

        if ((port < 0) || (port > 65535))
            throw wrapper.badIiopAddressPort( new Integer(port)) ;

        this.host = host ;
        this.port = port ;
    }

    public IIOPAddressImpl( InputStream is )
    {
        host = is.read_string() ;
        short thePort = is.read_short() ;
        port = shortToInt( thePort ) ;
    }

    public String getHost()
    {
        return host ;
    }

    public int getPort()
    {
        return port ;
    }
}
