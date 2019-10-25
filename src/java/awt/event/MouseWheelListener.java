/*
 * Copyright (c) 2000, 2003, Oracle and/or its affiliates. All rights reserved.
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

package java.awt.event;

import java.util.EventListener;

/**
 * The listener interface for receiving mouse wheel events on a component.
 * (For clicks and other mouse events, use the <code>MouseListener</code>.
 * For mouse movement and drags, use the <code>MouseMotionListener</code>.)
 * <P>
 * The class that is interested in processing a mouse wheel event
 * implements this interface (and all the methods it contains).
 * <P>
 * The listener object created from that class is then registered with a
 * component using the component's <code>addMouseWheelListener</code>
 * method. A mouse wheel event is generated when the mouse wheel is rotated.
 * When a mouse wheel event occurs, that object's <code>mouseWheelMoved</code>
 * method is invoked.
 * <p>
 * For information on how mouse wheel events are dispatched, see
 * the class description for {@link MouseWheelEvent}.
 *
 * @author Brent Christian
 * @see MouseWheelEvent
 * @since 1.4
 */
public interface MouseWheelListener extends EventListener {

    /**
     * Invoked when the mouse wheel is rotated.
     * @see MouseWheelEvent
     */
    public void mouseWheelMoved(MouseWheelEvent e);
}
