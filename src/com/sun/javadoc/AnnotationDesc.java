/*
 * Copyright (c) 2003, 2013, Oracle and/or its affiliates. All rights reserved.
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
 * Represents an annotation.
 * An annotation associates a value with each element of an annotation type.
 *
 * @author Scott Seligman
 * @since 1.5
 */
public interface AnnotationDesc {

    /**
     * Returns the annotation type of this annotation.
     *
     * @return the annotation type of this annotation.
     */
    AnnotationTypeDoc annotationType();

    /**
     * Returns this annotation's elements and their values.
     * Only those explicitly present in the annotation are
     * included, not those assuming their default values.
     * Returns an empty array if there are none.
     *
     * @return this annotation's elements and their values.
     */
    ElementValuePair[] elementValues();

    /**
     * Check for the synthesized bit on the annotation.
     *
     * @return true if the annotation is synthesized.
     */
    boolean isSynthesized();

    /**
     * Represents an association between an annotation type element
     * and one of its values.
     *
     * @author Scott Seligman
     * @since 1.5
     */
    public interface ElementValuePair {

        /**
         * Returns the annotation type element.
         *
         * @return the annotation type element.
         */
        AnnotationTypeElementDoc element();

        /**
         * Returns the value associated with the annotation type element.
         *
         * @return the value associated with the annotation type element.
         */
        AnnotationValue value();
    }
}
