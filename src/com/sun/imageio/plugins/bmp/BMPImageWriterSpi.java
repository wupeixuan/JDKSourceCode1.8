/*
 * Copyright (c) 2003, 2010, Oracle and/or its affiliates. All rights reserved.
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

import java.awt.image.DataBuffer;
import java.awt.image.SampleModel;
import java.awt.image.SinglePixelPackedSampleModel;

import javax.imageio.spi.ImageWriterSpi;
import javax.imageio.spi.ServiceRegistry;
import javax.imageio.spi.IIORegistry;
import javax.imageio.stream.ImageOutputStream;
import javax.imageio.ImageWriter;
import javax.imageio.ImageTypeSpecifier;
import javax.imageio.IIOException;
import java.util.Locale;

import javax.imageio.plugins.bmp.BMPImageWriteParam;

public class BMPImageWriterSpi extends ImageWriterSpi {
    private static String [] readerSpiNames =
        {"com.sun.imageio.plugins.bmp.BMPImageReaderSpi"};
    private static String[] formatNames = {"bmp", "BMP"};
    private static String[] entensions = {"bmp"};
    private static String[] mimeType = {"image/bmp"};

    private boolean registered = false;

    public BMPImageWriterSpi() {
        super("Oracle Corporation",
              "1.0",
              formatNames,
              entensions,
              mimeType,
              "com.sun.imageio.plugins.bmp.BMPImageWriter",
              new Class[] { ImageOutputStream.class },
              readerSpiNames,
              false,
              null, null, null, null,
              true,
              BMPMetadata.nativeMetadataFormatName,
              "com.sun.imageio.plugins.bmp.BMPMetadataFormat",
              null, null);
    }

    public String getDescription(Locale locale) {
        return "Standard BMP Image Writer";
    }

    public void onRegistration(ServiceRegistry registry,
                               Class<?> category) {
        if (registered) {
            return;
        }

        registered = true;
    }

    public boolean canEncodeImage(ImageTypeSpecifier type) {
        int dataType= type.getSampleModel().getDataType();
        if (dataType < DataBuffer.TYPE_BYTE || dataType > DataBuffer.TYPE_INT)
            return false;

        SampleModel sm = type.getSampleModel();
        int numBands = sm.getNumBands();
        if (!(numBands == 1 || numBands == 3))
            return false;

        if (numBands == 1 && dataType != DataBuffer.TYPE_BYTE)
            return false;

        if (dataType > DataBuffer.TYPE_BYTE &&
              !(sm instanceof SinglePixelPackedSampleModel))
            return false;

        return true;
    }

    public ImageWriter createWriterInstance(Object extension)
        throws IIOException {
        return new BMPImageWriter(this);
    }
}
