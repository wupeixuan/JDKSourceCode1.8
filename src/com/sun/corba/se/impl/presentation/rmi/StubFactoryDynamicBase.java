/*
 * Copyright (c) 2004, 2013, Oracle and/or its affiliates. All rights reserved.
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

import java.io.SerializablePermission;
import java.lang.reflect.InvocationHandler ;
import java.lang.reflect.Proxy ;

import com.sun.corba.se.spi.presentation.rmi.PresentationManager ;
import com.sun.corba.se.spi.presentation.rmi.DynamicStub ;

import com.sun.corba.se.spi.orbutil.proxy.InvocationHandlerFactory ;
import com.sun.corba.se.spi.orbutil.proxy.LinkedInvocationHandler ;

public abstract class StubFactoryDynamicBase extends StubFactoryBase
{
    protected final ClassLoader loader ;

    private static Void checkPermission() {
        SecurityManager sm = System.getSecurityManager();
        if (sm != null) {
            sm.checkPermission(new SerializablePermission(
                    "enableSubclassImplementation"));
        }
        return null;
    }

    private StubFactoryDynamicBase(Void unused,
            PresentationManager.ClassData classData, ClassLoader loader) {
        super(classData);
        // this.loader must not be null, or the newProxyInstance call
        // will fail.
        if (loader == null) {
            ClassLoader cl = Thread.currentThread().getContextClassLoader();
            if (cl == null)
                cl = ClassLoader.getSystemClassLoader();
            this.loader = cl ;
        } else {
            this.loader = loader ;
        }
    }

    public StubFactoryDynamicBase( PresentationManager.ClassData classData,
        ClassLoader loader )
    {
        this (checkPermission(), classData, loader);
    }

    public abstract org.omg.CORBA.Object makeStub() ;
}
