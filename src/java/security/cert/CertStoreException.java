/*
 * Copyright (c) 2000, 2013, Oracle and/or its affiliates. All rights reserved.
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

import java.security.GeneralSecurityException;

/**
 * An exception indicating one of a variety of problems retrieving
 * certificates and CRLs from a {@code CertStore}.
 * <p>
 * A {@code CertStoreException} provides support for wrapping
 * exceptions. The {@link #getCause getCause} method returns the throwable,
 * if any, that caused this exception to be thrown.
 * <p>
 * <b>Concurrent Access</b>
 * <p>
 * Unless otherwise specified, the methods defined in this class are not
 * thread-safe. Multiple threads that need to access a single
 * object concurrently should synchronize amongst themselves and
 * provide the necessary locking. Multiple threads each manipulating
 * separate objects need not synchronize.
 *
 * @see CertStore
 *
 * @since       1.4
 * @author      Sean Mullan
 */
public class CertStoreException extends GeneralSecurityException {

    private static final long serialVersionUID = 2395296107471573245L;

    /**
     * Creates a {@code CertStoreException} with {@code null} as
     * its detail message.
     */
    public CertStoreException() {
        super();
    }

    /**
     * Creates a {@code CertStoreException} with the given detail
     * message. A detail message is a {@code String} that describes this
     * particular exception.
     *
     * @param msg the detail message
     */
    public CertStoreException(String msg) {
        super(msg);
    }

    /**
     * Creates a {@code CertStoreException} that wraps the specified
     * throwable. This allows any exception to be converted into a
     * {@code CertStoreException}, while retaining information about the
     * cause, which may be useful for debugging. The detail message is
     * set to ({@code cause==null ? null : cause.toString()}) (which
     * typically contains the class and detail message of cause).
     *
     * @param cause the cause (which is saved for later retrieval by the
     * {@link #getCause getCause()} method). (A {@code null} value is
     * permitted, and indicates that the cause is nonexistent or unknown.)
     */
    public CertStoreException(Throwable cause) {
        super(cause);
    }

    /**
     * Creates a {@code CertStoreException} with the specified detail
     * message and cause.
     *
     * @param msg the detail message
     * @param cause the cause (which is saved for later retrieval by the
     * {@link #getCause getCause()} method). (A {@code null} value is
     * permitted, and indicates that the cause is nonexistent or unknown.)
     */
    public CertStoreException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
