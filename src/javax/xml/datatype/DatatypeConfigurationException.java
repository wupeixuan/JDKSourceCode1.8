/*
 * Copyright (c) 2004, 2005, Oracle and/or its affiliates. All rights reserved.
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

package javax.xml.datatype;

/**
 * <p>Indicates a serious configuration error.</p>
 *
 * @author <a href="mailto:Jeff.Suttor@Sun.com">Jeff Suttor</a>
 * @since 1.5
 */

public class DatatypeConfigurationException extends Exception {

    /**
     * <p>Create a new <code>DatatypeConfigurationException</code> with
     * no specified detail mesage and cause.</p>
     */

    public DatatypeConfigurationException() {
        super();
    }

    /**
     * <p>Create a new <code>DatatypeConfigurationException</code> with
         * the specified detail message.</p>
     *
         * @param message The detail message.
     */

    public DatatypeConfigurationException(String message) {
        super(message);
    }

        /**
         * <p>Create a new <code>DatatypeConfigurationException</code> with
         * the specified detail message and cause.</p>
         *
         * @param message The detail message.
         * @param cause The cause.  A <code>null</code> value is permitted, and indicates that the cause is nonexistent or unknown.
         */

        public DatatypeConfigurationException(String message, Throwable cause) {
                super(message, cause);
        }

        /**
         * <p>Create a new <code>DatatypeConfigurationException</code> with
         * the specified cause.</p>
         *
         * @param cause The cause.  A <code>null</code> value is permitted, and indicates that the cause is nonexistent or unknown.
         */

        public DatatypeConfigurationException(Throwable cause) {
                super(cause);
        }
}
