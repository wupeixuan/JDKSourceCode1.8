/*
 * Copyright (c) 2003, Oracle and/or its affiliates. All rights reserved.
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

package java.util;

/**
 * Unchecked exception thrown when the precision is a negative value other than
 * <tt>-1</tt>, the conversion does not support a precision, or the value is
 * otherwise unsupported.
 *
 * @since 1.5
 */
public class IllegalFormatPrecisionException extends IllegalFormatException {

    private static final long serialVersionUID = 18711008L;

    private int p;

    /**
     * Constructs an instance of this class with the specified precision.
     *
     * @param  p
     *         The precision
     */
    public IllegalFormatPrecisionException(int p) {
        this.p = p;
    }

    /**
     * Returns the precision
     *
     * @return  The precision
     */
    public int getPrecision() {
        return p;
    }

    public String getMessage() {
        return Integer.toString(p);
    }
}
