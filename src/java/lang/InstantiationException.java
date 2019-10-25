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
 * Thrown when an application tries to create an instance of a class
 * using the {@code newInstance} method in class
 * {@code Class}, but the specified class object cannot be
 * instantiated.  The instantiation can fail for a variety of
 * reasons including but not limited to:
 *
 * <ul>
 * <li> the class object represents an abstract class, an interface,
 *      an array class, a primitive type, or {@code void}
 * <li> the class has no nullary constructor
 *</ul>
 *
 * @author  unascribed
 * @see     java.lang.Class#newInstance()
 * @since   JDK1.0
 */
public
class InstantiationException extends ReflectiveOperationException {
    private static final long serialVersionUID = -8441929162975509110L;

    /**
     * Constructs an {@code InstantiationException} with no detail message.
     */
    public InstantiationException() {
        super();
    }

    /**
     * Constructs an {@code InstantiationException} with the
     * specified detail message.
     *
     * @param   s   the detail message.
     */
    public InstantiationException(String s) {
        super(s);
    }
}
