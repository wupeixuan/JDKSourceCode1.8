/*
 * Copyright (c) 2003, 2013, Oracle and/or its affiliates. All rights reserved.
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
 * This immutable class specifies the set of domain parameters
 * used with elliptic curve cryptography (ECC).
 *
 * @see AlgorithmParameterSpec
 *
 * @author Valerie Peng
 *
 * @since 1.5
 */
public class ECParameterSpec implements AlgorithmParameterSpec {

    private final EllipticCurve curve;
    private final ECPoint g;
    private final BigInteger n;
    private final int h;

    /**
     * Creates elliptic curve domain parameters based on the
     * specified values.
     * @param curve the elliptic curve which this parameter
     * defines.
     * @param g the generator which is also known as the base point.
     * @param n the order of the generator {@code g}.
     * @param h the cofactor.
     * @exception NullPointerException if {@code curve},
     * {@code g}, or {@code n} is null.
     * @exception IllegalArgumentException if {@code n}
     * or {@code h} is not positive.
     */
    public ECParameterSpec(EllipticCurve curve, ECPoint g,
                           BigInteger n, int h) {
        if (curve == null) {
            throw new NullPointerException("curve is null");
        }
        if (g == null) {
            throw new NullPointerException("g is null");
        }
        if (n == null) {
            throw new NullPointerException("n is null");
        }
        if (n.signum() != 1) {
            throw new IllegalArgumentException("n is not positive");
        }
        if (h <= 0) {
            throw new IllegalArgumentException("h is not positive");
        }
        this.curve = curve;
        this.g = g;
        this.n = n;
        this.h = h;
    }

    /**
     * Returns the elliptic curve that this parameter defines.
     * @return the elliptic curve that this parameter defines.
     */
    public EllipticCurve getCurve() {
        return curve;
    }

    /**
     * Returns the generator which is also known as the base point.
     * @return the generator which is also known as the base point.
     */
    public ECPoint getGenerator() {
        return g;
    }

    /**
     * Returns the order of the generator.
     * @return the order of the generator.
     */
    public BigInteger getOrder() {
        return n;
    }

    /**
     * Returns the cofactor.
     * @return the cofactor.
     */
    public int getCofactor() {
        return h;
    }
}
