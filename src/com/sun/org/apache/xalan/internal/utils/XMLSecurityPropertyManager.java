/*
 * Copyright (c) 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.org.apache.xalan.internal.utils;


import com.sun.org.apache.xalan.internal.XalanConstants;
import javax.xml.XMLConstants;

/**
 * This class manages security related properties
 *
 */
public final class XMLSecurityPropertyManager extends FeaturePropertyBase {

    /**
     * Properties managed by the security property manager
     */
    public static enum Property {
        ACCESS_EXTERNAL_DTD(XMLConstants.ACCESS_EXTERNAL_DTD,
                XalanConstants.EXTERNAL_ACCESS_DEFAULT),
        ACCESS_EXTERNAL_STYLESHEET(XMLConstants.ACCESS_EXTERNAL_STYLESHEET,
                XalanConstants.EXTERNAL_ACCESS_DEFAULT);

        final String name;
        final String defaultValue;

        Property(String name, String value) {
            this.name = name;
            this.defaultValue = value;
        }

        public boolean equalsName(String propertyName) {
            return (propertyName == null) ? false : name.equals(propertyName);
        }

        String defaultValue() {
            return defaultValue;
        }
    }


    /**
     * Default constructor. Establishes default values
     */
    public XMLSecurityPropertyManager() {
        values = new String[Property.values().length];
        for (Property property : Property.values()) {
            values[property.ordinal()] = property.defaultValue();
        }
        //read system properties or jaxp.properties
        readSystemProperties();
    }

    /**
     * Get the index by property name
     * @param propertyName property name
     * @return the index of the property if found; return -1 if not
     */
    public int getIndex(String propertyName){
        for (Property property : Property.values()) {
            if (property.equalsName(propertyName)) {
                //internally, ordinal is used as index
                return property.ordinal();
            }
        }
        return -1;
    }

    /**
     * Read from system properties, or those in jaxp.properties
     */
    private void readSystemProperties() {
        getSystemProperty(Property.ACCESS_EXTERNAL_DTD,
                XalanConstants.SP_ACCESS_EXTERNAL_DTD);
        getSystemProperty(Property.ACCESS_EXTERNAL_STYLESHEET,
                XalanConstants.SP_ACCESS_EXTERNAL_STYLESHEET);
    }

}
