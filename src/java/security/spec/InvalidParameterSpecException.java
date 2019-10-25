/*
 * Copyright (c) 1997, 2003, Oracle and/or its affiliates. All rights reserved.
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

import java.security.GeneralSecurityException;

/**
 * This is the exception for invalid parameter specifications.
 *
 * @author Jan Luehe
 *
 *
 * @see java.security.AlgorithmParameters
 * @see AlgorithmParameterSpec
 * @see DSAParameterSpec
 *
 * @since 1.2
 */

public class InvalidParameterSpecException extends GeneralSecurityException {

    private static final long serialVersionUID = -970468769593399342L;

    /**
     * Constructs an InvalidParameterSpecException with no detail message. A
     * detail message is a String that describes this particular
     * exception.
     */
    public InvalidParameterSpecException() {
        super();
    }

    /**
     * Constructs an InvalidParameterSpecException with the specified detail
     * message. A detail message is a String that describes this
     * particular exception.
     *
     * @param msg the detail message.
     */
    public InvalidParameterSpecException(String msg) {
        super(msg);
    }
}
