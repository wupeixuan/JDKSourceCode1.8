/*
 * Copyright (c) 2002, 2007, Oracle and/or its affiliates. All rights reserved.
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


package javax.management.remote;

import java.io.IOException;

/**
 * <p>Exception thrown by {@link JMXConnectorFactory} and
 * {@link JMXConnectorServerFactory} when a provider exists for
 * the required protocol but cannot be used for some reason.</p>
 *
 * @see JMXConnectorFactory#newJMXConnector
 * @see JMXConnectorServerFactory#newJMXConnectorServer
 * @since 1.5
 */
public class JMXProviderException extends IOException {

    private static final long serialVersionUID = -3166703627550447198L;

    /**
     * <p>Constructs a <code>JMXProviderException</code> with no
     * specified detail message.</p>
     */
    public JMXProviderException() {
    }

    /**
     * <p>Constructs a <code>JMXProviderException</code> with the
     * specified detail message.</p>
     *
     * @param message the detail message
     */
    public JMXProviderException(String message) {
        super(message);
    }

    /**
     * <p>Constructs a <code>JMXProviderException</code> with the
     * specified detail message and nested exception.</p>
     *
     * @param message the detail message
     * @param cause the nested exception
     */
    public JMXProviderException(String message, Throwable cause) {
        super(message);
        this.cause = cause;
    }

    public Throwable getCause() {
        return cause;
    }

    /**
     * @serial An exception that caused this exception to be thrown.
     *         This field may be null.
     * @see #getCause()
     **/
    private Throwable cause = null;
}
