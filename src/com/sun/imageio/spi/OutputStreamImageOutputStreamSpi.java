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
import java.io.IOException;
import java.io.OutputStream;
import java.util.Locale;
import javax.imageio.spi.ImageOutputStreamSpi;
import javax.imageio.stream.ImageOutputStream;
import javax.imageio.stream.FileCacheImageOutputStream;
import javax.imageio.stream.MemoryCacheImageOutputStream;

public class OutputStreamImageOutputStreamSpi extends ImageOutputStreamSpi {

    private static final String vendorName = "Oracle Corporation";

    private static final String version = "1.0";

    private static final Class outputClass = OutputStream.class;

    public OutputStreamImageOutputStreamSpi() {
        super(vendorName, version, outputClass);
    }

    public String getDescription(Locale locale) {
        return "Service provider that instantiates an OutputStreamImageOutputStream from an OutputStream";
    }

    public boolean canUseCacheFile() {
        return true;
    }

    public boolean needsCacheFile() {
        return false;
    }

    public ImageOutputStream createOutputStreamInstance(Object output,
                                                        boolean useCache,
                                                        File cacheDir)
        throws IOException {
        if (output instanceof OutputStream) {
            OutputStream os = (OutputStream)output;
            if (useCache) {
                return new FileCacheImageOutputStream(os, cacheDir);
            } else {
                return new MemoryCacheImageOutputStream(os);
            }
        } else {
            throw new IllegalArgumentException();
        }
    }
}
