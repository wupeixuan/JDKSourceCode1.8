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

import java.io.IOException ;

import org.omg.CORBA_2_3.portable.InputStream ;
import org.omg.CORBA_2_3.portable.OutputStream ;

import com.sun.corba.se.spi.ior.ObjectId ;
import com.sun.corba.se.spi.ior.ObjectAdapterId ;
import com.sun.corba.se.spi.ior.ObjectKeyFactory ;

import com.sun.corba.se.spi.ior.iiop.GIOPVersion ;

import com.sun.corba.se.spi.orb.ORB ;
import com.sun.corba.se.spi.orb.ORBVersion ;
import com.sun.corba.se.spi.orb.ORBVersionFactory ;

import com.sun.corba.se.impl.ior.ObjectKeyFactoryImpl ;

public abstract class NewObjectKeyTemplateBase extends ObjectKeyTemplateBase
{
    public NewObjectKeyTemplateBase( ORB orb, int magic, int scid, int serverid,
        String orbid, ObjectAdapterId oaid )
    {
        super( orb, magic, scid, serverid, orbid, oaid ) ;
        // subclass must set the version, since we don't have the object key here.

        if (magic != ObjectKeyFactoryImpl.JAVAMAGIC_NEWER)
            throw wrapper.badMagic( new Integer( magic ) ) ;
    }

    public void write(ObjectId objectId, OutputStream os)
    {
        super.write( objectId, os ) ;
        getORBVersion().write( os ) ;
    }

    public void write(OutputStream os)
    {
        super.write( os ) ;
        getORBVersion().write( os ) ;
    }

    protected void setORBVersion( InputStream is )
    {
        ORBVersion version = ORBVersionFactory.create( is ) ;
        setORBVersion( version ) ;
    }
}
