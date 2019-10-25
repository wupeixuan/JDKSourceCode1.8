/*
 * Copyright (c) 2005, 2013, Oracle and/or its affiliates. All rights reserved.
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
/*
 * $Id: TransformException.java,v 1.3 2005/05/10 16:03:48 mullan Exp $
 */
package javax.xml.crypto.dsig;

import java.io.PrintStream;
import java.io.PrintWriter;

/**
 * Indicates an exceptional condition that occurred while executing a
 * transform algorithm.
 *
 * <p>A <code>TransformException</code> can contain a cause: another
 * throwable that caused this <code>TransformException</code> to get thrown.
 *
 * @see Transform#transform
 * @author Sean Mullan
 * @author JSR 105 Expert Group
 * @since 1.6
 */
public class TransformException extends Exception {

    private static final long serialVersionUID = 5082634801360427800L;

    /**
     * The throwable that caused this exception to get thrown, or null if this
     * exception was not caused by another throwable or if the causative
     * throwable is unknown.
     *
     * @serial
     */
    private Throwable cause;

    /**
     * Constructs a new <code>TransformException</code> with
     * <code>null</code> as its detail message.
     */
    public TransformException() {
        super();
    }

    /**
     * Constructs a new <code>TransformException</code> with the specified
     * detail message.
     *
     * @param message the detail message
     */
    public TransformException(String message) {
        super(message);
    }

    /**
     * Constructs a new <code>TransformException</code> with the
     * specified detail message and cause.
     * <p>Note that the detail message associated with
     * <code>cause</code> is <i>not</i> automatically incorporated in
     * this exception's detail message.
     *
     * @param message the detail message
     * @param cause the cause (A <tt>null</tt> value is permitted, and
     *        indicates that the cause is nonexistent or unknown.)
     */
    public TransformException(String message, Throwable cause) {
        super(message);
        this.cause = cause;
    }

    /**
     * Constructs a new <code>TransformException</code> with the specified
     * cause and a detail message of
     * <code>(cause==null ? null : cause.toString())</code>
     * (which typically contains the class and detail message of
     * <code>cause</code>).
     *
     * @param cause the cause (A <tt>null</tt> value is permitted, and
     *        indicates that the cause is nonexistent or unknown.)
     */
    public TransformException(Throwable cause) {
        super(cause==null ? null : cause.toString());
        this.cause = cause;
    }

    /**
     * Returns the cause of this <code>TransformException</code> or
     * <code>null</code> if the cause is nonexistent or unknown.  (The
     * cause is the throwable that caused this
     * <code>TransformException</code> to get thrown.)
     *
     * @return the cause of this <code>TransformException</code> or
     *         <code>null</code> if the cause is nonexistent or unknown.
     */
    public Throwable getCause() {
        return cause;
    }

    /**
     * Prints this <code>TransformException</code>, its backtrace and
     * the cause's backtrace to the standard error stream.
     */
    public void printStackTrace() {
        super.printStackTrace();
        if (cause != null) {
            cause.printStackTrace();
        }
    }

    /**
     * Prints this <code>TransformException</code>, its backtrace and
     * the cause's backtrace to the specified print stream.
     *
     * @param s <code>PrintStream</code> to use for output
     */
    public void printStackTrace(PrintStream s) {
        super.printStackTrace(s);
        if (cause != null) {
            cause.printStackTrace(s);
        }
    }

    /**
     * Prints this <code>TransformException</code>, its backtrace and
     * the cause's backtrace to the specified print writer.
     *
     * @param s <code>PrintWriter</code> to use for output
     */
    public void printStackTrace(PrintWriter s) {
        super.printStackTrace(s);
        if (cause != null) {
            cause.printStackTrace(s);
        }
    }
}
