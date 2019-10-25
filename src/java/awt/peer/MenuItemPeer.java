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

import java.awt.MenuItem;

/**
 * The peer interface for menu items. This is used by {@link MenuItem}.
 *
 * The peer interfaces are intended only for use in porting
 * the AWT. They are not intended for use by application
 * developers, and developers should not implement peers
 * nor invoke any of the peer methods directly on the peer
 * instances.
 */
public interface MenuItemPeer extends MenuComponentPeer {

    /**
     * Sets the label to be displayed in this menu item.
     *
     * @param label the label to be displayed
     */
    void setLabel(String label);

    /**
     * Enables or disables the menu item.
     *
     * @param e {@code true} to enable the menu item, {@code false}
     *        to disable it
     */
    void setEnabled(boolean e);

}
