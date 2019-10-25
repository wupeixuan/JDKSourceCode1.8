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

package com.sun.corba.se.impl.monitoring;

import com.sun.corba.se.spi.monitoring.MonitoredAttributeInfoFactory;
import com.sun.corba.se.spi.monitoring.MonitoredAttributeInfo;

public class MonitoredAttributeInfoFactoryImpl
    implements MonitoredAttributeInfoFactory
{
    public MonitoredAttributeInfo createMonitoredAttributeInfo(
        String description, Class type, boolean isWritable,
        boolean isStatistic  )
    {
        return new MonitoredAttributeInfoImpl( description, type,
            isWritable, isStatistic );
    }
}
