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
 * Signals that one of the ObjectStreamExceptions was thrown during a
 * write operation.  Thrown during a read operation when one of the
 * ObjectStreamExceptions was thrown during a write operation.  The
 * exception that terminated the write can be found in the detail
 * field. The stream is reset to it's initial state and all references
 * to objects already deserialized are discarded.
 *
 * <p>As of release 1.4, this exception has been retrofitted to conform to
 * the general purpose exception-chaining mechanism.  The "exception causing
 * the abort" that is provided at construction time and
 * accessed via the public {@link #detail} field is now known as the
 * <i>cause</i>, and may be accessed via the {@link Throwable#getCause()}
 * method, as well as the aforementioned "legacy field."
 *
 * @author  unascribed
 * @since   JDK1.1
 */
public class WriteAbortedException extends ObjectStreamException {
    private static final long serialVersionUID = -3326426625597282442L;

    /**
     * Exception that was caught while writing the ObjectStream.
     *
     * <p>This field predates the general-purpose exception chaining facility.
     * The {@link Throwable#getCause()} method is now the preferred means of
     * obtaining this information.
     *
     * @serial
     */
    public Exception detail;

    /**
     * Constructs a WriteAbortedException with a string describing
     * the exception and the exception causing the abort.
     * @param s   String describing the exception.
     * @param ex  Exception causing the abort.
     */
    public WriteAbortedException(String s, Exception ex) {
        super(s);
        initCause(null);  // Disallow subsequent initCause
        detail = ex;
    }

    /**
     * Produce the message and include the message from the nested
     * exception, if there is one.
     */
    public String getMessage() {
        if (detail == null)
            return super.getMessage();
        else
            return super.getMessage() + "; " + detail.toString();
    }

    /**
     * Returns the exception that terminated the operation (the <i>cause</i>).
     *
     * @return  the exception that terminated the operation (the <i>cause</i>),
     *          which may be null.
     * @since   1.4
     */
    public Throwable getCause() {
        return detail;
    }
}
