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

package com.sun.corba.se.impl.presentation.rmi;

import java.security.AccessController;
import java.security.PrivilegedAction;
import com.sun.corba.se.spi.presentation.rmi.PresentationManager ;

public class StubFactoryFactoryProxyImpl extends StubFactoryFactoryDynamicBase
{
    public PresentationManager.StubFactory makeDynamicStubFactory(
        PresentationManager pm, final PresentationManager.ClassData classData,
        final ClassLoader classLoader )
    {
        return AccessController
                .doPrivileged(new PrivilegedAction<StubFactoryProxyImpl>() {
                    @Override
                    public StubFactoryProxyImpl run() {
                        return new StubFactoryProxyImpl(classData, classLoader);
                    }
                });
    }
}
