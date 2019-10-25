/*
 * Copyright (c) 1999, 2002, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.corba.se.impl.util;

/**
 * The vendor minor code ID reserved for Sun by the OMG.
 * All VMCIDs occupy the high order 20 bits.
 */

public interface SUNVMCID {

    /**
     * The vendor minor code ID reserved for Sun. This value is or'd with
     * the high order 20 bits of the minor code to produce the minor value
     * in a system exception.
     */
    static final int value = 0x53550000;
}
