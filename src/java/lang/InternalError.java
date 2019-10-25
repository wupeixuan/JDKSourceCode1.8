/*
 * Copyright (c) 1994, 2011, Oracle and/or its affiliates. All rights reserved.
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

package java.lang;

/**
 * Thrown to indicate some unexpected internal error has occurred in
 * the Java Virtual Machine.
 *
 * @author  unascribed
 * @since   JDK1.0
 */
public class InternalError extends VirtualMachineError {
    private static final long serialVersionUID = -9062593416125562365L;

    /**
     * Constructs an <code>InternalError</code> with no detail message.
     */
    public InternalError() {
        super();
    }

    /**
     * Constructs an <code>InternalError</code> with the specified
     * detail message.
     *
     * @param   message   the detail message.
     */
    public InternalError(String message) {
        super(message);
    }


    /**
     * Constructs an {@code InternalError} with the specified detail
     * message and cause.  <p>Note that the detail message associated
     * with {@code cause} is <i>not</i> automatically incorporated in
     * this error's detail message.
     *
     * @param  message the detail message (which is saved for later retrieval
     *         by the {@link #getMessage()} method).
     * @param  cause the cause (which is saved for later retrieval by the
     *         {@link #getCause()} method).  (A {@code null} value is
     *         permitted, and indicates that the cause is nonexistent or
     *         unknown.)
     * @since  1.8
     */
    public InternalError(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs an {@code InternalError} with the specified cause
     * and a detail message of {@code (cause==null ? null :
     * cause.toString())} (which typically contains the class and
     * detail message of {@code cause}).
     *
     * @param  cause the cause (which is saved for later retrieval by the
     *         {@link #getCause()} method).  (A {@code null} value is
     *         permitted, and indicates that the cause is nonexistent or
     *         unknown.)
     * @since  1.8
     */
    public InternalError(Throwable cause) {
        super(cause);
    }

}
