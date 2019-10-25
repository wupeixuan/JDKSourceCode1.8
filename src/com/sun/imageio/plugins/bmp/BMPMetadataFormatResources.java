/*
 * Copyright (c) 2003, 2005, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.imageio.plugins.bmp;

import java.util.ListResourceBundle;
import javax.imageio.metadata.IIOMetadataFormat;
import javax.imageio.metadata.IIOMetadataFormatImpl;

public class BMPMetadataFormatResources extends ListResourceBundle {

    public BMPMetadataFormatResources() {}

    protected Object[][] getContents() {
        return new Object[][] {

        // Node name, followed by description
        { "BMPVersion", "BMP version string" },
        { "Width", "The width of the image" },
        { "Height","The height of the image" },
        { "BitsPerPixel", "" },
        { "PixelsPerMeter", "Resolution in pixels per unit distance" },
        { "X", "Pixels Per Meter along X" },
        { "Y", "Pixels Per Meter along Y" },
        { "ColorsUsed",
          "Number of color indexes in the color table actually used" },
        { "ColorsImportant",
          "Number of color indexes considered important for display" },
        { "Mask",
          "Color masks; present for BI_BITFIELDS compression only"},

        { "Intent", "Rendering intent" },
        { "Palette", "The color palette" },

        { "Red", "Red Mask/Color Palette" },
        { "Green", "Green Mask/Color Palette/Gamma" },
        { "Blue", "Blue Mask/Color Palette/Gamma" },
        { "Alpha", "Alpha Mask/Color Palette/Gamma" },

        { "ColorSpaceType", "Color Space Type" },

        { "X", "The X coordinate of a point in XYZ color space" },
        { "Y", "The Y coordinate of a point in XYZ color space" },
        { "Z", "The Z coordinate of a point in XYZ color space" },
        };
    }
}
