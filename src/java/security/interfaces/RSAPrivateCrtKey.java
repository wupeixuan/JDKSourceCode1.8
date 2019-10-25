/*
 * Copyright (c) 1998, 2013, Oracle and/or its affiliates. All rights reserved.
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

package java.security.interfaces;

import java.math.BigInteger;

/**
 * The interface to an RSA private key, as defined in the PKCS#1 standard,
 * using the <i>Chinese Remainder Theorem</i> (CRT) information values.
 *
 * @author Jan Luehe
 *
 *
 * @see RSAPrivateKey
 */

public interface RSAPrivateCrtKey extends RSAPrivateKey {

    /**
     * The type fingerprint that is set to indicate
     * serialization compatibility with a previous
     * version of the type.
     */
    static final long serialVersionUID = -5682214253527700368L;

    /**
     * Returns the public exponent.
     *
     * @return the public exponent
     */
    public BigInteger getPublicExponent();

    /**
     * Returns the primeP.

     * @return the primeP
     */
    public BigInteger getPrimeP();

    /**
     * Returns the primeQ.
     *
     * @return the primeQ
     */
    public BigInteger getPrimeQ();

    /**
     * Returns the primeExponentP.
     *
     * @return the primeExponentP
     */
    public BigInteger getPrimeExponentP();

    /**
     * Returns the primeExponentQ.
     *
     * @return the primeExponentQ
     */
    public BigInteger getPrimeExponentQ();

    /**
     * Returns the crtCoefficient.
     *
     * @return the crtCoefficient
     */
    public BigInteger getCrtCoefficient();
}
