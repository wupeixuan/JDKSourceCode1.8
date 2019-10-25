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

package com.sun.corba.se.pept.transport;

import java.util.Collection;

import com.sun.corba.se.pept.transport.Acceptor;
import com.sun.corba.se.pept.transport.ByteBufferPool;
import com.sun.corba.se.pept.transport.ConnectionCache;
import com.sun.corba.se.pept.transport.Selector;

/**
 * @author Harold Carr
 */
public interface TransportManager
{
    public ByteBufferPool getByteBufferPool(int id);

    public OutboundConnectionCache getOutboundConnectionCache(
        ContactInfo contactInfo);

    public Collection getOutboundConnectionCaches();

    public InboundConnectionCache getInboundConnectionCache(Acceptor acceptor);

    public Collection getInboundConnectionCaches();

    public Selector getSelector(int id);

    public void registerAcceptor(Acceptor acceptor);

    public Collection getAcceptors();

    public void unregisterAcceptor(Acceptor acceptor);

    public void close();
}

// End of file.
