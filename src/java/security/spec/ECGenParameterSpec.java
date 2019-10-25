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
 * This immutable class specifies the set of parameters used for
 * generating elliptic curve (EC) domain parameters.
 *
 * @see AlgorithmParameterSpec
 *
 * @author Valerie Peng
 *
 * @since 1.5
 */
public class ECGenParameterSpec implements AlgorithmParameterSpec {

    private String name;

    /**
     * Creates a parameter specification for EC parameter
     * generation using a standard (or predefined) name
     * {@code stdName} in order to generate the corresponding
     * (precomputed) elliptic curve domain parameters. For the
     * list of supported names, please consult the documentation
     * of provider whose implementation will be used.
     * @param stdName the standard name of the to-be-generated EC
     * domain parameters.
     * @exception NullPointerException if {@code stdName}
     * is null.
     */
    public ECGenParameterSpec(String stdName) {
        if (stdName == null) {
            throw new NullPointerException("stdName is null");
        }
        this.name = stdName;
    }

    /**
     * Returns the standard or predefined name of the
     * to-be-generated EC domain parameters.
     * @return the standard or predefined name.
     */
    public String getName() {
        return name;
    }
}
