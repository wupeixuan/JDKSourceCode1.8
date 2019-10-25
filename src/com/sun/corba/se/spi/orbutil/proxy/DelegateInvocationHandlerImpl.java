/*
 * Copyright (c) 2004, 2006, Oracle and/or its affiliates. All rights reserved.
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

import java.io.Serializable ;

import java.util.Map ;
import java.util.LinkedHashMap ;

import java.lang.reflect.Proxy ;
import java.lang.reflect.Method ;
import java.lang.reflect.InvocationHandler ;
import java.lang.reflect.InvocationTargetException ;
import com.sun.corba.se.impl.presentation.rmi.DynamicAccessPermission ;

public abstract class DelegateInvocationHandlerImpl
{
    private DelegateInvocationHandlerImpl() {}

    public static InvocationHandler create( final Object delegate )
    {
        SecurityManager s = System.getSecurityManager();
        if (s != null) {
            s.checkPermission(new DynamicAccessPermission("access"));
        }
        return new InvocationHandler() {
            public Object invoke( Object proxy, Method method, Object[] args )
                throws Throwable
            {
                // This throws an IllegalArgument exception if the delegate
                // is not assignable from method.getDeclaring class.
                try {
                    return method.invoke( delegate, args ) ;
                } catch (InvocationTargetException ite) {
                    // Propagate the underlying exception as the
                    // result of the invocation
                    throw ite.getCause() ;
                }
            }
        } ;
    }
}
