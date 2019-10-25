/*
 * Copyright (c) 2000, 2001, Oracle and/or its affiliates. All rights reserved.
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
package java.net;

/**
 * Constants used by the SOCKS protocol implementation.
 */

interface SocksConsts {
    static final int PROTO_VERS4                = 4;
    static final int PROTO_VERS         = 5;
    static final int DEFAULT_PORT               = 1080;

    static final int NO_AUTH            = 0;
    static final int GSSAPI             = 1;
    static final int USER_PASSW         = 2;
    static final int NO_METHODS         = -1;

    static final int CONNECT            = 1;
    static final int BIND                       = 2;
    static final int UDP_ASSOC          = 3;

    static final int IPV4                       = 1;
    static final int DOMAIN_NAME                = 3;
    static final int IPV6                       = 4;

    static final int REQUEST_OK         = 0;
    static final int GENERAL_FAILURE    = 1;
    static final int NOT_ALLOWED                = 2;
    static final int NET_UNREACHABLE    = 3;
    static final int HOST_UNREACHABLE   = 4;
    static final int CONN_REFUSED               = 5;
    static final int TTL_EXPIRED                = 6;
    static final int CMD_NOT_SUPPORTED  = 7;
    static final int ADDR_TYPE_NOT_SUP  = 8;
}
