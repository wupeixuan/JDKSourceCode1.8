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

import java.util.List ;
import java.util.LinkedList ;
import java.util.Map ;
import java.util.HashMap ;
import java.util.Iterator ;
import java.util.Properties ;

import com.sun.corba.se.impl.orb.ParserAction ;
import com.sun.corba.se.impl.orb.ParserActionFactory ;

public class PropertyParser {
    private List actions ;

    public PropertyParser( )
    {
        actions = new LinkedList() ;
    }

    public PropertyParser add( String propName,
        Operation action, String fieldName )
    {
        actions.add( ParserActionFactory.makeNormalAction( propName,
            action, fieldName ) ) ;
        return this ;
    }

    public PropertyParser addPrefix( String propName,
        Operation action, String fieldName, Class componentType )
    {
        actions.add( ParserActionFactory.makePrefixAction( propName,
            action, fieldName, componentType ) ) ;
        return this ;
    }

    /** Return a map from field name to value.
    */
    public Map parse( Properties props )
    {
        Map map = new HashMap() ;
        Iterator iter = actions.iterator() ;
        while (iter.hasNext()) {
            ParserAction act = (ParserAction)(iter.next()) ;

            Object result = act.apply( props ) ;

            // A null result means that the property was not set for
            // this action, so do not override the default value in this case.
            if (result != null)
                map.put( act.getFieldName(), result ) ;
        }

        return map ;
    }

    public Iterator iterator()
    {
        return actions.iterator() ;
    }
}
