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

import org.omg.CORBA.INTERNAL ;
import org.omg.CORBA.OctetSeqHolder ;

import org.omg.CORBA_2_3.portable.InputStream ;
import org.omg.CORBA_2_3.portable.OutputStream ;

import com.sun.corba.se.spi.orb.ORB ;
import com.sun.corba.se.spi.orb.ORBVersion ;
import com.sun.corba.se.spi.orb.ORBVersionFactory ;

import com.sun.corba.se.impl.ior.ObjectKeyFactoryImpl ;

/**
 * @author Ken Cavanaugh
 */
public final class OldPOAObjectKeyTemplate extends OldObjectKeyTemplateBase
{
    /** This constructor reads the template ONLY from the stream
    */
    public OldPOAObjectKeyTemplate( ORB orb, int magic, int scid, InputStream is )
    {
        this( orb, magic, scid, is.read_long(), is.read_long(), is.read_long() ) ;
    }

    /** This constructor reads a complete ObjectKey (template and Id)
    * from the stream.
    */
    public OldPOAObjectKeyTemplate( ORB orb, int magic, int scid, InputStream is,
        OctetSeqHolder osh )
    {
        this( orb, magic, scid, is ) ;
        osh.value = readObjectKey( is ) ;
    }

    public OldPOAObjectKeyTemplate( ORB orb, int magic, int scid, int serverid,
        int orbid, int poaid)
    {
        super( orb, magic, scid, serverid,
            Integer.toString( orbid ),
            new ObjectAdapterIdNumber( poaid ) ) ;
    }

    public void writeTemplate(OutputStream os)
    {
        os.write_long( getMagic() ) ;
        os.write_long( getSubcontractId() ) ;
        os.write_long( getServerId() ) ;

        int orbid = Integer.parseInt( getORBId() ) ;
        os.write_long( orbid ) ;

        ObjectAdapterIdNumber oaid = (ObjectAdapterIdNumber)(getObjectAdapterId()) ;
        int poaid = oaid.getOldPOAId()  ;
        os.write_long( poaid ) ;
    }

    public ORBVersion getORBVersion()
    {
        if (getMagic() == ObjectKeyFactoryImpl.JAVAMAGIC_OLD)
            return ORBVersionFactory.getOLD() ;
        else if (getMagic() == ObjectKeyFactoryImpl.JAVAMAGIC_NEW)
            return ORBVersionFactory.getNEW() ;
        else
            throw new INTERNAL() ;
    }
}
