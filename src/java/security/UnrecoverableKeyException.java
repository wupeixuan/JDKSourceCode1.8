/*
 * Copyright (c) 1997, 2005, Oracle and/or its affiliates. All rights reserved.
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

package java.security;

/**
 * This exception is thrown if a key in the keystore cannot be recovered.
 *
 *
 * @since 1.2
 */

public class UnrecoverableKeyException extends UnrecoverableEntryException {

    private static final long serialVersionUID = 7275063078190151277L;

    /**
     * Constructs an UnrecoverableKeyException with no detail message.
     */
    public UnrecoverableKeyException() {
        super();
    }

    /**
     * Constructs an UnrecoverableKeyException with the specified detail
     * message, which provides more information about why this exception
     * has been thrown.
     *
     * @param msg the detail message.
     */
   public UnrecoverableKeyException(String msg) {
       super(msg);
    }
}
