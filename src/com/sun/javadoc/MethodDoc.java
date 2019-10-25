/*
 * Copyright (c) 1998, 2012, Oracle and/or its affiliates. All rights reserved.
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
 * Represents a method of a java class.
 *
 * @since 1.2
 * @author Robert Field
 */
public interface MethodDoc extends ExecutableMemberDoc {

    /**
     * Return true if this method is abstract
     */
    boolean isAbstract();

    /**
     * Return true if this method is default
     */
    boolean isDefault();

    /**
     * Get return type.
     *
     * @return the return type of this method, null if it
     * is a constructor.
     */
    Type returnType();

    /**
     * Return the class containing the method that this method overrides.
     *
     * <p> <i>The <code>overriddenClass</code> method cannot
     * accommodate certain generic type constructs.  The
     * <code>overriddenType</code> method should be used instead.</i>
     *
     * @return a ClassDoc representing the superclass
     *         defining a method that this method overrides, or null if
     *         this method does not override.
     */
    ClassDoc overriddenClass();

    /**
     * Return the type containing the method that this method overrides.
     * It may be a <code>ClassDoc</code> or a <code>ParameterizedType</code>.
     *
     * @return the supertype whose method is overridden, or null if this
     *         method does not override another in a superclass
     * @since 1.5
     */
    Type overriddenType();

    /**
     * Return the method that this method overrides.
     *
     * @return a MethodDoc representing a method definition
     * in a superclass this method overrides, null if
     * this method does not override.
     */
    MethodDoc overriddenMethod();

    /**
     * Tests whether this method overrides another.
     * The overridden method may be one declared in a superclass or
     * a superinterface (unlike {@link #overriddenMethod()}).
     *
     * <p> When a non-abstract method overrides an abstract one, it is
     * also said to <i>implement</i> the other.
     *
     * @param meth  the other method to examine
     * @return <tt>true</tt> if this method overrides the other
     * @since 1.5
     */
    boolean overrides(MethodDoc meth);
}
