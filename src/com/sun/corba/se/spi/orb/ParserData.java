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
package com.sun.corba.se.spi.orb ;

import java.util.Properties ;

public interface ParserData {
    public String  getPropertyName() ;

    public Operation getOperation() ;

    public String getFieldName() ;

    public Object getDefaultValue() ;

    public Object getTestValue() ;

    public void addToParser( PropertyParser parser ) ;

    public void addToProperties( Properties props ) ;
}
