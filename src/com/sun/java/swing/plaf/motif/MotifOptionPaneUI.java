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

package com.sun.java.swing.plaf.motif;

import javax.swing.*;
import javax.swing.plaf.basic.BasicOptionPaneUI;
import javax.swing.plaf.ComponentUI;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Rectangle;

/**
 * Provides the CDE/Motif look and feel for a JOptionPane.
 * <p>
 * <strong>Warning:</strong>
 * Serialized objects of this class will not be compatible with
 * future Swing releases.  The current serialization support is appropriate
 * for short term storage or RMI between applications running the same
 * version of Swing.  A future release of Swing will provide support for
 * long term persistence.
 *
 * @author Scott Violet
 */
public class MotifOptionPaneUI extends BasicOptionPaneUI
{
    /**
      * Creates a new MotifOptionPaneUI instance.
      */
    public static ComponentUI createUI(JComponent x) {
        return new MotifOptionPaneUI();
    }

    /**
     * Creates and returns a Container containin the buttons. The buttons
     * are created by calling <code>getButtons</code>.
     */
    protected Container createButtonArea() {
        Container          b = super.createButtonArea();

        if(b != null && b.getLayout() instanceof ButtonAreaLayout) {
            ((ButtonAreaLayout)b.getLayout()).setCentersChildren(false);
        }
        return b;
    }

    /**
     * Returns null, CDE/Motif does not impose a minimum size.
     */
    public Dimension getMinimumOptionPaneSize() {
        return null;
    }

    protected Container createSeparator() {
        return new JPanel() {

            public Dimension getPreferredSize() {
                return new Dimension(10, 2);
            }

            public void paint(Graphics g) {
                int width = getWidth();
                g.setColor(Color.darkGray);
                g.drawLine(0, 0, width, 0);
                g.setColor(Color.white);
                g.drawLine(0, 1, width, 1);
            }
        };
    }

    /**
     * Creates and adds a JLabel representing the icon returned from
     * <code>getIcon</code> to <code>top</code>. This is messaged from
     * <code>createMessageArea</code>
     */
    protected void addIcon(Container top) {
        /* Create the icon. */
        Icon                  sideIcon = getIcon();

        if (sideIcon != null) {
            JLabel            iconLabel = new JLabel(sideIcon);

            iconLabel.setVerticalAlignment(SwingConstants.CENTER);
            top.add(iconLabel, "West");
        }
    }

}
