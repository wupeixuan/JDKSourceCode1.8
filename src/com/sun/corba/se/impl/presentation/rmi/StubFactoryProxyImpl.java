/*
 * Copyright (c) 2003, 2004, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.corba.se.impl.presentation.rmi ;

import java.lang.reflect.Proxy ;

import com.sun.corba.se.spi.presentation.rmi.PresentationManager ;
import com.sun.corba.se.spi.presentation.rmi.DynamicStub ;

import com.sun.corba.se.spi.orbutil.proxy.InvocationHandlerFactory ;
import com.sun.corba.se.spi.orbutil.proxy.LinkedInvocationHandler  ;

public class StubFactoryProxyImpl extends StubFactoryDynamicBase
{
    public StubFactoryProxyImpl( PresentationManager.ClassData classData,
        ClassLoader loader )
    {
        super( classData, loader ) ;
    }

    public org.omg.CORBA.Object makeStub()
    {
        // Construct the dynamic proxy that implements this stub
        // using the composite handler
        InvocationHandlerFactory factory = classData.getInvocationHandlerFactory() ;
        LinkedInvocationHandler handler =
            (LinkedInvocationHandler)factory.getInvocationHandler() ;
        Class[] interfaces = factory.getProxyInterfaces() ;
        DynamicStub stub = (DynamicStub)Proxy.newProxyInstance( loader, interfaces,
            handler ) ;
        handler.setProxy( (Proxy)stub ) ;
        return stub ;
    }
}
