/*
 * Copyright (c) 1996, 2003, Oracle and/or its affiliates. All rights reserved.
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

package java.rmi;

/**
 * A <code>RemoteException</code> is the common superclass for a number of
 * communication-related exceptions that may occur during the execution of a
 * remote method call.  Each method of a remote interface, an interface that
 * extends <code>java.rmi.Remote</code>, must list
 * <code>RemoteException</code> in its throws clause.
 *
 * <p>As of release 1.4, this exception has been retrofitted to conform to
 * the general purpose exception-chaining mechanism.  The "wrapped remote
 * exception" that may be provided at construction time and accessed via
 * the public {@link #detail} field is now known as the <i>cause</i>, and
 * may be accessed via the {@link Throwable#getCause()} method, as well as
 * the aforementioned "legacy field."
 *
 * <p>Invoking the method {@link Throwable#initCause(Throwable)} on an
 * instance of <code>RemoteException</code> always throws {@link
 * IllegalStateException}.
 *
 * @author  Ann Wollrath
 * @since   JDK1.1
 */
public class RemoteException extends java.io.IOException {

    /* indicate compatibility with JDK 1.1.x version of class */
    private static final long serialVersionUID = -5148567311918794206L;

    /**
     * The cause of the remote exception.
     *
     * <p>This field predates the general-purpose exception chaining facility.
     * The {@link Throwable#getCause()} method is now the preferred means of
     * obtaining this information.
     *
     * @serial
     */
    public Throwable detail;

    /**
     * Constructs a <code>RemoteException</code>.
     */
    public RemoteException() {
        initCause(null);  // Disallow subsequent initCause
    }

    /**
     * Constructs a <code>RemoteException</code> with the specified
     * detail message.
     *
     * @param s the detail message
     */
    public RemoteException(String s) {
        super(s);
        initCause(null);  // Disallow subsequent initCause
    }

    /**
     * Constructs a <code>RemoteException</code> with the specified detail
     * message and cause.  This constructor sets the {@link #detail}
     * field to the specified <code>Throwable</code>.
     *
     * @param s the detail message
     * @param cause the cause
     */
    public RemoteException(String s, Throwable cause) {
        super(s);
        initCause(null);  // Disallow subsequent initCause
        detail = cause;
    }

    /**
     * Returns the detail message, including the message from the cause, if
     * any, of this exception.
     *
     * @return the detail message
     */
    public String getMessage() {
        if (detail == null) {
            return super.getMessage();
        } else {
            return super.getMessage() + "; nested exception is: \n\t" +
                detail.toString();
        }
    }

    /**
     * Returns the cause of this exception.  This method returns the value
     * of the {@link #detail} field.
     *
     * @return  the cause, which may be <tt>null</tt>.
     * @since   1.4
     */
    public Throwable getCause() {
        return detail;
    }
}
