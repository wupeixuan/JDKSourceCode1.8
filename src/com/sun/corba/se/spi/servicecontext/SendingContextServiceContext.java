/*
 * Copyright (c) 1999, 2003, Oracle and/or its affiliates. All rights reserved.
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
import com.sun.corba.se.spi.ior.IOR ;
import com.sun.corba.se.spi.ior.iiop.GIOPVersion;
import com.sun.corba.se.spi.servicecontext.ServiceContext ;
import com.sun.corba.se.impl.encoding.MarshalOutputStream ;
import com.sun.corba.se.impl.ior.IORImpl ;

public class SendingContextServiceContext extends ServiceContext {
    public SendingContextServiceContext( IOR ior )
    {
        this.ior = ior ;
    }

    public SendingContextServiceContext(InputStream is, GIOPVersion gv)
    {
        super(is, gv) ;
        ior = new IORImpl( in ) ;
    }

    // Required SERVICE_CONTEXT_ID and getId definitions
    public static final int SERVICE_CONTEXT_ID = 6 ;
    public int getId() { return SERVICE_CONTEXT_ID ; }

    public void writeData( OutputStream os ) throws SystemException
    {
        ior.write( os ) ;
    }

    public IOR getIOR()
    {
        return ior ;
    }

    private IOR ior = null ;

    public String toString()
    {
        return "SendingContexServiceContext[ ior=" + ior + " ]" ;
    }
}
