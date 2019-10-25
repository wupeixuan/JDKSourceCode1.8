/*
 * Copyright (c) 2001, 2007, Oracle and/or its affiliates. All rights reserved.
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

import java.util.EventListenerProxy;
import java.awt.AWTEvent;

/**
 * A class which extends the {@code EventListenerProxy}
 * specifically for adding an {@code AWTEventListener}
 * for a specific event mask.
 * Instances of this class can be added as {@code AWTEventListener}s
 * to a {@code Toolkit} object.
 * <p>
 * The {@code getAWTEventListeners} method of {@code Toolkit}
 * can return a mixture of {@code AWTEventListener}
 * and {@code AWTEventListenerProxy} objects.
 *
 * @see java.awt.Toolkit
 * @see java.util.EventListenerProxy
 * @since 1.4
 */
public class AWTEventListenerProxy
        extends EventListenerProxy<AWTEventListener>
        implements AWTEventListener {

    private final long eventMask;

    /**
     * Constructor which binds the {@code AWTEventListener}
     * to a specific event mask.
     *
     * @param eventMask  the bitmap of event types to receive
     * @param listener   the listener object
     */
    public AWTEventListenerProxy (long eventMask, AWTEventListener listener) {
        super(listener);
        this.eventMask = eventMask;
    }

    /**
     * Forwards the AWT event to the listener delegate.
     *
     * @param event  the AWT event
     */
    public void eventDispatched(AWTEvent event) {
        getListener().eventDispatched(event);
    }

    /**
     * Returns the event mask associated with the listener.
     *
     * @return the event mask associated with the listener
     */
    public long getEventMask() {
        return this.eventMask;
    }
}
