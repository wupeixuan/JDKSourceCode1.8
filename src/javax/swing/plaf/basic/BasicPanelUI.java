/*
 * Copyright (c) 1998, 2005, Oracle and/or its affiliates. All rights reserved.
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
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.plaf.*;
import java.awt.*;
import java.awt.event.*;


/**
 * BasicPanel implementation
 *
 * @author Steve Wilson
 */
public class BasicPanelUI extends PanelUI {

    // Shared UI object
    private static PanelUI panelUI;

    public static ComponentUI createUI(JComponent c) {
        if(panelUI == null) {
            panelUI = new BasicPanelUI();
        }
        return panelUI;
    }

    public void installUI(JComponent c) {
        JPanel p = (JPanel)c;
        super.installUI(p);
        installDefaults(p);
    }

    public void uninstallUI(JComponent c) {
        JPanel p = (JPanel)c;
        uninstallDefaults(p);
        super.uninstallUI(c);
    }

    protected void installDefaults(JPanel p) {
        LookAndFeel.installColorsAndFont(p,
                                         "Panel.background",
                                         "Panel.foreground",
                                         "Panel.font");
        LookAndFeel.installBorder(p,"Panel.border");
        LookAndFeel.installProperty(p, "opaque", Boolean.TRUE);
    }

    protected void uninstallDefaults(JPanel p) {
        LookAndFeel.uninstallBorder(p);
    }


    /**
     * Returns the baseline.
     *
     * @throws NullPointerException {@inheritDoc}
     * @throws IllegalArgumentException {@inheritDoc}
     * @see javax.swing.JComponent#getBaseline(int, int)
     * @since 1.6
     */
    public int getBaseline(JComponent c, int width, int height) {
        super.getBaseline(c, width, height);
        Border border = c.getBorder();
        if (border instanceof AbstractBorder) {
            return ((AbstractBorder)border).getBaseline(c, width, height);
        }
        return -1;
    }

    /**
     * Returns an enum indicating how the baseline of the component
     * changes as the size changes.
     *
     * @throws NullPointerException {@inheritDoc}
     * @see javax.swing.JComponent#getBaseline(int, int)
     * @since 1.6
     */
    public Component.BaselineResizeBehavior getBaselineResizeBehavior(
            JComponent c) {
        super.getBaselineResizeBehavior(c);
        Border border = c.getBorder();
        if (border instanceof AbstractBorder) {
            return ((AbstractBorder)border).getBaselineResizeBehavior(c);
        }
        return Component.BaselineResizeBehavior.OTHER;
    }
}
