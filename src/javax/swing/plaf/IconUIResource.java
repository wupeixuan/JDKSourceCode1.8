/*
 * Copyright (c) 1997, 2013, Oracle and/or its affiliates. All rights reserved.
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

package javax.swing.plaf;

import java.awt.Component;
import java.awt.Graphics;
import java.io.Serializable;
import javax.swing.Icon;
import javax.swing.plaf.UIResource;

/**
 * An Icon wrapper class which implements UIResource.  UI
 * classes which set icon properties should use this class
 * to wrap any icons specified as defaults.
 *
 * This class delegates all method invocations to the
 * Icon "delegate" object specified at construction.
 * <p>
 * <strong>Warning:</strong>
 * Serialized objects of this class will not be compatible with
 * future Swing releases. The current serialization support is
 * appropriate for short term storage or RMI between applications running
 * the same version of Swing.  As of 1.4, support for long term storage
 * of all JavaBeans&trade;
 * has been added to the <code>java.beans</code> package.
 * Please see {@link java.beans.XMLEncoder}.
 *
 * @see javax.swing.plaf.UIResource
 * @author Amy Fowler
 *
 */
public class IconUIResource implements Icon, UIResource, Serializable
{
    private Icon delegate;

    /**
     * Creates a UIResource icon object which wraps
     * an existing Icon instance.
     * @param delegate the icon being wrapped
     */
    public IconUIResource(Icon delegate) {
        if (delegate == null) {
            throw new IllegalArgumentException("null delegate icon argument");
        }
        this.delegate = delegate;
    }

    public void paintIcon(Component c, Graphics g, int x, int y) {
        delegate.paintIcon(c, g, x, y);
    }

    public int getIconWidth() {
        return delegate.getIconWidth();
    }

    public int getIconHeight() {
        return delegate.getIconHeight();
    }

}
