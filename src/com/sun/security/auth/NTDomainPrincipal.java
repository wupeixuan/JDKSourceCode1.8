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

import java.security.Principal;

/**
 * <p> This class implements the <code>Principal</code> interface
 * and represents the name of the Windows NT domain into which the
 * user authenticated.  This will be a domain name if the user logged
 * into a Windows NT domain, a workgroup name if the user logged into
 * a workgroup, or a machine name if the user logged into a standalone
 * configuration.
 *
 * <p> Principals such as this <code>NTDomainPrincipal</code>
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
public class NTDomainPrincipal implements Principal, java.io.Serializable {

    private static final long serialVersionUID = -4408637351440771220L;

    /**
     * @serial
     */
    private String name;

    /**
     * Create an <code>NTDomainPrincipal</code> with a Windows NT domain name.
     *
     * <p>
     *
     * @param name the Windows NT domain name for this user. <p>
     *
     * @exception NullPointerException if the <code>name</code>
     *                  is <code>null</code>.
     */
    public NTDomainPrincipal(String name) {
        if (name == null) {
            java.text.MessageFormat form = new java.text.MessageFormat
                (sun.security.util.ResourcesMgr.getString
                        ("invalid.null.input.value",
                        "sun.security.util.AuthResources"));
            Object[] source = {"name"};
            throw new NullPointerException(form.format(source));
        }
        this.name = name;
    }

    /**
     * Return the Windows NT domain name for this
     * <code>NTDomainPrincipal</code>.
     *
     * <p>
     *
     * @return the Windows NT domain name for this
     *                  <code>NTDomainPrincipal</code>
     */
    public String getName() {
        return name;
    }

    /**
     * Return a string representation of this <code>NTDomainPrincipal</code>.
     *
     * <p>
     *
     * @return a string representation of this <code>NTDomainPrincipal</code>.
     */
    public String toString() {
        java.text.MessageFormat form = new java.text.MessageFormat
                (sun.security.util.ResourcesMgr.getString
                        ("NTDomainPrincipal.name",
                        "sun.security.util.AuthResources"));
        Object[] source = {name};
        return form.format(source);
    }

    /**
     * Compares the specified Object with this <code>NTDomainPrincipal</code>
     * for equality.  Returns true if the given object is also a
     * <code>NTDomainPrincipal</code> and the two NTDomainPrincipals
     * have the same name.
     *
     * <p>
     *
     * @param o Object to be compared for equality with this
     *          <code>NTDomainPrincipal</code>.
     *
     * @return true if the specified Object is equal equal to this
     *          <code>NTDomainPrincipal</code>.
     */
    public boolean equals(Object o) {
        if (o == null)
                return false;

        if (this == o)
            return true;

        if (!(o instanceof NTDomainPrincipal))
            return false;
        NTDomainPrincipal that = (NTDomainPrincipal)o;

            if (name.equals(that.getName()))
                return true;
            return false;
    }

    /**
     * Return a hash code for this <code>NTDomainPrincipal</code>.
     *
     * <p>
     *
     * @return a hash code for this <code>NTDomainPrincipal</code>.
     */
    public int hashCode() {
        return this.getName().hashCode();
    }
}
