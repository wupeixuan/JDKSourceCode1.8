/*
 * Copyright (c) 1996, 1998, Oracle and/or its affiliates. All rights reserved.
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

package java.rmi.server;

/**
 * An <code>ServerNotActiveException</code> is an <code>Exception</code>
 * thrown during a call to <code>RemoteServer.getClientHost</code> if
 * the getClientHost method is called outside of servicing a remote
 * method call.
 *
 * @author  Roger Riggs
 * @since   JDK1.1
 * @see java.rmi.server.RemoteServer#getClientHost()
 */
public class ServerNotActiveException extends java.lang.Exception {

    /* indicate compatibility with JDK 1.1.x version of class */
    private static final long serialVersionUID = 4687940720827538231L;

    /**
     * Constructs an <code>ServerNotActiveException</code> with no specified
     * detail message.
     * @since JDK1.1
     */
    public ServerNotActiveException() {}

    /**
     * Constructs an <code>ServerNotActiveException</code> with the specified
     * detail message.
     *
     * @param s the detail message.
     * @since JDK1.1
     */
    public ServerNotActiveException(String s)
    {
        super(s);
    }
}
