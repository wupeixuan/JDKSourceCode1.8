/*
 * Copyright (c) 2003, Oracle and/or its affiliates. All rights reserved.
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
package com.sun.corba.se.spi.monitoring;

/**
 * <p>
 *
 * @author Hemanth Puttaswamy
 * </p>
 * <p>
 * MonitoredAttributeInfoFactory used mostly by internal classes. If the
 * User needs to define some special MonitoredAttributes like a Character
 * type Monitored Attribute, they can use this factory to build the meta
 * information.
 *
 * </p>
 */

public interface MonitoredAttributeInfoFactory {
    /**
     *  A Simple Factory Method to create the Monitored Attribute Info.
     */
    MonitoredAttributeInfo createMonitoredAttributeInfo( String description,
        Class type, boolean isWritable, boolean isStatistic  );
}
