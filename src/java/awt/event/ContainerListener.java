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
 * The listener interface for receiving container events.
 * The class that is interested in processing a container event
 * either implements this interface (and all the methods it
 * contains) or extends the abstract <code>ContainerAdapter</code> class
 * (overriding only the methods of interest).
 * The listener object created from that class is then registered with a
 * component using the component's <code>addContainerListener</code>
 * method. When the container's contents change because a component
 * has been added or removed, the relevant method in the listener object
 * is invoked, and the <code>ContainerEvent</code> is passed to it.
 * <P>
 * Container events are provided for notification purposes ONLY;
 * The AWT will automatically handle add and remove operations
 * internally so the program works properly regardless of
 * whether the program registers a {@code ContainerListener} or not.
 *
 * @see ContainerAdapter
 * @see ContainerEvent
 * @see <a href="https://docs.oracle.com/javase/tutorial/uiswing/events/containerlistener.html">Tutorial: Writing a Container Listener</a>
 *
 * @author Tim Prinzing
 * @author Amy Fowler
 * @since 1.1
 */
public interface ContainerListener extends EventListener {
    /**
     * Invoked when a component has been added to the container.
     */
    public void componentAdded(ContainerEvent e);

    /**
     * Invoked when a component has been removed from the container.
     */
    public void componentRemoved(ContainerEvent e);

}
