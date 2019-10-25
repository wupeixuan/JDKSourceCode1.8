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

import org.omg.CORBA.INTERNAL ;

import org.omg.CORBA_2_3.portable.OutputStream ;
import org.omg.CORBA_2_3.portable.InputStream ;

import org.omg.IOP.TAG_INTERNET_IOP ;

import com.sun.corba.se.spi.ior.IdentifiableContainerBase ;
import com.sun.corba.se.spi.ior.IdentifiableFactoryFinder ;
import com.sun.corba.se.spi.ior.IORTemplate ;
import com.sun.corba.se.spi.ior.ObjectKeyTemplate ;
import com.sun.corba.se.spi.ior.TaggedProfileTemplate ;
import com.sun.corba.se.spi.ior.ObjectId ;
import com.sun.corba.se.spi.ior.IOR ;
import com.sun.corba.se.spi.ior.IORFactory ;

import com.sun.corba.se.spi.orb.ORB ;

/**
 * This class is a container of TaggedProfileTemplates.
 * @author
 */
public class IORTemplateImpl extends IdentifiableContainerBase implements IORTemplate
{
    private ObjectKeyTemplate oktemp ;

    public boolean equals( Object obj )
    {
        if (obj == null)
            return false ;

        if (!(obj instanceof IORTemplateImpl))
            return false ;

        IORTemplateImpl other = (IORTemplateImpl)obj ;

        return super.equals( obj ) && oktemp.equals( other.getObjectKeyTemplate() ) ;
    }

    public int hashCode()
    {
        return super.hashCode() ^ oktemp.hashCode() ;
    }

    public ObjectKeyTemplate getObjectKeyTemplate()
    {
        return oktemp ;
    }

    public IORTemplateImpl( ObjectKeyTemplate oktemp )
    {
        this.oktemp = oktemp ;
    }

    public IOR makeIOR( ORB orb, String typeid, ObjectId oid )
    {
        return new IORImpl( orb, typeid, this, oid ) ;
    }

    public boolean isEquivalent( IORFactory other )
    {
        if (!(other instanceof IORTemplate))
            return false ;

        IORTemplate list = (IORTemplate)other ;

        Iterator thisIterator = iterator() ;
        Iterator listIterator = list.iterator() ;
        while (thisIterator.hasNext() && listIterator.hasNext()) {
            TaggedProfileTemplate thisTemplate =
                (TaggedProfileTemplate)thisIterator.next() ;
            TaggedProfileTemplate listTemplate =
                (TaggedProfileTemplate)listIterator.next() ;
            if (!thisTemplate.isEquivalent( listTemplate ))
                return false ;
        }

        return (thisIterator.hasNext() == listIterator.hasNext()) &&
            getObjectKeyTemplate().equals( list.getObjectKeyTemplate() ) ;
    }

    /** Ensure that this IORTemplate and all of its profiles can not be
    * modified.  This overrides the method inherited from
    * FreezableList through IdentifiableContainerBase.
    */
    public void makeImmutable()
    {
        makeElementsImmutable() ;
        super.makeImmutable() ;
    }

    public void write( OutputStream os )
    {
        oktemp.write( os ) ;
        EncapsulationUtility.writeIdentifiableSequence( this, os ) ;
    }

    public IORTemplateImpl( InputStream is )
    {
        ORB orb = (ORB)(is.orb()) ;
        IdentifiableFactoryFinder finder =
            orb.getTaggedProfileTemplateFactoryFinder() ;

        oktemp = orb.getObjectKeyFactory().createTemplate( is ) ;
        EncapsulationUtility.readIdentifiableSequence( this, finder, is ) ;

        makeImmutable() ;
    }
}
