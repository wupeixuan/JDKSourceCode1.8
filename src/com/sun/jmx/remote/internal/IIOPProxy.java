/*
 * Copyright (c) 2009, Oracle and/or its affiliates. All rights reserved.
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

import java.util.Properties;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.NoSuchObjectException;

/**
 * An interface to a subset of the RMI-IIOP and CORBA APIs to avoid a
 * static dependencies on the types defined by these APIs.
 */

public interface IIOPProxy {

    /**
     * Returns true if the given object is a Stub.
     */
    boolean isStub(Object obj);

    /**
     * Returns the Delegate to which the given Stub delegates.
     */
    Object getDelegate(Object stub);

    /**
     * Sets the Delegate for a given Stub.
     */
    void setDelegate(Object stub, Object delegate);

    /**
     * Returns the ORB associated with the given stub
     *
     * @throws  UnsupportedOperationException
     *          if the object does not support the operation that
     *          was invoked
     */
    Object getOrb(Object stub);

    /**
     * Connects the Stub to the given ORB.
     */
    void connect(Object stub, Object orb) throws RemoteException;

    /**
     * Returns true if the given object is an ORB.
     */
    boolean isOrb(Object obj);

    /**
     * Creates, and returns, a new ORB instance.
     */
    Object createOrb(String[] args, Properties props);

    /**
     * Converts a string, produced by the object_to_string method, back
     * to a CORBA object reference.
     */
    Object stringToObject(Object orb, String str);

    /**
     * Converts the given CORBA object reference to a string.
     */
    String objectToString(Object orb, Object obj);

    /**
     * Checks to ensure that an object of a remote or abstract interface
     * type can be cast to a desired type.
     */
    <T> T narrow(Object narrowFrom, Class<T> narrowTo);

    /**
     * Makes a server object ready to receive remote calls
     */
    void exportObject(Remote obj) throws RemoteException;

    /**
     * Deregisters a server object from the runtime.
     */
    void unexportObject(Remote obj) throws NoSuchObjectException;

    /**
     * Returns a stub for the given server object.
     */
    Remote toStub(Remote obj) throws NoSuchObjectException;
}
