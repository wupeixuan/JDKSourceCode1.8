/*
 * Copyright (c) 1996, 2002, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.corba.se.impl.orbutil;

import java.io.StringWriter;
import java.io.OutputStream;
import java.io.IOException;

/**
 * Writes each input byte as a 2 byte hexidecimal output pair making it
 * possible to turn arbitrary binary data into an ASCII format.
 * The high 4 bits of the byte is translated into the first byte.
 *
 * @author      Jeff Nisewanger
 */
public class HexOutputStream extends OutputStream
{
    static private final char hex[] = {
        '0', '1', '2', '3', '4', '5', '6', '7',
        '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'
    };

    private StringWriter writer;

    /**
     * Creates a new HexOutputStream.
     * @param w The underlying StringWriter.
     */
    public
        HexOutputStream(StringWriter w) {
        writer = w;
    }


    /**
     * Writes a byte. Will block until the byte is actually
     * written.
     * param b The byte to write out.
     * @exception java.io.IOException I/O error occurred.
     */
    public synchronized void write(int b) throws IOException {
        writer.write(hex[((b >> 4) & 0xF)]);
        writer.write(hex[((b >> 0) & 0xF)]);
    }

    public synchronized void write(byte[] b) throws IOException {
        write(b, 0, b.length);
    }

    public synchronized void write(byte[] b, int off, int len)
        throws IOException
    {
        for(int i=0; i < len; i++) {
            write(b[off + i]);
        }
    }
}
