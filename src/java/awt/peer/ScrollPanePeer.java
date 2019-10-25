/*
 * Copyright (c) 1996, 2007, Oracle and/or its affiliates. All rights reserved.
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
package java.awt.peer;

import java.awt.Adjustable;
import java.awt.ScrollPane;
import java.awt.ScrollPaneAdjustable;

/**
 * The peer interface for {@link ScrollPane}.
 *
 * The peer interfaces are intended only for use in porting
 * the AWT. They are not intended for use by application
 * developers, and developers should not implement peers
 * nor invoke any of the peer methods directly on the peer
 * instances.
 */
public interface ScrollPanePeer extends ContainerPeer {

    /**
     * Returns the height of the horizontal scroll bar.
     *
     * @return the height of the horizontal scroll bar
     *
     * @see ScrollPane#getHScrollbarHeight()
     */
    int getHScrollbarHeight();

    /**
     * Returns the width of the vertical scroll bar.
     *
     * @return the width of the vertical scroll bar
     *
     * @see ScrollPane#getVScrollbarWidth()
     */
    int getVScrollbarWidth();

    /**
     * Sets the scroll position of the child.
     *
     * @param x the X coordinate of the scroll position
     * @param y the Y coordinate of the scroll position
     *
     * @see ScrollPane#setScrollPosition(int, int)
     */
    void setScrollPosition(int x, int y);

    /**
     * Called when the child component changes its size.
     *
     * @param w the new width of the child component
     * @param h the new height of the child component
     *
     * @see ScrollPane#layout()
     */
    void childResized(int w, int h);

    /**
     * Sets the unit increment of one of the scroll pane's adjustables.
     *
     * @param adj the scroll pane adjustable object
     * @param u the unit increment
     *
     * @see ScrollPaneAdjustable#setUnitIncrement(int)
     */
    void setUnitIncrement(Adjustable adj, int u);

    /**
     * Sets the value for one of the scroll pane's adjustables.
     *
     * @param adj the scroll pane adjustable object
     * @param v the value to set
     */
    void setValue(Adjustable adj, int v);
}
