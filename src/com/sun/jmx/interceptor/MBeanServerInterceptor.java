/*
 * Copyright (c) 2002, 2008, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.jmx.interceptor;


import java.io.ObjectInputStream;
import javax.management.InstanceNotFoundException;
import javax.management.MBeanException;
import javax.management.MBeanServer;
import javax.management.ObjectName;
import javax.management.OperationsException;
import javax.management.ReflectionException;
import javax.management.loading.ClassLoaderRepository;

/**
 * <p>This interface specifies the behavior to be implemented by an
 * MBean Server Interceptor.  An MBean Server Interceptor has
 * essentially the same interface as an MBean Server.  An MBean Server
 * forwards received requests to its default interceptor, which may
 * handle them itself or forward them to other interceptors.  The
 * default interceptor may be changed via the {@link
 * com.sun.jmx.mbeanserver.SunJmxMBeanServer#setMBeanServerInterceptor}
 * method.</p>
 *
 * <p>The initial default interceptor provides the standard MBean
 * Server behavior.  It handles a collection of named MBeans, each
 * represented by a Java object.  A replacement default interceptor
 * may build on this behavior, for instance by adding logging or
 * security checks, before forwarding requests to the initial default
 * interceptor.  Or, it may route each request to one of a number of
 * sub-interceptors, for instance based on the {@link ObjectName} in
 * the request.</p>
 *
 * <p>An interceptor, default or not, need not implement MBeans as
 * Java objects, in the way that the initial default interceptor does.
 * It may instead implement <em>virtual MBeans</em>, which do not
 * exist as Java objects when they are not in use.  For example, these
 * MBeans could be implemented by forwarding requests to a database,
 * or to a remote MBean server, or by performing system calls to query
 * or modify system resources.</p>
 *
 * @since 1.5
 */
public interface MBeanServerInterceptor extends MBeanServer {
    /**
     * This method should never be called.
     * Usually hrows UnsupportedOperationException.
     */
    public Object instantiate(String className)
            throws ReflectionException, MBeanException;
    /**
     * This method should never be called.
     * Usually throws UnsupportedOperationException.
     */
    public Object instantiate(String className, ObjectName loaderName)
            throws ReflectionException, MBeanException,
            InstanceNotFoundException;
    /**
     * This method should never be called.
     * Usually throws UnsupportedOperationException.
     */
    public Object instantiate(String className, Object[] params,
            String[] signature) throws ReflectionException, MBeanException;

    /**
     * This method should never be called.
     * Usually throws UnsupportedOperationException.
     */
    public Object instantiate(String className, ObjectName loaderName,
            Object[] params, String[] signature)
            throws ReflectionException, MBeanException,
            InstanceNotFoundException;

    /**
     * This method should never be called.
     * Usually throws UnsupportedOperationException.
     */
    @Deprecated
    public ObjectInputStream deserialize(ObjectName name, byte[] data)
            throws InstanceNotFoundException, OperationsException;

    /**
     * This method should never be called.
     * Usually throws UnsupportedOperationException.
     */
    @Deprecated
    public ObjectInputStream deserialize(String className, byte[] data)
            throws OperationsException, ReflectionException;

    /**
     * This method should never be called.
     * Usually hrows UnsupportedOperationException.
     */
    @Deprecated
    public ObjectInputStream deserialize(String className,
            ObjectName loaderName, byte[] data)
            throws InstanceNotFoundException, OperationsException,
            ReflectionException;

    /**
     * This method should never be called.
     * Usually throws UnsupportedOperationException.
     */
    public ClassLoaderRepository getClassLoaderRepository();

}

