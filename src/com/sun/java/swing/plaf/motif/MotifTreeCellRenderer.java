/*
 * Copyright (c) 1997, 1999, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.java.swing.plaf.motif;

import javax.swing.*;
import javax.swing.plaf.*;
import javax.swing.tree.*;
import java.awt.*;
import java.awt.event.*;
import java.beans.*;
import java.io.*;
import java.util.*;

/**
 * Motif rendered to display a tree cell.
 * <p>
 * <strong>Warning:</strong>
 * Serialized objects of this class will not be compatible with
 * future Swing releases.  The current serialization support is appropriate
 * for short term storage or RMI between applications running the same
 * version of Swing.  A future release of Swing will provide support for
 * long term persistence.
 *
 * @author Jeff Dinkins
 */
public class MotifTreeCellRenderer extends DefaultTreeCellRenderer
{
    static final int LEAF_SIZE = 13;
    static final Icon LEAF_ICON = new IconUIResource(new TreeLeafIcon());

    public MotifTreeCellRenderer() {
        super();
    }

    public static Icon loadLeafIcon() {
        return LEAF_ICON;
    }

    /**
     * Icon for a node with no children.
     * <p>
     * <strong>Warning:</strong>
     * Serialized objects of this class will not be compatible with
     * future Swing releases.  The current serialization support is appropriate
     * for short term storage or RMI between applications running the same
     * version of Swing.  A future release of Swing will provide support for
     * long term persistence.
     */
    public static class TreeLeafIcon implements Icon, Serializable {

        Color bg;
        Color shadow;
        Color highlight;

        public TreeLeafIcon() {
            bg = UIManager.getColor("Tree.iconBackground");
            shadow = UIManager.getColor("Tree.iconShadow");
            highlight = UIManager.getColor("Tree.iconHighlight");
        }

        public void paintIcon(Component c, Graphics g, int x, int y) {
            g.setColor(bg);

            y -= 3;
            g.fillRect(x + 4, y + 7, 5, 5);

            g.drawLine(x + 6, y + 6, x + 6, y + 6);
            g.drawLine(x + 3, y + 9, x + 3, y + 9);
            g.drawLine(x + 6, y + 12, x + 6, y + 12);
            g.drawLine(x + 9, y + 9, x + 9, y + 9);

            g.setColor(highlight);
            g.drawLine(x + 2, y + 9, x + 5, y + 6);
            g.drawLine(x + 3, y + 10, x + 5, y + 12);

            g.setColor(shadow);
            g.drawLine(x + 6, y + 13, x + 10, y + 9);
            g.drawLine(x + 9, y + 8, x + 7, y + 6);
        }

        public int getIconWidth() {
            return LEAF_SIZE;
        }

        public int getIconHeight() {
            return LEAF_SIZE;
        }

    }
}
