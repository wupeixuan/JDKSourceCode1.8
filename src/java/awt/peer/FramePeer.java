/*
 * Copyright (c) 1995, 2013, Oracle and/or its affiliates. All rights reserved.
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

import java.awt.*;

import sun.awt.EmbeddedFrame;

/**
 * The peer interface for {@link Frame}. This adds a couple of frame specific
 * methods to the {@link WindowPeer} interface.
 *
 * The peer interfaces are intended only for use in porting
 * the AWT. They are not intended for use by application
 * developers, and developers should not implement peers
 * nor invoke any of the peer methods directly on the peer
 * instances.
 */
public interface FramePeer extends WindowPeer {

    /**
     * Sets the title on the frame.
     *
     * @param title the title to set
     *
     * @see Frame#setTitle(String)
     */
    void setTitle(String title);

    /**
     * Sets the menu bar for the frame.
     *
     * @param mb the menu bar to set
     *
     * @see Frame#setMenuBar(MenuBar)
     */
    void setMenuBar(MenuBar mb);

    /**
     * Sets if the frame should be resizable or not.
     *
     * @param resizeable {@code true} when the frame should be resizable,
     *        {@code false} if not
     *
     * @see Frame#setResizable(boolean)
     */
    void setResizable(boolean resizeable);

    /**
     * Changes the state of the frame.
     *
     * @param state the new state
     *
     * @see Frame#setExtendedState(int)
     */
    void setState(int state);

    /**
     * Returns the current state of the frame.
     *
     * @return the current state of the frame
     *
     * @see Frame#getExtendedState()
     */
    int getState();

    /**
     * Sets the bounds of the frame when it becomes maximized.
     *
     * @param bounds the maximized bounds of the frame
     *
     * @see Frame#setMaximizedBounds(Rectangle)
     */
    void setMaximizedBounds(Rectangle bounds);

    /**
     * Sets the size and location for embedded frames. (On embedded frames,
     * setLocation() and setBounds() always set the frame to (0,0) for
     * backwards compatibility.
     *
     * @param x the X location
     * @param y the Y location
     * @param width the width of the frame
     * @param height the height of the frame
     *
     * @see EmbeddedFrame#setBoundsPrivate(int, int, int, int)
     */
    // TODO: This is only used in EmbeddedFrame, and should probably be moved
    // into an EmbeddedFramePeer which would extend FramePeer
    void setBoundsPrivate(int x, int y, int width, int height);

    /**
     * Returns the size and location for embedded frames. (On embedded frames,
     * setLocation() and setBounds() always set the frame to (0,0) for
     * backwards compatibility.
     *
     * @return the bounds of an embedded frame
     *
     * @see EmbeddedFrame#getBoundsPrivate()
     */
    // TODO: This is only used in EmbeddedFrame, and should probably be moved
    // into an EmbeddedFramePeer which would extend FramePeer
    Rectangle getBoundsPrivate();

    /**
     * Requests the peer to emulate window activation.
     *
     * @param activate activate or deactivate the window
     */
    void emulateActivation(boolean activate);
}
