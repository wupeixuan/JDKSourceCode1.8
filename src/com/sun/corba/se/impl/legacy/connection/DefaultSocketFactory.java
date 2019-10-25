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
package com.sun.corba.se.impl.legacy.connection;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

import org.omg.CORBA.ORB;
import org.omg.CORBA.COMM_FAILURE;
import org.omg.CORBA.CompletionStatus;

import com.sun.corba.se.spi.ior.IOR;
import com.sun.corba.se.spi.ior.iiop.IIOPProfileTemplate ;
import com.sun.corba.se.spi.ior.iiop.IIOPAddress ;
import com.sun.corba.se.spi.legacy.connection.GetEndPointInfoAgainException;
import com.sun.corba.se.spi.legacy.connection.ORBSocketFactory;
import com.sun.corba.se.spi.logging.CORBALogDomains;
import com.sun.corba.se.spi.transport.SocketInfo;

import com.sun.corba.se.impl.legacy.connection.EndPointInfoImpl;
import com.sun.corba.se.impl.logging.ORBUtilSystemException;
import com.sun.corba.se.impl.orbutil.ORBConstants;

public class DefaultSocketFactory
    implements
        ORBSocketFactory
{
    private com.sun.corba.se.spi.orb.ORB orb;
    private static ORBUtilSystemException wrapper = ORBUtilSystemException.get(
        CORBALogDomains.RPC_TRANSPORT ) ;

    public DefaultSocketFactory()
    {
    }

    public void setORB(com.sun.corba.se.spi.orb.ORB orb)
    {
        this.orb = orb;
    }

    public ServerSocket createServerSocket(String type, int port)
        throws
            IOException
    {
        if (! type.equals(ORBSocketFactory.IIOP_CLEAR_TEXT)) {
            throw wrapper.defaultCreateServerSocketGivenNonIiopClearText( type ) ;
        }

        ServerSocket serverSocket;

        if (orb.getORBData().acceptorSocketType().equals(ORBConstants.SOCKETCHANNEL)) {
            ServerSocketChannel serverSocketChannel =
                ServerSocketChannel.open();
            serverSocket = serverSocketChannel.socket();
        } else {
            serverSocket = new ServerSocket();
        }
        serverSocket.bind(new InetSocketAddress(port));
        return serverSocket;
    }

    public SocketInfo getEndPointInfo(ORB orb,
                                        IOR ior,
                                        SocketInfo socketInfo)
    {
        IIOPProfileTemplate temp =
            (IIOPProfileTemplate)ior.getProfile().getTaggedProfileTemplate() ;
        IIOPAddress primary = temp.getPrimaryAddress() ;

        return new EndPointInfoImpl(ORBSocketFactory.IIOP_CLEAR_TEXT,
                                    primary.getPort(),
                                    primary.getHost().toLowerCase());
    }

    public Socket createSocket(SocketInfo socketInfo)
        throws
            IOException,
            GetEndPointInfoAgainException
    {
        Socket socket;

        if (orb.getORBData().acceptorSocketType().equals(ORBConstants.SOCKETCHANNEL)) {
            InetSocketAddress address =
                new InetSocketAddress(socketInfo.getHost(),
                                      socketInfo.getPort());
            SocketChannel socketChannel = SocketChannel.open(address);
            socket = socketChannel.socket();
        } else {
            socket = new Socket(socketInfo.getHost(),
                                socketInfo.getPort());
        }

        // REVISIT - this is done in SocketOrChannelConnectionImpl
        try {
            socket.setTcpNoDelay(true);
        } catch (Exception e) {
            ;
        }
        return socket;
    }
}

// End of file.
