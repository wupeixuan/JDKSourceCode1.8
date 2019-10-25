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

package com.sun.corba.se.impl.protocol;

import java.util.Iterator;

import com.sun.corba.se.spi.orb.ORB;

import com.sun.corba.se.pept.protocol.ClientInvocationInfo;
import com.sun.corba.se.pept.protocol.MessageMediator;

import com.sun.corba.se.pept.protocol.ClientRequestDispatcher;

/**
 * @author Harold Carr
 */
public class CorbaInvocationInfo implements ClientInvocationInfo
{
    // REVISIT - these needs to be an interface-based impl.

    private boolean isRetryInvocation;
    private int entryCount;
    private ORB orb;
    private Iterator contactInfoListIterator;
    private ClientRequestDispatcher clientRequestDispatcher;
    private MessageMediator messageMediator;

    private CorbaInvocationInfo()
    {
    }

    public CorbaInvocationInfo(ORB orb)
    {
        this.orb = orb;
        isRetryInvocation = false;
        entryCount = 0;
    }

    public Iterator getContactInfoListIterator()
    {
        return contactInfoListIterator;
    }

    public void setContactInfoListIterator(Iterator contactInfoListIterator)
    {
        this.contactInfoListIterator = contactInfoListIterator;
    }

    public boolean isRetryInvocation()
    {
        return isRetryInvocation;
    }

    public void setIsRetryInvocation(boolean isRetryInvocation)
    {
        this.isRetryInvocation = isRetryInvocation;
    }

    public int getEntryCount()
    {
        return entryCount;
    }

    public void incrementEntryCount()
    {
        entryCount++;
    }

    public void decrementEntryCount()
    {
        entryCount--;
    }

    public void setClientRequestDispatcher(ClientRequestDispatcher clientRequestDispatcher)
    {
        this.clientRequestDispatcher = clientRequestDispatcher;
    }

    public ClientRequestDispatcher getClientRequestDispatcher()
    {
        return clientRequestDispatcher;
    }

    public void setMessageMediator(MessageMediator messageMediator)
    {
        this.messageMediator = messageMediator;
    }

    public MessageMediator getMessageMediator()
    {
        return messageMediator;
    }
}

// End of file.
