/*
 * Copyright (c) 1997, 2013, Oracle and/or its affiliates. All rights reserved.
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
 * Represents a type.  A type can be a class or interface, an
 * invocation (like {@code List<String>}) of a generic class or interface,
 * a type variable, a wildcard type ("<code>?</code>"),
 * or a primitive data type (like <code>char</code>).
 *
 * @since 1.2
 * @author Kaiyang Liu (original)
 * @author Robert Field (rewrite)
 * @author Scott Seligman (generics)
 */
public interface Type {

    /**
     * Return unqualified name of type excluding any dimension information.
     * <p>
     * For example, a two dimensional array of String returns
     * "<code>String</code>".
     */
    String typeName();

    /**
     * Return qualified name of type excluding any dimension information.
     *<p>
     * For example, a two dimensional array of String
     * returns "<code>java.lang.String</code>".
     */
    String qualifiedTypeName();

    /**
     * Return the simple name of this type excluding any dimension information.
     * This is the unqualified name of the type, except that for nested types
     * only the identifier of the innermost type is included.
     * <p>
     * For example, the class {@code Outer.Inner} returns
     * "<code>Inner</code>".
     *
     * @since 1.5
     */
    String simpleTypeName();

    /**
     * Return the type's dimension information, as a string.
     * <p>
     * For example, a two dimensional array of String returns
     * "<code>[][]</code>".
     */
    String dimension();

    /**
     * Return a string representation of the type.
     * This includes any dimension information and type arguments.
     * <p>
     * For example, a two dimensional array of String may return
     * "<code>java.lang.String[][]</code>",
     * and the parameterized type {@code List<Integer>} may return
     * "{@code java.util.List<java.lang.Integer>}".
     *
     * @return a string representation of the type.
     */
    String toString();

    /**
     * Return true if this type represents a primitive type.
     *
     * @return true if this type represents a primitive type.
     * @since 1.5
     */
    boolean isPrimitive();

    /**
     * Return this type as a <code>ClassDoc</code> if it represents a class
     * or interface.  Array dimensions are ignored.
     * If this type is a <code>ParameterizedType</code>,
     * <code>TypeVariable</code>, or <code>WildcardType</code>, return
     * the <code>ClassDoc</code> of the type's erasure.  If this is an
     * <code>AnnotationTypeDoc</code>, return this as a <code>ClassDoc</code>
     * (but see {@link #asAnnotationTypeDoc()}).
     * If this is a primitive type, return null.
     *
     * @return the <code>ClassDoc</code> of this type,
     *         or null if it is a primitive type.
     */
    ClassDoc asClassDoc();

    /**
     * Return this type as a <code>ParameterizedType</code> if it represents
     * an invocation of a generic class or interface.  Array dimensions
     * are ignored.
     *
     * @return a <code>ParameterizedType</code> if the type is an
     *         invocation of a generic type, or null if it is not.
     * @since 1.5
     */
    ParameterizedType asParameterizedType();

    /**
     * Return this type as a <code>TypeVariable</code> if it represents
     * a type variable.  Array dimensions are ignored.
     *
     * @return a <code>TypeVariable</code> if the type is a type variable,
     *         or null if it is not.
     * @since 1.5
     */
    TypeVariable asTypeVariable();

    /**
     * Return this type as a <code>WildcardType</code> if it represents
     * a wildcard type.
     *
     * @return a <code>WildcardType</code> if the type is a wildcard type,
     *         or null if it is not.
     * @since 1.5
     */
    WildcardType asWildcardType();

    /**
     * Returns this type as a <code>AnnotatedType</code> if it represents
     * an annotated type.
     *
     * @return a <code>AnnotatedType</code> if the type if an annotated type,
     *         or null if it is not
     * @since 1.8
     */
    AnnotatedType asAnnotatedType();

    /**
     * Return this type as an <code>AnnotationTypeDoc</code> if it represents
     * an annotation type.  Array dimensions are ignored.
     *
     * @return an <code>AnnotationTypeDoc</code> if the type is an annotation
     *         type, or null if it is not.
     * @since 1.5
     */
    AnnotationTypeDoc asAnnotationTypeDoc();

    /**
     * If this type is an array type, return the element type of the
     * array. Otherwise, return null.
     *
     * @return a <code>Type</code> representing the element type or null.
     * @since 1.8
     */
    Type getElementType();
}
