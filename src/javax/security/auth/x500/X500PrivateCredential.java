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

package javax.security.auth.x500;

import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import javax.security.auth.Destroyable;

/**
 * <p> This class represents an {@code X500PrivateCredential}.
 * It associates an X.509 certificate, corresponding private key and the
 * KeyStore alias used to reference that exact key pair in the KeyStore.
 * This enables looking up the private credentials for an X.500 principal
 * in a subject.
 *
 */
public final class X500PrivateCredential implements Destroyable {
    private X509Certificate cert;
    private PrivateKey key;
    private String alias;

    /**
     * Creates an X500PrivateCredential that associates an X.509 certificate,
     * a private key and the KeyStore alias.
     * <p>
     * @param cert X509Certificate
     * @param key  PrivateKey for the certificate
     * @exception IllegalArgumentException if either {@code cert} or
     * {@code key} is null
     *
     */

    public X500PrivateCredential(X509Certificate cert, PrivateKey key) {
        if (cert == null || key == null )
            throw new IllegalArgumentException();
        this.cert = cert;
        this.key = key;
        this.alias=null;
    }

    /**
     * Creates an X500PrivateCredential that associates an X.509 certificate,
     * a private key and the KeyStore alias.
     * <p>
     * @param cert X509Certificate
     * @param key  PrivateKey for the certificate
     * @param alias KeyStore alias
     * @exception IllegalArgumentException if either {@code cert},
     * {@code key} or {@code alias} is null
     *
     */
    public X500PrivateCredential(X509Certificate cert, PrivateKey key,
                                 String alias) {
        if (cert == null || key == null|| alias == null )
            throw new IllegalArgumentException();
        this.cert = cert;
        this.key = key;
        this.alias=alias;
    }

    /**
     * Returns the X.509 certificate.
     * <p>
     * @return the X509Certificate
     */

    public X509Certificate getCertificate() {
        return cert;
    }

    /**
     * Returns the PrivateKey.
     * <p>
     * @return the PrivateKey
     */
    public PrivateKey getPrivateKey() {
        return key;
    }

    /**
     * Returns the KeyStore alias.
     * <p>
     * @return the KeyStore alias
     */

    public String getAlias() {
        return alias;
    }

    /**
     * Clears the references to the X.509 certificate, private key and the
     * KeyStore alias in this object.
     */

    public void destroy() {
        cert = null;
        key = null;
        alias =null;
    }

    /**
     * Determines if the references to the X.509 certificate and private key
     * in this object have been cleared.
     * <p>
     * @return true if X509Certificate and the PrivateKey are null

     */
    public boolean isDestroyed() {
        return cert == null && key == null && alias==null;
    }
}
