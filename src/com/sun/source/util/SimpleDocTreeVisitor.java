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

package com.sun.source.util;

import com.sun.source.doctree.*;

/**
 * A simple visitor for tree nodes.
 *
 * @since 1.8
 */
@jdk.Exported
public class SimpleDocTreeVisitor<R,P> implements DocTreeVisitor<R, P> {
    protected final R DEFAULT_VALUE;

    protected SimpleDocTreeVisitor() {
        DEFAULT_VALUE = null;
    }

    protected SimpleDocTreeVisitor(R defaultValue) {
        DEFAULT_VALUE = defaultValue;
    }

    protected R defaultAction(DocTree node, P p) {
        return DEFAULT_VALUE;
    }

    public final R visit(DocTree node, P p) {
        return (node == null) ? null : node.accept(this, p);
    }

    public final R visit(Iterable<? extends DocTree> nodes, P p) {
        R r = null;
        if (nodes != null) {
            for (DocTree node : nodes)
                r = visit(node, p);
        }
        return r;
    }

    public R visitAttribute(AttributeTree node, P p) {
        return defaultAction(node, p);
    }

    public R visitAuthor(AuthorTree node, P p) {
        return defaultAction(node, p);
    }

    public R visitComment(CommentTree node, P p) {
        return defaultAction(node, p);
    }

    public R visitDeprecated(DeprecatedTree node, P p) {
        return defaultAction(node, p);
    }

    public R visitDocComment(DocCommentTree node, P p) {
        return defaultAction(node, p);
    }

    public R visitDocRoot(DocRootTree node, P p) {
        return defaultAction(node, p);
    }

    public R visitEndElement(EndElementTree node, P p) {
        return defaultAction(node, p);
    }

    public R visitEntity(EntityTree node, P p) {
        return defaultAction(node, p);
    }

    public R visitErroneous(ErroneousTree node, P p) {
        return defaultAction(node, p);
    }

    public R visitIdentifier(IdentifierTree node, P p) {
        return defaultAction(node, p);
    }

    public R visitInheritDoc(InheritDocTree node, P p) {
        return defaultAction(node, p);
    }

    public R visitLink(LinkTree node, P p) {
        return defaultAction(node, p);
    }

    public R visitLiteral(LiteralTree node, P p) {
        return defaultAction(node, p);
    }

    public R visitParam(ParamTree node, P p) {
        return defaultAction(node, p);
    }

    public R visitReference(ReferenceTree node, P p) {
        return defaultAction(node, p);
    }

    public R visitReturn(ReturnTree node, P p) {
        return defaultAction(node, p);
    }

    public R visitSee(SeeTree node, P p) {
        return defaultAction(node, p);
    }

    public R visitSerial(SerialTree node, P p) {
        return defaultAction(node, p);
    }

    public R visitSerialData(SerialDataTree node, P p) {
        return defaultAction(node, p);
    }

    public R visitSerialField(SerialFieldTree node, P p) {
        return defaultAction(node, p);
    }

    public R visitSince(SinceTree node, P p) {
        return defaultAction(node, p);
    }

    public R visitStartElement(StartElementTree node, P p) {
        return defaultAction(node, p);
    }

    public R visitText(TextTree node, P p) {
        return defaultAction(node, p);
    }

    public R visitThrows(ThrowsTree node, P p) {
        return defaultAction(node, p);
    }

    public R visitUnknownBlockTag(UnknownBlockTagTree node, P p) {
        return defaultAction(node, p);
    }

    public R visitUnknownInlineTag(UnknownInlineTagTree node, P p) {
        return defaultAction(node, p);
    }

    public R visitValue(ValueTree node, P p) {
        return defaultAction(node, p);
    }

    public R visitVersion(VersionTree node, P p) {
        return defaultAction(node, p);
    }

    public R visitOther(DocTree node, P p) {
        return defaultAction(node, p);
    }

}
