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
 *  A Convenient class provided to help users extend and implement only
 *  getValue(), if there is no need to clear the state and the attribute is not
 *  writable.
 *
 * </p>
 */
public abstract class MonitoredAttributeBase implements MonitoredAttribute {
    String name;
    MonitoredAttributeInfo attributeInfo;
    /**
     * Constructor.
     */
    public MonitoredAttributeBase( String name, MonitoredAttributeInfo info ) {
        this.name = name;
        this.attributeInfo = info;
    }


    /**
     * A Package Private Constructor for internal use only.
     */
    MonitoredAttributeBase( String name ) {
        this.name = name;
    }


    /**
     * A Package Private convenience method for setting MonitoredAttributeInfo
     * for this Monitored Attribute.
     */
    void setMonitoredAttributeInfo( MonitoredAttributeInfo info ) {
        this.attributeInfo = info;
    }

    /**
     *  If the concrete class decides not to provide the implementation of this
     *  method, then it's OK. Some of the  examples where we may decide to not
     *  provide the implementation is the connection state. Irrespective of
     *  the call to clearState, the connection state will be showing the
     *  currect state of the connection.
     *  NOTE: This method is only used to clear the Monitored Attribute state,
     *  not the real state of the system itself.
     */
    public void clearState( ) {
    }

    /**
     *  This method should be implemented by the concrete class.
     */
    public abstract Object getValue( );

    /**
     *  This method should be implemented by the concrete class only if the
     *  attribute is writable. If the attribute is not writable and if this
     *  method called, it will result in an IllegalStateException.
     */
    public void setValue( Object value ) {
        if( !attributeInfo.isWritable() ) {
            throw new IllegalStateException(
                "The Attribute " + name + " is not Writable..." );
        }
        throw new IllegalStateException(
            "The method implementation is not provided for the attribute " +
            name );
    }


    /**
     *  Gets the MonitoredAttributeInfo for the attribute.
     */
    public MonitoredAttributeInfo getAttributeInfo( ) {
        return attributeInfo;
    }

    /**
     * Gets the name of the attribute.
     */
    public String getName( ) {
        return name;
    }
} // end MonitoredAttributeBase
