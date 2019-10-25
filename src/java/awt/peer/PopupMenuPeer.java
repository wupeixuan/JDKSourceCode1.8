/*
 * Copyright (c) 1996, 1998, Oracle and/or its affiliates. All rights reserved.
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

import java.awt.Event;
import java.awt.PopupMenu;

/**
 * The peer interface for {@link PopupMenu}.
 *
 * The peer interfaces are intended only for use in porting
 * the AWT. They are not intended for use by application
 * developers, and developers should not implement peers
 * nor invoke any of the peer methods directly on the peer
 * instances.
 */
public interface PopupMenuPeer extends MenuPeer {

    /**
     * Shows the popup menu.
     *
     * @param e a synthetic event describing the origin and location of the
     *        popup menu
     *
     * @see PopupMenu#show(java.awt.Component, int, int)
     */
    void show(Event e);
}
