/*
 * Copyright (c) 1994, 2013, Oracle and/or its affiliates. All rights reserved.
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
 * Thrown to indicate that the code has attempted to cast an object
 * to a subclass of which it is not an instance. For example, the
 * following code generates a <code>ClassCastException</code>:
 * <blockquote><pre>
 *     Object x = new Integer(0);
 *     System.out.println((String)x);
 * </pre></blockquote>
 *
 * @author  unascribed
 * @since   JDK1.0
 */
public
class ClassCastException extends RuntimeException {
    private static final long serialVersionUID = -9223365651070458532L;

    /**
     * Constructs a <code>ClassCastException</code> with no detail message.
     */
    public ClassCastException() {
        super();
    }

    /**
     * Constructs a <code>ClassCastException</code> with the specified
     * detail message.
     *
     * @param   s   the detail message.
     */
    public ClassCastException(String s) {
        super(s);
    }
}
