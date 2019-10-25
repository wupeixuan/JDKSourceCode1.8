/*
 * Copyright (c) 1998, 1999, Oracle and/or its affiliates. All rights reserved.
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

package java.rmi.activation;

/**
 * This exception is thrown by the RMI runtime when activation
 * fails during a remote call to an activatable object.
 *
 * @author      Ann Wollrath
 * @since       1.2
 */
public class ActivateFailedException extends java.rmi.RemoteException {

    /** indicate compatibility with the Java 2 SDK v1.2 version of class */
    private static final long serialVersionUID = 4863550261346652506L;

    /**
     * Constructs an <code>ActivateFailedException</code> with the specified
     * detail message.
     *
     * @param s the detail message
     * @since 1.2
     */
    public ActivateFailedException(String s) {
        super(s);
    }

    /**
     * Constructs an <code>ActivateFailedException</code> with the specified
     * detail message and nested exception.
     *
     * @param s the detail message
     * @param ex the nested exception
     * @since 1.2
     */
    public ActivateFailedException(String s, Exception ex) {
        super(s, ex);
    }
}
