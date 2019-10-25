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

package com.sun.corba.se.spi.protocol;

import org.omg.CORBA.CompletionStatus;
import org.omg.CORBA.SystemException;
import org.omg.CORBA.portable.UnknownException;

import com.sun.corba.se.pept.protocol.ProtocolHandler;

import com.sun.corba.se.spi.ior.IOR ;
import com.sun.corba.se.spi.protocol.CorbaMessageMediator;

import com.sun.corba.se.spi.servicecontext.ServiceContexts;
import com.sun.corba.se.impl.protocol.giopmsgheaders.LocateRequestMessage;
import com.sun.corba.se.impl.protocol.giopmsgheaders.RequestMessage;

/**
 * @author Harold Carr
 */
public interface CorbaProtocolHandler
    extends ProtocolHandler
{
    public void handleRequest(RequestMessage header,
                              CorbaMessageMediator messageMediator);

    public void handleRequest(LocateRequestMessage header,
                              CorbaMessageMediator messageMediator);

    public CorbaMessageMediator createResponse(
        CorbaMessageMediator messageMediator,
        ServiceContexts svc);
    public CorbaMessageMediator createUserExceptionResponse(
        CorbaMessageMediator messageMediator,
        ServiceContexts svc);
    public CorbaMessageMediator createUnknownExceptionResponse(
        CorbaMessageMediator messageMediator,
        UnknownException ex);
    public CorbaMessageMediator createSystemExceptionResponse(
        CorbaMessageMediator messageMediator,
        SystemException ex,
        ServiceContexts svc);
    public CorbaMessageMediator createLocationForward(
        CorbaMessageMediator messageMediator,
        IOR ior,
        ServiceContexts svc);

    public void handleThrowableDuringServerDispatch(
        CorbaMessageMediator request,
        Throwable exception,
        CompletionStatus completionStatus);

}

// End of file.
