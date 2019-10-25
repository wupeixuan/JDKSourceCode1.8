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

package com.sun.source.tree;

import java.util.List;

/**
 * A tree node for a lambda expression.
 *
 * For example:
 * <pre>{@code
 *   ()->{}
 *   (List<String> ls)->ls.size()
 *   (x,y)-> { return x + y; }
 * }</pre>
 */
@jdk.Exported
public interface LambdaExpressionTree extends ExpressionTree {

    /**
     * Lambda expressions come in two forms: (i) expression lambdas, whose body
     * is an expression, and (ii) statement lambdas, whose body is a block
     */
    @jdk.Exported
    public enum BodyKind {
        /** enum constant for expression lambdas */
        EXPRESSION,
        /** enum constant for statement lambdas */
        STATEMENT;
    }

    List<? extends VariableTree> getParameters();
    Tree getBody();
    BodyKind getBodyKind();
}
