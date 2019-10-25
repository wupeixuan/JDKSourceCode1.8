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


// java import
//
import java.util.Enumeration;
import java.net.InetAddress;

/**
 * Defines the user based ACL used by the SNMP protocol adaptor.
 * <p>
 * <p><b>This API is a Sun Microsystems internal API  and is subject
 * to change without notice.</b></p>
 * @since 1.5
 */

public interface UserAcl {

    /**
     * Returns the name of the ACL.
     *
     * @return The name of the ACL.
     */
    public String getName();

    /**
     * Checks whether or not the specified user has <CODE>READ</CODE> access.
     *
     * @param user The user name to check.
     *
     * @return <CODE>true</CODE> if the host has read permission, <CODE>false</CODE> otherwise.
     */
    public boolean checkReadPermission(String user);

    /**
     * Checks whether or not the specified user and context name have <CODE>READ</CODE> access.
     *
     * @param user The user name to check.
     * @param contextName The context name associated with the user.
     * @param securityLevel The request security level.
     * @return <CODE>true</CODE> if the pair (user, context) has read permission, <CODE>false</CODE> otherwise.
     */
    public boolean checkReadPermission(String user, String contextName, int securityLevel);

    /**
     * Checks whether or not a context name is defined.
     *
     * @param contextName The context name to check.
     *
     * @return <CODE>true</CODE> if the context is known, <CODE>false</CODE> otherwise.
     */
    public boolean checkContextName(String contextName);

    /**
     * Checks whether or not the specified user has <CODE>WRITE</CODE> access.
     *
     * @param user The user to check.
     *
     * @return <CODE>true</CODE> if the user has write permission, <CODE>false</CODE> otherwise.
     */
    public boolean checkWritePermission(String user);

    /**
     * Checks whether or not the specified user and context name have <CODE>WRITE</CODE> access.
     *
     * @param user The user name to check.
     * @param contextName The context name associated with the user.
     * @param securityLevel The request security level.
     * @return <CODE>true</CODE> if the pair (user, context) has write permission, <CODE>false</CODE> otherwise.
     */
    public boolean checkWritePermission(String user, String contextName, int securityLevel);
}
