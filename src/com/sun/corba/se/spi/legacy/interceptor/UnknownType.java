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

package com.sun.corba.se.spi.legacy.interceptor;

public class UnknownType
    extends
        Exception
{
    public UnknownType()
    {
        super();
    }

    public UnknownType(String msg)
    {
        super(msg);
    }
}
