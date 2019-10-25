/*
 * Copyright (c) 1998, 2013, Oracle and/or its affiliates. All rights reserved.
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

package java.security;

/**
 * This exception is thrown by
 * {@code doPrivileged(PrivilegedExceptionAction)} and
 * {@code doPrivileged(PrivilegedExceptionAction,
 * AccessControlContext context)} to indicate
 * that the action being performed threw a checked exception.  The exception
 * thrown by the action can be obtained by calling the
 * {@code getException} method.  In effect, an
 * {@code PrivilegedActionException} is a "wrapper"
 * for an exception thrown by a privileged action.
 *
 * <p>As of release 1.4, this exception has been retrofitted to conform to
 * the general purpose exception-chaining mechanism.  The "exception thrown
 * by the privileged computation" that is provided at construction time and
 * accessed via the {@link #getException()} method is now known as the
 * <i>cause</i>, and may be accessed via the {@link Throwable#getCause()}
 * method, as well as the aforementioned "legacy method."
 *
 * @see PrivilegedExceptionAction
 * @see AccessController#doPrivileged(PrivilegedExceptionAction)
 * @see AccessController#doPrivileged(PrivilegedExceptionAction,AccessControlContext)
 */
public class PrivilegedActionException extends Exception {
    // use serialVersionUID from JDK 1.2.2 for interoperability
    private static final long serialVersionUID = 4724086851538908602L;

    /**
     * @serial
     */
    private Exception exception;

    /**
     * Constructs a new PrivilegedActionException &quot;wrapping&quot;
     * the specific Exception.
     *
     * @param exception The exception thrown
     */
    public PrivilegedActionException(Exception exception) {
        super((Throwable)null);  // Disallow initCause
        this.exception = exception;
    }

    /**
     * Returns the exception thrown by the privileged computation that
     * resulted in this {@code PrivilegedActionException}.
     *
     * <p>This method predates the general-purpose exception chaining facility.
     * The {@link Throwable#getCause()} method is now the preferred means of
     * obtaining this information.
     *
     * @return the exception thrown by the privileged computation that
     *         resulted in this {@code PrivilegedActionException}.
     * @see PrivilegedExceptionAction
     * @see AccessController#doPrivileged(PrivilegedExceptionAction)
     * @see AccessController#doPrivileged(PrivilegedExceptionAction,
     *                                            AccessControlContext)
     */
    public Exception getException() {
        return exception;
    }

    /**
     * Returns the cause of this exception (the exception thrown by
     * the privileged computation that resulted in this
     * {@code PrivilegedActionException}).
     *
     * @return  the cause of this exception.
     * @since   1.4
     */
    public Throwable getCause() {
        return exception;
    }

    public String toString() {
        String s = getClass().getName();
        return (exception != null) ? (s + ": " + exception.toString()) : s;
    }
}
