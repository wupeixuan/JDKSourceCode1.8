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

package javax.management;

import com.sun.jmx.mbeanserver.JmxMBeanServer;

/**
 * <p>This class represents a builder that creates a default
 * {@link javax.management.MBeanServer} implementation.
 * The JMX {@link javax.management.MBeanServerFactory} allows
 * applications to provide their custom MBeanServer
 * implementation by providing a subclass of this class.</p>
 *
 * @see MBeanServer
 * @see MBeanServerFactory
 *
 * @since 1.5
 */
public class MBeanServerBuilder {
    /**
     * Public default constructor.
     **/
    public MBeanServerBuilder() {
    }

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
     * passing the <var>delegate</var> that should be used by the MBeanServer
     * implementation.
     * <p>Note that the passed <var>delegate</var> might not be directly the
     * MBeanServerDelegate that was returned by this implementation. It could
     * be, for instance, a new object wrapping the previously
     * returned delegate.
     * <p>The <var>outer</var> parameter is a pointer to the MBeanServer that
     * should be passed to the {@link javax.management.MBeanRegistration}
     * interface when registering MBeans inside the MBeanServer.
     * If <var>outer</var> is <code>null</code>, then the MBeanServer
     * implementation must use its own <code>this</code> reference when
     * invoking the {@link javax.management.MBeanRegistration} interface.
     * <p>This makes it possible for a MBeanServer implementation to wrap
     * another MBeanServer implementation, in order to implement, e.g,
     * security checks, or to prevent access to the actual MBeanServer
     * implementation by returning a pointer to a wrapping object.
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
    public MBeanServer newMBeanServer(String              defaultDomain,
                                      MBeanServer         outer,
                                      MBeanServerDelegate delegate) {
        // By default, MBeanServerInterceptors are disabled.
        // Use com.sun.jmx.mbeanserver.MBeanServerBuilder to obtain
        // MBeanServers on which MBeanServerInterceptors are enabled.
        return JmxMBeanServer.newMBeanServer(defaultDomain,outer,delegate,
                                             false);
    }
}
