/*
 * Copyright (c) 1995, 1998, Oracle and/or its affiliates. All rights reserved.
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

import java.awt.Scrollbar;

/**
 * The peer interface for {@link Scrollbar}.
 *
 * The peer interfaces are intended only for use in porting
 * the AWT. They are not intended for use by application
 * developers, and developers should not implement peers
 * nor invoke any of the peer methods directly on the peer
 * instances.
 */
public interface ScrollbarPeer extends ComponentPeer {

    /**
     * Sets the parameters for the scrollbar.
     *
     * @param value the current value
     * @param visible how much of the whole scale is visible
     * @param minimum the minimum value
     * @param maximum the maximum value
     *
     * @see Scrollbar#setValues(int, int, int, int)
     */
    void setValues(int value, int visible, int minimum, int maximum);

    /**
     * Sets the line increment of the scrollbar.
     *
     * @param l the line increment
     *
     * @see Scrollbar#setLineIncrement(int)
     */
    void setLineIncrement(int l);

    /**
     * Sets the page increment of the scrollbar.
     *
     * @param l the page increment
     *
     * @see Scrollbar#setPageIncrement(int)
     */
    void setPageIncrement(int l);
}
