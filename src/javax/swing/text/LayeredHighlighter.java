/*
 * Copyright (c) 1998, Oracle and/or its affiliates. All rights reserved.
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
package javax.swing.text;

import java.awt.Graphics;
import java.awt.Shape;

/**
 *
 * @author  Scott Violet
 * @author  Timothy Prinzing
 * @see     Highlighter
 */
public abstract class LayeredHighlighter implements Highlighter {
    /**
     * When leaf Views (such as LabelView) are rendering they should
     * call into this method. If a highlight is in the given region it will
     * be drawn immediately.
     *
     * @param g Graphics used to draw
     * @param p0 starting offset of view
     * @param p1 ending offset of view
     * @param viewBounds Bounds of View
     * @param editor JTextComponent
     * @param view View instance being rendered
     */
    public abstract void paintLayeredHighlights(Graphics g, int p0, int p1,
                                                Shape viewBounds,
                                                JTextComponent editor,
                                                View view);


    /**
     * Layered highlight renderer.
     */
    static public abstract class LayerPainter implements Highlighter.HighlightPainter {
        public abstract Shape paintLayer(Graphics g, int p0, int p1,
                                        Shape viewBounds,JTextComponent editor,
                                        View view);
    }
}
