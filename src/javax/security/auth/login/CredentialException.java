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
 * A generic credential exception.
 *
 * @since 1.5
 */
public class CredentialException extends LoginException {

    private static final long serialVersionUID = -4772893876810601859L;

    /**
     * Constructs a CredentialException with no detail message. A detail
     * message is a String that describes this particular exception.
     */
    public CredentialException() {
        super();
    }

    /**
     * Constructs a CredentialException with the specified detail message.
     * A detail message is a String that describes this particular
     * exception.
     *
     * <p>
     *
     * @param msg the detail message.
     */
    public CredentialException(String msg) {
        super(msg);
    }
}
