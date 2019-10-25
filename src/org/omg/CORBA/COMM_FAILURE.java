/*
 * Copyright (c) 1995, 2006, Oracle and/or its affiliates. All rights reserved.
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
 * This exception is raised if communication is lost while an operation
 * is in progress, after the request was sent by the client, but before
 * the reply from the server has been returned to the client.<P>
 * It contains a minor code, which gives more detailed information about
 * what caused the exception, and a completion status. It may also contain
 * a string describing the exception.
 * <P>
 * See the section <A href="../../../../technotes/guides/idl/jidlExceptions.html#minorcodemeanings">meaning
 * of minor codes</A> to see the minor codes for this exception.
 *
 * @see <A href="../../../../technotes/guides/idl/jidlExceptions.html#minorcodemeanings">meaning of
 * minor codes</A>
 * @since       JDK1.2
 */

public final class COMM_FAILURE extends SystemException {

    /**
     * Constructs a <code>COMM_FAILURE</code> exception with
     * a default minor code of 0 and a completion state of COMPLETED_NO.
     */
    public COMM_FAILURE() {
        this("");
    }

    /**
     * Constructs a <code>COMM_FAILURE</code> exception with the specified detail
     * message, a minor code of 0, and a completion state of COMPLETED_NO.
     *
     * @param s the <code>String</code> containing a detail message describing
     *          this exception
     */
    public COMM_FAILURE(String s) {
        this(s, 0, CompletionStatus.COMPLETED_NO);
    }

    /**
     * Constructs a <code>COMM_FAILURE</code> exception with the specified
     * minor code and completion status.
     * @param minor the minor code
     * @param completed the completion status, which must be one of
     *                  <code>COMPLETED_YES</code>, <code>COMPLETED_NO</code>, or
     *                  <code>COMPLETED_MAYBE</code>.
     */
    public COMM_FAILURE(int minor, CompletionStatus completed) {
        this("", minor, completed);
    }

    /**
     * Constructs a <code>COMM_FAILURE</code> exception with the specified detail
     * message, minor code, and completion status.
     * A detail message is a String that describes this particular exception.
     * @param s the String containing a detail message
     * @param minor the minor code
     * @param completed the completion status, which must be one of
     *                  <code>COMPLETED_YES</code>, <code>COMPLETED_NO</code>, or
     *                  <code>COMPLETED_MAYBE</code>.
     */
    public COMM_FAILURE(String s, int minor, CompletionStatus completed) {
        super(s, minor, completed);
    }
}
