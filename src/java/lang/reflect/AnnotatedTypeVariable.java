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
 * {@code AnnotatedTypeVariable} represents the potentially annotated use of a
 * type variable, whose declaration may have bounds which themselves represent
 * annotated uses of types.
 *
 * @since 1.8
 */
public interface AnnotatedTypeVariable extends AnnotatedType {

    /**
     * Returns the potentially annotated bounds of this type variable.
     *
     * @return the potentially annotated bounds of this type variable
     */
    AnnotatedType[] getAnnotatedBounds();
}
