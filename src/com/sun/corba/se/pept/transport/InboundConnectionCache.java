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

/**
 * @author Harold Carr
 */
public interface InboundConnectionCache
    extends ConnectionCache
{
    public Connection get(Acceptor acceptor); // REVISIT

    public void put(Acceptor acceptor, Connection connection);

    public void remove(Connection connection);

    public Acceptor getAcceptor();
}

// End of file.
