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
 * Exception  thrown
 * when a parameter passed to a call is out of range or
 * otherwise considered illegal. An ORB may raise this exception
 * if null values or null pointers are passed to an operation (for
 * language mappings where the concept of a null pointers or null
 * values applies). BAD_PARAM can also be raised as a result of a
 * client generating requests with incorrect parameters using the DII. <P>
 * It contains a minor code, which gives more detailed information about
 * what caused the exception, and a completion status. It may also contain
 * a string describing the exception.
 *
 * @see <A href="../../../../technotes/guides/idl/jidlExceptions.html">documentation on
 * Java&nbsp;IDL exceptions</A>
 * @see <A href="../../../../technotes/guides/idl/jidlExceptions.html#minorcodemeanings">meaning of
 * minor codes</A>
 * @since       JDK1.2
 */

public final class BAD_PARAM extends SystemException {

    /**
     * Constructs a <code>BAD_PARAM</code> exception with a default
     * minor code of 0 and a completion state of COMPLETED_NO.
     */
    public BAD_PARAM() {
        this("");
    }

    /**
     * Constructs a <code>BAD_PARAM</code> exception with the specified detail
     * message, a minor code of 0, and a completion state of COMPLETED_NO.
     *
     * @param s the String containing a detail message describing this
     *          exception
     */
    public BAD_PARAM(String s) {
        this(s, 0, CompletionStatus.COMPLETED_NO);
    }

    /**
     * Constructs a <code>BAD_PARAM</code> exception with the specified
     * minor code and completion status.
     * @param minor the minor code
     * @param completed the completion status
     */
    public BAD_PARAM(int minor, CompletionStatus completed) {
        this("", minor, completed);
    }

    /**
     * Constructs a <code>BAD_PARAM</code> exception with the specified detail
     * message, minor code, and completion status.
     * A detail message is a <code>String</code> that describes
     * this particular exception.
     *
     * @param s the <code>String</code> containing a detail message
     * @param minor the minor code
     * @param completed the completion status
     */
    public BAD_PARAM(String s, int minor, CompletionStatus completed) {
        super(s, minor, completed);
    }
}
