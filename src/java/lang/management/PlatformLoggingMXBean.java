/*
 * Copyright (c) 2009, 2011, Oracle and/or its affiliates. All rights reserved.
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
 * The management interface for the {@linkplain java.util.logging logging} facility.
 *
 * <p>There is a single global instance of the <tt>PlatformLoggingMXBean</tt>.
 * The {@link java.lang.management.ManagementFactory#getPlatformMXBean(Class)
 * ManagementFactory.getPlatformMXBean} method can be used to obtain
 * the {@code PlatformLoggingMXBean} object as follows:
 * <pre>
 *     PlatformLoggingMXBean logging = ManagementFactory.getPlatformMXBean(PlatformLoggingMXBean.class);
 * </pre>
 * The {@code PlatformLoggingMXBean} object is also registered with the
 * platform {@linkplain java.lang.management.ManagementFactory#getPlatformMBeanServer
 * MBeanServer}.
 * The {@link javax.management.ObjectName ObjectName} for uniquely
 * identifying the {@code PlatformLoggingMXBean} within an MBeanServer is:
 * <pre>
 *      {@link java.util.logging.LogManager#LOGGING_MXBEAN_NAME java.util.logging:type=Logging}
 * </pre>
 *
 * <p>The instance registered in the platform <tt>MBeanServer</tt> with
 * this {@code ObjectName} implements all attributes defined by
 * {@link java.util.logging.LoggingMXBean}.
 *
 * @since   1.7
 */
public interface PlatformLoggingMXBean extends PlatformManagedObject {

    /**
     * Returns the list of the currently registered
     * {@linkplain java.util.logging.Logger logger} names. This method
     * calls {@link java.util.logging.LogManager#getLoggerNames} and
     * returns a list of the logger names.
     *
     * @return A list of {@code String} each of which is a
     *         currently registered {@code Logger} name.
     */
    java.util.List<String> getLoggerNames();

    /**
     * Gets the name of the log {@linkplain java.util.logging.Logger#getLevel
     * level} associated with the specified logger.
     * If the specified logger does not exist, {@code null}
     * is returned.
     * This method first finds the logger of the given name and
     * then returns the name of the log level by calling:
     * <blockquote>
     *   {@link java.util.logging.Logger#getLevel
     *    Logger.getLevel()}.{@link java.util.logging.Level#getName getName()};
     * </blockquote>
     *
     * <p>
     * If the {@code Level} of the specified logger is {@code null},
     * which means that this logger's effective level is inherited
     * from its parent, an empty string will be returned.
     *
     * @param loggerName The name of the {@code Logger} to be retrieved.
     *
     * @return The name of the log level of the specified logger; or
     *         an empty string if the log level of the specified logger
     *         is {@code null}.  If the specified logger does not
     *         exist, {@code null} is returned.
     *
     * @see java.util.logging.Logger#getLevel
     */
    String getLoggerLevel(String loggerName);

    /**
     * Sets the specified logger to the specified new
     * {@linkplain java.util.logging.Logger#setLevel level}.
     * If the {@code levelName} is not {@code null}, the level
     * of the specified logger is set to the parsed
     * {@link java.util.logging.Level Level}
     * matching the {@code levelName}.
     * If the {@code levelName} is {@code null}, the level
     * of the specified logger is set to {@code null} and
     * the effective level of the logger is inherited from
     * its nearest ancestor with a specific (non-null) level value.
     *
     * @param loggerName The name of the {@code Logger} to be set.
     *                   Must be non-null.
     * @param levelName The name of the level to set on the specified logger,
     *                 or  {@code null} if setting the level to inherit
     *                 from its nearest ancestor.
     *
     * @throws IllegalArgumentException if the specified logger
     * does not exist, or {@code levelName} is not a valid level name.
     *
     * @throws SecurityException if a security manager exists and if
     * the caller does not have LoggingPermission("control").
     *
     * @see java.util.logging.Logger#setLevel
     */
    void setLoggerLevel(String loggerName, String levelName);

    /**
     * Returns the name of the
     * {@linkplain java.util.logging.Logger#getParent parent}
     * for the specified logger.
     * If the specified logger does not exist, {@code null} is returned.
     * If the specified logger is the root {@code Logger} in the namespace,
     * the result will be an empty string.
     *
     * @param loggerName The name of a {@code Logger}.
     *
     * @return the name of the nearest existing parent logger;
     *         an empty string if the specified logger is the root logger.
     *         If the specified logger does not exist, {@code null}
     *         is returned.
     */
    String getParentLoggerName(String loggerName);
}
