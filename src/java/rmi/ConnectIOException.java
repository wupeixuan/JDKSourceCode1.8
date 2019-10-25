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

package java.rmi;

/**
 * A <code>ConnectIOException</code> is thrown if an
 * <code>IOException</code> occurs while making a connection
 * to the remote host for a remote method call.
 *
 * @author  Ann Wollrath
 * @since   JDK1.1
 */
public class ConnectIOException extends RemoteException {

    /* indicate compatibility with JDK 1.1.x version of class */
    private static final long serialVersionUID = -8087809532704668744L;

    /**
     * Constructs a <code>ConnectIOException</code> with the specified
     * detail message.
     *
     * @param s the detail message
     * @since JDK1.1
     */
    public ConnectIOException(String s) {
        super(s);
    }


    /**
     * Constructs a <code>ConnectIOException</code> with the specified
     * detail message and nested exception.
     *
     * @param s the detail message
     * @param ex the nested exception
     * @since JDK1.1
     */
    public ConnectIOException(String s, Exception ex) {
        super(s, ex);
    }
}
