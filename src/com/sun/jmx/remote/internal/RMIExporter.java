/*
 * Copyright (c) 2003, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.jmx.remote.internal;

import java.rmi.NoSuchObjectException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.RMIClientSocketFactory;
import java.rmi.server.RMIServerSocketFactory;
import java.rmi.server.UnicastRemoteObject;

/**
 * <p>Unpublished interface controlling how the RMI Connector Server
 * exports objects.  The RMIServerImpl object and each
 * RMIConnectionImpl object are exported using the exporter.  The
 * default exporter calls {@link
 * UnicastRemoteObject#exportObject(Remote, int,
 * RMIClientSocketFactory, RMIServerSocketFactory)} to export objects
 * and {@link UnicastRemoteObject#unexportObject(Remote, boolean)} to
 * unexport them.  A replacement exporter can be specified via the
 * {@link #EXPORTER_ATTRIBUTE} property in the environment Map passed
 * to the RMI connector server.</p>
 */
public interface RMIExporter {
    public static final String EXPORTER_ATTRIBUTE =
        "com.sun.jmx.remote.rmi.exporter";

    public Remote exportObject(Remote obj,
                               int port,
                               RMIClientSocketFactory csf,
                               RMIServerSocketFactory ssf)
            throws RemoteException;

    public boolean unexportObject(Remote obj, boolean force)
            throws NoSuchObjectException;
}
