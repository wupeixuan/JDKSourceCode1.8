/*
 * Copyright (c) 1999, Oracle and/or its affiliates. All rights reserved.
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
 * An abstract adapter class for receiving ancestor moved and resized events.
 * The methods in this class are empty. This class exists as a
 * convenience for creating listener objects.
 * <p>
 * Extend this class and override the method for the event of interest. (If
 * you implement the <code>HierarchyBoundsListener</code> interface, you have
 * to define both methods in it. This abstract class defines null methods for
 * them both, so you only have to define the method for the event you care
 * about.)
 * <p>
 * Create a listener object using your class and then register it with a
 * Component using the Component's <code>addHierarchyBoundsListener</code>
 * method. When the hierarchy to which the Component belongs changes by
 * resize or movement of an ancestor, the relevant method in the listener
 * object is invoked, and the <code>HierarchyEvent</code> is passed to it.
 *
 * @author      David Mendenhall
 * @see         HierarchyBoundsListener
 * @see         HierarchyEvent
 * @since       1.3
 */
public abstract class HierarchyBoundsAdapter implements HierarchyBoundsListener
{
    /**
     * Called when an ancestor of the source is moved.
     */
    public void ancestorMoved(HierarchyEvent e) {}

    /**
     * Called when an ancestor of the source is resized.
     */
    public void ancestorResized(HierarchyEvent e) {}
}
