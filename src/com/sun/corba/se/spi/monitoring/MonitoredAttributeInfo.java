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
 * Monitored AttributeInfo contains the meta information of the Monitored
 * Attribute.
 * </p>
 */
public interface MonitoredAttributeInfo {

  ///////////////////////////////////////
  // operations

/**
 * <p>
 * If the Attribute is writable from ASAdmin then isWritable() will return
 * true.
 * </p>
 * <p>
 *
 * @return a boolean with true or false
 * </p>
 */
    public boolean isWritable();
/**
 * <p>
 * isStatistic() is true if the attribute is presented as a Statistic.
 * </p>
 * <p>
 *
 * @return a boolean with true or false
 * </p>
 */
    public boolean isStatistic();
/**
 * <p>
 * Class Type: We will allow only basic class types: 1)Boolean 2)Integer
 * 3)Byte 4)Long 5)Float 6)Double 7)String 8)Character
 * </p>
 * <p>
 *
 * @return a Class Type
 * </p>
 */
    public Class type();
/**
 * <p>
 * Get's the description for the Monitored Attribute.
 * </p>
 * <p>
 *
 * @return a String with description
 * </p>
 */
    public String getDescription();

} // end MonitoredAttributeInfo
