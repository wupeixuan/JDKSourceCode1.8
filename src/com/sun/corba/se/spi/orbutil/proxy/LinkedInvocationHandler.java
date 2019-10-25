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

package com.sun.corba.se.spi.orbutil.proxy ;

import java.lang.reflect.InvocationHandler ;
import java.lang.reflect.Proxy ;

/** This interface is used for InvocationHandler types that are
 * linked to their Proxy.  This is useful when the InvocationHandler
 * needs access to data keyed by identity on the Proxy.
 */
public interface LinkedInvocationHandler extends InvocationHandler
{
    void setProxy( Proxy proxy ) ;

    Proxy getProxy() ;
}
