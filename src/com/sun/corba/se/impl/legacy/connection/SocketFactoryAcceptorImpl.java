/*
 * Copyright (c) 2003, 2004, Oracle and/or its affiliates. All rights reserved.
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

import org.omg.CORBA.CompletionStatus;
import org.omg.CORBA.INTERNAL;

import com.sun.corba.se.spi.orb.ORB;

import com.sun.corba.se.impl.orbutil.ORBUtility;
import com.sun.corba.se.impl.transport.SocketOrChannelContactInfoImpl;
import com.sun.corba.se.impl.transport.SocketOrChannelAcceptorImpl;

/**
 * @author Harold Carr
 */
public class SocketFactoryAcceptorImpl
    extends
        SocketOrChannelAcceptorImpl
{
    public SocketFactoryAcceptorImpl(ORB orb, int port,
                                     String name, String type)
    {
        super(orb, port, name, type);
    }

    ////////////////////////////////////////////////////
    //
    // pept Acceptor
    //

    public boolean initialize()
    {
        if (initialized) {
            return false;
        }
        if (orb.transportDebugFlag) {
            dprint("initialize: " + this);
        }
        try {
            serverSocket = orb.getORBData()
                .getLegacySocketFactory().createServerSocket(type, port);
            internalInitialize();
        } catch (Throwable t) {
            throw wrapper.createListenerFailed( t, Integer.toString(port) ) ;
        }
        initialized = true;
        return true;
    }

    ////////////////////////////////////////////////////
    //
    // Implementation.
    //

    protected String toStringName()
    {
        return "SocketFactoryAcceptorImpl";
    }

    protected void dprint(String msg)
    {
        ORBUtility.dprint(toStringName(), msg);
    }
}

// End of file.
