/*
 * Copyright (c) 2001, 2013, Oracle and/or its affiliates. All rights reserved.
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

package java.security.spec;

import java.math.BigInteger;

/**
 * This class represents the triplet (prime, exponent, and coefficient)
 * inside RSA's OtherPrimeInfo structure, as defined in the PKCS#1 v2.1.
 * The ASN.1 syntax of RSA's OtherPrimeInfo is as follows:
 *
 * <pre>
 * OtherPrimeInfo ::= SEQUENCE {
 *   prime INTEGER,
 *   exponent INTEGER,
 *   coefficient INTEGER
 *   }
 *
 * </pre>
 *
 * @author Valerie Peng
 *
 *
 * @see RSAPrivateCrtKeySpec
 * @see java.security.interfaces.RSAMultiPrimePrivateCrtKey
 *
 * @since 1.4
 */

public class RSAOtherPrimeInfo {

    private BigInteger prime;
    private BigInteger primeExponent;
    private BigInteger crtCoefficient;


   /**
    * Creates a new {@code RSAOtherPrimeInfo}
    * given the prime, primeExponent, and
    * crtCoefficient as defined in PKCS#1.
    *
    * @param prime the prime factor of n.
    * @param primeExponent the exponent.
    * @param crtCoefficient the Chinese Remainder Theorem
    * coefficient.
    * @exception NullPointerException if any of the parameters, i.e.
    * {@code prime}, {@code primeExponent},
    * {@code crtCoefficient}, is null.
    *
    */
    public RSAOtherPrimeInfo(BigInteger prime,
                          BigInteger primeExponent,
                          BigInteger crtCoefficient) {
        if (prime == null) {
            throw new NullPointerException("the prime parameter must be " +
                                            "non-null");
        }
        if (primeExponent == null) {
            throw new NullPointerException("the primeExponent parameter " +
                                            "must be non-null");
        }
        if (crtCoefficient == null) {
            throw new NullPointerException("the crtCoefficient parameter " +
                                            "must be non-null");
        }
        this.prime = prime;
        this.primeExponent = primeExponent;
        this.crtCoefficient = crtCoefficient;
    }

    /**
     * Returns the prime.
     *
     * @return the prime.
     */
    public final BigInteger getPrime() {
        return this.prime;
    }

    /**
     * Returns the prime's exponent.
     *
     * @return the primeExponent.
     */
    public final BigInteger getExponent() {
        return this.primeExponent;
    }

    /**
     * Returns the prime's crtCoefficient.
     *
     * @return the crtCoefficient.
     */
    public final BigInteger getCrtCoefficient() {
        return this.crtCoefficient;
    }
}
