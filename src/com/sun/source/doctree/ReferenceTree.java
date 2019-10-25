/*
 * Copyright (c) 2011, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.source.doctree;

/**
 * A tree node to a reference to a Java language element.
 *
 * <p>
 * package.class#field
 *
 * @since 1.8
 */
@jdk.Exported
public interface ReferenceTree extends DocTree {
    String getSignature();
}
