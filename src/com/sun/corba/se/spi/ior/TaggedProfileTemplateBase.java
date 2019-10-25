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

package com.sun.corba.se.spi.ior;

import java.util.Iterator ;

import org.omg.CORBA_2_3.portable.OutputStream ;

import com.sun.corba.se.spi.orb.ORB ;

import com.sun.corba.se.impl.ior.EncapsulationUtility ;

public abstract class TaggedProfileTemplateBase
    extends IdentifiableContainerBase
    implements TaggedProfileTemplate
{
    public void write( OutputStream os )
    {
        EncapsulationUtility.writeEncapsulation( this, os ) ;
    }

    public org.omg.IOP.TaggedComponent[] getIOPComponents( ORB orb, int id )
    {
        int count = 0 ;
        Iterator iter = iteratorById( id ) ;
        while (iter.hasNext()) {
            iter.next() ;
            count++ ;
        }

        org.omg.IOP.TaggedComponent[] result = new
            org.omg.IOP.TaggedComponent[count] ;

        int index = 0 ;
        iter = iteratorById( id ) ;
        while (iter.hasNext()) {
            TaggedComponent comp = (TaggedComponent)(iter.next()) ;
            result[index++] = comp.getIOPComponent( orb ) ;
        }

        return result ;
    }
}
