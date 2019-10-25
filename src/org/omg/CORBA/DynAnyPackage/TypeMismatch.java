/*
 * Copyright (c) 1998, 1999, Oracle and/or its affiliates. All rights reserved.
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


package org.omg.CORBA.DynAnyPackage;

/**
 * TypeMismatch is thrown by dynamic any accessor methods when
 * type of the actual contents do not match what is trying to be
 * accessed.
 */
public final class TypeMismatch
    extends org.omg.CORBA.UserException {

    /**
     * Constructs a <code>TypeMismatch</code> object.
     */
    public TypeMismatch() {
        super();
    }

    /**
     * Constructs a <code>TypeMismatch</code> object.
     * @param reason  a <code>String</code> giving more information
     * regarding the exception.
     */
    public TypeMismatch(String reason) {
        super(reason);
    }
}
