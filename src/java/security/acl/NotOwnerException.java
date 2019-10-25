/*
 * Copyright (c) 1996, 2003, Oracle and/or its affiliates. All rights reserved.
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

package java.security.acl;

/**
 * This is an exception that is thrown whenever the modification of an object
 * (such as an Access Control List) is only allowed to be done by an owner of
 * the object, but the Principal attempting the modification is not an owner.
 *
 * @author      Satish Dharmaraj
 */
public class NotOwnerException extends Exception {

    private static final long serialVersionUID = -5555597911163362399L;

    /**
     * Constructs a NotOwnerException.
     */
    public NotOwnerException() {
    }
}
