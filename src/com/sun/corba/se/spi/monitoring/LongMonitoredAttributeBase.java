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

import java.util.*;

/**
 * <p>
 *
 * @author Hemanth Puttaswamy
 * </p>
 * <p>
 * A Cleaner Abstraction to provide a Monitored Attribute of type 'Long'
 * </p>
 */
public abstract class LongMonitoredAttributeBase extends MonitoredAttributeBase {

  ///////////////////////////////////////
  // operations


/**
 * <p>
 * Constructs LongMonitoredAttribute, by creating the
 * MonitoredAttributeInfo with 'Long' as the class type.
 * Users are expected to extend this class and provide the implementation
 * for getValue() and if needed clearState() as well.
 * </p>
 * <p>
 *
 * @param name of tthe MonitoredAttribute
 * </p>
 * <p>
 * @param description of the Attribute, Please provid a well thought out
 * description, so that the admin can make sense of the attribute supplied.
 * </p>
 */
    public  LongMonitoredAttributeBase(String name, String description) {
        super( name );
        MonitoredAttributeInfoFactory f =
            MonitoringFactories.getMonitoredAttributeInfoFactory();
        MonitoredAttributeInfo maInfo = f.createMonitoredAttributeInfo(
                description, Long.class, false, false );
        this.setMonitoredAttributeInfo( maInfo );
    } // end LongMonitoredAttributeBase


} // end LongMonitoredAttributeBase
