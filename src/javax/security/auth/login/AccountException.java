/*
 * Copyright (c) 2003, 2004, Oracle and/or its affiliates. All rights reserved.
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

package javax.security.auth.login;

/**
 * A generic account exception.
 *
 * @since 1.5
 */
public class AccountException extends LoginException {

    private static final long serialVersionUID = -2112878680072211787L;

    /**
     * Constructs a AccountException with no detail message. A detail
     * message is a String that describes this particular exception.
     */
    public AccountException() {
        super();
    }

    /**
     * Constructs a AccountException with the specified detail message.
     * A detail message is a String that describes this particular
     * exception.
     *
     * <p>
     *
     * @param msg the detail message.
     */
    public AccountException(String msg) {
        super(msg);
    }
}
