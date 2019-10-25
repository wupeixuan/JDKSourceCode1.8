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

import javax.lang.model.element.Name;

/**
 * A tree node for a member reference expression.
 *
 * For example:
 * <pre>
 *   <em>expression</em> # <em>[ identifier | new ]</em>
 * </pre>
 *
 * @since 1.8
 */
@jdk.Exported
public interface MemberReferenceTree extends ExpressionTree {

    /**
     * There are two kinds of member references: (i) method references and
     * (ii) constructor references
     */
    @jdk.Exported
    public enum ReferenceMode {
        /** enum constant for method references */
        INVOKE,
        /** enum constant for constructor references */
        NEW
    }
    ReferenceMode getMode();
    ExpressionTree getQualifierExpression();
    Name getName();
    List<? extends ExpressionTree> getTypeArguments();
}
