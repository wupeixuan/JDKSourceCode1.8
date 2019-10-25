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
 * A private key.
 * The purpose of this interface is to group (and provide type safety
 * for) all private key interfaces.
 * <p>
 * Note: The specialized private key interfaces extend this interface.
 * See, for example, the {@code DSAPrivateKey} interface in
 * {@link java.security.interfaces}.
 * <p>
 * Implementations should override the default {@code destroy} and
 * {@code isDestroyed} methods from the
 * {@link javax.security.auth.Destroyable} interface to enable
 * sensitive key information to be destroyed, cleared, or in the case
 * where such information is immutable, unreferenced.
 * Finally, since {@code PrivateKey} is {@code Serializable}, implementations
 * should also override
 * {@link java.io.ObjectOutputStream#writeObject(java.lang.Object)}
 * to prevent keys that have been destroyed from being serialized.
 *
 * @see Key
 * @see PublicKey
 * @see Certificate
 * @see Signature#initVerify
 * @see java.security.interfaces.DSAPrivateKey
 * @see java.security.interfaces.RSAPrivateKey
 * @see java.security.interfaces.RSAPrivateCrtKey
 *
 * @author Benjamin Renaud
 * @author Josh Bloch
 */

public interface PrivateKey extends Key, javax.security.auth.Destroyable {

    // Declare serialVersionUID to be compatible with JDK1.1
    /**
     * The class fingerprint that is set to indicate serialization
     * compatibility with a previous version of the class.
     */
    static final long serialVersionUID = 6034044314589513430L;
}
