/*
 *
 * Copyright (c) 2007, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
// Copyright (c) 1995-96 by Cisco Systems, Inc.

package com.sun.jmx.snmp.daemon;

/**
 * A static instance of this class is usually created.  It contains a
 * counter that is incremented every time it is accessed.  For example,
 * this class can be used in <CODE>SnmpSession</CODE> to generate a request
 * identifier that is used to identify a message in a client-server session.
 * The class wraps around when it reaches the maximum positive value, 2^31 - 1.
 */

final class SnmpRequestCounter {
        /**
         * A counter with value between 1...2^31-1.
         */
        int reqid = 0 ;

        public SnmpRequestCounter() {}

        /**
         * Returns the next request identifier.
         * @return next request identifier.  The value wraps to 1 if it reaches negative value.
         */
        public synchronized int getNewId() {
                if (++reqid  < 0)
                        reqid = 1 ;
                return reqid ;
        }
}
