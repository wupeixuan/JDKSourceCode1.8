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

/**
 * An abstract adapter class for receiving component events.
 * The methods in this class are empty. This class exists as
 * convenience for creating listener objects.
 * <P>
 * Extend this class to create a <code>ComponentEvent</code> listener
 * and override the methods for the events of interest. (If you implement the
 * <code>ComponentListener</code> interface, you have to define all of
 * the methods in it. This abstract class defines null methods for them
 * all, so you can only have to define methods for events you care about.)
 * <P>
 * Create a listener object using your class and then register it with a
 * component using the component's <code>addComponentListener</code>
 * method. When the component's size, location, or visibility
 * changes, the relevant method in the listener object is invoked,
 * and the <code>ComponentEvent</code> is passed to it.
 *
 * @see ComponentEvent
 * @see ComponentListener
 * @see <a href="https://docs.oracle.com/javase/tutorial/uiswing/events/componentlistener.html">Tutorial: Writing a Component Listener</a>
 *
 * @author Carl Quinn
 * @since 1.1
 */
public abstract class ComponentAdapter implements ComponentListener {
    /**
     * Invoked when the component's size changes.
     */
    public void componentResized(ComponentEvent e) {}

    /**
     * Invoked when the component's position changes.
     */
    public void componentMoved(ComponentEvent e) {}

    /**
     * Invoked when the component has been made visible.
     */
    public void componentShown(ComponentEvent e) {}

    /**
     * Invoked when the component has been made invisible.
     */
    public void componentHidden(ComponentEvent e) {}
}
