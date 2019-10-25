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
 * {@code AnnotatedParameterizedType} represents the potentially annotated use
 * of a parameterized type, whose type arguments may themselves represent
 * annotated uses of types.
 *
 * @since 1.8
 */
public interface AnnotatedParameterizedType extends AnnotatedType {

    /**
     * Returns the potentially annotated actual type arguments of this parameterized type.
     *
     * @return the potentially annotated actual type arguments of this parameterized type
     */
    AnnotatedType[] getAnnotatedActualTypeArguments();
}
