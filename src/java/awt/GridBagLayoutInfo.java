/*
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
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
 * The {@code GridBagLayoutInfo} is an utility class for
 * {@code GridBagLayout} layout manager.
 * It stores align, size and baseline parameters for every component within a container.
 * <p>
 * @see       java.awt.GridBagLayout
 * @see       java.awt.GridBagConstraints
 * @since 1.6
 */
public class GridBagLayoutInfo implements java.io.Serializable {
    /*
     * serialVersionUID
     */
    private static final long serialVersionUID = -4899416460737170217L;

    int width, height;          /* number of  cells: horizontal and vertical */
    int startx, starty;         /* starting point for layout */
    int minWidth[];             /* largest minWidth in each column */
    int minHeight[];            /* largest minHeight in each row */
    double weightX[];           /* largest weight in each column */
    double weightY[];           /* largest weight in each row */
    boolean hasBaseline;        /* Whether or not baseline layout has been
                                 * requested and one of the components
                                 * has a valid baseline. */
    // These are only valid if hasBaseline is true and are indexed by
    // row.
    short baselineType[];       /* The type of baseline for a particular
                                 * row.  A mix of the BaselineResizeBehavior
                                 * constants (1 << ordinal()) */
    int maxAscent[];            /* Max ascent (baseline). */
    int maxDescent[];           /* Max descent (height - baseline) */

    /**
     * Creates an instance of GridBagLayoutInfo representing {@code GridBagLayout}
     * grid cells with it's own parameters.
     * @param width the columns
     * @param height the rows
     * @since 6.0
     */
    GridBagLayoutInfo(int width, int height) {
        this.width = width;
        this.height = height;
    }

    /**
     * Returns true if the specified row has any component aligned on the
     * baseline with a baseline resize behavior of CONSTANT_DESCENT.
     */
    boolean hasConstantDescent(int row) {
        return ((baselineType[row] & (1 << Component.BaselineResizeBehavior.
                                      CONSTANT_DESCENT.ordinal())) != 0);
    }

    /**
     * Returns true if there is a baseline for the specified row.
     */
    boolean hasBaseline(int row) {
        return (hasBaseline && baselineType[row] != 0);
    }
}
