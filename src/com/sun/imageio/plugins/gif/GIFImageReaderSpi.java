/*
 * Copyright (c) 2000, 2010, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.imageio.plugins.gif;

import java.io.IOException;
import java.util.Locale;
import java.util.Iterator;
import javax.imageio.ImageReader;
import javax.imageio.metadata.IIOMetadataFormat;
import javax.imageio.metadata.IIOMetadataFormatImpl;
import javax.imageio.spi.ImageReaderSpi;
import javax.imageio.stream.ImageInputStream;

public class GIFImageReaderSpi extends ImageReaderSpi {

    private static final String vendorName = "Oracle Corporation";

    private static final String version = "1.0";

    private static final String[] names = { "gif", "GIF" };

    private static final String[] suffixes = { "gif" };

    private static final String[] MIMETypes = { "image/gif" };

    private static final String readerClassName =
        "com.sun.imageio.plugins.gif.GIFImageReader";

    private static final String[] writerSpiNames = {
        "com.sun.imageio.plugins.gif.GIFImageWriterSpi"
    };

    public GIFImageReaderSpi() {
        super(vendorName,
              version,
              names,
              suffixes,
              MIMETypes,
              readerClassName,
              new Class[] { ImageInputStream.class },
              writerSpiNames,
              true,
              GIFStreamMetadata.nativeMetadataFormatName,
              "com.sun.imageio.plugins.gif.GIFStreamMetadataFormat",
              null, null,
              true,
              GIFImageMetadata.nativeMetadataFormatName,
              "com.sun.imageio.plugins.gif.GIFImageMetadataFormat",
              null, null
              );
    }

    public String getDescription(Locale locale) {
        return "Standard GIF image reader";
    }

    public boolean canDecodeInput(Object input) throws IOException {
        if (!(input instanceof ImageInputStream)) {
            return false;
        }

        ImageInputStream stream = (ImageInputStream)input;
        byte[] b = new byte[6];
        stream.mark();
        stream.readFully(b);
        stream.reset();

        return b[0] == 'G' && b[1] == 'I' && b[2] == 'F' && b[3] == '8' &&
            (b[4] == '7' || b[4] == '9') && b[5] == 'a';
    }

    public ImageReader createReaderInstance(Object extension) {
        return new GIFImageReader(this);
    }

}
