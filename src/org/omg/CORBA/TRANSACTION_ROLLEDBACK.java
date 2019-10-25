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
 * Exception  thrown when the transaction associated with the request has
 * already been rolled back or marked to roll back. Thus, the requested
 * operation either could not be performed or was not performed because
 * further computation on behalf of the transaction would be fruitless.<P>
 * See the OMG Transaction
 * Service specification for details.
 * It contains a minor code, which gives more detailed information about
 * what caused the exception, and a completion status. It may also contain
 * a string describing the exception.
 *
 * @see <A href="../../../../technotes/guides/idl/jidlExceptions.html">documentation on
 * Java&nbsp;IDL exceptions</A>
 */

public final class TRANSACTION_ROLLEDBACK extends SystemException {
    /**
     * Constructs a <code>TRANSACTION_ROLLEDBACK</code> exception with a default minor code
     * of 0, a completion state of CompletionStatus.COMPLETED_NO,
     * and a null description.
     */
    public TRANSACTION_ROLLEDBACK() {
        this("");
    }

    /**
     * Constructs a <code>TRANSACTION_ROLLEDBACK</code> exception with the
     * specified description message,
     * a minor code of 0, and a completion state of COMPLETED_NO.
     * @param s the String containing a detail message
     */
    public TRANSACTION_ROLLEDBACK(String s) {
        this(s, 0, CompletionStatus.COMPLETED_NO);
    }

    /**
     * Constructs a <code>TRANSACTION_ROLLEDBACK</code> exception with the specified
     * minor code and completion status.
     * @param minor the minor code
     * @param completed the completion status
     */
    public TRANSACTION_ROLLEDBACK(int minor, CompletionStatus completed) {
        this("", minor, completed);
    }

    /**
     * Constructs a <code>TRANSACTION_ROLLEDBACK</code> exception with the
     * specified description message, minor code, and completion status.
     * @param s the String containing a description message
     * @param minor the minor code
     * @param completed the completion status
     */
    public TRANSACTION_ROLLEDBACK(String s, int minor, CompletionStatus completed) {
        super(s, minor, completed);
    }
}
