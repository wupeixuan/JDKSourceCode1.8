/*
 * Copyright (c) 2002, Oracle and/or its affiliates. All rights reserved.
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

package org.omg.CORBA.portable;

/**
 * Java to IDL ptc 02-01-12 1.5.1.4
 *
 * ValueInputStream is used for implementing RMI-IIOP
 * stream format version 2.
 */
public interface ValueInputStream {

    /**
     * The start_value method reads a valuetype
     * header for a nested custom valuetype and
     * increments the valuetype nesting depth.
     */
    void start_value();

    /**
     * The end_value method reads the end tag
     * for the nested custom valuetype (after
     * skipping any data that precedes the end
     * tag) and decrements the valuetype nesting
     * depth.
     */
    void end_value();
}
