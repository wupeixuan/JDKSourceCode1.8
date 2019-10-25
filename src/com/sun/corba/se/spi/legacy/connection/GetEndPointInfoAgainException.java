/*
 * Copyright (c) 2000, 2004, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.corba.se.spi.legacy.connection;

import com.sun.corba.se.spi.transport.SocketInfo;

/**
 * This exception is raised by <code>ORBSocketFactory.createSocket</code>.
 * It informs the ORB that it should call
 * <code>ORBSocketFactory.getEndPointInfo</code> again with the
 * given <code>socketInfo</code> object as an argument (i.e., a cookie).
 *
 */

public class GetEndPointInfoAgainException
    extends Exception
{
    private SocketInfo socketInfo;

    public GetEndPointInfoAgainException(SocketInfo socketInfo)
    {
        this.socketInfo = socketInfo;
    }

    public SocketInfo getEndPointInfo()
    {
        return socketInfo;
    }
}
