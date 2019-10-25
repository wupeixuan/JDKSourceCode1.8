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

package java.security.cert;

/**
 * Certificate Encoding Exception. This is thrown whenever an error
 * occurs while attempting to encode a certificate.
 *
 * @author Hemma Prafullchandra
 */
public class CertificateEncodingException extends CertificateException {

    private static final long serialVersionUID = 6219492851589449162L;

    /**
     * Constructs a CertificateEncodingException with no detail message. A
     * detail message is a String that describes this particular
     * exception.
     */
    public CertificateEncodingException() {
        super();
    }

    /**
     * Constructs a CertificateEncodingException with the specified detail
     * message. A detail message is a String that describes this
     * particular exception.
     *
     * @param message the detail message.
     */
    public CertificateEncodingException(String message) {
        super(message);
    }

    /**
     * Creates a {@code CertificateEncodingException} with the specified
     * detail message and cause.
     *
     * @param message the detail message (which is saved for later retrieval
     *        by the {@link #getMessage()} method).
     * @param cause the cause (which is saved for later retrieval by the
     *        {@link #getCause()} method).  (A {@code null} value is permitted,
     *        and indicates that the cause is nonexistent or unknown.)
     * @since 1.5
     */
    public CertificateEncodingException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Creates a {@code CertificateEncodingException}
     * with the specified cause and a detail message of
     * {@code (cause==null ? null : cause.toString())}
     * (which typically contains the class and detail message of
     * {@code cause}).
     *
     * @param cause the cause (which is saved for later retrieval by the
     *        {@link #getCause()} method).  (A {@code null} value is permitted,
     *        and indicates that the cause is nonexistent or unknown.)
     * @since 1.5
     */
    public CertificateEncodingException(Throwable cause) {
        super(cause);
    }
}
