/*
 * Copyright (c) 1999, 2007, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.jmx.snmp.daemon;

// java import
//
import java.io.PrintStream;
import java.io.PrintWriter;

/**
 * Represents exceptions raised due to communications problems,
 * for example when a managed object server is out of reach.<p>
 *
 * <p><b>This API is a Sun Microsystems internal API  and is subject
 * to change without notice.</b></p>
 */

public class CommunicationException extends javax.management.JMRuntimeException {

    /* Serial version */
    private static final long serialVersionUID = -2499186113233316177L;

    /**
     * Constructs a CommunicationException with a target exception.
     */
    public CommunicationException(Throwable target) {
        super(target.getMessage());
        initCause(target);
    }

    /**
     * Constructs a CommunicationException with a target exception
     * and a detail message.
     */
    public CommunicationException(Throwable target, String msg) {
        super(msg);
        initCause(target);
    }

    /**
     * Constructs a CommunicationException with a detail message.
     */
    public CommunicationException(String msg) {
        super(msg);
    }

    /**
     * Get the thrown target exception.
     */
    public Throwable getTargetException() {
        return getCause();
    }

}
