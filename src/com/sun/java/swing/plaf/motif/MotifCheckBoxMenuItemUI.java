/*
 * Copyright (c) 1997, 2006, Oracle and/or its affiliates. All rights reserved.
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
import javax.swing.event.*;
import javax.swing.plaf.*;
import javax.swing.plaf.basic.BasicButtonListener;
import javax.swing.plaf.basic.BasicCheckBoxMenuItemUI;

import java.awt.*;
import java.awt.event.*;


/**
 * MotifCheckboxMenuItem implementation
 * <p>
 *
 * @author Georges Saab
 * @author Rich Schiavi
 */
public class MotifCheckBoxMenuItemUI extends BasicCheckBoxMenuItemUI
{
    protected ChangeListener changeListener;

    public static ComponentUI createUI(JComponent b) {
        return new MotifCheckBoxMenuItemUI();
    }

    protected void installListeners() {
        super.installListeners();
        changeListener = createChangeListener(menuItem);
        menuItem.addChangeListener(changeListener);
    }

    protected void uninstallListeners() {
        super.uninstallListeners();
        menuItem.removeChangeListener(changeListener);
    }

    protected ChangeListener createChangeListener(JComponent c) {
        return new ChangeHandler();
    }

    protected class ChangeHandler implements ChangeListener {
        public void stateChanged(ChangeEvent e) {
            JMenuItem c = (JMenuItem)e.getSource();
            LookAndFeel.installProperty(c, "borderPainted", c.isArmed());
        }
    }

    protected MouseInputListener createMouseInputListener(JComponent c) {
        return new MouseInputHandler();
    }


    protected class MouseInputHandler implements MouseInputListener {
        public void mouseClicked(MouseEvent e) {}
        public void mousePressed(MouseEvent e) {
            MenuSelectionManager manager = MenuSelectionManager.defaultManager();
            manager.setSelectedPath(getPath());
        }
        public void mouseReleased(MouseEvent e) {
            MenuSelectionManager manager =
                MenuSelectionManager.defaultManager();
            JMenuItem menuItem = (JMenuItem)e.getComponent();
            Point p = e.getPoint();
            if(p.x >= 0 && p.x < menuItem.getWidth() &&
               p.y >= 0 && p.y < menuItem.getHeight()) {
                manager.clearSelectedPath();
                menuItem.doClick(0);
            } else {
                manager.processMouseEvent(e);
            }
        }
        public void mouseEntered(MouseEvent e) {}
        public void mouseExited(MouseEvent e) {}
        public void mouseDragged(MouseEvent e) {
            MenuSelectionManager.defaultManager().processMouseEvent(e);
        }
        public void mouseMoved(MouseEvent e) { }
    }

}
