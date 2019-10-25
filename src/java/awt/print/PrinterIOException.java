/*
 * Copyright (c) 1998, 2000, Oracle and/or its affiliates. All rights reserved.
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

package java.awt.print;
import java.io.IOException;

/**
 * The <code>PrinterIOException</code> class is a subclass of
 * {@link PrinterException} and is used to indicate that an IO error
 * of some sort has occurred while printing.
 *
 * <p>As of release 1.4, this exception has been retrofitted to conform to
 * the general purpose exception-chaining mechanism.  The
 * "<code>IOException</code> that terminated the print job"
 * that is provided at construction time and accessed via the
 * {@link #getIOException()} method is now known as the <i>cause</i>,
 * and may be accessed via the {@link Throwable#getCause()} method,
 * as well as the aforementioned "legacy method."
 */
public class PrinterIOException extends PrinterException {
    static final long serialVersionUID = 5850870712125932846L;

    /**
     * The IO error that terminated the print job.
     * @serial
     */
    private IOException mException;

    /**
     * Constructs a new <code>PrinterIOException</code>
     * with the string representation of the specified
     * {@link IOException}.
     * @param exception the specified <code>IOException</code>
     */
    public PrinterIOException(IOException exception) {
        initCause(null);  // Disallow subsequent initCause
        mException = exception;
    }

    /**
     * Returns the <code>IOException</code> that terminated
     * the print job.
     *
     * <p>This method predates the general-purpose exception chaining facility.
     * The {@link Throwable#getCause()} method is now the preferred means of
     * obtaining this information.
     *
     * @return the <code>IOException</code> that terminated
     * the print job.
     * @see IOException
     */
    public IOException getIOException() {
        return mException;
    }

    /**
     * Returns the the cause of this exception (the <code>IOException</code>
     * that terminated the print job).
     *
     * @return  the cause of this exception.
     * @since   1.4
     */
    public Throwable getCause() {
        return mException;
    }
}
