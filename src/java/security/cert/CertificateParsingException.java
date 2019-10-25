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
 * Certificate Parsing Exception. This is thrown whenever an
 * invalid DER-encoded certificate is parsed or unsupported DER features
 * are found in the Certificate.
 *
 * @author Hemma Prafullchandra
 */
public class CertificateParsingException extends CertificateException {

    private static final long serialVersionUID = -7989222416793322029L;

    /**
     * Constructs a CertificateParsingException with no detail message. A
     * detail message is a String that describes this particular
     * exception.
     */
    public CertificateParsingException() {
        super();
    }

    /**
     * Constructs a CertificateParsingException with the specified detail
     * message. A detail message is a String that describes this
     * particular exception.
     *
     * @param message the detail message.
     */
    public CertificateParsingException(String message) {
        super(message);
    }

    /**
     * Creates a {@code CertificateParsingException} with the specified
     * detail message and cause.
     *
     * @param message the detail message (which is saved for later retrieval
     *        by the {@link #getMessage()} method).
     * @param cause the cause (which is saved for later retrieval by the
     *        {@link #getCause()} method).  (A {@code null} value is permitted,
     *        and indicates that the cause is nonexistent or unknown.)
     * @since 1.5
     */
    public CertificateParsingException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Creates a {@code CertificateParsingException} with the
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
    public CertificateParsingException(Throwable cause) {
        super(cause);
    }
}
