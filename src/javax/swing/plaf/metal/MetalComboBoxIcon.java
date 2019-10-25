/*
 * Copyright (c) 1998, 2000, Oracle and/or its affiliates. All rights reserved.
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

package javax.swing.plaf.metal;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.plaf.*;
import javax.swing.border.*;
import java.io.Serializable;
import javax.swing.plaf.basic.BasicComboBoxUI;


/**
 * This utility class draws the horizontal bars which indicate a MetalComboBox
 *
 * @see MetalComboBoxUI
 * @author Tom Santos
 */
public class MetalComboBoxIcon implements Icon, Serializable {

    /**
     * Paints the horizontal bars for the
     */
    public void paintIcon(Component c, Graphics g, int x, int y){
        JComponent component = (JComponent)c;
        int iconWidth = getIconWidth();

        g.translate( x, y );

        g.setColor( component.isEnabled() ? MetalLookAndFeel.getControlInfo() : MetalLookAndFeel.getControlShadow() );
        g.drawLine( 0, 0, iconWidth - 1, 0 );
        g.drawLine( 1, 1, 1 + (iconWidth - 3), 1 );
        g.drawLine( 2, 2, 2 + (iconWidth - 5), 2 );
        g.drawLine( 3, 3, 3 + (iconWidth - 7), 3 );
        g.drawLine( 4, 4, 4 + (iconWidth - 9), 4 );

        g.translate( -x, -y );
    }

    /**
     * Created a stub to satisfy the interface.
     */
    public int getIconWidth() { return 10; }

    /**
     * Created a stub to satisfy the interface.
     */
    public int getIconHeight()  { return 5; }

}
