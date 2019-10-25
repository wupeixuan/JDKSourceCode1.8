/*
 * Copyright (c) 2003, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.corba.se.spi.transport;

import java.net.ServerSocket;

/**
 * @author Harold Carr
 */
public interface SocketOrChannelAcceptor
{
    public ServerSocket getServerSocket();
}

// End of file.
