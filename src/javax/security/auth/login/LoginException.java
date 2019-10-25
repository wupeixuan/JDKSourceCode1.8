/*
 * Copyright (c) 1998, 2003, Oracle and/or its affiliates. All rights reserved.
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
 * This is the basic login exception.
 *
 * @see javax.security.auth.login.LoginContext
 */

public class LoginException extends java.security.GeneralSecurityException {

    private static final long serialVersionUID = -4679091624035232488L;

    /**
     * Constructs a LoginException with no detail message. A detail
     * message is a String that describes this particular exception.
     */
    public LoginException() {
        super();
    }

    /**
     * Constructs a LoginException with the specified detail message.
     * A detail message is a String that describes this particular
     * exception.
     *
     * <p>
     *
     * @param msg the detail message.
     */
    public LoginException(String msg) {
        super(msg);
    }
}
