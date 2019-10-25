/*
 * Copyright (c) 2005, 2007, Oracle and/or its affiliates. All rights reserved.
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

import java.awt.Dimension;
import java.awt.SystemTray;

/**
 * The peer interface for {@link SystemTray}. This doesn't need to be
 * implemented if {@link SystemTray#isSupported()} returns false.
 */
public interface SystemTrayPeer {

    /**
     * Returns the size of the system tray icon.
     *
     * @return the size of the system tray icon
     *
     * @see SystemTray#getTrayIconSize()
     */
    Dimension getTrayIconSize();
}
