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
 * <p> This class extends <code>NTSid</code>
 * and represents a Windows NT user's SID.
 *
 * <p> Principals such as this <code>NTSidUserPrincipal</code>
 * may be associated with a particular <code>Subject</code>
 * to augment that <code>Subject</code> with an additional
 * identity.  Refer to the <code>Subject</code> class for more information
 * on how to achieve this.  Authorization decisions can then be based upon
 * the Principals associated with a <code>Subject</code>.
 *
 * @see java.security.Principal
 * @see javax.security.auth.Subject
 */
@jdk.Exported
public class NTSidUserPrincipal extends NTSid {

    private static final long serialVersionUID = -5573239889517749525L;

    /**
     * Create an <code>NTSidUserPrincipal</code> with a Windows NT SID.
     *
     * <p>
     *
     * @param name a string version of the Windows NT SID for this user.<p>
     *
     * @exception NullPointerException if the <code>name</code>
     *                  is <code>null</code>.
     */
    public NTSidUserPrincipal(String name) {
        super(name);
    }

    /**
     * Return a string representation of this <code>NTSidUserPrincipal</code>.
     *
     * <p>
     *
     * @return a string representation of this <code>NTSidUserPrincipal</code>.
     */
    public String toString() {
        java.text.MessageFormat form = new java.text.MessageFormat
                (sun.security.util.ResourcesMgr.getString
                        ("NTSidUserPrincipal.name",
                        "sun.security.util.AuthResources"));
        Object[] source = {getName()};
        return form.format(source);
    }

    /**
     * Compares the specified Object with this <code>NTSidUserPrincipal</code>
     * for equality.  Returns true if the given object is also a
     * <code>NTSidUserPrincipal</code> and the two NTSidUserPrincipals
     * have the same SID.
     *
     * <p>
     *
     * @param o Object to be compared for equality with this
     *          <code>NTSidUserPrincipal</code>.
     *
     * @return true if the specified Object is equal equal to this
     *          <code>NTSidUserPrincipal</code>.
     */
    public boolean equals(Object o) {
            if (o == null)
                return false;

        if (this == o)
            return true;

        if (!(o instanceof NTSidUserPrincipal))
            return false;

        return super.equals(o);
    }
}
