/*
 * Copyright (c) 2003, 2013, Oracle and/or its affiliates. All rights reserved.
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

package java.lang.management;

/**
 * The management interface for the compilation system of
 * the Java virtual machine.
 *
 * <p> A Java virtual machine has a single instance of the implementation
 * class of this interface.  This instance implementing this interface is
 * an <a href="ManagementFactory.html#MXBean">MXBean</a>
 * that can be obtained by calling
 * the {@link ManagementFactory#getCompilationMXBean} method or
 * from the {@link ManagementFactory#getPlatformMBeanServer
 * platform <tt>MBeanServer</tt>} method.
 *
 * <p>The <tt>ObjectName</tt> for uniquely identifying the MXBean for
 * the compilation system within an MBeanServer is:
 * <blockquote>
 *  {@link ManagementFactory#COMPILATION_MXBEAN_NAME
 *         <tt>java.lang:type=Compilation</tt>}
 * </blockquote>
 *
 * It can be obtained by calling the
 * {@link PlatformManagedObject#getObjectName} method.
 *
 * @see ManagementFactory#getPlatformMXBeans(Class)
 * @see <a href="../../../javax/management/package-summary.html">
 *      JMX Specification.</a>
 * @see <a href="package-summary.html#examples">
 *      Ways to Access MXBeans</a>
 *
 * @author  Mandy Chung
 * @since   1.5
 */
public interface CompilationMXBean extends PlatformManagedObject {
    /**
     * Returns the name of the Just-in-time (JIT) compiler.
     *
     * @return the name of the JIT compiler.
     */
    public java.lang.String    getName();

    /**
     * Tests if the Java virtual machine supports the monitoring of
     * compilation time.
     *
     * @return <tt>true</tt> if the monitoring of compilation time is
     * supported ; <tt>false</tt> otherwise.
     */
    public boolean isCompilationTimeMonitoringSupported();

    /**
     * Returns the approximate accumulated elapsed time (in milliseconds)
     * spent in compilation.
     * If multiple threads are used for compilation, this value is
     * summation of the approximate time that each thread spent in compilation.
     *
     * <p>This method is optionally supported by the platform.
     * A Java virtual machine implementation may not support the compilation
     * time monitoring. The {@link #isCompilationTimeMonitoringSupported}
     * method can be used to determine if the Java virtual machine
     * supports this operation.
     *
     * <p> This value does not indicate the level of performance of
     * the Java virtual machine and is not intended for performance comparisons
     * of different virtual machine implementations.
     * The implementations may have different definitions and different
     * measurements of the compilation time.
     *
     * @return Compilation time in milliseconds
     * @throws java.lang.UnsupportedOperationException if the Java
     * virtual machine does not support
     * this operation.
     *
     */
    public long                getTotalCompilationTime();
}
