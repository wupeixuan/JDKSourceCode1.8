/*
 * Copyright (c) 1997, 1999, Oracle and/or its affiliates. All rights reserved.
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

package org.omg.CORBA.TypeCodePackage;

/**
 * Provides the <code>TypeCode</code> operations <code>member_name()</code>,
 * <code>member_type()</code>, and <code>member_label</code>.
 * These methods
 * raise <code>Bounds</code> when the index parameter is greater than or equal
 * to the number of members constituting the type.
 *
 * @since   JDK1.2
 */

public final class Bounds extends org.omg.CORBA.UserException {

    /**
     * Constructs a <code>Bounds</code> exception with no reason message.
     */
    public Bounds() {
        super();
    }

    /**
     * Constructs a <code>Bounds</code> exception with the specified
     * reason message.
     * @param reason the String containing a reason message
     */
    public Bounds(String reason) {
        super(reason);
    }
}
