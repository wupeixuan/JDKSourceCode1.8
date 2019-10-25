/*
 * Copyright (c) 2000, 2003, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.corba.se.impl.ior ;

import java.util.Iterator ;
import java.util.Arrays ;

public class ObjectAdapterIdArray extends ObjectAdapterIdBase {
    private final String[] objectAdapterId ;

    public ObjectAdapterIdArray( String[] objectAdapterId )
    {
        this.objectAdapterId = objectAdapterId ;
    }

    /** Special constructor used for OA IDs of length 2.
     */
    public ObjectAdapterIdArray( String name1, String name2 )
    {
        objectAdapterId = new String[2] ;
        objectAdapterId[0] = name1 ;
        objectAdapterId[1] = name2 ;
    }

    public int getNumLevels()
    {
        return objectAdapterId.length ;
    }

    public Iterator iterator()
    {
        return Arrays.asList( objectAdapterId ).iterator() ;
    }

    public String[] getAdapterName()
    {
        return (String[])(objectAdapterId.clone()) ;
    }
}
