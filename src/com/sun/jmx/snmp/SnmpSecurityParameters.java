/*
 * Copyright (c) 2001, 2003, Oracle and/or its affiliates. All rights reserved.
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
import com.sun.jmx.snmp.SnmpStatusException;
import com.sun.jmx.snmp.SnmpTooBigException;

/**
 * Security parameters are security model dependent. Every security parameters class wishing to be passed to a security model must implement this marker interface.
 * This interface has to be implemented when developing customized security models.
 * <p><b>This API is a Sun Microsystems internal API  and is subject
 * to change without notice.</b></p>
 * @since 1.5
 */
public interface SnmpSecurityParameters {
    /**
     * BER encoding of security parameters.
     * @param outputBytes Array to fill.
     * @return Encoded parameters length.
     */
    int encode(byte[] outputBytes) throws SnmpTooBigException;
    /**
     * BER decoding of security parameters.
     * @param params Encoded parameters.
     */
    void decode(byte[] params) throws SnmpStatusException;

    /**
     * Principal coded inside the security parameters.
     * @return The security principal.
     */
    String getPrincipal();
}
