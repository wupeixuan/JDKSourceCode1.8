/*
 * Copyright (c) 2013, Oracle and/or its affiliates. All rights reserved.
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

package java.lang.reflect;

/**
 * Thrown when {@link java.lang.reflect.Executable#getParameters the
 * java.lang.reflect package} attempts to read method parameters from
 * a class file and determines that one or more parameters are
 * malformed.
 *
 * <p>The following is a list of conditions under which this exception
 * can be thrown:
 * <ul>
 * <li> The number of parameters (parameter_count) is wrong for the method
 * <li> A constant pool index is out of bounds.
 * <li> A constant pool index does not refer to a UTF-8 entry
 * <li> A parameter's name is "", or contains an illegal character
 * <li> The flags field contains an illegal flag (something other than
 *     FINAL, SYNTHETIC, or MANDATED)
 * </ul>
 *
 * See {@link java.lang.reflect.Executable#getParameters} for more
 * information.
 *
 * @see java.lang.reflect.Executable#getParameters
 * @since 1.8
 */
public class MalformedParametersException extends RuntimeException {

    /**
     * Version for serialization.
     */
    private static final long serialVersionUID = 20130919L;

    /**
     * Create a {@code MalformedParametersException} with an empty
     * reason.
     */
    public MalformedParametersException() {}

    /**
     * Create a {@code MalformedParametersException}.
     *
     * @param reason The reason for the exception.
     */
    public MalformedParametersException(String reason) {
        super(reason);
    }
}
