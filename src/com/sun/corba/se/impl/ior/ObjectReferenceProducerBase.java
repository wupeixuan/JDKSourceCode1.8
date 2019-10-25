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

package com.sun.corba.se.impl.ior ;

import com.sun.corba.se.spi.orb.ORB ;

import com.sun.corba.se.spi.ior.IORFactory ;
import com.sun.corba.se.spi.ior.IOR ;
import com.sun.corba.se.spi.ior.IORFactories ;
import com.sun.corba.se.spi.ior.IORTemplateList ;
import com.sun.corba.se.spi.ior.ObjectId ;

import com.sun.corba.se.spi.logging.CORBALogDomains ;

import com.sun.corba.se.impl.orbutil.ORBUtility ;

import com.sun.corba.se.impl.logging.IORSystemException ;

public abstract class ObjectReferenceProducerBase {
    transient protected ORB orb ;

    public abstract IORFactory getIORFactory() ;

    public abstract IORTemplateList getIORTemplateList() ;

    public ObjectReferenceProducerBase( ORB orb )
    {
        this.orb = orb ;
    }

    public org.omg.CORBA.Object make_object (String repositoryId,
        byte[] objectId)
    {
        ObjectId oid = IORFactories.makeObjectId( objectId ) ;
        IOR ior = getIORFactory().makeIOR( orb, repositoryId, oid ) ;

        return ORBUtility.makeObjectReference( ior ) ;
    }
}
