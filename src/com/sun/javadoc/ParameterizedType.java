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
 * Represents an invocation of a generic class or interface.  For example,
 * given the generic interface {@code List<E>}, possible invocations
 * include:
 * <pre>
 *      {@code List<String>}
 *      {@code List<T extends Number>}
 *      {@code List<?>}
 * </pre>
 * A generic inner class {@code Outer<T>.Inner<S>} might be invoked as:
 * <pre>
 *      {@code Outer<Number>.Inner<String>}
 * </pre>
 *
 * @author Scott Seligman
 * @since 1.5
 */
public interface ParameterizedType extends Type {

    /**
     * Return the generic class or interface that declared this type.
     *
     * @return the generic class or interface that declared this type.
     */
    ClassDoc asClassDoc();

    /**
     * Return the actual type arguments of this type.
     * For a generic type that is nested within some other generic type
     * (such as {@code Outer<T>.Inner<S>}),
     * only the type arguments of the innermost type are included.
     *
     * @return the actual type arguments of this type.
     */
    Type[] typeArguments();

    /**
     * Return the class type that is a direct supertype of this one.
     * This is the superclass of this type's declaring class,
     * with type arguments substituted in.
     * Return null if this is an interface type.
     *
     * <p> For example, if this parameterized type is
     * {@code java.util.ArrayList<String>}, the result will be
     * {@code java.util.AbstractList<String>}.
     *
     * @return the class type that is a direct supertype of this one.
     */
    Type superclassType();

    /**
     * Return the interface types directly implemented by or extended by this
     * parameterized type.
     * These are the interfaces directly implemented or extended
     * by this type's declaring class or interface,
     * with type arguments substituted in.
     * Return an empty array if there are no interfaces.
     *
     * <p> For example, the interface extended by
     * {@code java.util.Set<String>} is {@code java.util.Collection<String>}.
     *
     * @return the interface types directly implemented by or extended by this
     * parameterized type.
     */
    Type[] interfaceTypes();

    /**
     * Return the type that contains this type as a member.
     * Return null is this is a top-level type.
     *
     * <p> For example, the containing type of
     * {@code AnInterface.Nested<Number>} is the <code>ClassDoc</code>
     * representing {@code AnInterface}, and the containing type of
     * {@code Outer<String>.Inner<Number>} is the
     * <code>ParameterizedType</code> representing {@code Outer<String>}.
     *
     * @return the type that contains this type as a member.
     */
    Type containingType();
}
