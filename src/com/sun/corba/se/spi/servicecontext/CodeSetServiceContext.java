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
import org.omg.CORBA_2_3.portable.InputStream;
import org.omg.CORBA_2_3.portable.OutputStream;
import com.sun.corba.se.spi.ior.iiop.GIOPVersion;
import com.sun.corba.se.impl.encoding.MarshalInputStream ;
import com.sun.corba.se.impl.encoding.MarshalOutputStream ;
import com.sun.corba.se.impl.encoding.CodeSetComponentInfo  ;

public class CodeSetServiceContext extends ServiceContext {
    public CodeSetServiceContext( CodeSetComponentInfo.CodeSetContext csc )
    {
        this.csc = csc ;
    }

    public CodeSetServiceContext(InputStream is, GIOPVersion gv)
    {
        super(is, gv) ;
        csc = new CodeSetComponentInfo.CodeSetContext() ;
        csc.read( (MarshalInputStream)in ) ;
    }

    // Required SERVICE_CONTEXT_ID and getId definitions
    public static final int SERVICE_CONTEXT_ID = 1 ;
    public int getId() { return SERVICE_CONTEXT_ID ; }

    public void writeData( OutputStream os ) throws SystemException
    {
        csc.write( (MarshalOutputStream)os ) ;
    }

    public CodeSetComponentInfo.CodeSetContext getCodeSetContext()
    {
        return csc ;
    }

    private CodeSetComponentInfo.CodeSetContext csc ;

    public String toString()
    {
        return "CodeSetServiceContext[ csc=" + csc + " ]" ;
    }
}
