/*
 * Copyright (c) 1998, 2013, Oracle and/or its affiliates. All rights reserved.
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
 * Signals that a user account has expired.
 *
 * <p> This exception is thrown by LoginModules when they determine
 * that an account has expired.  For example, a {@code LoginModule},
 * after successfully authenticating a user, may determine that the
 * user's account has expired.  In this case the {@code LoginModule}
 * throws this exception to notify the application.  The application can
 * then take the appropriate steps to notify the user.
 *
 */
public class AccountExpiredException extends AccountException {

    private static final long serialVersionUID = -6064064890162661560L;

    /**
     * Constructs a AccountExpiredException with no detail message. A detail
     * message is a String that describes this particular exception.
     */
    public AccountExpiredException() {
        super();
    }

    /**
     * Constructs a AccountExpiredException with the specified detail
     * message.  A detail message is a String that describes this particular
     * exception.
     *
     * <p>
     *
     * @param msg the detail message.
     */
    public AccountExpiredException(String msg) {
        super(msg);
    }
}
