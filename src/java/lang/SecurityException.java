/*
 * Copyright (c) 1995, 2003, Oracle and/or its affiliates. All rights reserved.
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
package java.lang;

/**
 * Thrown by the security manager to indicate a security violation.
 *
 * @author  unascribed
 * @see     java.lang.SecurityManager
 * @since   JDK1.0
 */
public class SecurityException extends RuntimeException {

    private static final long serialVersionUID = 6878364983674394167L;

    /**
     * Constructs a <code>SecurityException</code> with no detail  message.
     */
    public SecurityException() {
        super();
    }

    /**
     * Constructs a <code>SecurityException</code> with the specified
     * detail message.
     *
     * @param   s   the detail message.
     */
    public SecurityException(String s) {
        super(s);
    }

    /**
     * Creates a <code>SecurityException</code> with the specified
     * detail message and cause.
     *
     * @param message the detail message (which is saved for later retrieval
     *        by the {@link #getMessage()} method).
     * @param cause the cause (which is saved for later retrieval by the
     *        {@link #getCause()} method).  (A <tt>null</tt> value is permitted,
     *        and indicates that the cause is nonexistent or unknown.)
     * @since 1.5
     */
    public SecurityException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Creates a <code>SecurityException</code> with the specified cause
     * and a detail message of <tt>(cause==null ? null : cause.toString())</tt>
     * (which typically contains the class and detail message of
     * <tt>cause</tt>).
     *
     * @param cause the cause (which is saved for later retrieval by the
     *        {@link #getCause()} method).  (A <tt>null</tt> value is permitted,
     *        and indicates that the cause is nonexistent or unknown.)
     * @since 1.5
     */
    public SecurityException(Throwable cause) {
        super(cause);
    }
}
