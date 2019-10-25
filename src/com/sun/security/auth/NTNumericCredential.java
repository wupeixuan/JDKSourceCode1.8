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
 * <p> This class abstracts an NT security token
 * and provides a mechanism to do same-process security impersonation.
 *
 */

@jdk.Exported
public class NTNumericCredential {

    private long impersonationToken;

    /**
     * Create an <code>NTNumericCredential</code> with an integer value.
     *
     * <p>
     *
     * @param token the Windows NT security token for this user. <p>
     *
     */
    public NTNumericCredential(long token) {
        this.impersonationToken = token;
    }

    /**
     * Return an integer representation of this
     * <code>NTNumericCredential</code>.
     *
     * <p>
     *
     * @return an integer representation of this
     *          <code>NTNumericCredential</code>.
     */
    public long getToken() {
        return impersonationToken;
    }

    /**
     * Return a string representation of this <code>NTNumericCredential</code>.
     *
     * <p>
     *
     * @return a string representation of this <code>NTNumericCredential</code>.
     */
    public String toString() {
        java.text.MessageFormat form = new java.text.MessageFormat
                (sun.security.util.ResourcesMgr.getString
                        ("NTNumericCredential.name",
                        "sun.security.util.AuthResources"));
        Object[] source = {Long.toString(impersonationToken)};
        return form.format(source);
    }

    /**
     * Compares the specified Object with this <code>NTNumericCredential</code>
     * for equality.  Returns true if the given object is also a
     * <code>NTNumericCredential</code> and the two NTNumericCredentials
     * represent the same NT security token.
     *
     * <p>
     *
     * @param o Object to be compared for equality with this
     *          <code>NTNumericCredential</code>.
     *
     * @return true if the specified Object is equal equal to this
     *          <code>NTNumericCredential</code>.
     */
    public boolean equals(Object o) {
        if (o == null)
            return false;

        if (this == o)
            return true;

        if (!(o instanceof NTNumericCredential))
            return false;
        NTNumericCredential that = (NTNumericCredential)o;

        if (impersonationToken == that.getToken())
            return true;
        return false;
    }

    /**
     * Return a hash code for this <code>NTNumericCredential</code>.
     *
     * <p>
     *
     * @return a hash code for this <code>NTNumericCredential</code>.
     */
    public int hashCode() {
        return (int)this.impersonationToken;
    }
}
