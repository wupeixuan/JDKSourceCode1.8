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
 * Exception raised
 * when an ORB cannot reach the interface
 * repository, or some other failure relating to the interface repository
 * is detected.<P>
 * It contains a minor code, which gives more detailed information about
 * what caused the exception, and a completion status. It may also contain
 * a string describing the exception.
 *
 * @see <A href="../../../../technotes/guides/idl/jidlExceptions.html">documentation on
 * Java&nbsp;IDL exceptions</A>
 * @since       JDK1.2
 */

public final class INTF_REPOS extends SystemException {
    /**
     * Constructs an <code>INTF_REPOS</code> exception with a default minor code
     * of 0 and a completion state of COMPLETED_NO.
     */
    public INTF_REPOS() {
        this("");
    }

    /**
     * Constructs an <code>INTF_REPOS</code> exception with the specified detail.
     * @param s the String containing a detail message
     */
    public INTF_REPOS(String s) {
        this(s, 0, CompletionStatus.COMPLETED_NO);
    }

    /**
     * Constructs an <code>INTF_REPOS</code> exception with the specified
     * minor code and completion status.
     * @param minor the minor code
     * @param completed the completion status
     */
    public INTF_REPOS(int minor, CompletionStatus completed) {
        this("", minor, completed);
    }

    /**
     * Constructs an <code>INTF_REPOS</code> exception with the specified detail
     * message, minor code, and completion status.
     * A detail message is a String that describes this particular exception.
     * @param s the String containing a detail message
     * @param minor the minor code
     * @param completed the completion status
     */
    public INTF_REPOS(String s, int minor, CompletionStatus completed) {
        super(s, minor, completed);
    }
}
