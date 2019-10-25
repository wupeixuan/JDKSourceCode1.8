/*
 * Copyright (c) 1995, 2008, Oracle and/or its affiliates. All rights reserved.
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

package java.io;

/**
 * Signals that a malformed string in
 * <a href="DataInput.html#modified-utf-8">modified UTF-8</a>
 * format has been read in a data
 * input stream or by any class that implements the data input
 * interface.
 * See the
 * <a href="DataInput.html#modified-utf-8"><code>DataInput</code></a>
 * class description for the format in
 * which modified UTF-8 strings are read and written.
 *
 * @author  Frank Yellin
 * @see     java.io.DataInput
 * @see     java.io.DataInputStream#readUTF(java.io.DataInput)
 * @see     java.io.IOException
 * @since   JDK1.0
 */
public
class UTFDataFormatException extends IOException {
    private static final long serialVersionUID = 420743449228280612L;

    /**
     * Constructs a <code>UTFDataFormatException</code> with
     * <code>null</code> as its error detail message.
     */
    public UTFDataFormatException() {
        super();
    }

    /**
     * Constructs a <code>UTFDataFormatException</code> with the
     * specified detail message. The string <code>s</code> can be
     * retrieved later by the
     * <code>{@link java.lang.Throwable#getMessage}</code>
     * method of class <code>java.lang.Throwable</code>.
     *
     * @param   s   the detail message.
     */
    public UTFDataFormatException(String s) {
        super(s);
    }
}
