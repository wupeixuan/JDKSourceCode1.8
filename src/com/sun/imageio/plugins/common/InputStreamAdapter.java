/*
 * Copyright (c) 2000, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.imageio.plugins.common;

import java.io.IOException;
import java.io.InputStream;
import javax.imageio.stream.ImageInputStream;

public class InputStreamAdapter extends InputStream {

    ImageInputStream stream;

    public InputStreamAdapter(ImageInputStream stream) {
        super();

        this.stream = stream;
    }

    public int read() throws IOException {
        return stream.read();
    }

    public int read(byte b[], int off, int len) throws IOException {
        return stream.read(b, off, len);
    }
}
