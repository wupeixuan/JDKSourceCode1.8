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

package com.sun.corba.se.spi.servicecontext;

import org.omg.CORBA.SystemException;
import org.omg.CORBA_2_3.portable.InputStream ;
import org.omg.CORBA_2_3.portable.OutputStream ;

import com.sun.corba.se.spi.orb.ORBVersion ;
import com.sun.corba.se.spi.orb.ORBVersionFactory ;

import com.sun.corba.se.spi.ior.iiop.GIOPVersion;
import com.sun.corba.se.spi.servicecontext.ServiceContext ;
import com.sun.corba.se.impl.orbutil.ORBConstants ;

public class ORBVersionServiceContext extends ServiceContext {

    public ORBVersionServiceContext( )
    {
        version = ORBVersionFactory.getORBVersion() ;
    }

    public ORBVersionServiceContext( ORBVersion ver )
    {
        this.version = ver ;
    }

    public ORBVersionServiceContext(InputStream is, GIOPVersion gv)
    {
        super(is, gv) ;
        // pay particular attention to where the version is being read from!
        // is contains an encapsulation, ServiceContext reads off the
        // encapsulation and leaves the pointer in the variable "in",
        // which points to the long value.

        version = ORBVersionFactory.create( in ) ;
    }

    // Required SERVICE_CONTEXT_ID and getId definitions
    public static final int SERVICE_CONTEXT_ID = ORBConstants.TAG_ORB_VERSION ;
    public int getId() { return SERVICE_CONTEXT_ID ; }

    public void writeData( OutputStream os ) throws SystemException
    {
        version.write( os ) ;
    }

    public ORBVersion getVersion()
    {
        return version ;
    }

    // current ORB Version
    private ORBVersion version = ORBVersionFactory.getORBVersion() ;

    public String toString()
    {
        return "ORBVersionServiceContext[ version=" + version + " ]" ;
    }
}
