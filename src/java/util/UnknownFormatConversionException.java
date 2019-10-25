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
 * Unchecked exception thrown when an unknown conversion is given.
 *
 * <p> Unless otherwise specified, passing a <tt>null</tt> argument to
 * any method or constructor in this class will cause a {@link
 * NullPointerException} to be thrown.
 *
 * @since 1.5
 */
public class UnknownFormatConversionException extends IllegalFormatException {

    private static final long serialVersionUID = 19060418L;

    private String s;

    /**
     * Constructs an instance of this class with the unknown conversion.
     *
     * @param  s
     *         Unknown conversion
     */
    public UnknownFormatConversionException(String s) {
        if (s == null)
            throw new NullPointerException();
        this.s = s;
    }

    /**
     * Returns the unknown conversion.
     *
     * @return  The unknown conversion.
     */
    public String getConversion() {
        return s;
    }

    // javadoc inherited from Throwable.java
    public String getMessage() {
        return String.format("Conversion = '%s'", s);
    }
}
