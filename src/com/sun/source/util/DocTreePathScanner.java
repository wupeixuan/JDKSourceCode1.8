/*
 * Copyright (c) 2006, 2013, Oracle and/or its affiliates. All rights reserved.
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

import com.sun.source.doctree.DocTree;

/**
 * A DocTreeVisitor that visits all the child tree nodes, and provides
 * support for maintaining a path for the parent nodes.
 * To visit nodes of a particular type, just override the
 * corresponding visitorXYZ method.
 * Inside your method, call super.visitXYZ to visit descendant
 * nodes.
 *
 * @since 1.8
 */
@jdk.Exported
public class DocTreePathScanner<R, P> extends DocTreeScanner<R, P> {
    /**
     * Scan a tree from a position identified by a TreePath.
     */
    public R scan(DocTreePath path, P p) {
        this.path = path;
        try {
            return path.getLeaf().accept(this, p);
        } finally {
            this.path = null;
        }
    }

    /**
     * Scan a single node.
     * The current path is updated for the duration of the scan.
     */
    @Override
    public R scan(DocTree tree, P p) {
        if (tree == null)
            return null;

        DocTreePath prev = path;
        path = new DocTreePath(path, tree);
        try {
            return tree.accept(this, p);
        } finally {
            path = prev;
        }
    }

    /**
     * Get the current path for the node, as built up by the currently
     * active set of scan calls.
     */
    public DocTreePath getCurrentPath() {
        return path;
    }

    private DocTreePath path;
}
