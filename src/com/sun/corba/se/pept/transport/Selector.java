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

package com.sun.corba.se.pept.transport;

/**
 * @author Harold Carr
 */
public interface Selector
{
    public void setTimeout(long timeout);
    public long getTimeout();
    public void registerInterestOps(EventHandler eventHandler);
    public void registerForEvent(EventHandler eventHander);
    public void unregisterForEvent(EventHandler eventHandler);
    public void close();
}

// End of file.
