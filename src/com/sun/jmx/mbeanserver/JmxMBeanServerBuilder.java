/*
 * Copyright (c) 2002, 2007, Oracle and/or its affiliates. All rights reserved.
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
import javax.management.MBeanServerBuilder;

/**
 * This class represents a builder that creates
 * {@link javax.management.MBeanServer} implementations.
 * The JMX {@link javax.management.MBeanServerFactory} allows
 * for applications to provide their custom MBeanServer
 * implementation. This class is not used when the whole Sun Reference JMX
 * Implementation is used. However it may be used to substitute Sun
 * MBeanServer implementation to another JMX implementation.
 * <p>
 * Contrarily to the default {@link javax.management.MBeanServerBuilder
 * javax.management.MBeanServerBuilder} this MBeanServerBuilder returns
 * MBeanServers on which
 * {@link com.sun.jmx.interceptor.MBeanServerInterceptor}s are enabled.
 *
 * @since 1.5
 */
public class JmxMBeanServerBuilder extends MBeanServerBuilder {
    /**
     * This method creates a new MBeanServerDelegate for a new MBeanServer.
     * When creating a new MBeanServer the
     * {@link javax.management.MBeanServerFactory} first calls this method
     * in order to create a new MBeanServerDelegate.
     * <br>Then it calls
     * <code>newMBeanServer(defaultDomain,outer,delegate)</code>
     * passing the <var>delegate</var> that should be used by the MBeanServer
     * implementation.
     * <p>Note that the passed <var>delegate</var> might not be directly the
     * MBeanServerDelegate that was returned by this method. It could
     * be, for instance, a new object wrapping the previously
     * returned object.
     *
     * @return A new {@link javax.management.MBeanServerDelegate}.
     **/
    public MBeanServerDelegate newMBeanServerDelegate() {
        return JmxMBeanServer.newMBeanServerDelegate();
    }

    /**
     * This method creates a new MBeanServer implementation object.
     * When creating a new MBeanServer the
     * {@link javax.management.MBeanServerFactory} first calls
     * <code>newMBeanServerDelegate()</code> in order to obtain a new
     * {@link javax.management.MBeanServerDelegate} for the new
     * MBeanServer. Then it calls
     * <code>newMBeanServer(defaultDomain,outer,delegate)</code>
     * passing the <var>delegate</var> that should be used by the
     * MBeanServer  implementation.
     * <p>Note that the passed <var>delegate</var> might not be directly the
     * MBeanServerDelegate that was returned by this implementation. It could
     * be, for instance, a new object wrapping the previously
     * returned delegate.
     * <p>The <var>outer</var> parameter is a pointer to the MBeanServer that
     * should be passed to the {@link javax.management.MBeanRegistration}
     * interface when registering MBeans inside the MBeanServer.
     * If <var>outer</var> is <code>null</code>, then the MBeanServer
     * implementation is free to use its own <code>this</code> pointer when
     * invoking the {@link javax.management.MBeanRegistration} interface.
     * <p>This makes it possible for a MBeanServer implementation to wrap
     * another MBeanServer implementation, in order to implement, e.g,
     * security checks, or to prevent access to the actual MBeanServer
     * implementation by returning a pointer to a wrapping object.
     * <p>
     * This MBeanServerBuilder makes it possible to create MBeanServer
     * which support {@link com.sun.jmx.interceptor.MBeanServerInterceptor}s.
     *
     * @param defaultDomain Default domain of the new MBeanServer.
     * @param outer A pointer to the MBeanServer object that must be
     *        passed to the MBeans when invoking their
     *        {@link javax.management.MBeanRegistration} interface.
     * @param delegate A pointer to the MBeanServerDelegate associated
     *        with the new MBeanServer. The new MBeanServer must register
     *        this MBean in its MBean repository.
     *
     * @return A new private implementation of an MBeanServer.
     **/
    public MBeanServer newMBeanServer(String defaultDomain,
                                      MBeanServer outer,
                                      MBeanServerDelegate delegate) {
        return JmxMBeanServer.newMBeanServer(defaultDomain,outer,delegate,
                                             true);
    }

}
