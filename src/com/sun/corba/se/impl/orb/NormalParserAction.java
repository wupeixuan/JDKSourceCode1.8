/*
 * Copyright (c) 2002, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.corba.se.impl.orb ;

import java.util.Properties ;

import com.sun.corba.se.spi.orb.Operation ;

public class NormalParserAction extends ParserActionBase {
    public NormalParserAction( String propertyName,
        Operation operation, String fieldName )
    {
        super( propertyName, false, operation, fieldName ) ;
    }

    /** Create a String[] of all suffixes of property names that
     * match the propertyName prefix, pass this to op, and return the
     * result.
     */
    public Object apply( Properties props )
    {
        Object value = props.getProperty( getPropertyName() ) ;
        if (value != null)
            return getOperation().operate( value ) ;
        else
            return null ;
    }
}
