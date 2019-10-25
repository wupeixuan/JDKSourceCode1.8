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
 * Signals that an account was locked.
 *
 * <p> This exception may be thrown by a LoginModule if it
 * determines that authentication is being attempted on a
 * locked account.
 *
 * @since 1.5
 */
public class AccountLockedException extends AccountException {

    private static final long serialVersionUID = 8280345554014066334L;

    /**
     * Constructs a AccountLockedException with no detail message.
     * A detail message is a String that describes this particular exception.
     */
    public AccountLockedException() {
        super();
    }

    /**
     * Constructs a AccountLockedException with the specified
     * detail message. A detail message is a String that describes
     * this particular exception.
     *
     * <p>
     *
     * @param msg the detail message.
     */
    public AccountLockedException(String msg) {
        super(msg);
    }
}
