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
 * This exception indicates that an object reference is internally
 * malformed. For example, the repository ID may have incorrect
 * syntax or the addressing information may be invalid. This
 * exception is raised by ORB::string_to_object if the passed
 * string does not decode correctly. An ORB may choose to detect
 * calls via nil references (but is not obliged to do detect them).
 * <tt>INV_OBJREF</tt> is used to indicate this.<P>
 * It contains a minor code, which gives more detailed information about
 * what caused the exception, and a completion status. It may also contain
 * a string describing the exception.
 * <P>
 * See the section <A href="../../../../technotes/guides/idl/jidlExceptions.html#minorcodemeanings">Minor
 * Code Meanings</A> to see the minor codes for this exception.
 *
 * @see <A href="../../../../technotes/guides/idl/jidlExceptions.html">documentation on
 * Java&nbsp;IDL exceptions</A>
 * @since       JDK1.2
 */

public final class INV_OBJREF extends SystemException {
    /**
     * Constructs an <code>INV_OBJREF</code> exception with a default
     * minor code of 0 and a completion state of COMPLETED_NO.
     */
    public INV_OBJREF() {
        this("");
    }

    /**
     * Constructs an <code>INV_OBJREF</code> exception with the specified detail
     * message, a minor code of 0, and a completion state of COMPLETED_NO.
     * @param s the String containing a detail message
     */
    public INV_OBJREF(String s) {
        this(s, 0, CompletionStatus.COMPLETED_NO);
    }

    /**
     * Constructs an <code>INV_OBJREF</code> exception with the specified
     * minor code and completion status.
     * @param minor the minor code
     * @param completed a <code>CompletionStatus</code> instance indicating
     *                  the completion status
     */
    public INV_OBJREF(int minor, CompletionStatus completed) {
        this("", minor, completed);
    }

    /**
     * Constructs an <code>INV_OBJREF</code> exception with the specified detail
     * message, minor code, and completion status.
     * A detail message is a String that describes this particular exception.
     * @param s the String containing a detail message
     * @param minor the minor code
     * @param completed a <code>CompletionStatus</code> instance indicating
     *                  the completion status
     */
    public INV_OBJREF(String s, int minor, CompletionStatus completed) {
        super(s, minor, completed);
    }
}
