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
 * {@code AnnotatedArrayType} represents the potentially annotated use of an
 * array type, whose component type may itself represent the annotated use of a
 * type.
 *
 * @since 1.8
 */
public interface AnnotatedArrayType extends AnnotatedType {

    /**
     * Returns the potentially annotated generic component type of this array type.
     *
     * @return the potentially annotated generic component type of this array type
     */
    AnnotatedType  getAnnotatedGenericComponentType();
}
