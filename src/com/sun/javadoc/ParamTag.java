/*
 * Copyright (c) 1998, 2003, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.javadoc;

/**
 * Represents an @param documentation tag.
 * Stores the name and comment parts of the parameter tag.
 * An @param tag may represent either a method or constructor parameter,
 * or a type parameter.
 *
 * @author Robert Field
 *
 */
public interface ParamTag extends Tag {

    /**
     * Return the name of the parameter or type parameter
     * associated with this <code>ParamTag</code>.
     * The angle brackets delimiting a type parameter are not part of
     * its name.
     *
     * @return the parameter name.
     */
    String parameterName();

    /**
     * Return the parameter comment
     * associated with this <code>ParamTag</code>.
     *
     * @return the parameter comment.
     */
    String parameterComment();

    /**
     * Return true if this <code>ParamTag</code> corresponds to a type
     * parameter.  Return false if it corresponds to an ordinary parameter
     * of a method or constructor.
     *
     * @return true if this <code>ParamTag</code> corresponds to a type
     * parameter.
     * @since 1.5
     */
    boolean isTypeParameter();
}
