/*
 * Copyright (c) 1998, 2003, Oracle and/or its affiliates. All rights reserved.
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

package javax.swing.plaf.basic;


import java.awt.*;
import java.io.*;

/**
  * Center-positioning layout manager.
  * @author Tom Santos
  * @author Steve Wilson
  */
class CenterLayout implements LayoutManager, Serializable {
    public void addLayoutComponent(String name, Component comp) { }
    public void removeLayoutComponent(Component comp) { }

    public Dimension preferredLayoutSize( Container container ) {
        Component c = container.getComponent( 0 );
        if ( c != null ) {
            Dimension size = c.getPreferredSize();
            Insets insets = container.getInsets();

            return new Dimension(size.width + insets.left + insets.right,
                                 size.height + insets.top + insets.bottom);
        }
        else {
            return new Dimension( 0, 0 );
        }
    }

    public Dimension minimumLayoutSize(Container cont) {
        return preferredLayoutSize(cont);
    }

    public void layoutContainer(Container container) {
        if (container.getComponentCount() > 0) {
            Component c = container.getComponent(0);
            Dimension pref = c.getPreferredSize();
            int containerWidth = container.getWidth();
            int containerHeight = container.getHeight();
            Insets containerInsets = container.getInsets();

            containerWidth -= containerInsets.left +
                              containerInsets.right;
            containerHeight -= containerInsets.top +
                               containerInsets.bottom;

            int left = (containerWidth - pref.width) / 2 +
                            containerInsets.left;
            int right = (containerHeight - pref.height) / 2 +
                            containerInsets.top;

            c.setBounds(left, right, pref.width, pref.height);
        }
    }
}
