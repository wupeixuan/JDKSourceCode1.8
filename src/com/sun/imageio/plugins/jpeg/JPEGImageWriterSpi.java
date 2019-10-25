/*
 * Copyright (c) 2000, 2004, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.imageio.plugins.jpeg;

import javax.imageio.spi.ImageWriterSpi;
import javax.imageio.spi.ServiceRegistry;
import javax.imageio.spi.IIORegistry;
import javax.imageio.stream.ImageOutputStream;
import javax.imageio.ImageWriter;
import javax.imageio.ImageTypeSpecifier;
import javax.imageio.IIOException;

import java.awt.image.ColorModel;
import java.awt.image.IndexColorModel;
import java.awt.image.SampleModel;
import java.util.Locale;

public class JPEGImageWriterSpi extends ImageWriterSpi {

    private static String [] readerSpiNames =
        {"com.sun.imageio.plugins.jpeg.JPEGImageReaderSpi"};

    public JPEGImageWriterSpi() {
        super(JPEG.vendor,
              JPEG.version,
              JPEG.names,
              JPEG.suffixes,
              JPEG.MIMETypes,
              "com.sun.imageio.plugins.jpeg.JPEGImageWriter",
              new Class[] { ImageOutputStream.class },
              readerSpiNames,
              true,
              JPEG.nativeStreamMetadataFormatName,
              JPEG.nativeStreamMetadataFormatClassName,
              null, null,
              true,
              JPEG.nativeImageMetadataFormatName,
              JPEG.nativeImageMetadataFormatClassName,
              null, null
              );
    }

    public String getDescription(Locale locale) {
        return "Standard JPEG Image Writer";
    }

    public boolean isFormatLossless() {
        return false;
    }

    public boolean canEncodeImage(ImageTypeSpecifier type) {
        SampleModel sampleModel = type.getSampleModel();

        // Find the maximum bit depth across all channels
        int[] sampleSize = sampleModel.getSampleSize();
        int bitDepth = sampleSize[0];
        for (int i = 1; i < sampleSize.length; i++) {
            if (sampleSize[i] > bitDepth) {
                bitDepth = sampleSize[i];
            }
        }

        // 4450894: Ensure bitDepth is between 1 and 8
        if (bitDepth < 1 || bitDepth > 8) {
            return false;
        }

        return true;
    }

    public ImageWriter createWriterInstance(Object extension)
        throws IIOException {
        return new JPEGImageWriter(this);
    }
}
