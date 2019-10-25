/*
 * Copyright (c) 2001, 2003, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.corba.se.pept.broker;

import com.sun.corba.se.pept.protocol.ClientInvocationInfo;
import com.sun.corba.se.pept.transport.TransportManager;

/**
 * @author Harold Carr
 */
public interface Broker
{
    public ClientInvocationInfo createOrIncrementInvocationInfo();
    public ClientInvocationInfo getInvocationInfo();
    public void releaseOrDecrementInvocationInfo();

    public abstract TransportManager getTransportManager();
}

// End of file.
