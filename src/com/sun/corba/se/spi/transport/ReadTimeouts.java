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

package com.sun.corba.se.spi.transport;

public interface ReadTimeouts {
    public int get_initial_time_to_wait();
    public int get_max_time_to_wait();
    public double get_backoff_factor();
    public int get_max_giop_header_time_to_wait();
}

// End of file.
