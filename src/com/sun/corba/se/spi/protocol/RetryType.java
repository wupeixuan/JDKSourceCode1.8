/*
 * Copyright (c) 2010, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.corba.se.spi.protocol ;

// Introduce more information about WHY we are re-trying a request
// so we can properly handle the two cases:
// - BEFORE_RESPONSE means that the retry is caused by
//   something that happened BEFORE the message was sent: either
//   an exception from the SocketFactory, or one from the
//   Client side send_request interceptor point.
// - AFTER_RESPONSE means that the retry is a result either of the
//   request sent to the server (from the response), or from the
//   Client side receive_xxx interceptor point.
public enum RetryType {
    NONE( false ),
    BEFORE_RESPONSE( true ),
    AFTER_RESPONSE( true ) ;

    private final boolean isRetry ;

    RetryType( boolean isRetry ) {
        this.isRetry = isRetry ;
    }

    public boolean isRetry() {
        return this.isRetry ;
    }
} ;

