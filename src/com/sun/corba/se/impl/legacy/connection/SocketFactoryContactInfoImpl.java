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

import com.sun.corba.se.pept.transport.Connection;

import com.sun.corba.se.spi.orb.ORB;
import com.sun.corba.se.spi.ior.IOR;
import com.sun.corba.se.spi.logging.CORBALogDomains;
import com.sun.corba.se.spi.transport.CorbaContactInfoList;
import com.sun.corba.se.spi.transport.SocketInfo;

import com.sun.corba.se.impl.logging.ORBUtilSystemException;
import com.sun.corba.se.impl.transport.SocketOrChannelContactInfoImpl;


/**
 * @author Harold Carr
 */
public class SocketFactoryContactInfoImpl
    extends
        SocketOrChannelContactInfoImpl
{
    protected ORBUtilSystemException wrapper;
    protected SocketInfo socketInfo;

    // XREVISIT
    // See SocketOrChannelAcceptorImpl.createMessageMediator
    // See SocketFactoryContactInfoImpl.constructor()
    // See SocketOrChannelContactInfoImpl.constructor()
    public SocketFactoryContactInfoImpl()
    {
    }

    public SocketFactoryContactInfoImpl(
        ORB orb,
        CorbaContactInfoList contactInfoList,
        IOR effectiveTargetIOR,
        short addressingDisposition,
        SocketInfo cookie)
    {
        super(orb, contactInfoList);
        this.effectiveTargetIOR = effectiveTargetIOR;
        this.addressingDisposition = addressingDisposition;

        wrapper = ORBUtilSystemException.get( orb,
            CORBALogDomains.RPC_TRANSPORT ) ;

        socketInfo =
            orb.getORBData().getLegacySocketFactory()
                .getEndPointInfo(orb, effectiveTargetIOR, cookie);

        socketType = socketInfo.getType();
        hostname = socketInfo.getHost();
        port = socketInfo.getPort();
    }

    ////////////////////////////////////////////////////
    //
    // pept.transport.ContactInfo
    //

    public Connection createConnection()
    {
        Connection connection =
            new SocketFactoryConnectionImpl(
                orb, this,
                orb.getORBData().connectionSocketUseSelectThreadToWait(),
                orb.getORBData().connectionSocketUseWorkerThreadForEvent());
        return connection;
    }

    ////////////////////////////////////////////////////
    //
    // java.lang.Object
    //

    public String toString()
    {
        return
            "SocketFactoryContactInfoImpl["
            + socketType + " "
            + hostname + " "
            + port
            + "]";
    }
}

// End of file.
