/*
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
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

import java.security.*;

/**
 * This class controls the use of dynamic proxies.
 * A DynamicAccessPermission contains a name (also referred to as a "target name") but
 * no actions list; you either have the named permission
 * or you don't.
 *
 */

public final class DynamicAccessPermission extends BasicPermission {
    //private static final long serialVersionUID = -8343910153355041693L;

    /**
     * Creates a new DynamicAccessPermission with the specified name.
     * @param name the name of the DynamicAccessPermission.
     */
    public DynamicAccessPermission(String name)
    {
        super(name);
    }

    /**
     * Creates a new DynamicAccessPermission object with the specified name.
     * The name is the symbolic name of the DynamicAccessPermission, and the
     * actions String is currently unused and should be null.
     *
     * @param name the name of the DynamicAccessPermission.
     * @param actions should be null.
     */
    public DynamicAccessPermission(String name, String actions)
    {
        super(name, actions);
    }
}
