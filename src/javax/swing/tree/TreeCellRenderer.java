/*
 * Copyright (c) 1997, 2013, Oracle and/or its affiliates. All rights reserved.
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
package javax.swing.tree;

import java.awt.Component;
import javax.swing.JTree;

/**
 * Defines the requirements for an object that displays a tree node.
 * See <a
 href="https://docs.oracle.com/javase/tutorial/uiswing/components/tree.html">How to Use Trees</a>
 * in <em>The Java Tutorial</em>
 * for an example of implementing a tree cell renderer
 * that displays custom icons.
 *
 * @author Rob Davis
 * @author Ray Ryan
 * @author Scott Violet
 */
public interface TreeCellRenderer {

    /**
     * Sets the value of the current tree cell to <code>value</code>.
     * If <code>selected</code> is true, the cell will be drawn as if
     * selected. If <code>expanded</code> is true the node is currently
     * expanded and if <code>leaf</code> is true the node represents a
     * leaf and if <code>hasFocus</code> is true the node currently has
     * focus. <code>tree</code> is the <code>JTree</code> the receiver is being
     * configured for.  Returns the <code>Component</code> that the renderer
     * uses to draw the value.
     * <p>
     * The <code>TreeCellRenderer</code> is also responsible for rendering the
     * the cell representing the tree's current DnD drop location if
     * it has one. If this renderer cares about rendering
     * the DnD drop location, it should query the tree directly to
     * see if the given row represents the drop location:
     * <pre>
     *     JTree.DropLocation dropLocation = tree.getDropLocation();
     *     if (dropLocation != null
     *             &amp;&amp; dropLocation.getChildIndex() == -1
     *             &amp;&amp; tree.getRowForPath(dropLocation.getPath()) == row) {
     *
     *         // this row represents the current drop location
     *         // so render it specially, perhaps with a different color
     *     }
     * </pre>
     *
     * @return  the <code>Component</code> that the renderer uses to draw the value
     */
    Component getTreeCellRendererComponent(JTree tree, Object value,
                                   boolean selected, boolean expanded,
                                   boolean leaf, int row, boolean hasFocus);

}
