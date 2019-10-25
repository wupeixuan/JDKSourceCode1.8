/*
 * Copyright (c) 1999, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.security.auth;

/**
 * An object that implements the <code>java.security.Principal</code>
 * interface typically also implements this interface to provide
 * a means for comparing that object to a specified <code>Subject</code>.
 *
 * <p> The comparison is achieved via the <code>implies</code> method.
 * The implementation of the <code>implies</code> method determines
 * whether this object "implies" the specified <code>Subject</code>.
 * One example application of this method may be for
 * a "group" object to imply a particular <code>Subject</code>
 * if that <code>Subject</code> belongs to the group.
 * Another example application of this method would be for
 * "role" object to imply a particular <code>Subject</code>
 * if that <code>Subject</code> is currently acting in that role.
 *
 * <p> Although classes that implement this interface typically
 * also implement the <code>java.security.Principal</code> interface,
 * it is not required.  In other words, classes may implement the
 * <code>java.security.Principal</code> interface by itself,
 * the <code>PrincipalComparator</code> interface by itself,
 * or both at the same time.
 *
 * @see java.security.Principal
 * @see javax.security.auth.Subject
 */
@jdk.Exported
public interface PrincipalComparator {
    /**
     * Check if the specified <code>Subject</code> is implied by
     * this object.
     *
     * <p>
     *
     * @return true if the specified <code>Subject</code> is implied by
     *          this object, or false otherwise.
     */
    boolean implies(javax.security.auth.Subject subject);
}
