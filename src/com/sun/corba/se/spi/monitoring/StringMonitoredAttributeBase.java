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
 * A Convenient Abstraction to present String type Monitored Attribute. One
 * of the examples of StringMonitoredAttribute is the State information.
 * </p>
 */
public abstract class StringMonitoredAttributeBase
    extends MonitoredAttributeBase
{

  ///////////////////////////////////////
  // operations


/**
 * <p>
 * Constructs StringMonitoredAttribute with the MonitoredAttributeInfo
 * built with the class type of String.
 * </p>
 * <p>
 *
 * @param name of this attribute
 * </p>
 * <p>
 * @param description of this attribute
 * </p>
 * <p>
 * @return a StringMonitoredAttributeBase
 * </p>
 */
    public  StringMonitoredAttributeBase(String name, String description) {
        super( name );
        MonitoredAttributeInfoFactory f =
            MonitoringFactories.getMonitoredAttributeInfoFactory();
        MonitoredAttributeInfo maInfo = f.createMonitoredAttributeInfo(
            description, String.class, false, false );
       this.setMonitoredAttributeInfo( maInfo );
    } // end StringMonitoredAttributeBase


} // end StringMonitoredAttributeBase
