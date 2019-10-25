/*
 * Copyright (c) 2008, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.source.tree;

import java.util.List;

/**
 * A tree node for an annotated type
 *
 * For example:
 * <pre>
 *    {@code @}<em>annotationType String</em>
 *    {@code @}<em>annotationType</em> ( <em>arguments</em> ) <em>Date</em>
 * </pre>
 *
 * @see "JSR 308: Annotations on Java Types"
 *
 * @author Mahmood Ali
 * @since 1.8
 */
@jdk.Exported
public interface AnnotatedTypeTree extends ExpressionTree {
    List<? extends AnnotationTree> getAnnotations();
    ExpressionTree getUnderlyingType();
}
