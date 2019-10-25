/*
 * Copyright (c) 2004, 2006, Oracle and/or its affiliates. All rights reserved.
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
 * <code>TIMEOUT</code> is raised when no delivery has been made and the
 * specified time-to-live period has been exceeded. It is a standard system
 * exception because time-to-live QoS can be applied to any invocation.
 *
 * @see <A href="../../../../technotes/guides/idl/jidlExceptions.html">documentation on
 *      Java&nbsp;IDL exceptions</A>
 * @since   J2SE 1.5
 */

public final class TIMEOUT extends SystemException {

    /**
     * Constructs an <code>TIMEOUT</code> exception with
     * minor code set to 0 and CompletionStatus set to COMPLETED_NO.
     */
    public TIMEOUT() {
        this("");
    }

    /**
     * Constructs an <code>TIMEOUT</code> exception with the
     * specified message.
     *
     * @param detailMessage string containing a detailed message.
     */
    public TIMEOUT(String detailMessage) {
        this(detailMessage, 0, CompletionStatus.COMPLETED_NO);
    }

    /**
     * Constructs an <code>TIMEOUT</code> exception with the
     * specified minor code and completion status.
     *
     * @param minorCode minor code.
     * @param completionStatus completion status.
     */
    public TIMEOUT(int minorCode,
                   CompletionStatus completionStatus) {
        this("", minorCode, completionStatus);
    }

    /**
     * Constructs an <code>TIMEOUT</code> exception with the
     * specified message, minor code, and completion status.
     *
     * @param detailMessage string containing a detailed message.
     * @param minorCode minor code.
     * @param completionStatus completion status.
     */
    public TIMEOUT(String detailMessage,
                   int minorCode,
                   CompletionStatus completionStatus) {
        super(detailMessage, minorCode, completionStatus);
    }
}
