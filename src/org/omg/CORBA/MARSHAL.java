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
 * A request or reply from the network is structurally invalid.
 * This error typically indicates a bug in either the client-side
 * or server-side run time. For example, if a reply from the server
 * indicates that the message contains 1000 bytes, but the actual
 * message is shorter or longer than 1000 bytes, the ORB raises
 * this exception. <tt>MARSHAL</tt> can also be caused by using
 * the DII or DSI incorrectly, for example, if the type of the
 * actual parameters sent does not agree with IDL signature of an
 * operation.<P>
 * It contains a minor code, which gives more detailed information about
 * what caused the exception, and a completion status. It may also contain
 * a string describing the exception.
 * <P>
 * See the section <A href="../../../../technotes/guides/idl/jidlExceptions.html#minorcodemeanings">Minor
 * Code Meanings</A> to see the minor codes for this exception.
 *
 * @since       JDK1.2
 */

public final class MARSHAL extends SystemException {
    /**
     * Constructs a <code>MARSHAL</code> exception with a default minor code
     * of 0, a completion state of CompletionStatus.COMPLETED_NO,
     * and a null description.
     */
    public MARSHAL() {
        this("");
    }

    /**
     * Constructs a <code>MARSHAL</code> exception with the specified description message,
     * a minor code of 0, and a completion state of COMPLETED_NO.
     * @param s the String containing a description of the exception
     */
    public MARSHAL(String s) {
        this(s, 0, CompletionStatus.COMPLETED_NO);
    }

    /**
     * Constructs a <code>MARSHAL</code> exception with the specified
     * minor code and completion status.
     * @param minor the minor code
     * @param completed the completion status
     */
    public MARSHAL(int minor, CompletionStatus completed) {
        this("", minor, completed);
    }

    /**
     * Constructs a <code>MARSHAL</code> exception with the specified description
     * message, minor code, and completion status.
     * @param s the String containing a description message
     * @param minor the minor code
     * @param completed the completion status
     */
    public MARSHAL(String s, int minor, CompletionStatus completed) {
        super(s, minor, completed);
    }
}
