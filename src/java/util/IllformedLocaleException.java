/*
 * Copyright (c) 2010, Oracle and/or its affiliates. All rights reserved.
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

/*
 *******************************************************************************
 * Copyright (C) 2009-2010, International Business Machines Corporation and    *
 * others. All Rights Reserved.                                                *
 *******************************************************************************
 */

package java.util;

/**
 * Thrown by methods in {@link Locale} and {@link Locale.Builder} to
 * indicate that an argument is not a well-formed BCP 47 tag.
 *
 * @see Locale
 * @since 1.7
 */
public class IllformedLocaleException extends RuntimeException {

    private static final long serialVersionUID = -5245986824925681401L;

    private int _errIdx = -1;

    /**
     * Constructs a new <code>IllformedLocaleException</code> with no
     * detail message and -1 as the error index.
     */
    public IllformedLocaleException() {
        super();
    }

    /**
     * Constructs a new <code>IllformedLocaleException</code> with the
     * given message and -1 as the error index.
     *
     * @param message the message
     */
    public IllformedLocaleException(String message) {
        super(message);
    }

    /**
     * Constructs a new <code>IllformedLocaleException</code> with the
     * given message and the error index.  The error index is the approximate
     * offset from the start of the ill-formed value to the point where the
     * parse first detected an error.  A negative error index value indicates
     * either the error index is not applicable or unknown.
     *
     * @param message the message
     * @param errorIndex the index
     */
    public IllformedLocaleException(String message, int errorIndex) {
        super(message + ((errorIndex < 0) ? "" : " [at index " + errorIndex + "]"));
        _errIdx = errorIndex;
    }

    /**
     * Returns the index where the error was found. A negative value indicates
     * either the error index is not applicable or unknown.
     *
     * @return the error index
     */
    public int getErrorIndex() {
        return _errIdx;
    }
}
