/*
 * Copyright (c) 2000, 2007, Oracle and/or its affiliates. All rights reserved.
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

package java.awt;

import sun.awt.AppContext;
import sun.awt.SunToolkit;

/**
 * A wrapping tag for a nested AWTEvent which indicates that the event was
 * sent from another AppContext. The destination AppContext should handle the
 * event even if it is currently blocked waiting for a SequencedEvent or
 * another SentEvent to be handled.
 *
 * @author David Mendenhall
 */
class SentEvent extends AWTEvent implements ActiveEvent {
    /*
     * serialVersionUID
     */
    private static final long serialVersionUID = -383615247028828931L;

    static final int ID =
        java.awt.event.FocusEvent.FOCUS_LAST + 2;

    boolean dispatched;
    private AWTEvent nested;
    private AppContext toNotify;

    SentEvent() {
        this(null);
    }
    SentEvent(AWTEvent nested) {
        this(nested, null);
    }
    SentEvent(AWTEvent nested, AppContext toNotify) {
        super((nested != null)
                  ? nested.getSource()
                  : Toolkit.getDefaultToolkit(),
              ID);
        this.nested = nested;
        this.toNotify = toNotify;
    }

    public void dispatch() {
        try {
            if (nested != null) {
                Toolkit.getEventQueue().dispatchEvent(nested);
            }
        } finally {
            dispatched = true;
            if (toNotify != null) {
                SunToolkit.postEvent(toNotify, new SentEvent());
            }
            synchronized (this) {
                notifyAll();
            }
        }
    }
    final void dispose() {
        dispatched = true;
        if (toNotify != null) {
            SunToolkit.postEvent(toNotify, new SentEvent());
        }
        synchronized (this) {
            notifyAll();
        }
    }
}
