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

/** Policy used to implement zero IIOP port policy in the POA.
*/
public class ZeroPortPolicy extends LocalObject implements Policy
{
    private static ZeroPortPolicy policy = new ZeroPortPolicy( true ) ;

    private boolean flag = true ;

    private ZeroPortPolicy( boolean type )
    {
        this.flag = type ;
    }

    public String toString()
    {
        return "ZeroPortPolicy[" + flag + "]" ;
    }

    public boolean forceZeroPort()
    {
        return flag ;
    }

    public synchronized static ZeroPortPolicy getPolicy()
    {
        return policy ;
    }

    public int policy_type ()
    {
        return ORBConstants.ZERO_PORT_POLICY ;
    }

    public org.omg.CORBA.Policy copy ()
    {
        return this ;
    }

    public void destroy ()
    {
        // NO-OP
    }
}
