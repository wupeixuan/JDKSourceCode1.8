/*
 * Copyright (c) 1995, 2005, Oracle and/or its affiliates. All rights reserved.
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

/**
 * Defines the interface for classes that know how to lay out
 * <code>Container</code>s.
 * <p>
 * Swing's painting architecture assumes the children of a
 * <code>JComponent</code> do not overlap.  If a
 * <code>JComponent</code>'s <code>LayoutManager</code> allows
 * children to overlap, the <code>JComponent</code> must override
 * <code>isOptimizedDrawingEnabled</code> to return false.
 *
 * @see Container
 * @see javax.swing.JComponent#isOptimizedDrawingEnabled
 *
 * @author      Sami Shaio
 * @author      Arthur van Hoff
 */
public interface LayoutManager {
    /**
     * If the layout manager uses a per-component string,
     * adds the component <code>comp</code> to the layout,
     * associating it
     * with the string specified by <code>name</code>.
     *
     * @param name the string to be associated with the component
     * @param comp the component to be added
     */
    void addLayoutComponent(String name, Component comp);

    /**
     * Removes the specified component from the layout.
     * @param comp the component to be removed
     */
    void removeLayoutComponent(Component comp);

    /**
     * Calculates the preferred size dimensions for the specified
     * container, given the components it contains.
     * @param parent the container to be laid out
     *
     * @see #minimumLayoutSize
     */
    Dimension preferredLayoutSize(Container parent);

    /**
     * Calculates the minimum size dimensions for the specified
     * container, given the components it contains.
     * @param parent the component to be laid out
     * @see #preferredLayoutSize
     */
    Dimension minimumLayoutSize(Container parent);

    /**
     * Lays out the specified container.
     * @param parent the container to be laid out
     */
    void layoutContainer(Container parent);
}
