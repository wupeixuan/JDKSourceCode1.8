/*
 * Copyright (c) 1998, 2013, Oracle and/or its affiliates. All rights reserved.
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

import javax.swing.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Rectangle;
import javax.swing.JToolBar;
import javax.swing.plaf.*;
import javax.swing.plaf.basic.BasicSeparatorUI;


/**
 * A Basic L&amp;F implementation of ToolBarSeparatorUI.  This implementation
 * is a "combined" view/controller.
 * <p>
 *
 * @author Jeff Shapiro
 */

public class BasicToolBarSeparatorUI extends BasicSeparatorUI
{
    public static ComponentUI createUI( JComponent c )
    {
        return new BasicToolBarSeparatorUI();
    }

    protected void installDefaults( JSeparator s )
    {
        Dimension size = ( (JToolBar.Separator)s ).getSeparatorSize();

        if ( size == null || size instanceof UIResource )
        {
            JToolBar.Separator sep = (JToolBar.Separator)s;
            size = (Dimension)(UIManager.get("ToolBar.separatorSize"));
            if (size != null) {
                if (sep.getOrientation() == JSeparator.HORIZONTAL) {
                    size = new Dimension(size.height, size.width);
                }
                sep.setSeparatorSize(size);
            }
        }
    }

    public void paint( Graphics g, JComponent c )
    {
    }

    public Dimension getPreferredSize( JComponent c )
    {
        Dimension size = ( (JToolBar.Separator)c ).getSeparatorSize();

        if ( size != null )
        {
            return size.getSize();
        }
        else
        {
            return null;
        }
    }
}
