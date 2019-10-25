/*
 * Copyright (c) 2005, 2013, Oracle and/or its affiliates. All rights reserved.
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

/**
 * A tree node for an array access expression.
 *
 * For example:
 * <pre>
 *   <em>expression</em> [ <em>index</em> ]
 * </pre>
 *
 * @jls section 15.13
 *
 * @author Peter von der Ah&eacute;
 * @author Jonathan Gibbons
 * @since 1.6
 */
@jdk.Exported
public interface ArrayAccessTree extends ExpressionTree {
    ExpressionTree getExpression();
    ExpressionTree getIndex();
}
