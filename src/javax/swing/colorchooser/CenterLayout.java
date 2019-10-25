/*
 * Copyright (c) 1998, Oracle and/or its affiliates. All rights reserved.
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

package javax.swing.colorchooser;

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
            size.width += insets.left + insets.right;
            size.height += insets.top + insets.bottom;
            return size;
        }
        else {
            return new Dimension( 0, 0 );
        }
    }

    public Dimension minimumLayoutSize(Container cont) {
        return preferredLayoutSize(cont);
    }

    public void layoutContainer(Container container) {
        try {
           Component c = container.getComponent( 0 );

           c.setSize( c.getPreferredSize() );
           Dimension size = c.getSize();
           Dimension containerSize = container.getSize();
           Insets containerInsets = container.getInsets();
           containerSize.width -= containerInsets.left + containerInsets.right;
           containerSize.height -= containerInsets.top + containerInsets.bottom;
           int componentLeft = (containerSize.width / 2) - (size.width / 2);
           int componentTop = (containerSize.height / 2) - (size.height / 2);
           componentLeft += containerInsets.left;
           componentTop += containerInsets.top;

            c.setBounds( componentLeft, componentTop, size.width, size.height );
         }
         catch( Exception e ) {
         }
    }
}
