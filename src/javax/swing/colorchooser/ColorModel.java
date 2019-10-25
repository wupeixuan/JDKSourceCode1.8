/*
 * Copyright (c) 2008, Oracle and/or its affiliates. All rights reserved.
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

package javax.swing.colorchooser;

import java.awt.Component;
import javax.swing.UIManager;

class ColorModel {

    private final String prefix;
    private final String[] labels;

    ColorModel(String name, String... labels) {
        this.prefix = "ColorChooser." + name; // NON-NLS: default prefix
        this.labels = labels;
    }

    ColorModel() {
        this("rgb", "Red", "Green", "Blue", "Alpha"); // NON-NLS: components
    }

    void setColor(int color, float[] model) {
        model[0] = normalize(color >> 16);
        model[1] = normalize(color >> 8);
        model[2] = normalize(color);
        model[3] = normalize(color >> 24);
    }

    int getColor(float[] model) {
        return to8bit(model[2]) | (to8bit(model[1]) << 8) | (to8bit(model[0]) << 16) | (to8bit(model[3]) << 24);
    }

    int getCount() {
        return this.labels.length;
    }

    int getMinimum(int index) {
        return 0;
    }

    int getMaximum(int index) {
        return 255;
    }

    float getDefault(int index) {
        return 0.0f;
    }

    final String getLabel(Component component, int index) {
        return getText(component, this.labels[index]);
    }

    private static float normalize(int value) {
        return (float) (value & 0xFF) / 255.0f;
    }

    private static int to8bit(float value) {
        return (int) (255.0f * value);
    }

    final String getText(Component component, String suffix) {
        return UIManager.getString(this.prefix + suffix + "Text", component.getLocale()); // NON-NLS: default postfix
    }

    final int getInteger(Component component, String suffix) {
        Object value = UIManager.get(this.prefix + suffix, component.getLocale());
        if (value instanceof Integer) {
            return (Integer) value;
        }
        if (value instanceof String) {
            try {
                return Integer.parseInt((String) value);
            }
            catch (NumberFormatException exception) {
            }
        }
        return -1;
    }
}
