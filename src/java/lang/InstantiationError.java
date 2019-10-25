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
 * Thrown when an application tries to use the Java <code>new</code>
 * construct to instantiate an abstract class or an interface.
 * <p>
 * Normally, this error is caught by the compiler; this error can
 * only occur at run time if the definition of a class has
 * incompatibly changed.
 *
 * @author  unascribed
 * @since   JDK1.0
 */


public
class InstantiationError extends IncompatibleClassChangeError {
    private static final long serialVersionUID = -4885810657349421204L;

    /**
     * Constructs an <code>InstantiationError</code> with no detail  message.
     */
    public InstantiationError() {
        super();
    }

    /**
     * Constructs an <code>InstantiationError</code> with the specified
     * detail message.
     *
     * @param   s   the detail message.
     */
    public InstantiationError(String s) {
        super(s);
    }
}
