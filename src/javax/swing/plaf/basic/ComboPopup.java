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

import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.KeyListener;
import javax.swing.JList;


/**
 * The interface which defines the methods required for the implementation of the popup
 * portion of a combo box.
 * <p>
 * <strong>Warning:</strong>
 * Serialized objects of this class will not be compatible with
 * future Swing releases. The current serialization support is
 * appropriate for short term storage or RMI between applications running
 * the same version of Swing.  As of 1.4, support for long term storage
 * of all JavaBeans&trade;
 * has been added to the <code>java.beans</code> package.
 * Please see {@link java.beans.XMLEncoder}.
 *
 * @author Tom Santos
 */
public interface ComboPopup {
    /**
     * Shows the popup
     */
    public void show();

    /**
     * Hides the popup
     */
    public void hide();

    /**
     * Returns true if the popup is visible (currently being displayed).
     *
     * @return <code>true</code> if the component is visible; <code>false</code> otherwise.
     */
    public boolean isVisible();

    /**
     * Returns the list that is being used to draw the items in the combo box.
     * This method is highly implementation specific and should not be used
     * for general list manipulation.
     */
    public JList getList();

    /**
     * Returns a mouse listener that will be added to the combo box or null.
     * If this method returns null then it will not be added to the combo box.
     *
     * @return a <code>MouseListener</code> or null
     */
    public MouseListener getMouseListener();

    /**
     * Returns a mouse motion listener that will be added to the combo box or null.
     * If this method returns null then it will not be added to the combo box.
     *
     * @return a <code>MouseMotionListener</code> or null
     */
    public MouseMotionListener getMouseMotionListener();

    /**
     * Returns a key listener that will be added to the combo box or null.
     * If this method returns null then it will not be added to the combo box.
     */
    public KeyListener getKeyListener();

    /**
     * Called to inform the ComboPopup that the UI is uninstalling.
     * If the ComboPopup added any listeners in the component, it should remove them here.
     */
    public void uninstallingUI();
}
