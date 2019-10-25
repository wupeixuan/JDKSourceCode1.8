/*
 * Copyright (c) 2000, 2013, Oracle and/or its affiliates. All rights reserved.
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

package javax.security.sasl;

import javax.security.auth.callback.Callback;

/**
  * This callback is used by {@code SaslServer} to determine whether
  * one entity (identified by an authenticated authentication id)
  * can act on
  * behalf of another entity (identified by an authorization id).
  *
  * @since 1.5
  *
  * @author Rosanna Lee
  * @author Rob Weltman
  */
public class AuthorizeCallback implements Callback, java.io.Serializable {
    /**
     * The (authenticated) authentication id to check.
     * @serial
     */
    private String authenticationID;

    /**
     * The authorization id to check.
     * @serial
     */
    private String authorizationID;

    /**
     * The id of the authorized entity. If null, the id of
     * the authorized entity is authorizationID.
     * @serial
     */
    private String authorizedID;

    /**
     * A flag indicating whether the authentication id is allowed to
     * act on behalf of the authorization id.
     * @serial
     */
    private boolean authorized;

    /**
     * Constructs an instance of {@code AuthorizeCallback}.
     *
     * @param authnID   The (authenticated) authentication id.
     * @param authzID   The authorization id.
     */
    public AuthorizeCallback(String authnID, String authzID) {
        authenticationID = authnID;
        authorizationID = authzID;
    }

    /**
     * Returns the authentication id to check.
     * @return The authentication id to check.
     */
    public String getAuthenticationID() {
        return authenticationID;
    }

    /**
     * Returns the authorization id to check.
     * @return The authentication id to check.
     */
    public String getAuthorizationID() {
        return authorizationID;
    }

    /**
     * Determines whether the authentication id is allowed to
     * act on behalf of the authorization id.
     *
     * @return {@code true} if authorization is allowed; {@code false} otherwise
     * @see #setAuthorized(boolean)
     * @see #getAuthorizedID()
     */
    public boolean isAuthorized() {
        return authorized;
    }

    /**
     * Sets whether the authorization is allowed.
     * @param ok {@code true} if authorization is allowed; {@code false} otherwise
     * @see #isAuthorized
     * @see #setAuthorizedID(java.lang.String)
     */
    public void setAuthorized(boolean ok) {
        authorized = ok;
    }

    /**
     * Returns the id of the authorized user.
     * @return The id of the authorized user. {@code null} means the
     * authorization failed.
     * @see #setAuthorized(boolean)
     * @see #setAuthorizedID(java.lang.String)
     */
    public String getAuthorizedID() {
        if (!authorized) {
            return null;
        }
        return (authorizedID == null) ? authorizationID : authorizedID;
    }

    /**
     * Sets the id of the authorized entity. Called by handler only when the id
     * is different from getAuthorizationID(). For example, the id
     * might need to be canonicalized for the environment in which it
     * will be used.
     * @param id The id of the authorized user.
     * @see #setAuthorized(boolean)
     * @see #getAuthorizedID
     */
    public void setAuthorizedID(String id) {
        authorizedID = id;
    }

    private static final long serialVersionUID = -2353344186490470805L;
}
