/*
 * Copyright (c) 1997, 2008, Oracle and/or its affiliates. All rights reserved.
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

import sun.awt.AppContext;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.plaf.*;
import javax.swing.text.View;



/**
 * BasicToggleButton implementation
 * <p>
 *
 * @author Jeff Dinkins
 */
public class BasicToggleButtonUI extends BasicButtonUI {

    private static final Object BASIC_TOGGLE_BUTTON_UI_KEY = new Object();

    private final static String propertyPrefix = "ToggleButton" + ".";

    // ********************************
    //          Create PLAF
    // ********************************
    public static ComponentUI createUI(JComponent b) {
        AppContext appContext = AppContext.getAppContext();
        BasicToggleButtonUI toggleButtonUI =
                (BasicToggleButtonUI) appContext.get(BASIC_TOGGLE_BUTTON_UI_KEY);
        if (toggleButtonUI == null) {
            toggleButtonUI = new BasicToggleButtonUI();
            appContext.put(BASIC_TOGGLE_BUTTON_UI_KEY, toggleButtonUI);
        }
        return toggleButtonUI;
    }

    protected String getPropertyPrefix() {
        return propertyPrefix;
    }


    // ********************************
    //          Paint Methods
    // ********************************
    public void paint(Graphics g, JComponent c) {
        AbstractButton b = (AbstractButton) c;
        ButtonModel model = b.getModel();

        Dimension size = b.getSize();
        FontMetrics fm = g.getFontMetrics();

        Insets i = c.getInsets();

        Rectangle viewRect = new Rectangle(size);

        viewRect.x += i.left;
        viewRect.y += i.top;
        viewRect.width -= (i.right + viewRect.x);
        viewRect.height -= (i.bottom + viewRect.y);

        Rectangle iconRect = new Rectangle();
        Rectangle textRect = new Rectangle();

        Font f = c.getFont();
        g.setFont(f);

        // layout the text and icon
        String text = SwingUtilities.layoutCompoundLabel(
            c, fm, b.getText(), b.getIcon(),
            b.getVerticalAlignment(), b.getHorizontalAlignment(),
            b.getVerticalTextPosition(), b.getHorizontalTextPosition(),
            viewRect, iconRect, textRect,
            b.getText() == null ? 0 : b.getIconTextGap());

        g.setColor(b.getBackground());

        if (model.isArmed() && model.isPressed() || model.isSelected()) {
            paintButtonPressed(g,b);
        }

        // Paint the Icon
        if(b.getIcon() != null) {
            paintIcon(g, b, iconRect);
        }

        // Draw the Text
        if(text != null && !text.equals("")) {
            View v = (View) c.getClientProperty(BasicHTML.propertyKey);
            if (v != null) {
               v.paint(g, textRect);
            } else {
               paintText(g, b, textRect, text);
            }
        }

        // draw the dashed focus line.
        if (b.isFocusPainted() && b.hasFocus()) {
            paintFocus(g, b, viewRect, textRect, iconRect);
        }
    }

    protected void paintIcon(Graphics g, AbstractButton b, Rectangle iconRect) {
        ButtonModel model = b.getModel();
        Icon icon = null;

        if(!model.isEnabled()) {
            if(model.isSelected()) {
               icon = b.getDisabledSelectedIcon();
            } else {
               icon = b.getDisabledIcon();
            }
        } else if(model.isPressed() && model.isArmed()) {
            icon = b.getPressedIcon();
            if(icon == null) {
                // Use selected icon
                icon = b.getSelectedIcon();
            }
        } else if(model.isSelected()) {
            if(b.isRolloverEnabled() && model.isRollover()) {
                icon = b.getRolloverSelectedIcon();
                if (icon == null) {
                    icon = b.getSelectedIcon();
                }
            } else {
                icon = b.getSelectedIcon();
            }
        } else if(b.isRolloverEnabled() && model.isRollover()) {
            icon = b.getRolloverIcon();
        }

        if(icon == null) {
            icon = b.getIcon();
        }

        icon.paintIcon(b, g, iconRect.x, iconRect.y);
    }

    /**
     * Overriden so that the text will not be rendered as shifted for
     * Toggle buttons and subclasses.
     */
    protected int getTextShiftOffset() {
        return 0;
    }

}
