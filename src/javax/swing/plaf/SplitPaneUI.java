/*
 * Copyright (c) 1997, 1998, Oracle and/or its affiliates. All rights reserved.
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

import javax.swing.JSplitPane;
import java.awt.Graphics;

/**
 * Pluggable look and feel interface for JSplitPane.
 *
 * @author Scott Violet
 */
public abstract class SplitPaneUI extends ComponentUI
{
    /**
     * Messaged to relayout the JSplitPane based on the preferred size
     * of the children components.
     */
    public abstract void resetToPreferredSizes(JSplitPane jc);

    /**
     * Sets the location of the divider to location.
     */
    public abstract void setDividerLocation(JSplitPane jc, int location);

    /**
     * Returns the location of the divider.
     */
    public abstract int getDividerLocation(JSplitPane jc);

    /**
     * Returns the minimum possible location of the divider.
     */
    public abstract int getMinimumDividerLocation(JSplitPane jc);

    /**
     * Returns the maximum possible location of the divider.
     */
    public abstract int getMaximumDividerLocation(JSplitPane jc);

    /**
     * Messaged after the JSplitPane the receiver is providing the look
     * and feel for paints its children.
     */
    public abstract void finishedPaintingChildren(JSplitPane jc, Graphics g);
}
