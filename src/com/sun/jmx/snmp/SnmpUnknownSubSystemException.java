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
 * This exception is thrown when the handled <CODE> SnmpSubSystem </CODE> is unknown.
 * <p><b>This API is a Sun Microsystems internal API  and is subject
 * to change without notice.</b></p>
 * @since 1.5
 */
public class SnmpUnknownSubSystemException extends Exception {
    private static final long serialVersionUID = 4463202140045245052L;

    /**
     * Constructor.
     * @param msg The exception msg to display.
     */
    public SnmpUnknownSubSystemException(String msg) {
        super(msg);
    }
}
