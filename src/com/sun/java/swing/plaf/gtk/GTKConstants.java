/*
 * Copyright (c) 2002, 2005, Oracle and/or its affiliates. All rights reserved.
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
package com.sun.java.swing.plaf.gtk;

/**
 * @author Scott Violet
 */
public interface GTKConstants {

    /**
     * Used to indicate a constant is not defined.
     */
    public static final int UNDEFINED = -100;

    /**
     * Java representation of native GtkIconSize enum
     */
    public enum IconSize {
        INVALID,
        MENU,
        SMALL_TOOLBAR,
        LARGE_TOOLBAR,
        BUTTON,
        DND,
        DIALOG
    }

    /**
     * Java representation of native GtkTextDirection enum
     */
    public enum TextDirection {
        NONE,
        LTR,
        RTL
    }

    /**
     * Java representation of native GtkShadowType enum
     */
    public enum ShadowType {
        NONE,
        IN,
        OUT,
        ETCHED_IN,
        ETCHED_OUT
    }

    /**
     * Java representation of native GtkStateType enum
     */
    public enum StateType {
        NORMAL,
        ACTIVE,
        PRELIGHT,
        SELECTED,
        INSENSITIVE
    }

    /**
     * Java representation of native GtkExpanderStyle enum
     */
    public enum ExpanderStyle {
        COLLAPSED,
        SEMI_COLLAPSED,
        SEMI_EXPANDED,
        EXPANDED,
    }

    /**
     * Java representation of native GtkPositionType enum
     */
    public enum PositionType {
        LEFT,
        RIGHT,
        TOP,
        BOTTOM
    }

    /**
     * Java representation of native GtkArrowType enum
     */
    public enum ArrowType {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }

    /**
     * Java representation of native GtkOrientation enum
     */
    public enum Orientation {
        HORIZONTAL,
        VERTICAL
    }
}
