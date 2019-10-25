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
 * <p>A public key. This interface contains no methods or constants.
 * It merely serves to group (and provide type safety for) all public key
 * interfaces.
 *
 * Note: The specialized public key interfaces extend this interface.
 * See, for example, the DSAPublicKey interface in
 * {@code java.security.interfaces}.
 *
 * @see Key
 * @see PrivateKey
 * @see Certificate
 * @see Signature#initVerify
 * @see java.security.interfaces.DSAPublicKey
 * @see java.security.interfaces.RSAPublicKey
 *
 */

public interface PublicKey extends Key {
    // Declare serialVersionUID to be compatible with JDK1.1
    /**
     * The class fingerprint that is set to indicate serialization
     * compatibility with a previous version of the class.
     */
    static final long serialVersionUID = 7187392471159151072L;
}
