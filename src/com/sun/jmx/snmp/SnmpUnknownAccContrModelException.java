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

import com.sun.jmx.snmp.SnmpUnknownModelException;

/**
 * This exception is thrown when an
 * <CODE>SnmpAccessControlSubSystem</CODE> doesn't know the passed ID.
 *
 * <p><b>This API is a Sun Microsystems internal API  and is subject
 * to change without notice.</b></p>
 * @since 1.5
 */
public class SnmpUnknownAccContrModelException extends SnmpUnknownModelException {
    private static final long serialVersionUID = -8831186713954487538L;

    /**
     * Constructor.
     * @param msg The exception msg to display.
     */
    public SnmpUnknownAccContrModelException(String msg) {
        super(msg);
    }
}
