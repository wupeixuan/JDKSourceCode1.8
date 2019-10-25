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
 * Thrown to indicate that an operation could not complete because
 * the input did not conform to the appropriate XML document type
 * for a collection of preferences, as per the {@link Preferences}
 * specification.
 *
 * @author  Josh Bloch
 * @see     Preferences
 * @since   1.4
 */
public class InvalidPreferencesFormatException extends Exception {
    /**
     * Constructs an InvalidPreferencesFormatException with the specified
     * cause.
     *
     * @param  cause the cause (which is saved for later retrieval by the
     *         {@link Throwable#getCause()} method).
     */
    public InvalidPreferencesFormatException(Throwable cause) {
        super(cause);
    }

   /**
    * Constructs an InvalidPreferencesFormatException with the specified
    * detail message.
    *
    * @param   message   the detail message. The detail message is saved for
    *          later retrieval by the {@link Throwable#getMessage()} method.
    */
    public InvalidPreferencesFormatException(String message) {
        super(message);
    }

    /**
     * Constructs an InvalidPreferencesFormatException with the specified
     * detail message and cause.
     *
     * @param  message   the detail message. The detail message is saved for
     *         later retrieval by the {@link Throwable#getMessage()} method.
     * @param  cause the cause (which is saved for later retrieval by the
     *         {@link Throwable#getCause()} method).
     */
    public InvalidPreferencesFormatException(String message, Throwable cause) {
        super(message, cause);
    }

    private static final long serialVersionUID = -791715184232119669L;
}
