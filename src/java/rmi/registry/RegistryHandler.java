/*
 * Copyright (c) 1997, 2004, Oracle and/or its affiliates. All rights reserved.
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

package java.rmi.registry;

import java.rmi.RemoteException;
import java.rmi.UnknownHostException;

/**
 * <code>RegistryHandler</code> is an interface used internally by the RMI
 * runtime in previous implementation versions.  It should never be accessed
 * by application code.
 *
 * @author  Ann Wollrath
 * @since   JDK1.1
 * @deprecated no replacement
 */
@Deprecated
public interface RegistryHandler {

    /**
     * Returns a "stub" for contacting a remote registry
     * on the specified host and port.
     *
     * @deprecated no replacement.  As of the Java 2 platform v1.2, RMI no
     * longer uses the <code>RegistryHandler</code> to obtain the registry's
     * stub.
     * @param host name of remote registry host
     * @param port remote registry port
     * @return remote registry stub
     * @throws RemoteException if a remote error occurs
     * @throws UnknownHostException if unable to resolve given hostname
     */
    @Deprecated
    Registry registryStub(String host, int port)
        throws RemoteException, UnknownHostException;

    /**
     * Constructs and exports a Registry on the specified port.
     * The port must be non-zero.
     *
     * @deprecated no replacement.  As of the Java 2 platform v1.2, RMI no
     * longer uses the <code>RegistryHandler</code> to obtain the registry's
     * implementation.
     * @param port port to export registry on
     * @return registry stub
     * @throws RemoteException if a remote error occurs
     */
    @Deprecated
    Registry registryImpl(int port) throws RemoteException;
}
