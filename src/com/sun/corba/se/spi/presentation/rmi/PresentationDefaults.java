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

package com.sun.corba.se.spi.presentation.rmi;

import com.sun.corba.se.spi.orb.ORB;

import com.sun.corba.se.spi.presentation.rmi.PresentationManager;

import com.sun.corba.se.impl.presentation.rmi.StubFactoryFactoryProxyImpl;
import com.sun.corba.se.impl.presentation.rmi.StubFactoryFactoryStaticImpl;
import com.sun.corba.se.impl.presentation.rmi.StubFactoryStaticImpl;

public abstract class PresentationDefaults
{
    private static StubFactoryFactoryStaticImpl staticImpl = null ;

    private PresentationDefaults() {}

    public synchronized static PresentationManager.StubFactoryFactory
        getStaticStubFactoryFactory()
    {
        if (staticImpl == null)
            staticImpl = new StubFactoryFactoryStaticImpl( );

        return staticImpl ;
    }

    public static PresentationManager.StubFactoryFactory
        getProxyStubFactoryFactory()
    {
        return new StubFactoryFactoryProxyImpl();
    }

    public static PresentationManager.StubFactory makeStaticStubFactory(
        Class stubClass )
    {
        return new StubFactoryStaticImpl( stubClass ) ;
    }
}
