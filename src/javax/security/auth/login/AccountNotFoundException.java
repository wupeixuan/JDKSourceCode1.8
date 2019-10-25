/*
 * Copyright (c) 2003, Oracle and/or its affiliates. All rights reserved.
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
 * Signals that an account was not found.
 *
 * <p> This exception may be thrown by a LoginModule if it is unable
 * to locate an account necessary to perform authentication.
 *
 * @since 1.5
 */
public class AccountNotFoundException extends AccountException {

    private static final long serialVersionUID = 1498349563916294614L;

    /**
     * Constructs a AccountNotFoundException with no detail message.
     * A detail message is a String that describes this particular exception.
     */
    public AccountNotFoundException() {
        super();
    }

    /**
     * Constructs a AccountNotFoundException with the specified
     * detail message. A detail message is a String that describes
     * this particular exception.
     *
     * <p>
     *
     * @param msg the detail message.
     */
    public AccountNotFoundException(String msg) {
        super(msg);
    }
}
