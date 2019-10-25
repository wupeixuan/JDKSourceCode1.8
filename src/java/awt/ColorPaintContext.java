/*
 * Copyright (c) 1997, 2007, Oracle and/or its affiliates. All rights reserved.
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

import java.awt.image.ColorModel;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;
import sun.awt.image.IntegerComponentRaster;
import java.util.Arrays;

class ColorPaintContext implements PaintContext {
    int color;
    WritableRaster savedTile;

    protected ColorPaintContext(int color, ColorModel cm) {
        this.color = color;
    }

    public void dispose() {
    }

    /*
     * Returns the RGB value representing the color in the default sRGB
     * {@link ColorModel}.
     * (Bits 24-31 are alpha, 16-23 are red, 8-15 are green, 0-7 are
     * blue).
     * @return the RGB value of the color in the default sRGB
     *         <code>ColorModel</code>.
     * @see java.awt.image.ColorModel#getRGBdefault
     * @see #getRed
     * @see #getGreen
     * @see #getBlue
     */
    int getRGB() {
        return color;
    }

    public ColorModel getColorModel() {
        return ColorModel.getRGBdefault();
    }

    public synchronized Raster getRaster(int x, int y, int w, int h) {
        WritableRaster t = savedTile;

        if (t == null || w > t.getWidth() || h > t.getHeight()) {
            t = getColorModel().createCompatibleWritableRaster(w, h);
            IntegerComponentRaster icr = (IntegerComponentRaster) t;
            Arrays.fill(icr.getDataStorage(), color);
            // Note - markDirty is probably unnecessary since icr is brand new
            icr.markDirty();
            if (w <= 64 && h <= 64) {
                savedTile = t;
            }
        }

        return t;
    }
}
