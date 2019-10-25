/*
 * Copyright (c) 2009, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.security.jgss;

/**
 * Attribute types that can be specified as an argument of
 * {@link com.sun.security.jgss.ExtendedGSSContext#inquireSecContext}
 */
@jdk.Exported
public enum InquireType {
    /**
     * Attribute type for retrieving the session key of an
     * established Kerberos 5 security context.
     */
    KRB5_GET_SESSION_KEY,
    /**
     * Attribute type for retrieving the service ticket flags of an
     * established Kerberos 5 security context.
     */
    KRB5_GET_TKT_FLAGS,
    /**
     * Attribute type for retrieving the authorization data in the
     * service ticket of an established Kerberos 5 security context.
     * Only supported on the acceptor side.
     */
    KRB5_GET_AUTHZ_DATA,
    /**
     * Attribute type for retrieving the authtime in the service ticket
     * of an established Kerberos 5 security context.
     */
    KRB5_GET_AUTHTIME
}
