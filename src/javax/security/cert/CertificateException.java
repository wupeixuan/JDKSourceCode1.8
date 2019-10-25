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


package javax.security.cert;

/**
 * This exception indicates one of a variety of certificate problems.
 *
 * <p><em>Note: The classes in the package {@code javax.security.cert}
 * exist for compatibility with earlier versions of the
 * Java Secure Sockets Extension (JSSE). New applications should instead
 * use the standard Java SE certificate classes located in
 * {@code java.security.cert}.</em></p>
 *
 * @author Hemma Prafullchandra
 * @since 1.4
 * @see Certificate
 */
public class CertificateException extends Exception {

    private static final long serialVersionUID = -5757213374030785290L;
    /**
     * Constructs a certificate exception with no detail message. A detail
     * message is a String that describes this particular exception.
     */
    public CertificateException() {
        super();
    }

    /**
     * Constructs a certificate exception with the given detail
     * message. A detail message is a String that describes this
     * particular exception.
     *
     * @param msg the detail message.
     */
    public CertificateException(String msg) {
        super(msg);
    }
}
