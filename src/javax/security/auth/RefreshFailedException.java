/*
 * Copyright (c) 1999, 2013, Oracle and/or its affiliates. All rights reserved.
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

package javax.security.auth;

/**
 * Signals that a {@code refresh} operation failed.
 *
 * <p> This exception is thrown by credentials implementing
 * the {@code Refreshable} interface when the {@code refresh}
 * method fails.
 *
 */
public class RefreshFailedException extends Exception {

    private static final long serialVersionUID = 5058444488565265840L;

    /**
     * Constructs a RefreshFailedException with no detail message. A detail
     * message is a String that describes this particular exception.
     */
    public RefreshFailedException() {
        super();
    }

    /**
     * Constructs a RefreshFailedException with the specified detail
     * message.  A detail message is a String that describes this particular
     * exception.
     *
     * <p>
     *
     * @param msg the detail message.
     */
    public RefreshFailedException(String msg) {
        super(msg);
    }
}
