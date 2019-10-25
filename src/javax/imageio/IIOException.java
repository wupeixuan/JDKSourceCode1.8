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

package javax.imageio;

import java.io.IOException;

/**
 * An exception class used for signaling run-time failure of reading
 * and writing operations.
 *
 * <p> In addition to a message string, a reference to another
 * <code>Throwable</code> (<code>Error</code> or
 * <code>Exception</code>) is maintained.  This reference, if
 * non-<code>null</code>, refers to the event that caused this
 * exception to occur.  For example, an <code>IOException</code> while
 * reading from a <code>File</code> would be stored there.
 *
 */
public class IIOException extends IOException {

    /**
     * Constructs an <code>IIOException</code> with a given message
     * <code>String</code>.  No underlying cause is set;
     * <code>getCause</code> will return <code>null</code>.
     *
     * @param message the error message.
     *
     * @see #getMessage
     */
    public IIOException(String message) {
        super(message);
    }

    /**
     * Constructs an <code>IIOException</code> with a given message
     * <code>String</code> and a <code>Throwable</code> that was its
     * underlying cause.
     *
     * @param message the error message.
     * @param cause the <code>Throwable</code> (<code>Error</code> or
     * <code>Exception</code>) that caused this exception to occur.
     *
     * @see #getCause
     * @see #getMessage
     */
    public IIOException(String message, Throwable cause) {
        super(message);
        initCause(cause);
    }
}
