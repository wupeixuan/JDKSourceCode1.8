/*
 * Copyright (c) 1995, 2007, Oracle and/or its affiliates. All rights reserved.
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

import java.awt.*;

/**
 * The peer interface for {@link Dialog}. This adds a couple of dialog specific
 * features to the {@link WindowPeer} interface.
 *
 * The peer interfaces are intended only for use in porting
 * the AWT. They are not intended for use by application
 * developers, and developers should not implement peers
 * nor invoke any of the peer methods directly on the peer
 * instances.
 */
public interface DialogPeer extends WindowPeer {

    /**
     * Sets the title on the dialog window.
     *
     * @param title the title to set
     *
     * @see Dialog#setTitle(String)
     */
    void setTitle(String title);

    /**
     * Sets if the dialog should be resizable or not.
     *
     * @param resizeable {@code true} when the dialog should be resizable,
     *        {@code false} if not
     *
     * @see Dialog#setResizable(boolean)
     */
    void setResizable(boolean resizeable);

    /**
     * Block the specified windows. This is used for modal dialogs.
     *
     * @param windows the windows to block
     *
     * @see Dialog#modalShow()
     * @see Dialog#blockWindows()
     */
    void blockWindows(java.util.List<Window> windows);
}
