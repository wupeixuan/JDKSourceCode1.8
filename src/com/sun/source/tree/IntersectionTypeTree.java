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

package com.sun.source.tree;

import java.util.List;

/**
 * A tree node for an intersection type in a cast expression.
 *
 * @author Maurizio Cimadamore
 *
 * @since 1.8
 */
@jdk.Exported
public interface IntersectionTypeTree extends Tree {
    List<? extends Tree> getBounds();
}
