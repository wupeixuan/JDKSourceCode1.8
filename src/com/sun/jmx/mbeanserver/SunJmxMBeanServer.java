/*
 * Copyright (c) 2000, 2008, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.jmx.mbeanserver;

import javax.management.MBeanServer;
import javax.management.MBeanServerDelegate;


/**
 * Extends the MBeanServer interface to
 * provide methods for getting the MetaData and MBeanServerInstantiator
 * objects associated with an MBeanServer.
 *
 * @since 1.5
 */
public interface SunJmxMBeanServer
    extends MBeanServer {

    /**
     * Return the MBeanInstantiator associated to this MBeanServer.
     * @exception UnsupportedOperationException if
     *            {@link MBeanServerInterceptor}s
     *            are not enabled on this object.
     * @see #interceptorsEnabled
     */
    public MBeanInstantiator getMBeanInstantiator();

    /**
     * Tell whether {@link MBeanServerInterceptor}s are enabled on this
     * object.
     * @return <code>true</code> if {@link MBeanServerInterceptor}s are
     *         enabled.
     * @see #getMBeanServerInterceptor
     * @see #setMBeanServerInterceptor
     * @see #getMBeanInstantiator
     * @see com.sun.jmx.mbeanserver.JmxMBeanServerBuilder
     **/
    public boolean interceptorsEnabled();

    /**
     * Return the MBeanServerInterceptor.
     * @exception UnsupportedOperationException if
     *            {@link MBeanServerInterceptor}s
     *            are not enabled on this object.
     * @see #interceptorsEnabled
     **/
    public MBeanServer getMBeanServerInterceptor();

    /**
     * Set the MBeanServerInterceptor.
     * @exception UnsupportedOperationException if
     *            {@link MBeanServerInterceptor}s
     *            are not enabled on this object.
     * @see #interceptorsEnabled
     **/
    public void setMBeanServerInterceptor(MBeanServer interceptor);

    /**
     * <p>Return the MBeanServerDelegate representing the MBeanServer.
     * Notifications can be sent from the MBean server delegate using
     * the method {@link MBeanServerDelegate#sendNotification}
     * in the returned object.</p>
     *
     */
    public MBeanServerDelegate getMBeanServerDelegate();

}
