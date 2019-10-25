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

package com.sun.corba.se.spi.transport;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.ServerSocket;

import com.sun.corba.se.pept.transport.Acceptor;
import com.sun.corba.se.spi.orb.ORB;

/**
 * @author Harold Carr
 */
public interface ORBSocketFactory
{
    public void setORB(ORB orb);

    public ServerSocket createServerSocket(String type,
                                           InetSocketAddress inetSocketAddress)
        throws IOException;

    public Socket createSocket(String type,
                               InetSocketAddress inetSocketAddress)
        throws IOException;

    public void setAcceptedSocketOptions(Acceptor acceptor,
                                         ServerSocket serverSocket,
                                         Socket socket)
        throws SocketException;

}

// End of file.
