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
 * This exception is raised whenever meaningful communication is not possible
 * between client and server native code sets.
 *
 * @see <A href="../../../../technotes/guides/idl/jidlExceptions.html">documentation on
 *      Java&nbsp;IDL exceptions</A>
 * @since   J2SE 1.5
 */

public final class CODESET_INCOMPATIBLE extends SystemException {

    /**
     * Constructs an <code>CODESET_INCOMPATIBLE</code> exception with
     * minor code set to 0 and CompletionStatus set to COMPLETED_NO.
     */
    public CODESET_INCOMPATIBLE() {
        this("");
    }

    /**
     * Constructs an <code>CODESET_INCOMPATIBLE</code> exception with the
     * specified message.
     *
     * @param detailMessage string containing a detailed message.
     */
    public CODESET_INCOMPATIBLE(String detailMessage) {
        this(detailMessage, 0, CompletionStatus.COMPLETED_NO);
    }

    /**
     * Constructs an <code>CODESET_INCOMPATIBLE</code> exception with the
     * specified minor code and completion status.
     *
     * @param minorCode minor code.
     * @param completionStatus completion status.
     */
    public CODESET_INCOMPATIBLE(int minorCode,
                                CompletionStatus completionStatus) {
        this("", minorCode, completionStatus);
    }

    /**
     * Constructs an <code>CODESET_INCOMPATIBLE</code> exception with the
     * specified message, minor code, and completion status.
     *
     * @param detailMessage string containing a detailed message.
     * @param minorCode minor code.
     * @param completionStatus completion status.
     */
    public CODESET_INCOMPATIBLE(String detailMessage,
                                int minorCode,
                                CompletionStatus completionStatus) {
        super(detailMessage, minorCode, completionStatus);
    }
}
