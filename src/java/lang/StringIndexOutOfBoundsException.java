/*
 * Copyright (c) 1994, 2012, Oracle and/or its affiliates. All rights reserved.
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

package java.lang;

/**
 * Thrown by {@code String} methods to indicate that an index
 * is either negative or greater than the size of the string.  For
 * some methods such as the charAt method, this exception also is
 * thrown when the index is equal to the size of the string.
 *
 * @author  unascribed
 * @see     java.lang.String#charAt(int)
 * @since   JDK1.0
 */
public
class StringIndexOutOfBoundsException extends IndexOutOfBoundsException {
    private static final long serialVersionUID = -6762910422159637258L;

    /**
     * Constructs a {@code StringIndexOutOfBoundsException} with no
     * detail message.
     *
     * @since   JDK1.0.
     */
    public StringIndexOutOfBoundsException() {
        super();
    }

    /**
     * Constructs a {@code StringIndexOutOfBoundsException} with
     * the specified detail message.
     *
     * @param   s   the detail message.
     */
    public StringIndexOutOfBoundsException(String s) {
        super(s);
    }

    /**
     * Constructs a new {@code StringIndexOutOfBoundsException}
     * class with an argument indicating the illegal index.
     *
     * @param   index   the illegal index.
     */
    public StringIndexOutOfBoundsException(int index) {
        super("String index out of range: " + index);
    }
}
