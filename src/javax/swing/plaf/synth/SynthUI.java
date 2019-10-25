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

import java.awt.Graphics;
import javax.swing.JComponent;

/**
 * SynthUI is used to fetch the SynthContext for a particular Component.
 *
 * @author Scott Violet
 * @since 1.7
 */
public interface SynthUI extends SynthConstants {

    /**
     * Returns the Context for the specified component.
     *
     * @param c Component requesting SynthContext.
     * @return SynthContext describing component.
     */
    public SynthContext getContext(JComponent c);

    /**
     * Paints the border.
     *
     * @param context a component context
     * @param g {@code Graphics} to paint on
     * @param x the X coordinate
     * @param y the Y coordinate
     * @param w width of the border
     * @param h height of the border
     */
    public void paintBorder(SynthContext context, Graphics g, int x,
                            int y, int w, int h);
}
