/*
 * Copyright (c) 2012, 2013, Oracle and/or its affiliates. All rights reserved.
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

package java.lang.reflect;

/**
 * {@code AnnotatedType} represents the potentially annotated use of a type in
 * the program currently running in this VM. The use may be of any type in the
 * Java programming language, including an array type, a parameterized type, a
 * type variable, or a wildcard type.
 *
 * @since 1.8
 */
public interface AnnotatedType extends AnnotatedElement {

    /**
     * Returns the underlying type that this annotated type represents.
     *
     * @return the type this annotated type represents
     */
    public Type getType();
}
