/*
 * Copyright (c) 1997, 1998, Oracle and/or its affiliates. All rights reserved.
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

package javax.swing.plaf;

import java.awt.Rectangle;
import javax.swing.JTree;
import javax.swing.tree.TreePath;

/**
 * Pluggable look and feel interface for JTree.
 *
 * @author Rob Davis
 * @author Scott Violet
 */
public abstract class TreeUI extends ComponentUI
{
    /**
      * Returns the Rectangle enclosing the label portion that the
      * last item in path will be drawn into.  Will return null if
      * any component in path is currently valid.
      */
    public abstract Rectangle getPathBounds(JTree tree, TreePath path);

    /**
      * Returns the path for passed in row.  If row is not visible
      * null is returned.
      */
    public abstract TreePath getPathForRow(JTree tree, int row);

    /**
      * Returns the row that the last item identified in path is visible
      * at.  Will return -1 if any of the elements in path are not
      * currently visible.
      */
    public abstract int getRowForPath(JTree tree, TreePath path);

    /**
      * Returns the number of rows that are being displayed.
      */
    public abstract int getRowCount(JTree tree);

    /**
      * Returns the path to the node that is closest to x,y.  If
      * there is nothing currently visible this will return null, otherwise
      * it'll always return a valid path.  If you need to test if the
      * returned object is exactly at x, y you should get the bounds for
      * the returned path and test x, y against that.
      */
    public abstract TreePath getClosestPathForLocation(JTree tree, int x,
                                                       int y);

    /**
      * Returns true if the tree is being edited.  The item that is being
      * edited can be returned by getEditingPath().
      */
    public abstract boolean isEditing(JTree tree);

    /**
      * Stops the current editing session.  This has no effect if the
      * tree isn't being edited.  Returns true if the editor allows the
      * editing session to stop.
      */
    public abstract boolean stopEditing(JTree tree);

    /**
      * Cancels the current editing session. This has no effect if the
      * tree isn't being edited.  Returns true if the editor allows the
      * editing session to stop.
      */
    public abstract void cancelEditing(JTree tree);

    /**
      * Selects the last item in path and tries to edit it.  Editing will
      * fail if the CellEditor won't allow it for the selected item.
      */
    public abstract void startEditingAtPath(JTree tree, TreePath path);

    /**
     * Returns the path to the element that is being edited.
     */
    public abstract TreePath getEditingPath(JTree tree);
}
