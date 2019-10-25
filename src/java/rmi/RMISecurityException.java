/*
 * Copyright (c) 1996, 2004, Oracle and/or its affiliates. All rights reserved.
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
 * An <code>RMISecurityException</code> signals that a security exception
 * has occurred during the execution of one of
 * <code>java.rmi.RMISecurityManager</code>'s methods.
 *
 * @author  Roger Riggs
 * @since   JDK1.1
 * @deprecated Use {@link java.lang.SecurityException} instead.
 * Application code should never directly reference this class, and
 * <code>RMISecurityManager</code> no longer throws this subclass of
 * <code>java.lang.SecurityException</code>.
 */
@Deprecated
public class RMISecurityException extends java.lang.SecurityException {

    /* indicate compatibility with JDK 1.1.x version of class */
     private static final long serialVersionUID = -8433406075740433514L;

    /**
     * Construct an <code>RMISecurityException</code> with a detail message.
     * @param name the detail message
     * @since JDK1.1
     * @deprecated no replacement
     */
    @Deprecated
    public RMISecurityException(String name) {
        super(name);
    }

    /**
     * Construct an <code>RMISecurityException</code> with a detail message.
     * @param name the detail message
     * @param arg ignored
     * @since JDK1.1
     * @deprecated no replacement
     */
    @Deprecated
    public RMISecurityException(String name, String arg) {
        this(name);
    }
}
