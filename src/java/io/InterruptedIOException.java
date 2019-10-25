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
 * Signals that an I/O operation has been interrupted. An
 * <code>InterruptedIOException</code> is thrown to indicate that an
 * input or output transfer has been terminated because the thread
 * performing it was interrupted. The field {@link #bytesTransferred}
 * indicates how many bytes were successfully transferred before
 * the interruption occurred.
 *
 * @author  unascribed
 * @see     java.io.InputStream
 * @see     java.io.OutputStream
 * @see     java.lang.Thread#interrupt()
 * @since   JDK1.0
 */
public
class InterruptedIOException extends IOException {
    private static final long serialVersionUID = 4020568460727500567L;

    /**
     * Constructs an <code>InterruptedIOException</code> with
     * <code>null</code> as its error detail message.
     */
    public InterruptedIOException() {
        super();
    }

    /**
     * Constructs an <code>InterruptedIOException</code> with the
     * specified detail message. The string <code>s</code> can be
     * retrieved later by the
     * <code>{@link java.lang.Throwable#getMessage}</code>
     * method of class <code>java.lang.Throwable</code>.
     *
     * @param   s   the detail message.
     */
    public InterruptedIOException(String s) {
        super(s);
    }

    /**
     * Reports how many bytes had been transferred as part of the I/O
     * operation before it was interrupted.
     *
     * @serial
     */
    public int bytesTransferred = 0;
}
