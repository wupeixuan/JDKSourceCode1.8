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

package com.sun.corba.se.spi.extension ;

import org.omg.CORBA.Policy ;
import org.omg.CORBA.LocalObject ;
import com.sun.corba.se.impl.orbutil.ORBConstants ;

/** Policy used to specify the copyObject implementation to use.
*/
public class CopyObjectPolicy extends LocalObject implements Policy
{
    private final int value ;

    public CopyObjectPolicy( int value )
    {
        this.value = value ;
    }

    public int getValue()
    {
        return value ;
    }

    public int policy_type ()
    {
        return ORBConstants.COPY_OBJECT_POLICY ;
    }

    public org.omg.CORBA.Policy copy ()
    {
        return this ;
    }

    public void destroy ()
    {
        // NO-OP
    }

    public String toString()
    {
        return "CopyObjectPolicy[" + value + "]" ;
    }
}
