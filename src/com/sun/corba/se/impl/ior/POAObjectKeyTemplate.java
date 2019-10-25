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

package com.sun.corba.se.impl.ior;

import java.util.Iterator ;

import org.omg.CORBA_2_3.portable.InputStream ;
import org.omg.CORBA_2_3.portable.OutputStream ;

import org.omg.CORBA.OctetSeqHolder ;

import com.sun.corba.se.spi.activation.POANameHelper ;

import com.sun.corba.se.spi.orb.ORB ;
import com.sun.corba.se.spi.orb.ORBVersion ;
import com.sun.corba.se.spi.orb.ORBVersionFactory ;

import com.sun.corba.se.spi.ior.ObjectAdapterId ;

import com.sun.corba.se.impl.ior.ObjectKeyFactoryImpl ;

/**
 * @author
 */
public final class POAObjectKeyTemplate extends NewObjectKeyTemplateBase
{
    /** This constructor reads the template ONLY from the stream.
    */
    public POAObjectKeyTemplate( ORB orb, int magic, int scid, InputStream is )
    {
        super( orb, magic, scid, is.read_long(), is.read_string(),
            new ObjectAdapterIdArray( POANameHelper.read( is ) ) ) ;

        setORBVersion( is ) ;
    }

    /** This constructor reads a complete ObjectKey (template and Id)
    * from the stream.
    */
    public POAObjectKeyTemplate( ORB orb, int magic, int scid, InputStream is,
        OctetSeqHolder osh )
    {
        super( orb, magic, scid, is.read_long(), is.read_string(),
            new ObjectAdapterIdArray( POANameHelper.read( is ) ) ) ;

        osh.value = readObjectKey( is ) ;

        setORBVersion( is ) ;
    }

    public POAObjectKeyTemplate( ORB orb, int scid, int serverid, String orbid,
        ObjectAdapterId objectAdapterId)
    {
        super( orb, ObjectKeyFactoryImpl.JAVAMAGIC_NEWER, scid, serverid, orbid,
            objectAdapterId ) ;

        setORBVersion( ORBVersionFactory.getORBVersion() ) ;
    }

    public void writeTemplate(OutputStream os)
    {
        os.write_long( getMagic() ) ;
        os.write_long( getSubcontractId() ) ;
        os.write_long( getServerId() ) ;
        os.write_string( getORBId() ) ;
        getObjectAdapterId().write( os ) ;
    }
}
