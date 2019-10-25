/*
 * Copyright (c) 2003, 2004, Oracle and/or its affiliates. All rights reserved.
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
 * Represents a value of an annotation type element.
 *
 * @author Scott Seligman
 * @since 1.5
 */
public interface AnnotationValue {

    /**
     * Returns the value.
     * The type of the returned object is one of the following:
     * <ul><li> a wrapper class for a primitive type
     *     <li> <code>String</code>
     *     <li> <code>Type</code> (representing a class literal)
     *     <li> <code>FieldDoc</code> (representing an enum constant)
     *     <li> <code>AnnotationDesc</code>
     *     <li> <code>AnnotationValue[]</code>
     * </ul>
     *
     * @return the value.
     */
    Object value();

    /**
     * Returns a string representation of the value.
     *
     * @return the text of a Java language annotation value expression
     *          whose value is the value of this element.
     */
    String toString();
}
