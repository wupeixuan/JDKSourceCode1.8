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
 * This is the basic key exception.
 *
 * @see Key
 * @see InvalidKeyException
 * @see KeyManagementException
 *
 * @author Benjamin Renaud
 */

public class KeyException extends GeneralSecurityException {

    private static final long serialVersionUID = -7483676942812432108L;

    /**
     * Constructs a KeyException with no detail message. A detail
     * message is a String that describes this particular exception.
     */
    public KeyException() {
        super();
    }

    /**
     * Constructs a KeyException with the specified detail message.
     * A detail message is a String that describes this particular
     * exception.
     *
     * @param msg the detail message.
     */
    public KeyException(String msg) {
        super(msg);
    }

    /**
     * Creates a {@code KeyException} with the specified
     * detail message and cause.
     *
     * @param message the detail message (which is saved for later retrieval
     *        by the {@link #getMessage()} method).
     * @param cause the cause (which is saved for later retrieval by the
     *        {@link #getCause()} method).  (A {@code null} value is permitted,
     *        and indicates that the cause is nonexistent or unknown.)
     * @since 1.5
     */
    public KeyException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Creates a {@code KeyException} with the specified cause
     * and a detail message of {@code (cause==null ? null : cause.toString())}
     * (which typically contains the class and detail message of
     * {@code cause}).
     *
     * @param cause the cause (which is saved for later retrieval by the
     *        {@link #getCause()} method).  (A {@code null} value is permitted,
     *        and indicates that the cause is nonexistent or unknown.)
     * @since 1.5
     */
    public KeyException(Throwable cause) {
        super(cause);
    }
}
