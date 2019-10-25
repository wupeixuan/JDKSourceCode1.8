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

import com.sun.corba.se.spi.legacy.connection.Connection;

/**
 * This interface is implemented by our implementation of
 * PortableInterceptor.ClientRequestInfo and
 * PortableInterceptor.ServerRequestInfo. <p>
 *
 */

public interface RequestInfoExt
{
    /**
     * @return The connection on which the request is made.
     *         The return value will be null when a local transport
     *         is used.
     */
    public Connection connection();
}
