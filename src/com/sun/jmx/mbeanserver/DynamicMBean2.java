/*
 * Copyright (c) 2005, Oracle and/or its affiliates. All rights reserved.
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

import javax.management.DynamicMBean;
import javax.management.MBeanServer;
import javax.management.ObjectName;

/**
 * A dynamic MBean that wraps an underlying resource.  A version of this
 * interface might eventually appear in the public JMX API.
 *
 * @since 1.6
 */
public interface DynamicMBean2 extends DynamicMBean {
    /**
     * The resource corresponding to this MBean.  This is the object whose
     * class name should be reflected by the MBean's
     * getMBeanInfo().getClassName() for example.  For a "plain"
     * DynamicMBean it will be "this".  For an MBean that wraps another
     * object, like javax.management.StandardMBean, it will be the wrapped
     * object.
     */
    public Object getResource();

    /**
     * The name of this MBean's class, as used by permission checks.
     * This is typically equal to getResource().getClass().getName().
     * This method is typically faster, sometimes much faster,
     * than getMBeanInfo().getClassName(), but should return the same
     * result.
     */
    public String getClassName();

    /**
     * Additional registration hook.  This method is called after
     * {@link javax.management.MBeanRegistration#preRegister preRegister}.
     * Unlike that method, if it throws an exception and the MBean implements
     * {@code MBeanRegistration}, then {@link
     * javax.management.MBeanRegistration#postRegister postRegister(false)}
     * will be called on the MBean.  This is the behavior that the MBean
     * expects for a problem that does not come from its own preRegister
     * method.
     */
    public void preRegister2(MBeanServer mbs, ObjectName name)
            throws Exception;

    /**
     * Additional registration hook.  This method is called if preRegister
     * and preRegister2 succeed, but then the MBean cannot be registered
     * (for example because there is already another MBean of the same name).
     */
    public void registerFailed();
}
