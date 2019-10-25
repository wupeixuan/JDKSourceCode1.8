/*
 * Copyright (c) 2002, 2003, Oracle and/or its affiliates. All rights reserved.
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
 * This <CODE>SnmpEngineFactory</CODE> is instantiating an <CODE>SnmpEngine</CODE> containing :
 * <ul>
 * <li> Message Processing Sub System + V1, V2 et V3 Message Processing Models</li>
 * <li> Security Sub System + User based Security Model (Id 3)</li>
 * <li> Access Control Sub System + Ip Acl + User based Access Control Model. See <CODE> IpAcl </CODE> and <CODE> UserAcl </CODE>.</li>
 * </ul>
 *
 * <p><b>This API is a Sun Microsystems internal API  and is subject
 * to change without notice.</b></p>
 * @since 1.5
 */
public interface SnmpEngineFactory {
    /**
     * The engine instantiation method.
     * @param p The parameters used to instantiate a new engine.
     * @throws IllegalArgumentException Throwed if one of the configuration file file doesn't exist (Acl files, security file).
     * @return The newly created SnmpEngine.
     */
    public SnmpEngine createEngine(SnmpEngineParameters p);

    /**
     * The engine instantiation method.
     * @param p The parameters used to instantiate a new engine.
     * @param ipacl The Ip ACL to pass to the Access Control Model.
     * @throws IllegalArgumentException Throwed if one of the configuration
     *         file file doesn't exist (Acl files, security file).
     * @return The newly created SnmpEngine.
     */
    public SnmpEngine createEngine(SnmpEngineParameters p,
                                   InetAddressAcl ipacl);
}
