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
package com.sun.jmx.snmp.mpm;

import com.sun.jmx.snmp.SnmpSecurityParameters;
import com.sun.jmx.snmp.SnmpMsg;
/**
 * The translator interface is implemented by classes dealing with a specific SNMP protocol version. SnmpMsgTranslator are used in conjonction with SnmpMsgProcessingModel implementations.
 * <p><b>This API is a Sun Microsystems internal API  and is subject
 * to change without notice.</b></p>
 * @since 1.5
 */
public interface SnmpMsgTranslator {
    /**
     * Returns the request or message Id contained in the passed message. The message is a generic one that is narrowed in the object implementing this interface.
     */
    public int getMsgId(SnmpMsg msg);
    /**
     * Returns the response max message size. The message is a generic one that is narrowed in the object implementing this interface.
     */
    public int getMsgMaxSize(SnmpMsg msg);
    /**
     * Returns the message flags. The message is a generic one that is narrowed in the object implementing this interface.
     */
    public byte getMsgFlags(SnmpMsg msg);
    /**
     * Returns the message security model. The message is a generic one that is narrowed in the object implementing this interface.
     */
    public int getMsgSecurityModel(SnmpMsg msg);
    /**
     * Returns the message security level. The message is a generic one that is narrowed in the object implementing this interface.
     */
    public int getSecurityLevel(SnmpMsg msg);
     /**
     * Returns an encoded representation of security parameters contained in the passed msg. The message is a generic one that is narrowed in the object implementing this interface.
     */
    public byte[] getFlatSecurityParameters(SnmpMsg msg);
    /**
     * Returns the message security parameters. The message is a generic one that is narrowed in the object implementing this interface.
     */
    public SnmpSecurityParameters getSecurityParameters(SnmpMsg msg);
    /**
     * Returns the message context Engine Id. The message is a generic one that is narrowed in the object implementing this interface.
     */
    public byte[] getContextEngineId(SnmpMsg msg);
    /**
     * Returns the message context name. The message is a generic one that is narrowed in the object implementing this interface.
     */
    public byte[] getContextName(SnmpMsg msg);
    /**
     * Returns the raw message context name. Raw mean as it is received from the network, without translation. It can be useful when some data are piggy backed in the context name.The message is a generic one that is narrowed in the object implementing this interface.
     */
    public byte[] getRawContextName(SnmpMsg msg);
    /**
     * Returns the message accesscontext name. This access context name is used when dealing with access rights (eg: community for V1/V2 or context name for V3).The message is a generic one that is narrowed in the object implementing this interface.
     */
    public byte[] getAccessContext(SnmpMsg msg);
    /**
     * Returns the message encrypted pdu or null if no encryption. The message is a generic one that is narrowed in the object implementing this interface.
     */
    public byte[] getEncryptedPdu(SnmpMsg msg);
    /**
     * Set the context name of the passed message.
     */
    public void setContextName(SnmpMsg req, byte[] contextName);
     /**
     * Set the context engine Id of the passed message.
     */
    public void setContextEngineId(SnmpMsg req, byte[] contextEngineId);
}
