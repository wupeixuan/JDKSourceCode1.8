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

import com.sun.corba.se.spi.orb.Operation ;

public class ParserActionFactory{
    private ParserActionFactory() {}

    public static ParserAction makeNormalAction( String propertyName,
        Operation operation, String fieldName )
    {
        return new NormalParserAction( propertyName, operation, fieldName ) ;
    }

    public static ParserAction makePrefixAction( String propertyName,
        Operation operation, String fieldName, Class componentType )
    {
        return new PrefixParserAction( propertyName, operation, fieldName, componentType ) ;
    }
}
