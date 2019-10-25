/*
 * Copyright (c) 1996, 2013, Oracle and/or its affiliates. All rights reserved.
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
 * A runtime exception for Provider exceptions (such as
 * misconfiguration errors or unrecoverable internal errors),
 * which may be subclassed by Providers to
 * throw specialized, provider-specific runtime errors.
 *
 * @author Benjamin Renaud
 */
public class ProviderException extends RuntimeException {

    private static final long serialVersionUID = 5256023526693665674L;

    /**
     * Constructs a ProviderException with no detail message. A
     * detail message is a String that describes this particular
     * exception.
     */
    public ProviderException() {
        super();
    }

    /**
     * Constructs a ProviderException with the specified detail
     * message. A detail message is a String that describes this
     * particular exception.
     *
     * @param s the detail message.
     */
    public ProviderException(String s) {
        super(s);
    }

    /**
     * Creates a {@code ProviderException} with the specified
     * detail message and cause.
     *
     * @param message the detail message (which is saved for later retrieval
     *        by the {@link #getMessage()} method).
     * @param cause the cause (which is saved for later retrieval by the
     *        {@link #getCause()} method).  (A {@code null} value is permitted,
     *        and indicates that the cause is nonexistent or unknown.)
     * @since 1.5
     */
    public ProviderException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Creates a {@code ProviderException} with the specified cause
     * and a detail message of {@code (cause==null ? null : cause.toString())}
     * (which typically contains the class and detail message of
     * {@code cause}).
     *
     * @param cause the cause (which is saved for later retrieval by the
     *        {@link #getCause()} method).  (A {@code null} value is permitted,
     *        and indicates that the cause is nonexistent or unknown.)
     * @since 1.5
     */
    public ProviderException(Throwable cause) {
        super(cause);
    }
}
