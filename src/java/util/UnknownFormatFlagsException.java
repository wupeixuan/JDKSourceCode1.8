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
 * Unchecked exception thrown when an unknown flag is given.
 *
 * <p> Unless otherwise specified, passing a <tt>null</tt> argument to any
 * method or constructor in this class will cause a {@link
 * NullPointerException} to be thrown.
 *
 * @since 1.5
 */
public class UnknownFormatFlagsException extends IllegalFormatException {

    private static final long serialVersionUID = 19370506L;

    private String flags;

    /**
     * Constructs an instance of this class with the specified flags.
     *
     * @param  f
     *         The set of format flags which contain an unknown flag
     */
    public UnknownFormatFlagsException(String f) {
        if (f == null)
            throw new NullPointerException();
        this.flags = f;
    }

    /**
     * Returns the set of flags which contains an unknown flag.
     *
     * @return  The flags
     */
    public String getFlags() {
        return flags;
    }

    // javadoc inherited from Throwable.java
    public String getMessage() {
        return "Flags = " + flags;
    }
}
