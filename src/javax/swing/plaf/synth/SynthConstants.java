/*
 * Copyright (c) 2002, 2003, Oracle and/or its affiliates. All rights reserved.
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
package javax.swing.plaf.synth;

import javax.swing.*;

/**
 * Constants used by Synth. Not all Components support all states. A
 * Component will at least be in one of the primary states. That is, the
 * return value from <code>SynthContext.getComponentState()</code> will at
 * least be one of <code>ENABLED</code>, <code>MOUSE_OVER</code>,
 * <code>PRESSED</code> or <code>DISABLED</code>, and may also contain
 * <code>FOCUSED</code>, <code>SELECTED</code> or <code>DEFAULT</code>.
 *
 * @since 1.5
 */
public interface SynthConstants {
    /**
     * Primary state indicating the component is enabled.
     */
    public static final int ENABLED = 1 << 0;
    /**
     * Primary state indicating the mouse is over the region.
     */
    public static final int MOUSE_OVER = 1 << 1;
    /**
     * Primary state indicating the region is in a pressed state. Pressed
     * does not necessarily mean the user has pressed the mouse button.
     */
    public static final int PRESSED = 1 << 2;
    /**
     * Primary state indicating the region is not enabled.
     */
    public static final int DISABLED = 1 << 3;

    /**
     * Indicates the region has focus.
     */
    public static final int FOCUSED = 1 << 8;
    /**
     * Indicates the region is selected.
     */
    public static final int SELECTED = 1 << 9;
    /**
     * Indicates the region is the default. This is typically used for buttons
     * to indicate this button is somehow special.
     */
    public static final int DEFAULT = 1 << 10;
}
