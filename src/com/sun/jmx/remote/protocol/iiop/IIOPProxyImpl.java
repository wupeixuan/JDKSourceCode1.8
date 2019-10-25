/*
 * Copyright (c) 2009,2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.jmx.remote.protocol.iiop;

import org.omg.CORBA.ORB;
import org.omg.CORBA.portable.Delegate;
import javax.rmi.PortableRemoteObject;
import javax.rmi.CORBA.Stub;

import java.util.Properties;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.NoSuchObjectException;

import com.sun.jmx.remote.internal.IIOPProxy;
import java.io.SerializablePermission;
import java.security.AccessControlContext;
import java.security.AccessController;
import java.security.Permissions;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.security.ProtectionDomain;

/**
 * An implementation of IIOPProxy that simply delegates to the appropriate
 * RMI-IIOP and CORBA APIs.
 */

public class IIOPProxyImpl implements IIOPProxy {
    // special ACC used to initialize the IIOP stub
    // the only allowed privilege is SerializablePermission("enableSubclassImplementation")
    private static final AccessControlContext STUB_ACC;

    static {
        Permissions p = new Permissions();
        p.add(new SerializablePermission("enableSubclassImplementation"));
        STUB_ACC = new AccessControlContext(
            new ProtectionDomain[]{
                new ProtectionDomain(null, p)
            }
        );
    }

    public IIOPProxyImpl() { }

    @Override
    public boolean isStub(Object obj) {
        return (obj instanceof Stub);
    }

    @Override
    public Object getDelegate(Object stub) {
        return ((Stub)stub)._get_delegate();
    }

    @Override
    public void setDelegate(Object stub, Object delegate) {
        ((Stub)stub)._set_delegate((Delegate)delegate);
    }

    @Override
    public Object getOrb(Object stub) {
        try {
            return ((Stub)stub)._orb();
        } catch (org.omg.CORBA.BAD_OPERATION x) {
            throw new UnsupportedOperationException(x);
        }
    }

    @Override
    public void connect(Object stub, Object orb)
        throws RemoteException
    {
        ((Stub)stub).connect((ORB)orb);
    }

    @Override
    public boolean isOrb(Object obj) {
        return (obj instanceof ORB);
    }

    @Override
    public Object createOrb(String[] args, Properties props) {
        return ORB.init(args, props);
    }

    @Override
    public Object stringToObject(Object orb, String str) {
        return ((ORB)orb).string_to_object(str);
    }

    @Override
    public String objectToString(Object orb, Object obj) {
        return ((ORB)orb).object_to_string((org.omg.CORBA.Object)obj);
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T narrow(Object narrowFrom, Class<T> narrowTo) {
        return (T)PortableRemoteObject.narrow(narrowFrom, narrowTo);
    }

    @Override
    public void exportObject(Remote obj) throws RemoteException {
        PortableRemoteObject.exportObject(obj);
    }

    @Override
    public void unexportObject(Remote obj) throws NoSuchObjectException {
        PortableRemoteObject.unexportObject(obj);
    }

    @Override
    public Remote toStub(final Remote obj) throws NoSuchObjectException {
        if (System.getSecurityManager() == null) {
            return PortableRemoteObject.toStub(obj);
        } else {
            try {
                return AccessController.doPrivileged(new PrivilegedExceptionAction<Remote>() {

                    @Override
                    public Remote run() throws Exception {
                        return PortableRemoteObject.toStub(obj);
                    }
                }, STUB_ACC);
            } catch (PrivilegedActionException e) {
                if (e.getException() instanceof NoSuchObjectException) {
                    throw (NoSuchObjectException)e.getException();
                }
                throw new RuntimeException("Unexpected exception type", e.getException());
            }
        }
    }
}
