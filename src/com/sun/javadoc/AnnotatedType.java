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
 * Represents an annotated type.
 * For example:
 * <pre>
 *      {@code @NonNull String}
 *      {@code @Positive int}
 * </pre>
 *
 * @author Mahmood Ali
 * @since 1.8
 */
public interface AnnotatedType extends Type {

    AnnotationDesc[] annotations();

    Type underlyingType();
}
