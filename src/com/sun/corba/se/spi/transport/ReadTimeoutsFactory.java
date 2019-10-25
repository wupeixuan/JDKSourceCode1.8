/*
 * Copyright (c) 2004, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.corba.se.spi.transport ;

import com.sun.corba.se.spi.transport.ReadTimeouts;

public interface ReadTimeoutsFactory {
   // create transport read timeouts
   public ReadTimeouts create(int initial_wait_time,
                              int max_wait_time,
                              int max_giop_hdr_wait_time,
                              int backoff_percent_factor);
}
