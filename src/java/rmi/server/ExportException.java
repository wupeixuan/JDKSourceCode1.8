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
 * An <code>ExportException</code> is a <code>RemoteException</code>
 * thrown if an attempt to export a remote object fails.  A remote object is
 * exported via the constructors and <code>exportObject</code> methods of
 * <code>java.rmi.server.UnicastRemoteObject</code> and
 * <code>java.rmi.activation.Activatable</code>.
 *
 * @author  Ann Wollrath
 * @since   JDK1.1
 * @see java.rmi.server.UnicastRemoteObject
 * @see java.rmi.activation.Activatable
 */
public class ExportException extends java.rmi.RemoteException {

    /* indicate compatibility with JDK 1.1.x version of class */
    private static final long serialVersionUID = -9155485338494060170L;

    /**
     * Constructs an <code>ExportException</code> with the specified
     * detail message.
     *
     * @param s the detail message
     * @since JDK1.1
     */
    public ExportException(String s) {
        super(s);
    }

    /**
     * Constructs an <code>ExportException</code> with the specified
     * detail message and nested exception.
     *
     * @param s the detail message
     * @param ex the nested exception
     * @since JDK1.1
     */
    public ExportException(String s, Exception ex) {
        super(s, ex);
    }

}
