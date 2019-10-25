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

package com.sun.imageio.spi;

import java.io.File;
import java.io.RandomAccessFile;
import java.util.Locale;
import javax.imageio.spi.ImageOutputStreamSpi;
import javax.imageio.stream.ImageOutputStream;
import javax.imageio.stream.FileImageOutputStream;

public class RAFImageOutputStreamSpi extends ImageOutputStreamSpi {

    private static final String vendorName = "Oracle Corporation";

    private static final String version = "1.0";

    private static final Class outputClass = RandomAccessFile.class;

    public RAFImageOutputStreamSpi() {
        super(vendorName, version, outputClass);
    }

    public String getDescription(Locale locale) {
        return "Service provider that instantiates a FileImageOutputStream from a RandomAccessFile";
    }

    public ImageOutputStream createOutputStreamInstance(Object output,
                                                        boolean useCache,
                                                        File cacheDir) {
        if (output instanceof RandomAccessFile) {
            try {
                return new FileImageOutputStream((RandomAccessFile)output);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        } else {
            throw new IllegalArgumentException
                ("input not a RandomAccessFile!");
        }
    }
}
