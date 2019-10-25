/*
 * Copyright (c) 2001, 2006, Oracle and/or its affiliates. All rights reserved.
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
package com.sun.jmx.snmp;
/**
 * This exception is thrown when a needed model is not present in the engine.
 * <p><b>This API is a Sun Microsystems internal API  and is subject
 * to change without notice.</b></p>
 * @since 1.5
 */
public class SnmpUnknownModelException extends Exception {
    private static final long serialVersionUID = -8667664269418048003L;

    /**
     * Constructor.
     * @param msg The exception msg to display.
     */
    public SnmpUnknownModelException(String msg) {
        super(msg);
    }
}
