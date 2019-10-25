/*
 * Copyright (c) 2003, 2012, Oracle and/or its affiliates. All rights reserved.
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

package java.util;

import java.io.NotSerializableException;
import java.io.IOException;

/**
 * Thrown to indicate that an operation could not complete because
 * the input did not conform to the appropriate XML document type
 * for a collection of properties, as per the {@link Properties}
 * specification.<p>
 *
 * Note, that although InvalidPropertiesFormatException inherits Serializable
 * interface from Exception, it is not intended to be Serializable. Appropriate
 * serialization methods are implemented to throw NotSerializableException.
 *
 * @see     Properties
 * @since   1.5
 * @serial exclude
 */

public class InvalidPropertiesFormatException extends IOException {

    private static final long serialVersionUID = 7763056076009360219L;

    /**
     * Constructs an InvalidPropertiesFormatException with the specified
     * cause.
     *
     * @param  cause the cause (which is saved for later retrieval by the
     *         {@link Throwable#getCause()} method).
     */
    public InvalidPropertiesFormatException(Throwable cause) {
        super(cause==null ? null : cause.toString());
        this.initCause(cause);
    }

   /**
    * Constructs an InvalidPropertiesFormatException with the specified
    * detail message.
    *
    * @param   message   the detail message. The detail message is saved for
    *          later retrieval by the {@link Throwable#getMessage()} method.
    */
    public InvalidPropertiesFormatException(String message) {
        super(message);
    }

    /**
     * Throws NotSerializableException, since InvalidPropertiesFormatException
     * objects are not intended to be serializable.
     */
    private void writeObject(java.io.ObjectOutputStream out)
        throws NotSerializableException
    {
        throw new NotSerializableException("Not serializable.");
    }

    /**
     * Throws NotSerializableException, since InvalidPropertiesFormatException
     * objects are not intended to be serializable.
     */
    private void readObject(java.io.ObjectInputStream in)
        throws NotSerializableException
    {
        throw new NotSerializableException("Not serializable.");
    }

}
