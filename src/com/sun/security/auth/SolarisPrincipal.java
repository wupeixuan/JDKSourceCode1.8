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
 * and represents a Solaris user.
 *
 * <p> Principals such as this <code>SolarisPrincipal</code>
 * may be associated with a particular <code>Subject</code>
 * to augment that <code>Subject</code> with an additional
 * identity.  Refer to the <code>Subject</code> class for more information
 * on how to achieve this.  Authorization decisions can then be based upon
 * the Principals associated with a <code>Subject</code>.
 *
 * @deprecated As of JDK&nbsp;1.4, replaced by
 *             {@link UnixPrincipal}.
 *             This class is entirely deprecated.
 * @see java.security.Principal
 * @see javax.security.auth.Subject
 */
@jdk.Exported(false)
@Deprecated
public class SolarisPrincipal implements Principal, java.io.Serializable {

    private static final long serialVersionUID = -7840670002439379038L;

    private static final java.util.ResourceBundle rb =
          java.security.AccessController.doPrivileged
          (new java.security.PrivilegedAction<java.util.ResourceBundle>() {
              public java.util.ResourceBundle run() {
                  return (java.util.ResourceBundle.getBundle
                                ("sun.security.util.AuthResources"));
              }
          });


    /**
     * @serial
     */
    private String name;

    /**
     * Create a SolarisPrincipal with a Solaris username.
     *
     * <p>
     *
     * @param name the Unix username for this user.
     *
     * @exception NullPointerException if the <code>name</code>
     *                  is <code>null</code>.
     */
    public SolarisPrincipal(String name) {
        if (name == null)
            throw new NullPointerException(rb.getString("provided.null.name"));

        this.name = name;
    }

    /**
     * Return the Unix username for this <code>SolarisPrincipal</code>.
     *
     * <p>
     *
     * @return the Unix username for this <code>SolarisPrincipal</code>
     */
    public String getName() {
        return name;
    }

    /**
     * Return a string representation of this <code>SolarisPrincipal</code>.
     *
     * <p>
     *
     * @return a string representation of this <code>SolarisPrincipal</code>.
     */
    public String toString() {
        return(rb.getString("SolarisPrincipal.") + name);
    }

    /**
     * Compares the specified Object with this <code>SolarisPrincipal</code>
     * for equality.  Returns true if the given object is also a
     * <code>SolarisPrincipal</code> and the two SolarisPrincipals
     * have the same username.
     *
     * <p>
     *
     * @param o Object to be compared for equality with this
     *          <code>SolarisPrincipal</code>.
     *
     * @return true if the specified Object is equal equal to this
     *          <code>SolarisPrincipal</code>.
     */
    public boolean equals(Object o) {
        if (o == null)
            return false;

        if (this == o)
            return true;

        if (!(o instanceof SolarisPrincipal))
            return false;
        SolarisPrincipal that = (SolarisPrincipal)o;

        if (this.getName().equals(that.getName()))
            return true;
        return false;
    }

    /**
     * Return a hash code for this <code>SolarisPrincipal</code>.
     *
     * <p>
     *
     * @return a hash code for this <code>SolarisPrincipal</code>.
     */
    public int hashCode() {
        return name.hashCode();
    }
}
