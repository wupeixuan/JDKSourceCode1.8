/*
 * Copyright (c) 1996, 2009, Oracle and/or its affiliates. All rights reserved.
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

package java.beans;

/**
 * Thrown when an exception happens during Introspection.
 * <p>
 * Typical causes include not being able to map a string class name
 * to a Class object, not being able to resolve a string method name,
 * or specifying a method name that has the wrong type signature for
 * its intended use.
 */

public
class IntrospectionException extends Exception {
    private static final long serialVersionUID = -3728150539969542619L;

    /**
     * Constructs an <code>IntrospectionException</code> with a
     * detailed message.
     *
     * @param mess Descriptive message
     */
    public IntrospectionException(String mess) {
        super(mess);
    }
}
