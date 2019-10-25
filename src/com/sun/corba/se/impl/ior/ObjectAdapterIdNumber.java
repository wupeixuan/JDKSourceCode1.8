/*
 * Copyright (c) 2001, 2002, Oracle and/or its affiliates. All rights reserved.
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
import org.omg.CORBA_2_3.portable.OutputStream ;

/** ObjectAdapterIdNumber is used to represent pre-JDK 1.4 POA adapter
 * IDs.  The POA ID was simply represented as a single integer, which was
 * mapped to the actual POA instance.  Here, we just represent these
 * internally as arrays of the form { "OldRootPOA", "<number>" },
 * and provide an extra method to get the number back.
 */
public class ObjectAdapterIdNumber extends ObjectAdapterIdArray {
    private int poaid ;

    public ObjectAdapterIdNumber( int poaid )
    {
        super( "OldRootPOA", Integer.toString( poaid ) ) ;
        this.poaid = poaid ;
    }

    public int getOldPOAId()
    {
        return poaid ;
    }
}
