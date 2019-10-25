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
import com.sun.corba.se.spi.servicecontext.ServiceContext ;

public class UnknownServiceContext extends ServiceContext {
    public UnknownServiceContext( int id, byte[] data )
    {
        this.id = id ;
        this.data = data ;
    }

    public UnknownServiceContext( int id, InputStream is )
    {
        this.id = id ;

        int len = is.read_long();
        data = new byte[len];
        is.read_octet_array(data,0,len);
    }

    public int getId() { return id ; }

    public void writeData( OutputStream os ) throws SystemException
    {
    }

    public void write( OutputStream os , GIOPVersion gv)
        throws SystemException
    {
        os.write_long( id ) ;
        os.write_long( data.length ) ;
        os.write_octet_array( data, 0, data.length ) ;
    }

    public byte[] getData()
    {
        return data ;
    }

    private int id = -1 ;
    private byte[] data = null ;
}
