/*
 * Copyright (c) 1995, 2008, Oracle and/or its affiliates. All rights reserved.
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
 * Thrown if an application tries to access or modify a specified
 * field of an object, and that object no longer has that field.
 * <p>
 * Normally, this error is caught by the compiler; this error can
 * only occur at run time if the definition of a class has
 * incompatibly changed.
 *
 * @author  unascribed
 * @since   JDK1.0
 */
public
class NoSuchFieldError extends IncompatibleClassChangeError {
    private static final long serialVersionUID = -3456430195886129035L;

    /**
     * Constructs a <code>NoSuchFieldError</code> with no detail message.
     */
    public NoSuchFieldError() {
        super();
    }

    /**
     * Constructs a <code>NoSuchFieldError</code> with the specified
     * detail message.
     *
     * @param   s   the detail message.
     */
    public NoSuchFieldError(String s) {
        super(s);
    }
}
