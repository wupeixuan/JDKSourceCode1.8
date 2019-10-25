/*
 * Copyright (c) 2002, 2006, Oracle and/or its affiliates. All rights reserved.
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

import java.io.Serializable;

/**
 * This class is used to pass some specific parameters to an <CODE>
 * SnmpEngineFactory </CODE>.
 *
 * <p><b>This API is a Sun Microsystems internal API  and is subject
 * to change without notice.</b></p>
 * @since 1.5
 */
public class SnmpEngineParameters implements Serializable {
    private static final long serialVersionUID = 3720556613478400808L;

    private UserAcl uacl = null;
    private String securityFile = null;
    private boolean encrypt = false;
    private SnmpEngineId engineId = null;

    /**
     * Sets the file to use for SNMP Runtime Lcd. If no file is provided, the default location will be checked.
     */
    public void setSecurityFile(String securityFile) {
        this.securityFile = securityFile;
    }

    /**
     * Gets the file to use for SNMP Runtime Lcd.
     * @return The security file.
     */
    public String getSecurityFile() {
        return securityFile;
    }
    /**
     * Sets a customized user ACL. User Acl is used in order to check
     * access for SNMP V3 requests. If no ACL is provided,
     * <CODE>com.sun.jmx.snmp.usm.UserAcl.UserAcl</CODE> is instantiated.
     * @param uacl The user ACL to use.
     */
    public void setUserAcl(UserAcl uacl) {
        this.uacl = uacl;
    }

    /**
     * Gets the customized user ACL.
     * @return The customized user ACL.
     */
    public UserAcl getUserAcl() {
        return uacl;
    }

    /**
     * Activate SNMP V3 encryption. By default the encryption is not activated. Be sure that the security provider classes needed for DES are in your classpath (eg:JCE classes)
     *
     */
    public void activateEncryption() {
        this.encrypt = true;
    }

    /**
     * Deactivate SNMP V3 encryption. By default the encryption is not activated. Be sure that the security provider classes needed for DES are in your classpath (eg:JCE classes)
     *
     */
    public void deactivateEncryption() {
        this.encrypt = false;
    }

    /**
     * Check if encryption is activated. By default the encryption is not activated.
     * @return The encryption activation status.
     */
    public boolean isEncryptionEnabled() {
        return encrypt;
    }

    /**
     * Set the engine Id.
     * @param engineId The engine Id to use.
     */
    public void setEngineId(SnmpEngineId engineId) {
        this.engineId = engineId;
    }

    /**
     * Get the engine Id.
     * @return The engineId.
     */
    public SnmpEngineId getEngineId() {
        return engineId;
    }
}
