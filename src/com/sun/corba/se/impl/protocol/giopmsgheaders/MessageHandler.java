/*
 * Copyright (c) 2002, 2003, Oracle and/or its affiliates. All rights reserved.
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
package com.sun.corba.se.impl.protocol.giopmsgheaders;

import java.io.IOException;

/**
 * Interface which allows an implementation to use
 * double dispatch when processing the various
 * concrete message types found in this package.
 */
public interface MessageHandler
{
    //
    // REVISIT - These should not throw IOException.
    //           Should be handled internally.

    /**
     * Used for message types for which we don't have concrete classes, yet,
     * such as CloseConnection and MessageError, as well as unknown types.
     */
    void handleInput(Message header) throws IOException;

    // Request
    void handleInput(RequestMessage_1_0 header) throws IOException;
    void handleInput(RequestMessage_1_1 header) throws IOException;
    void handleInput(RequestMessage_1_2 header) throws IOException;

    // Reply
    void handleInput(ReplyMessage_1_0 header) throws IOException;
    void handleInput(ReplyMessage_1_1 header) throws IOException;
    void handleInput(ReplyMessage_1_2 header) throws IOException;

    // LocateRequest
    void handleInput(LocateRequestMessage_1_0 header) throws IOException;
    void handleInput(LocateRequestMessage_1_1 header) throws IOException;
    void handleInput(LocateRequestMessage_1_2 header) throws IOException;

    // LocateReply
    void handleInput(LocateReplyMessage_1_0 header) throws IOException;
    void handleInput(LocateReplyMessage_1_1 header) throws IOException;
    void handleInput(LocateReplyMessage_1_2 header) throws IOException;

    // Fragment
    void handleInput(FragmentMessage_1_1 header) throws IOException;
    void handleInput(FragmentMessage_1_2 header) throws IOException;

    // CancelRequest
    void handleInput(CancelRequestMessage header) throws IOException;
}
