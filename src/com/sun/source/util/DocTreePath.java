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

import com.sun.source.doctree.DocCommentTree;
import com.sun.source.doctree.DocTree;
import java.util.Iterator;

/**
 * A path of tree nodes, typically used to represent the sequence of ancestor
 * nodes of a tree node up to the top level DocCommentTree node.
 *
 * @since 1.8
 */
@jdk.Exported
public class DocTreePath implements Iterable<DocTree> {
    /**
     * Gets a documentation tree path for a tree node within a compilation unit.
     * @return null if the node is not found
     */
    public static DocTreePath getPath(TreePath treePath, DocCommentTree doc, DocTree target) {
        return getPath(new DocTreePath(treePath, doc), target);
    }

    /**
     * Gets a documentation tree path for a tree node within a subtree identified by a DocTreePath object.
     * @return null if the node is not found
     */
    public static DocTreePath getPath(DocTreePath path, DocTree target) {
        path.getClass();
        target.getClass();

        class Result extends Error {
            static final long serialVersionUID = -5942088234594905625L;
            DocTreePath path;
            Result(DocTreePath path) {
                this.path = path;
            }
        }

        class PathFinder extends DocTreePathScanner<DocTreePath,DocTree> {
            public DocTreePath scan(DocTree tree, DocTree target) {
                if (tree == target) {
                    throw new Result(new DocTreePath(getCurrentPath(), target));
                }
                return super.scan(tree, target);
            }
        }

        if (path.getLeaf() == target) {
            return path;
        }

        try {
            new PathFinder().scan(path, target);
        } catch (Result result) {
            return result.path;
        }
        return null;
    }

    /**
     * Creates a DocTreePath for a root node.
     *
     * @param treePath the TreePath from which the root node was created.
     * @param t the DocCommentTree to create the path for.
     */
    public DocTreePath(TreePath treePath, DocCommentTree t) {
        treePath.getClass();
        t.getClass();

        this.treePath = treePath;
        this.docComment = t;
        this.parent = null;
        this.leaf = t;
    }

    /**
     * Creates a DocTreePath for a child node.
     */
    public DocTreePath(DocTreePath p, DocTree t) {
        if (t.getKind() == DocTree.Kind.DOC_COMMENT) {
            throw new IllegalArgumentException("Use DocTreePath(TreePath, DocCommentTree) to construct DocTreePath for a DocCommentTree.");
        } else {
            treePath = p.treePath;
            docComment = p.docComment;
            parent = p;
        }
        leaf = t;
    }

    /**
     * Get the TreePath associated with this path.
     * @return TreePath for this DocTreePath
     */
    public TreePath getTreePath() {
        return treePath;
    }

    /**
     * Get the DocCommentTree associated with this path.
     * @return DocCommentTree for this DocTreePath
     */
    public DocCommentTree getDocComment() {
        return docComment;
    }

    /**
     * Get the leaf node for this path.
     * @return DocTree for this DocTreePath
     */
    public DocTree getLeaf() {
        return leaf;
    }

    /**
     * Get the path for the enclosing node, or null if there is no enclosing node.
     * @return DocTreePath of parent
     */
    public DocTreePath getParentPath() {
        return parent;
    }

    public Iterator<DocTree> iterator() {
        return new Iterator<DocTree>() {
            public boolean hasNext() {
                return next != null;
            }

            public DocTree next() {
                DocTree t = next.leaf;
                next = next.parent;
                return t;
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }

            private DocTreePath next = DocTreePath.this;
        };
    }

    private final TreePath treePath;
    private final DocCommentTree docComment;
    private final DocTree leaf;
    private final DocTreePath parent;
}
