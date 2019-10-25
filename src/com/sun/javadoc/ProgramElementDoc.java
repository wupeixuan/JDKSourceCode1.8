/*
 * Copyright (c) 1998, 2006, Oracle and/or its affiliates. All rights reserved.
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
 * Represents a java program element: class, interface, field,
 * constructor, or method.
 * This is an abstract class dealing with information common to
 * these elements.
 *
 * @see MemberDoc
 * @see ClassDoc
 *
 * @author Robert Field
 */
public interface ProgramElementDoc extends Doc {

    /**
     * Get the containing class or interface of this program element.
     *
     * @return a ClassDoc for this element's containing class or interface.
     * If this is a top-level class or interface, return null.
     */
    ClassDoc containingClass();

    /**
     * Get the package that this program element is contained in.
     *
     * @return a PackageDoc for this element containing package.
     * If in the unnamed package, this PackageDoc will have the
     * name "".
     */
    PackageDoc containingPackage();

    /**
     * Get the fully qualified name of this program element.
     * For example, for the class <code>java.util.Hashtable</code>,
     * return "java.util.Hashtable".
     * <p>
     * For the method <code>bar()</code> in class <code>Foo</code>
     * in the unnamed package, return "Foo.bar".
     *
     * @return the qualified name of the program element as a String.
     */
    String qualifiedName();

    /**
     * Get the modifier specifier integer.
     *
     * @see java.lang.reflect.Modifier
     */
    int modifierSpecifier();

    /**
     * Get modifiers string.
     * For example, for:
     * <pre>
     *   public abstract int foo() { ... }
     * </pre>
     * return "public abstract".
     * Annotations are not included.
     */
    String modifiers();

    /**
     * Get the annotations of this program element.
     * Return an empty array if there are none.
     *
     * @return the annotations of this program element.
     * @since 1.5
     */
    AnnotationDesc[] annotations();

    /**
     * Return true if this program element is public.
     */
    boolean isPublic();

    /**
     * Return true if this program element is protected.
     */
    boolean isProtected();

    /**
     * Return true if this program element is private.
     */
    boolean isPrivate();

    /**
     * Return true if this program element is package private.
     */
    boolean isPackagePrivate();
    /**
     * Return true if this program element is static.
     */
    boolean isStatic();

    /**
     * Return true if this program element is final.
     */
    boolean isFinal();
}
