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

import com.sun.corba.se.spi.orbutil.closure.Closure ;

/**
 * @author
 */
public final class IIOPAddressClosureImpl extends IIOPAddressBase
{
    private Closure host;
    private Closure port;

    public IIOPAddressClosureImpl( Closure host, Closure port )
    {
        this.host = host ;
        this.port = port ;
    }

    public String getHost()
    {
        return (String)(host.evaluate()) ;
    }

    public int getPort()
    {
        Integer value = (Integer)(port.evaluate()) ;
        return value.intValue() ;
    }
}
