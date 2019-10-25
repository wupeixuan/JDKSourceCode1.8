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


package javax.security.cert;

/**
 * Certificate Expired Exception. This is thrown whenever the current
 * {@code Date} or the specified {@code Date} is after the
 * {@code notAfter} date/time specified in the validity period
 * of the certificate.
 *
 * <p><em>Note: The classes in the package {@code javax.security.cert}
 * exist for compatibility with earlier versions of the
 * Java Secure Sockets Extension (JSSE). New applications should instead
 * use the standard Java SE certificate classes located in
 * {@code java.security.cert}.</em></p>
 *
 * @since 1.4
 * @author Hemma Prafullchandra
 */
public class CertificateExpiredException extends CertificateException {

    private static final long serialVersionUID = 5091601212177261883L;
    /**
     * Constructs a CertificateExpiredException with no detail message. A
     * detail message is a String that describes this particular
     * exception.
     */
    public CertificateExpiredException() {
        super();
    }

    /**
     * Constructs a CertificateExpiredException with the specified detail
     * message. A detail message is a String that describes this
     * particular exception.
     *
     * @param message the detail message.
     */
    public CertificateExpiredException(String message) {
        super(message);
    }
}
