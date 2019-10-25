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

package java.awt;

import sun.security.util.SecurityConstants;
/**
 * <code>MouseInfo</code>  provides methods for getting information about the mouse,
 * such as mouse pointer location and the number of mouse buttons.
 *
 * @author     Roman Poborchiy
 * @since 1.5
 */

public class MouseInfo {

    /**
     * Private constructor to prevent instantiation.
     */
    private MouseInfo() {
    }

    /**
     * Returns a <code>PointerInfo</code> instance that represents the current
     * location of the mouse pointer.
     * The <code>GraphicsDevice</code> stored in this <code>PointerInfo</code>
     * contains the mouse pointer. The coordinate system used for the mouse position
     * depends on whether or not the <code>GraphicsDevice</code> is part of a virtual
     * screen device.
     * For virtual screen devices, the coordinates are given in the virtual
     * coordinate system, otherwise they are returned in the coordinate system
     * of the <code>GraphicsDevice</code>. See {@link GraphicsConfiguration}
     * for more information about the virtual screen devices.
     * On systems without a mouse, returns <code>null</code>.
     * <p>
     * If there is a security manager, its <code>checkPermission</code> method
     * is called with an <code>AWTPermission("watchMousePointer")</code>
     * permission before creating and returning a <code>PointerInfo</code>
     * object. This may result in a <code>SecurityException</code>.
     *
     * @exception HeadlessException if GraphicsEnvironment.isHeadless() returns true
     * @exception SecurityException if a security manager exists and its
     *            <code>checkPermission</code> method doesn't allow the operation
     * @see       GraphicsConfiguration
     * @see       SecurityManager#checkPermission
     * @see       java.awt.AWTPermission
     * @return    location of the mouse pointer
     * @since     1.5
     */
    public static PointerInfo getPointerInfo() throws HeadlessException {
        if (GraphicsEnvironment.isHeadless()) {
            throw new HeadlessException();
        }

        SecurityManager security = System.getSecurityManager();
        if (security != null) {
            security.checkPermission(SecurityConstants.AWT.WATCH_MOUSE_PERMISSION);
        }

        Point point = new Point(0, 0);
        int deviceNum = Toolkit.getDefaultToolkit().getMouseInfoPeer().fillPointWithCoords(point);
        GraphicsDevice[] gds = GraphicsEnvironment.getLocalGraphicsEnvironment().
                                   getScreenDevices();
        PointerInfo retval = null;
        if (areScreenDevicesIndependent(gds)) {
            retval = new PointerInfo(gds[deviceNum], point);
        } else {
            for (int i = 0; i < gds.length; i++) {
                GraphicsConfiguration gc = gds[i].getDefaultConfiguration();
                Rectangle bounds = gc.getBounds();
                if (bounds.contains(point)) {
                    retval = new PointerInfo(gds[i], point);
                }
            }
        }

        return retval;
    }

    private static boolean areScreenDevicesIndependent(GraphicsDevice[] gds) {
        for (int i = 0; i < gds.length; i++) {
            Rectangle bounds = gds[i].getDefaultConfiguration().getBounds();
            if (bounds.x != 0 || bounds.y != 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns the number of buttons on the mouse.
     * On systems without a mouse, returns <code>-1</code>.
     *
     * @exception HeadlessException if GraphicsEnvironment.isHeadless() returns true
     * @return number of buttons on the mouse
     * @since 1.5
     */
    public static int getNumberOfButtons() throws HeadlessException {
        if (GraphicsEnvironment.isHeadless()) {
            throw new HeadlessException();
        }
        Object prop = Toolkit.getDefaultToolkit().
                              getDesktopProperty("awt.mouse.numButtons");
        if (prop instanceof Integer) {
            return ((Integer)prop).intValue();
        }

        // This should never happen.
        assert false : "awt.mouse.numButtons is not an integer property";
        return 0;
    }

}
