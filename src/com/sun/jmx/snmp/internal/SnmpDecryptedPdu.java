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
package com.sun.jmx.snmp.internal;
/**
 * Class returned by <CODE>SnmpSecuritySubSystem</CODE> and <CODE>SnmpSecurityModel</CODE>. If privacy is applied, the received pdu must be decrypted. This class contains the field of of a decrypted scoped pdu.
 * <p><b>This API is a Sun Microsystems internal API  and is subject
 * to change without notice.</b></p>
 * @since 1.5
 */

public class SnmpDecryptedPdu {
    /**
     * Decrypted pdu data.
     */
    public byte[] data = null;
    /**
     * Decrypted pdu data length.
     */
    public int dataLength = 0;
    /**
     * Decrypted context name.
     */
    public byte[] contextName = null;
    /**
     * Decrypted context engine Id.
     */
    public byte[] contextEngineId = null;
}
