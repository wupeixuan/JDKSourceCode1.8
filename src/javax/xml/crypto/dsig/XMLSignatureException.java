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
 * $Id: XMLSignatureException.java,v 1.5 2005/05/10 16:03:48 mullan Exp $
 */
package javax.xml.crypto.dsig;

import java.io.PrintStream;
import java.io.PrintWriter;

/**
 * Indicates an exceptional condition that occurred during the XML
 * signature generation or validation process.
 *
 * <p>An <code>XMLSignatureException</code> can contain a cause: another
 * throwable that caused this <code>XMLSignatureException</code> to get thrown.
 *
 * @since 1.6
 */
public class XMLSignatureException extends Exception {

    private static final long serialVersionUID = -3438102491013869995L;

    /**
     * The throwable that caused this exception to get thrown, or null if this
     * exception was not caused by another throwable or if the causative
     * throwable is unknown.
     *
     * @serial
     */
    private Throwable cause;

    /**
     * Constructs a new <code>XMLSignatureException</code> with
     * <code>null</code> as its detail message.
     */
    public XMLSignatureException() {
        super();
    }

    /**
     * Constructs a new <code>XMLSignatureException</code> with the specified
     * detail message.
     *
     * @param message the detail message
     */
    public XMLSignatureException(String message) {
        super(message);
    }

    /**
     * Constructs a new <code>XMLSignatureException</code> with the
     * specified detail message and cause.
     * <p>Note that the detail message associated with
     * <code>cause</code> is <i>not</i> automatically incorporated in
     * this exception's detail message.
     *
     * @param message the detail message
     * @param cause the cause (A <tt>null</tt> value is permitted, and
     *        indicates that the cause is nonexistent or unknown.)
     */
    public XMLSignatureException(String message, Throwable cause) {
        super(message);
        this.cause = cause;
    }

    /**
     * Constructs a new <code>XMLSignatureException</code> with the specified
     * cause and a detail message of
     * <code>(cause==null ? null : cause.toString())</code>
     * (which typically contains the class and detail message of
     * <code>cause</code>).
     *
     * @param cause the cause (A <tt>null</tt> value is permitted, and
     *        indicates that the cause is nonexistent or unknown.)
     */
    public XMLSignatureException(Throwable cause) {
        super(cause==null ? null : cause.toString());
        this.cause = cause;
    }

    /**
     * Returns the cause of this <code>XMLSignatureException</code> or
     * <code>null</code> if the cause is nonexistent or unknown.  (The
     * cause is the throwable that caused this
     * <code>XMLSignatureException</code> to get thrown.)
     *
     * @return the cause of this <code>XMLSignatureException</code> or
     *         <code>null</code> if the cause is nonexistent or unknown.
     */
    public Throwable getCause() {
        return cause;
    }

    /**
     * Prints this <code>XMLSignatureException</code>, its backtrace and
     * the cause's backtrace to the standard error stream.
     */
    public void printStackTrace() {
        super.printStackTrace();
        if (cause != null) {
            cause.printStackTrace();
        }
    }

    /**
     * Prints this <code>XMLSignatureException</code>, its backtrace and
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
     * Prints this <code>XMLSignatureException</code>, its backtrace and
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
