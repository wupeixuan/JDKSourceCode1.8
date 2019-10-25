/*
 * Copyright (c) 1998, 2001, Oracle and/or its affiliates. All rights reserved.
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

import javax.swing.*;
import javax.swing.event.*;
import java.awt.Color;

/**
 * A model that supports selecting a <code>Color</code>.
 *
 * @author Steve Wilson
 *
 * @see java.awt.Color
 */
public interface ColorSelectionModel {
    /**
     * Returns the selected <code>Color</code> which should be
     * non-<code>null</code>.
     *
     * @return  the selected <code>Color</code>
     * @see     #setSelectedColor
     */
    Color getSelectedColor();

    /**
     * Sets the selected color to <code>color</code>.
     * Note that setting the color to <code>null</code>
     * is undefined and may have unpredictable results.
     * This method fires a state changed event if it sets the
     * current color to a new non-<code>null</code> color.
     *
     * @param color the new <code>Color</code>
     * @see   #getSelectedColor
     * @see   #addChangeListener
     */
    void setSelectedColor(Color color);

    /**
     * Adds <code>listener</code> as a listener to changes in the model.
     * @param listener the <code>ChangeListener</code> to be added
     */
    void addChangeListener(ChangeListener listener);

    /**
     * Removes <code>listener</code> as a listener to changes in the model.
     * @param listener the <code>ChangeListener</code> to be removed
     */
    void removeChangeListener(ChangeListener listener);
}
