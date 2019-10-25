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
package javax.swing;

import java.awt.*;
import java.awt.image.*;

/**
 * An image filter that "disables" an image by turning
 * it into a grayscale image, and brightening the pixels
 * in the image. Used by buttons to create an image for
 * a disabled button.
 *
 * @author      Jeff Dinkins
 * @author      Tom Ball
 * @author      Jim Graham
 */
public class GrayFilter extends RGBImageFilter {
    private boolean brighter;
    private int percent;

    /**
     * Creates a disabled image
     */
    public static Image createDisabledImage (Image i) {
        GrayFilter filter = new GrayFilter(true, 50);
        ImageProducer prod = new FilteredImageSource(i.getSource(), filter);
        Image grayImage = Toolkit.getDefaultToolkit().createImage(prod);
        return grayImage;
    }

    /**
     * Constructs a GrayFilter object that filters a color image to a
     * grayscale image. Used by buttons to create disabled ("grayed out")
     * button images.
     *
     * @param b  a boolean -- true if the pixels should be brightened
     * @param p  an int in the range 0..100 that determines the percentage
     *           of gray, where 100 is the darkest gray, and 0 is the lightest
     */
    public GrayFilter(boolean b, int p) {
        brighter = b;
        percent = p;

        // canFilterIndexColorModel indicates whether or not it is acceptable
        // to apply the color filtering of the filterRGB method to the color
        // table entries of an IndexColorModel object in lieu of pixel by pixel
        // filtering.
        canFilterIndexColorModel = true;
    }

    /**
     * Overrides <code>RGBImageFilter.filterRGB</code>.
     */
    public int filterRGB(int x, int y, int rgb) {
        // Use NTSC conversion formula.
        int gray = (int)((0.30 * ((rgb >> 16) & 0xff) +
                         0.59 * ((rgb >> 8) & 0xff) +
                         0.11 * (rgb & 0xff)) / 3);

        if (brighter) {
            gray = (255 - ((255 - gray) * (100 - percent) / 100));
        } else {
            gray = (gray * (100 - percent) / 100);
        }

        if (gray < 0) gray = 0;
        if (gray > 255) gray = 255;
        return (rgb & 0xff000000) | (gray << 16) | (gray << 8) | (gray << 0);
    }
}
