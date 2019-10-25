/*
 * Copyright (c) 2000, 2003, Oracle and/or its affiliates. All rights reserved.
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

package java.util.prefs;

import java.io.NotSerializableException;

/**
 * Thrown to indicate that a preferences operation could not complete because
 * of a failure in the backing store, or a failure to contact the backing
 * store.
 *
 * @author  Josh Bloch
 * @since   1.4
 */
public class BackingStoreException extends Exception {
    /**
     * Constructs a BackingStoreException with the specified detail message.
     *
     * @param s the detail message.
     */
    public BackingStoreException(String s) {
        super(s);
    }

    /**
     * Constructs a BackingStoreException with the specified cause.
     *
     * @param cause the cause
     */
    public BackingStoreException(Throwable cause) {
        super(cause);
    }

    private static final long serialVersionUID = 859796500401108469L;
}
