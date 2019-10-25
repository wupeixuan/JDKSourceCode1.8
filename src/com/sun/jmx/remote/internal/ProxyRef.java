/*
 * Copyright (c) 2003, 2008, Oracle and/or its affiliates. All rights reserved.
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

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.lang.reflect.Method;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.RemoteObject;
import java.rmi.server.RemoteRef;


@SuppressWarnings("deprecation")
public class ProxyRef implements RemoteRef {
    private static final long serialVersionUID = -6503061366316814723L;

    public ProxyRef(RemoteRef ref) {
        this.ref = ref;
    }

    public void readExternal(ObjectInput in)
            throws IOException, ClassNotFoundException {
        ref.readExternal(in);
    }

    public void writeExternal(ObjectOutput out) throws IOException {
        ref.writeExternal(out);
    }

    /**
     * @deprecated
     */
    @Deprecated
    public void invoke(java.rmi.server.RemoteCall call) throws Exception {
        ref.invoke(call);
    }

    public Object invoke(Remote obj, Method method, Object[] params,
                         long opnum) throws Exception {
        return ref.invoke(obj, method, params, opnum);
    }

    /**
     * @deprecated
     */
    @Deprecated
    public void done(java.rmi.server.RemoteCall call) throws RemoteException {
        ref.done(call);
    }

    public String getRefClass(ObjectOutput out) {
        return ref.getRefClass(out);
    }

    /**
     * @deprecated
     */
    @Deprecated
    public java.rmi.server.RemoteCall newCall(RemoteObject obj,
            java.rmi.server.Operation[] op, int opnum,
                              long hash) throws RemoteException {
        return ref.newCall(obj, op, opnum, hash);
    }

    public boolean remoteEquals(RemoteRef obj) {
        return ref.remoteEquals(obj);
    }

    public int remoteHashCode() {
        return ref.remoteHashCode();
    }

    public String remoteToString() {
        return ref.remoteToString();
    }

    protected RemoteRef ref;
}
