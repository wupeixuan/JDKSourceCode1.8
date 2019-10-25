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

import com.sun.jmx.snmp.SnmpSecurityException;
import com.sun.jmx.snmp.SnmpStatusException;
import com.sun.jmx.snmp.SnmpTooBigException;
import com.sun.jmx.snmp.SnmpSecurityParameters;

/**
 * Security model interface. Any security model implementation must implement this interface in order to be integrated in the engine framework. Security models are called when SNMP messages are received or sent. They deal with security (authentication and privacy).
 * <p><b>This API is a Sun Microsystems internal API  and is subject
 * to change without notice.</b></p>
 * @since 1.5
 */
public interface SnmpSecurityModel extends SnmpModel {
    /**
     * Called when a request is to be sent to the network. It must be securized.
     * <BR>The specified parameters are defined in RFC 2572 (see also the {@link com.sun.jmx.snmp.SnmpV3Message} class).
     * @param cache The cache that has been created by calling <CODE>createSecurityCache</CODE> on this model.
     * @param version The SNMP protocol version.
     * @param msgID The current request id.
     * @param msgMaxSize The message max size.
     * @param msgFlags The message flags (reportable, Auth and Priv).
     * @param msgSecurityModel This current security model.
     * @param params The security parameters that contain the model dependant parameters.
     * @param contextEngineID The context engine ID.
     * @param contextName The context name.
     * @param data The marshalled varbind list.
     * @param dataLength The marshalled varbind list length.
     * @param outputBytes The buffer to fill with securized request. This is a representation independant marshalled format. This buffer will be sent to the network.
     * @return The marshalled byte number.
     */
    public int generateRequestMsg(SnmpSecurityCache cache,
                                  int version,
                                  int msgID,
                                  int msgMaxSize,
                                  byte msgFlags,
                                  int msgSecurityModel,
                                  SnmpSecurityParameters params,
                                  byte[] contextEngineID,
                                  byte[] contextName,
                                  byte[] data,
                                  int dataLength,
                                  byte[] outputBytes)
        throws SnmpTooBigException, SnmpStatusException,
               SnmpSecurityException;

    /**
     * Called when a response is to be sent to the network. It must be securized.
     * <BR>The specified parameters are defined in RFC 2572 (see also the {@link com.sun.jmx.snmp.SnmpV3Message} class).
     * @param cache The cache that has been created by calling <CODE>createSecurityCache</CODE> on this model.
     * @param version The SNMP protocol version.
     * @param msgID The current request id.
     * @param msgMaxSize The message max size.
     * @param msgFlags The message flags (reportable, Auth and Priv)
     * @param msgSecurityModel This current security model.
     * @param params The security parameters that contain the model dependant parameters.
     * @param contextEngineID The context engine ID.
     * @param contextName The context name.
     * @param data The marshalled varbind list.
     * @param dataLength The marshalled varbind list length.
     * @param outputBytes The buffer to fill with securized request. This is a representation independant marshalled format. This buffer will be sent to the network.
     * @return The marshalled byte number.
     */
    public int generateResponseMsg(SnmpSecurityCache cache,
                                   int version,
                                   int msgID,
                                   int msgMaxSize,
                                   byte msgFlags,
                                   int msgSecurityModel,
                                   SnmpSecurityParameters params,
                                   byte[] contextEngineID,
                                   byte[] contextName,
                                   byte[] data,
                                   int dataLength,
                                   byte[] outputBytes)
        throws SnmpTooBigException, SnmpStatusException,
               SnmpSecurityException;
    /**
     * Called when a request is received from the network. It handles authentication and privacy.
     * <BR>The specified parameters are defined in RFC 2572 (see also the {@link com.sun.jmx.snmp.SnmpV3Message} class).
     * @param cache The cache that has been created by calling <CODE>createSecurityCache</CODE> on this model.
     * @param version The SNMP protocol version.
     * @param msgID The current request id.
     * @param msgMaxSize The message max size.
     * @param msgFlags The message flags (reportable, Auth and Priv)
     * @param msgSecurityModel This current security model.
     * @param params The security parameters in a marshalled format. The informations contained in this array are model dependant.
     * @param contextEngineID The context engine ID or null if encrypted.
     * @param contextName The context name or null if encrypted.
     * @param data The marshalled varbind list or null if encrypted
     * @param encryptedPdu The encrypted pdu or null if not encrypted.
     * @param decryptedPdu The decrypted pdu. If no decryption is to be done, the passed context engine ID, context name and data could be used to fill this object.
     * @return The decoded security parameters.

     */
    public SnmpSecurityParameters
        processIncomingRequest(SnmpSecurityCache cache,
                               int version,
                               int msgID,
                               int msgMaxSize,
                               byte msgFlags,
                               int msgSecurityModel,
                               byte[] params,
                               byte[] contextEngineID,
                               byte[] contextName,
                               byte[] data,
                               byte[] encryptedPdu,
                               SnmpDecryptedPdu decryptedPdu)
        throws SnmpStatusException, SnmpSecurityException;
 /**
     * Called when a response is received from the network. It handles authentication and privacy.
     * <BR>The specified parameters are defined in RFC 2572 (see also the {@link com.sun.jmx.snmp.SnmpV3Message} class).
     * @param cache The cache that has been created by calling <CODE>createSecurityCache</CODE> on this model.
     * @param version The SNMP protocol version.
     * @param msgID The current request id.
     * @param msgMaxSize The message max size.
     * @param msgFlags The message flags (reportable, Auth and Priv)
     * @param msgSecurityModel This current security model.
     * @param params The security parameters in a marshalled format. The informations cointained in this array are model dependant.
     * @param contextEngineID The context engine ID or null if encrypted.
     * @param contextName The context name or null if encrypted.
     * @param data The marshalled varbind list or null if encrypted
     * @param encryptedPdu The encrypted pdu or null if not encrypted.
     * @param decryptedPdu The decrypted pdu. If no decryption is to be done, the passed context engine ID, context name and data could be used to fill this object.
     * @return The security parameters.

     */
    public SnmpSecurityParameters processIncomingResponse(SnmpSecurityCache cache,
                                                          int version,
                                                          int msgID,
                                                          int msgMaxSize,
                                                          byte msgFlags,
                                                          int msgSecurityModel,
                                                          byte[] params,
                                                          byte[] contextEngineID,
                                                          byte[] contextName,
                                                          byte[] data,
                                                          byte[] encryptedPdu,
                                                          SnmpDecryptedPdu decryptedPdu)
        throws SnmpStatusException, SnmpSecurityException;

    /**
     * Instantiate an <CODE>SnmpSecurityCache</CODE> that is dependant to the model implementation.
     * @return The model dependant security cache.
     */
    public SnmpSecurityCache createSecurityCache();
    /**
     * Release the previously created cache.
     * @param cache The security cache to release.
     */
    public void releaseSecurityCache(SnmpSecurityCache cache);
}
