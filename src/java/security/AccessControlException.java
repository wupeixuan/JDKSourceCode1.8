/*
 * Copyright (c) 1997, 2013, Oracle and/or its affiliates. All rights reserved.
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

package java.security;

/**
 * <p> This exception is thrown by the AccessController to indicate
 * that a requested access (to a critical system resource such as the
 * file system or the network) is denied.
 *
 * <p> The reason to deny access can vary.  For example, the requested
 * permission might be of an incorrect type,  contain an invalid
 * value, or request access that is not allowed according to the
 * security policy.  Such information should be given whenever
 * possible at the time the exception is thrown.
 *
 * @author Li Gong
 * @author Roland Schemers
 */

public class AccessControlException extends SecurityException {

    private static final long serialVersionUID = 5138225684096988535L;

    // the permission that caused the exception to be thrown.
    private Permission perm;

    /**
     * Constructs an {@code AccessControlException} with the
     * specified, detailed message.
     *
     * @param   s   the detail message.
     */
    public AccessControlException(String s) {
        super(s);
    }

    /**
     * Constructs an {@code AccessControlException} with the
     * specified, detailed message, and the requested permission that caused
     * the exception.
     *
     * @param   s   the detail message.
     * @param   p   the permission that caused the exception.
     */
    public AccessControlException(String s, Permission p) {
        super(s);
        perm = p;
    }

    /**
     * Gets the Permission object associated with this exception, or
     * null if there was no corresponding Permission object.
     *
     * @return the Permission object.
     */
    public Permission getPermission() {
        return perm;
    }
}
