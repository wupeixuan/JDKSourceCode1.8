/*
 * Copyright (c) 1997, 2006, Oracle and/or its affiliates. All rights reserved.
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

package org.omg.CORBA;

/**
 * Exception  thrown
 * when the request carried an invalid transaction context.
 * For example, this exception could be raised if an error
 * occurred when trying to register a resource.<P>
 * It contains a minor code, which gives more detailed information about
 * what caused the exception, and a completion status. It may also contain
 * a string describing the exception.
 *
 * @see <A href="../../../../technotes/guides/idl/jidlExceptions.html">documentation on
 * Java&nbsp;IDL exceptions</A>
 * @since   JDK1.2
 *
 */

public final class INVALID_TRANSACTION extends SystemException {
    /**
     * Constructs an <code>INVALID_TRANSACTION</code> exception with a default minor code
     * of 0 and a completion state of COMPLETED_NO.
     */
    public INVALID_TRANSACTION() {
        this("");
    }

    /**
     * Constructs an <code>INVALID_TRANSACTION</code> exception
     * with the specified detail message.
     * @param s the String containing a detail message
     */
    public INVALID_TRANSACTION(String s) {
        this(s, 0, CompletionStatus.COMPLETED_NO);
    }

    /**
     * Constructs an <code>INVALID_TRANSACTION</code> exception with the specified
     * minor code and completion status.
     * @param minor the minor code
     * @param completed the completion status
     */
    public INVALID_TRANSACTION(int minor, CompletionStatus completed) {
        this("", minor, completed);
    }

    /**
     * Constructs an <code>INVALID_TRANSACTION</code> exception with the specified detail
     * message, minor code, and completion status.
     * A detail message is a String that describes this particular exception.
     * @param s the String containing a detail message
     * @param minor the minor code
     * @param completed the completion status
     */
    public INVALID_TRANSACTION(String s, int minor, CompletionStatus completed) {
        super(s, minor, completed);
    }
}
