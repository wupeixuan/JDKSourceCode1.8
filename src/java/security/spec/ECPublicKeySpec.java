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

/**
 * This immutable class specifies an elliptic curve public key with
 * its associated parameters.
 *
 * @see KeySpec
 * @see ECPoint
 * @see ECParameterSpec
 *
 * @author Valerie Peng
 *
 * @since 1.5
 */
public class ECPublicKeySpec implements KeySpec {

    private ECPoint w;
    private ECParameterSpec params;

    /**
     * Creates a new ECPublicKeySpec with the specified
     * parameter values.
     * @param w the public point.
     * @param params the associated elliptic curve domain
     * parameters.
     * @exception NullPointerException if {@code w}
     * or {@code params} is null.
     * @exception IllegalArgumentException if {@code w}
     * is point at infinity, i.e. ECPoint.POINT_INFINITY
     */
    public ECPublicKeySpec(ECPoint w, ECParameterSpec params) {
        if (w == null) {
            throw new NullPointerException("w is null");
        }
        if (params == null) {
            throw new NullPointerException("params is null");
        }
        if (w == ECPoint.POINT_INFINITY) {
            throw new IllegalArgumentException("w is ECPoint.POINT_INFINITY");
        }
        this.w = w;
        this.params = params;
    }

    /**
     * Returns the public point W.
     * @return the public point W.
     */
    public ECPoint getW() {
        return w;
    }

    /**
     * Returns the associated elliptic curve domain
     * parameters.
     * @return the EC domain parameters.
     */
    public ECParameterSpec getParams() {
        return params;
    }
}
