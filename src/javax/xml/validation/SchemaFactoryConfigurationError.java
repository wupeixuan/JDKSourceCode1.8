/*
 * Copyright (c) 2013, Oracle and/or its affiliates. All rights reserved.
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

package javax.xml.validation;

/**
 * Thrown when a problem with configuration with the Schema Factories
 * exists. This error will typically be thrown when the class of a
 * schema factory specified in the system properties cannot be found
 * or instantiated.
 * @since 1.8
 */
public final class SchemaFactoryConfigurationError extends Error {

    static final long serialVersionUID = 3531438703147750126L;

    /**
     * Create a new <code>SchemaFactoryConfigurationError</code> with no
     * detail message.
     */
    public SchemaFactoryConfigurationError() {
    }


    /**
     * Create a new <code>SchemaFactoryConfigurationError</code> with
     * the <code>String</code> specified as an error message.
     *
     * @param message The error message for the exception.
     */
    public SchemaFactoryConfigurationError(String message) {
        super(message);
    }

    /**
     * Create a new <code>SchemaFactoryConfigurationError</code> with the
     * given <code>Throwable</code> base cause.
     *
     * @param cause The exception or error to be encapsulated in a
     * SchemaFactoryConfigurationError.
     */
    public SchemaFactoryConfigurationError(Throwable cause) {
        super(cause);
    }

    /**
     * Create a new <code>SchemaFactoryConfigurationError</code> with the
     * given <code>Throwable</code> base cause and detail message.
     *
     * @param cause The exception or error to be encapsulated in a
     * SchemaFactoryConfigurationError.
     * @param message The detail message.
     */
    public SchemaFactoryConfigurationError(String message, Throwable cause) {
        super(message, cause);
    }

}
