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

// imports for javadoc
import javax.management.MBeanServer;

/**
 * Exception thrown as the result of a remote {@link MBeanServer}
 * method invocation when an <code>Error</code> is thrown while
 * processing the invocation in the remote MBean server.  A
 * <code>JMXServerErrorException</code> instance contains the original
 * <code>Error</code> that occurred as its cause.
 *
 * @see java.rmi.ServerError
 * @since 1.5
 */
public class JMXServerErrorException extends IOException {

    private static final long serialVersionUID = 3996732239558744666L;

    /**
     * Constructs a <code>JMXServerErrorException</code> with the specified
     * detail message and nested error.
     *
     * @param s the detail message.
     * @param err the nested error.  An instance of this class can be
     * constructed where this parameter is null, but the standard
     * connectors will never do so.
     */
    public JMXServerErrorException(String s, Error err) {
        super(s);
        cause = err;
    }

    public Throwable getCause() {
        return cause;
    }

    /**
     * @serial An {@link Error} that caused this exception to be thrown.
     * @see #getCause()
     **/
    private final Error cause;
}
