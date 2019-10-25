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
 * Exception thrown when the ORB has encountered a malformed type code
 * (for example, a type code with an invalid <tt>TCKind</tt> value).<P>
 * It contains a minor code, which gives more detailed information about
 * what caused the exception, and a completion status. It may also contain
 * a string describing the exception.
 *
 * @see <A href="../../../../technotes/guides/idl/jidlExceptions.html">documentation on
 * Java&nbsp;IDL exceptions</A>
 * @since       JDK1.2
 */

public final class BAD_TYPECODE extends SystemException {

    /**
     * Constructs a <code>BAD_TYPECODE</code> exception with a default
     * minor code of 0 and a completion state of COMPLETED_NO.
     */
    public BAD_TYPECODE() {
        this("");
    }

    /**
     * Constructs a <code>BAD_TYPECODE</code> exception with the specified detail,
     * a minor code of 0, and a completion state of COMPLETED_NO.
     *
     * @param s the String containing a detail message
     */
    public BAD_TYPECODE(String s) {
        this(s, 0, CompletionStatus.COMPLETED_NO);
    }

    /**
     * Constructs a <code>BAD_TYPECODE</code> exception with the specified
     * minor code and completion status.
     * @param minor the minor code
     * @param completed an instance of <code>CompletionStatus</code> indicating
     *                  the completion status
     */
    public BAD_TYPECODE(int minor, CompletionStatus completed) {
        this("", minor, completed);
    }

    /**
     * Constructs a <code>BAD_TYPECODE</code> exception with the specified detail
     * message, minor code, and completion status.
     * A detail message is a String that describes this particular exception.
     * @param s the String containing a detail message
     * @param minor the minor code
     * @param completed an instance of <code>CompletionStatus</code> indicating
     *                  the completion status
     */
    public BAD_TYPECODE(String s, int minor, CompletionStatus completed) {
        super(s, minor, completed);
    }
}
