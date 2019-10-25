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

import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;

import com.sun.corba.se.spi.orbutil.threadpool.Work;

/**
 * @author Harold Carr
 *
 * This should only be registered with ONE selector.
 */
public interface EventHandler
{
    public void setUseSelectThreadToWait(boolean x);
    public boolean shouldUseSelectThreadToWait();

    public SelectableChannel getChannel();

    public int getInterestOps();

    public void setSelectionKey(SelectionKey selectionKey);
    public SelectionKey getSelectionKey();

    public void handleEvent();

    // NOTE: if there is more than one interest op this does not
    // allow discrimination between different ops and how threading
    // is handled.
    public void setUseWorkerThreadForEvent(boolean x);
    public boolean shouldUseWorkerThreadForEvent();

    public void setWork(Work work);
    public Work getWork();

    // REVISIT: need base class with two derived.
    public Acceptor getAcceptor();
    public Connection getConnection();

}

// End of file.
