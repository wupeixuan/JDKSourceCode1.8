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
 * This is the exception for invalid or inappropriate algorithm parameters.
 *
 * @author Jan Luehe
 *
 *
 * @see AlgorithmParameters
 * @see java.security.spec.AlgorithmParameterSpec
 *
 * @since 1.2
 */

public class InvalidAlgorithmParameterException
extends GeneralSecurityException {

    private static final long serialVersionUID = 2864672297499471472L;

    /**
     * Constructs an InvalidAlgorithmParameterException with no detail
     * message.
     * A detail message is a String that describes this particular
     * exception.
     */
    public InvalidAlgorithmParameterException() {
        super();
    }

    /**
     * Constructs an InvalidAlgorithmParameterException with the specified
     * detail message.
     * A detail message is a String that describes this
     * particular exception.
     *
     * @param msg the detail message.
     */
    public InvalidAlgorithmParameterException(String msg) {
        super(msg);
    }

    /**
     * Creates a {@code InvalidAlgorithmParameterException} with the
     * specified detail message and cause.
     *
     * @param message the detail message (which is saved for later retrieval
     *        by the {@link #getMessage()} method).
     * @param cause the cause (which is saved for later retrieval by the
     *        {@link #getCause()} method).  (A {@code null} value is permitted,
     *        and indicates that the cause is nonexistent or unknown.)
     * @since 1.5
     */
    public InvalidAlgorithmParameterException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Creates a {@code InvalidAlgorithmParameterException} with the
     * specified cause and a detail message of
     * {@code (cause==null ? null : cause.toString())}
     * (which typically contains the class and detail message of
     * {@code cause}).
     *
     * @param cause the cause (which is saved for later retrieval by the
     *        {@link #getCause()} method).  (A {@code null} value is permitted,
     *        and indicates that the cause is nonexistent or unknown.)
     * @since 1.5
     */
    public InvalidAlgorithmParameterException(Throwable cause) {
        super(cause);
    }
}
