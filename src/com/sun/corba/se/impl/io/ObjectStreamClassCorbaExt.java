/*
 * Copyright (c) 2000, 2004, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.corba.se.impl.io;

import java.security.AccessController;
import java.security.PrivilegedExceptionAction;
import java.security.PrivilegedActionException;
import java.security.PrivilegedAction;

import java.lang.reflect.Modifier;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;


// This file contains some utility methods that
// originally were in the OSC in the RMI-IIOP
// code delivered by IBM.  They don't make
// sense there, and hence have been put
// here so that they can be factored out in
// an attempt to eliminate redundant code from
// ObjectStreamClass.  Eventually the goal is
// to move to java.io.ObjectStreamClass, and
// java.io.ObjectStreamField.

// class is package private for security reasons

class ObjectStreamClassCorbaExt {

    /**
     * Return true, iff,
     *
     * 1. 'cl' is an interface, and
     * 2. 'cl' and all its ancestors do not implement java.rmi.Remote, and
     * 3. if 'cl' has no methods (including those of its ancestors), or,
     *    if all the methods (including those of its ancestors) throw an
     *    exception that is atleast java.rmi.RemoteException or one of
     *    java.rmi.RemoteException's super classes.
     */
    static final boolean isAbstractInterface(Class cl) {
        if (!cl.isInterface() || // #1
                java.rmi.Remote.class.isAssignableFrom(cl)) { // #2
            return false;
        }
        Method[] methods = cl.getMethods();
        for (int i = 0; i < methods.length; i++) {
            Class exceptions[] = methods[i].getExceptionTypes();
            boolean exceptionMatch = false;
            for (int j = 0; (j < exceptions.length) && !exceptionMatch; j++) {
                if ((java.rmi.RemoteException.class == exceptions[j]) ||
                    (java.lang.Throwable.class == exceptions[j]) ||
                    (java.lang.Exception.class == exceptions[j]) ||
                    (java.io.IOException.class == exceptions[j])) {
                    exceptionMatch = true;
                }
            }
            if (!exceptionMatch) {
                return false;
            }
        }
        return true;
    }

    /*
     *  Returns TRUE if type is 'any'.
     */
    static final boolean isAny(String typeString) {

        int isAny = 0;

        if ( (typeString != null) &&
            (typeString.equals("Ljava/lang/Object;") ||
             typeString.equals("Ljava/io/Serializable;") ||
             typeString.equals("Ljava/io/Externalizable;")) )
                isAny = 1;

        return (isAny==1);
    }

    private static final Method[] getDeclaredMethods(final Class clz) {
        return (Method[]) AccessController.doPrivileged(new PrivilegedAction() {
            public Object run() {
                return clz.getDeclaredMethods();
            }
        });
    }

}
