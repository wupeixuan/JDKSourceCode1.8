/*
 * Copyright (c) 2003, 2007, Oracle and/or its affiliates. All rights reserved.
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

package javax.management.remote;

import java.security.Principal;
import javax.security.auth.Subject;

/**
 * <p>Interface to define how remote credentials are converted into a
 * JAAS Subject.  This interface is used by the RMI Connector Server,
 * and can be used by other connector servers.</p>
 *
 * <p>The user-defined authenticator instance is passed to the
 * connector server in the environment map as the value of the
 * attribute {@link JMXConnectorServer#AUTHENTICATOR}.  For connector
 * servers that use only this authentication system, if this attribute
 * is not present or its value is <code>null</code> then no user
 * authentication will be performed and full access to the methods
 * exported by the <code>MBeanServerConnection</code> object will be
 * allowed.</p>
 *
 * <p>If authentication is successful then an authenticated
 * {@link Subject subject} filled in with its associated
 * {@link Principal principals} is returned. Authorization checks
 * will be then performed based on the given set of principals.</p>
 *
 * @since 1.5
 */
public interface JMXAuthenticator {

    /**
     * <p>Authenticates the <code>MBeanServerConnection</code> client
     * with the given client credentials.</p>
     *
     * @param credentials the user-defined credentials to be passed
     * into the server in order to authenticate the user before
     * creating the <code>MBeanServerConnection</code>.  The actual
     * type of this parameter, and whether it can be null, depends on
     * the connector.
     *
     * @return the authenticated subject containing its associated principals.
     *
     * @exception SecurityException if the server cannot authenticate the user
     * with the provided credentials.
     */
    public Subject authenticate(Object credentials);
}
