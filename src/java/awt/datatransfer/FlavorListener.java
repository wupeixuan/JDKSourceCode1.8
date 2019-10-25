/*
 * Copyright (c) 2003, Oracle and/or its affiliates. All rights reserved.
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
package java.awt.datatransfer;

import java.util.EventListener;


/**
 * Defines an object which listens for {@link FlavorEvent}s.
 *
 * @author Alexander Gerasimov
 * @since 1.5
 */
public interface FlavorListener extends EventListener {
    /**
     * Invoked when the target {@link Clipboard} of the listener
     * has changed its available {@link DataFlavor}s.
     * <p>
     * Some notifications may be redundant &#151; they are not
     * caused by a change of the set of DataFlavors available
     * on the clipboard.
     * For example, if the clipboard subsystem supposes that
     * the system clipboard's contents has been changed but it
     * can't ascertain whether its DataFlavors have been changed
     * because of some exceptional condition when accessing the
     * clipboard, the notification is sent to ensure from omitting
     * a significant notification. Ordinarily, those redundant
     * notifications should be occasional.
     *
     * @param e  a <code>FlavorEvent</code> object
     */
    void flavorsChanged(FlavorEvent e);
}
