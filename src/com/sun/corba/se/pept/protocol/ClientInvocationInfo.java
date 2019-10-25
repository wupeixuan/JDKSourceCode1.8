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

package com.sun.corba.se.pept.protocol;

import com.sun.corba.se.pept.protocol.MessageMediator;
import com.sun.corba.se.pept.protocol.ClientRequestDispatcher;
import java.util.Iterator;

/**
 * @author Harold Carr
 */
public interface ClientInvocationInfo
{
    public Iterator getContactInfoListIterator();

    public void setContactInfoListIterator(Iterator contactInfoListIterator);

    public boolean isRetryInvocation();

    public void setIsRetryInvocation(boolean isRetryInvocation);

    public int getEntryCount();

    public void incrementEntryCount();

    public void decrementEntryCount();

    public void setClientRequestDispatcher(ClientRequestDispatcher clientRequestDispatcher);

    public ClientRequestDispatcher getClientRequestDispatcher();

    public void setMessageMediator(MessageMediator messageMediator);

    public MessageMediator getMessageMediator();
}

// End of file.
