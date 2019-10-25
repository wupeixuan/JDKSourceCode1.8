/*
 * Copyright (c) 1995, 2014, Oracle and/or its affiliates. All rights reserved.
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

import java.awt.CheckboxMenuItem;

/**
 * The peer interface for {@link CheckboxMenuItem}.
 *
 * The peer interfaces are intended only for use in porting
 * the AWT. They are not intended for use by application
 * developers, and developers should not implement peers
 * nor invoke any of the peer methods directly on the peer
 * instances.
 */
public interface CheckboxMenuItemPeer extends MenuItemPeer {

    /**
     * Sets the state of the checkbox to be checked {@code true} or
     * unchecked {@code false}.
     *
     * @param state the state to set on the checkbox
     *
     * @see CheckboxMenuItem#setState(boolean)
     */
    void setState(boolean state);
}
