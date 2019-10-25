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
 * A tree node used as the base class for the different types of
 * inline tags.
 *
 * @since 1.8
 */
@jdk.Exported
public interface InlineTagTree extends DocTree {
    String getTagName();
}
