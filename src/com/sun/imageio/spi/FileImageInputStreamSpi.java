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
import java.util.Locale;
import javax.imageio.spi.ImageInputStreamSpi;
import javax.imageio.stream.ImageInputStream;
import javax.imageio.stream.FileImageInputStream;

public class FileImageInputStreamSpi extends ImageInputStreamSpi {

    private static final String vendorName = "Oracle Corporation";

    private static final String version = "1.0";

    private static final Class inputClass = File.class;

    public FileImageInputStreamSpi() {
        super(vendorName, version, inputClass);
    }

    public String getDescription(Locale locale) {
        return "Service provider that instantiates a FileImageInputStream from a File";
    }

    public ImageInputStream createInputStreamInstance(Object input,
                                                      boolean useCache,
                                                      File cacheDir) {
        if (input instanceof File) {
            try {
                return new FileImageInputStream((File)input);
            } catch (Exception e) {
                return null;
            }
        } else {
            throw new IllegalArgumentException();
        }
    }
}
