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

package java.awt.event;

import java.util.EventListener;

/**
 * The listener interface for receiving action events.
 * The class that is interested in processing an action event
 * implements this interface, and the object created with that
 * class is registered with a component, using the component's
 * <code>addActionListener</code> method. When the action event
 * occurs, that object's <code>actionPerformed</code> method is
 * invoked.
 *
 * @see ActionEvent
 * @see <a href="https://docs.oracle.com/javase/tutorial/uiswing/events/actionlistener.html">How to Write an Action Listener</a>
 *
 * @author Carl Quinn
 * @since 1.1
 */
public interface ActionListener extends EventListener {

    /**
     * Invoked when an action occurs.
     */
    public void actionPerformed(ActionEvent e);

}
