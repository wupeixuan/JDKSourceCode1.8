/*
 * Copyright (c) 2001, 2009, Oracle and/or its affiliates. All rights reserved.
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
package javax.swing.plaf.metal;

import java.awt.*;

/**
 * DesktopProperty that only uses font height in configuring font. This
 * is only used on Windows.
 *
 */
class MetalFontDesktopProperty extends com.sun.java.swing.plaf.windows.DesktopProperty {
    /**
     * Maps from metal font theme type as defined in MetalTheme
     * to the corresponding desktop property name.
     */
    private static final String[] propertyMapping = {
        "win.ansiVar.font.height",
        "win.tooltip.font.height",
        "win.ansiVar.font.height",
        "win.menu.font.height",
        "win.frame.captionFont.height",
        "win.menu.font.height"
    };

    /**
     * Corresponds to a MetalTheme font type.
     */
    private int type;


    /**
     * Creates a MetalFontDesktopProperty. The key used to lookup the
     * desktop property is determined from the type of font.
     *
     * @param type MetalTheme font type.
     */
    MetalFontDesktopProperty(int type) {
        this(propertyMapping[type], type);
    }

    /**
     * Creates a MetalFontDesktopProperty.
     *
     * @param key Key used in looking up desktop value.
     * @param toolkit Toolkit used to fetch property from, can be null
     *        in which default will be used.
     * @param type Type of font being used, corresponds to MetalTheme font
     *        type.
     */
    MetalFontDesktopProperty(String key, int type) {
        super(key, null);
        this.type = type;
    }

    /**
     * Overriden to create a Font with the size coming from the desktop
     * and the style and name coming from DefaultMetalTheme.
     */
    protected Object configureValue(Object value) {
        if (value instanceof Integer) {
            value = new Font(DefaultMetalTheme.getDefaultFontName(type),
                             DefaultMetalTheme.getDefaultFontStyle(type),
                             ((Integer)value).intValue());
        }
        return super.configureValue(value);
    }

    /**
     * Returns the default font.
     */
    protected Object getDefaultValue() {
        return new Font(DefaultMetalTheme.getDefaultFontName(type),
                        DefaultMetalTheme.getDefaultFontStyle(type),
                        DefaultMetalTheme.getDefaultFontSize(type));
    }
}
