/*
 * Copyright (c) 1998, 2008, Oracle and/or its affiliates. All rights reserved.
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
 * Thrown when the Java Virtual Machine attempts to read a class
 * file and determines that the major and minor version numbers
 * in the file are not supported.
 *
 * @since   1.2
 */
public
class UnsupportedClassVersionError extends ClassFormatError {
    private static final long serialVersionUID = -7123279212883497373L;

    /**
     * Constructs a <code>UnsupportedClassVersionError</code>
     * with no detail message.
     */
    public UnsupportedClassVersionError() {
        super();
    }

    /**
     * Constructs a <code>UnsupportedClassVersionError</code> with
     * the specified detail message.
     *
     * @param   s   the detail message.
     */
    public UnsupportedClassVersionError(String s) {
        super(s);
    }
}
