/*
 * Copyright (c) 2003, 2005, Oracle and/or its affiliates. All rights reserved.
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
 * Unchecked exception thrown when a character with an invalid Unicode code
 * point as defined by {@link Character#isValidCodePoint} is passed to the
 * {@link Formatter}.
 *
 * <p> Unless otherwise specified, passing a <tt>null</tt> argument to any
 * method or constructor in this class will cause a {@link
 * NullPointerException} to be thrown.
 *
 * @since 1.5
 */
public class IllegalFormatCodePointException extends IllegalFormatException {

    private static final long serialVersionUID = 19080630L;

    private int c;

    /**
     * Constructs an instance of this class with the specified illegal code
     * point as defined by {@link Character#isValidCodePoint}.
     *
     * @param  c
     *         The illegal Unicode code point
     */
    public IllegalFormatCodePointException(int c) {
        this.c = c;
    }

    /**
     * Returns the illegal code point as defined by {@link
     * Character#isValidCodePoint}.
     *
     * @return  The illegal Unicode code point
     */
    public int getCodePoint() {
        return c;
    }

    public String getMessage() {
        return String.format("Code point = %#x", c);
    }
}
