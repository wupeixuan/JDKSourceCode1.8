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

import java.util.EventListener;

/**
 * The listener interface for receiving hierarchy changed events.
 * The class that is interested in processing a hierarchy changed event
 * should implement this interface.
 * The listener object created from that class is then registered with a
 * Component using the Component's <code>addHierarchyListener</code>
 * method. When the hierarchy to which the Component belongs changes, the
 * <code>hierarchyChanged</code> method in the listener object is invoked,
 * and the <code>HierarchyEvent</code> is passed to it.
 * <p>
 * Hierarchy events are provided for notification purposes ONLY;
 * The AWT will automatically handle changes to the hierarchy internally so
 * that GUI layout, displayability, and visibility work properly regardless
 * of whether a program registers a <code>HierarchyListener</code> or not.
 *
 * @author      David Mendenhall
 * @see         HierarchyEvent
 * @since       1.3
 */
public interface HierarchyListener extends EventListener {
    /**
     * Called when the hierarchy has been changed. To discern the actual
     * type of change, call <code>HierarchyEvent.getChangeFlags()</code>.
     *
     * @see HierarchyEvent#getChangeFlags()
     */
    public void hierarchyChanged(HierarchyEvent e);
}
