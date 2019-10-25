/*
 * Copyright (c) 2005, Oracle and/or its affiliates. All rights reserved.
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
package javax.swing;

import java.awt.Component;
import java.awt.Container;
import java.awt.Rectangle;
import java.awt.event.PaintEvent;
import java.security.AccessController;
import sun.awt.AppContext;
import sun.awt.SunToolkit;
import sun.awt.event.IgnorePaintEvent;
import sun.security.action.GetBooleanAction;
import sun.security.action.GetPropertyAction;

/**
 * Swing's PaintEventDispatcher.  If the component specified by the PaintEvent
 * is a top level Swing component (JFrame, JWindow, JDialog, JApplet), this
 * will forward the request to the RepaintManager for eventual painting.
 *
 */
class SwingPaintEventDispatcher extends sun.awt.PaintEventDispatcher {
    private static final boolean SHOW_FROM_DOUBLE_BUFFER;
    private static final boolean ERASE_BACKGROUND;

    static {
        SHOW_FROM_DOUBLE_BUFFER = "true".equals(AccessController.doPrivileged(
              new GetPropertyAction("swing.showFromDoubleBuffer", "true")));
        ERASE_BACKGROUND = AccessController.doPrivileged(
                                 new GetBooleanAction("swing.nativeErase"));
    }

    public PaintEvent createPaintEvent(Component component, int x, int y,
                                         int w, int h) {
        if (component instanceof RootPaneContainer) {
            AppContext appContext = SunToolkit.targetToAppContext(component);
            RepaintManager rm = RepaintManager.currentManager(appContext);
            if (!SHOW_FROM_DOUBLE_BUFFER ||
                  !rm.show((Container)component, x, y, w, h)) {
                rm.nativeAddDirtyRegion(appContext, (Container)component,
                                        x, y, w, h);
            }
            // For backward compatibility generate an empty paint
            // event.  Not doing this broke parts of Netbeans.
            return new IgnorePaintEvent(component, PaintEvent.PAINT,
                                        new Rectangle(x, y, w, h));
        }
        else if (component instanceof SwingHeavyWeight) {
            AppContext appContext = SunToolkit.targetToAppContext(component);
            RepaintManager rm = RepaintManager.currentManager(appContext);
            rm.nativeAddDirtyRegion(appContext, (Container)component,
                                    x, y, w, h);
            return new IgnorePaintEvent(component, PaintEvent.PAINT,
                                        new Rectangle(x, y, w, h));
        }
        return super.createPaintEvent(component, x, y, w, h);
    }

    public boolean shouldDoNativeBackgroundErase(Component c) {
        return ERASE_BACKGROUND || !(c instanceof RootPaneContainer);
    }

    public boolean queueSurfaceDataReplacing(Component c, Runnable r) {
        if (c instanceof RootPaneContainer) {
            AppContext appContext = SunToolkit.targetToAppContext(c);
            RepaintManager.currentManager(appContext).
                    nativeQueueSurfaceDataRunnable(appContext, c, r);
            return true;
        }
        return super.queueSurfaceDataReplacing(c, r);
    }
}
