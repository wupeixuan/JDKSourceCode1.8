/*
 * Copyright (c) 1997, 2004, Oracle and/or its affiliates. All rights reserved.
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

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.plaf.*;
import javax.swing.border.*;
import javax.swing.plaf.basic.*;


import javax.swing.plaf.basic.BasicMenuUI;

/**
 * A Motif L&F implementation of MenuUI.
 * <p>
 *
 * @author Georges Saab
 * @author Rich Schiavi
 */
public class MotifMenuUI extends BasicMenuUI
{

    public static ComponentUI createUI( JComponent x ) {
        return new MotifMenuUI();
    }

// These should not be necessary because BasicMenuUI does this,
// and this class overrides createChangeListener.
//    protected void installListeners() {
//      super.installListeners();
//        changeListener = createChangeListener(menuItem);
//        menuItem.addChangeListener(changeListener);
//    }
//
//    protected void uninstallListeners() {
//      super.uninstallListeners();
//      menuItem.removeChangeListener(changeListener);
//    }

    protected ChangeListener createChangeListener(JComponent c) {
        return new MotifChangeHandler((JMenu)c, this);
    }

    private boolean popupIsOpen(JMenu m,MenuElement me[]) {
        int i;
        JPopupMenu pm = m.getPopupMenu();

        for(i=me.length-1;i>=0;i--) {
            if(me[i].getComponent() == pm)
                return true;
        }
        return false;
    }

    protected MouseInputListener createMouseInputListener(JComponent c) {
        return new MouseInputHandler();
    }

    public class MotifChangeHandler extends ChangeHandler {
        public MotifChangeHandler(JMenu m, MotifMenuUI ui) {
            super(m, ui);
        }


        public void stateChanged(ChangeEvent e) {
            JMenuItem c = (JMenuItem)e.getSource();
            if (c.isArmed() || c.isSelected()) {
                c.setBorderPainted(true);
                // c.repaint();
            } else {
                c.setBorderPainted(false);
            }

            super.stateChanged(e);
        }
    }

    protected class MouseInputHandler implements MouseInputListener {
        public void mouseClicked(MouseEvent e) {}
        public void mousePressed(MouseEvent e) {
            MenuSelectionManager manager = MenuSelectionManager.defaultManager();
            JMenu menu = (JMenu)e.getComponent();
            if(menu.isEnabled()) {
                if(menu.isTopLevelMenu()) {
                    if(menu.isSelected()) {
                        manager.clearSelectedPath();
                    } else {
                        Container cnt = menu.getParent();
                        if(cnt != null && cnt instanceof JMenuBar) {
                            MenuElement me[] = new MenuElement[2];
                            me[0]=(MenuElement)cnt;
                            me[1]=menu;
                            manager.setSelectedPath(me);
                        }
                    }
                }

                MenuElement path[] = getPath();
                if (path.length > 0) {
                    MenuElement newPath[] = new MenuElement[path.length+1];
                    System.arraycopy(path,0,newPath,0,path.length);
                    newPath[path.length] = menu.getPopupMenu();
                    manager.setSelectedPath(newPath);
                }
            }
        }

        public void mouseReleased(MouseEvent e) {
            MenuSelectionManager manager =
                MenuSelectionManager.defaultManager();
            JMenuItem menuItem = (JMenuItem)e.getComponent();
            Point p = e.getPoint();
            if(!(p.x >= 0 && p.x < menuItem.getWidth() &&
                 p.y >= 0 && p.y < menuItem.getHeight())) {
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
