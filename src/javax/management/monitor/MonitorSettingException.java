/*
 * Copyright (c) 1999, 2007, Oracle and/or its affiliates. All rights reserved.
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

package javax.management.monitor;


/**
 * Exception thrown by the monitor when a monitor setting becomes invalid while the monitor is running.
 * <P>
 * As the monitor attributes may change at runtime, a check is performed before each observation.
 * If a monitor attribute has become invalid, a monitor setting exception is thrown.
 *
 *
 * @since 1.5
 */
public class MonitorSettingException extends javax.management.JMRuntimeException {

    /* Serial version */
    private static final long serialVersionUID = -8807913418190202007L;

    /**
     * Default constructor.
     */
    public MonitorSettingException() {
        super();
    }

    /**
     * Constructor that allows an error message to be specified.
     *
     * @param message The specific error message.
     */
    public MonitorSettingException(String message) {
        super(message);
    }
}
