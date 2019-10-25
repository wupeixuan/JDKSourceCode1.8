/*
 * Copyright (c) 1996, 2013, Oracle and/or its affiliates. All rights reserved.
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

package java.awt;

import java.awt.event.*;

import java.lang.annotation.Native;

/**
 * The interface for objects which have an adjustable numeric value
 * contained within a bounded range of values.
 *
 * @author Amy Fowler
 * @author Tim Prinzing
 */
public interface Adjustable {

    /**
     * Indicates that the <code>Adjustable</code> has horizontal orientation.
     */
    @Native public static final int HORIZONTAL = 0;

    /**
     * Indicates that the <code>Adjustable</code> has vertical orientation.
     */
    @Native public static final int VERTICAL = 1;

    /**
     * Indicates that the <code>Adjustable</code> has no orientation.
     */
    @Native public static final int NO_ORIENTATION = 2;

    /**
     * Gets the orientation of the adjustable object.
     * @return the orientation of the adjustable object;
     *   either <code>HORIZONTAL</code>, <code>VERTICAL</code>,
     *   or <code>NO_ORIENTATION</code>
     */
    int getOrientation();

    /**
     * Sets the minimum value of the adjustable object.
     * @param min the minimum value
     */
    void setMinimum(int min);

    /**
     * Gets the minimum value of the adjustable object.
     * @return the minimum value of the adjustable object
     */
    int getMinimum();

    /**
     * Sets the maximum value of the adjustable object.
     * @param max the maximum value
     */
    void setMaximum(int max);

    /**
     * Gets the maximum value of the adjustable object.
     * @return the maximum value of the adjustable object
     */
    int getMaximum();

    /**
     * Sets the unit value increment for the adjustable object.
     * @param u the unit increment
     */
    void setUnitIncrement(int u);

    /**
     * Gets the unit value increment for the adjustable object.
     * @return the unit value increment for the adjustable object
     */
    int getUnitIncrement();

    /**
     * Sets the block value increment for the adjustable object.
     * @param b the block increment
     */
    void setBlockIncrement(int b);

    /**
     * Gets the block value increment for the adjustable object.
     * @return the block value increment for the adjustable object
     */
    int getBlockIncrement();

    /**
     * Sets the length of the proportional indicator of the
     * adjustable object.
     * @param v the length of the indicator
     */
    void setVisibleAmount(int v);

    /**
     * Gets the length of the proportional indicator.
     * @return the length of the proportional indicator
     */
    int getVisibleAmount();

    /**
     * Sets the current value of the adjustable object. If
     * the value supplied is less than <code>minimum</code>
     * or greater than <code>maximum</code> - <code>visibleAmount</code>,
     * then one of those values is substituted, as appropriate.
     * <p>
     * Calling this method does not fire an
     * <code>AdjustmentEvent</code>.
     *
     * @param v the current value, between <code>minimum</code>
     *    and <code>maximum</code> - <code>visibleAmount</code>
     */
    void setValue(int v);

    /**
     * Gets the current value of the adjustable object.
     * @return the current value of the adjustable object
     */
    int getValue();

    /**
     * Adds a listener to receive adjustment events when the value of
     * the adjustable object changes.
     * @param l the listener to receive events
     * @see AdjustmentEvent
     */
    void addAdjustmentListener(AdjustmentListener l);

    /**
     * Removes an adjustment listener.
     * @param l the listener being removed
     * @see AdjustmentEvent
     */
    void removeAdjustmentListener(AdjustmentListener l);

}
