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
 * The CORBA <code>WrongTransaction</code> user-defined exception.
 * This exception is thrown only by the methods
 * <code>Request.get_response</code>
 * and <code>ORB.get_next_response</code> when they are invoked
 * from a transaction scope that is different from the one in
 * which the client originally sent the request.
 * See the OMG Transaction Service Specification for details.
 *
 * @see <A href="../../../../technotes/guides/idl/jidlExceptions.html">documentation on
 * Java&nbsp;IDL exceptions</A>
 */

public final class WrongTransaction extends UserException {
    /**
     * Constructs a WrongTransaction object with an empty detail message.
     */
    public WrongTransaction() {
        super(WrongTransactionHelper.id());
    }

    /**
     * Constructs a WrongTransaction object with the given detail message.
     * @param reason The detail message explaining what caused this exception to be thrown.
     */
    public WrongTransaction(String reason) {
        super(WrongTransactionHelper.id() + "  " + reason);
    }
}
