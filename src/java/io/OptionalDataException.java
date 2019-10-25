/*
 * Copyright (c) 1996, 2005, Oracle and/or its affiliates. All rights reserved.
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
 * Exception indicating the failure of an object read operation due to
 * unread primitive data, or the end of data belonging to a serialized
 * object in the stream.  This exception may be thrown in two cases:
 *
 * <ul>
 *   <li>An attempt was made to read an object when the next element in the
 *       stream is primitive data.  In this case, the OptionalDataException's
 *       length field is set to the number of bytes of primitive data
 *       immediately readable from the stream, and the eof field is set to
 *       false.
 *
 *   <li>An attempt was made to read past the end of data consumable by a
 *       class-defined readObject or readExternal method.  In this case, the
 *       OptionalDataException's eof field is set to true, and the length field
 *       is set to 0.
 * </ul>
 *
 * @author  unascribed
 * @since   JDK1.1
 */
public class OptionalDataException extends ObjectStreamException {

    private static final long serialVersionUID = -8011121865681257820L;

    /*
     * Create an <code>OptionalDataException</code> with a length.
     */
    OptionalDataException(int len) {
        eof = false;
        length = len;
    }

    /*
     * Create an <code>OptionalDataException</code> signifying no
     * more primitive data is available.
     */
    OptionalDataException(boolean end) {
        length = 0;
        eof = end;
    }

    /**
     * The number of bytes of primitive data available to be read
     * in the current buffer.
     *
     * @serial
     */
    public int length;

    /**
     * True if there is no more data in the buffered part of the stream.
     *
     * @serial
     */
    public boolean eof;
}
