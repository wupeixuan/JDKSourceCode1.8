/*
 * Copyright (c) 2002, 2003, Oracle and/or its affiliates. All rights reserved.
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


package com.sun.corba.se.impl.protocol ;

import org.omg.CORBA.portable.ServantObject ;

import com.sun.corba.se.spi.protocol.LocalClientRequestDispatcherFactory ;
import com.sun.corba.se.spi.protocol.LocalClientRequestDispatcher ;

import com.sun.corba.se.spi.ior.IOR ;

import com.sun.corba.se.spi.oa.OAInvocationInfo ;

import com.sun.corba.se.spi.orb.ORB ;

public class MinimalServantCacheLocalCRDImpl extends ServantCacheLocalCRDBase
{
    public MinimalServantCacheLocalCRDImpl( ORB orb, int scid, IOR ior )
    {
        super( (com.sun.corba.se.spi.orb.ORB)orb, scid, ior ) ;
    }

    public ServantObject servant_preinvoke( org.omg.CORBA.Object self,
        String operation, Class expectedType )
    {
        OAInvocationInfo cachedInfo = getCachedInfo() ;
        if (checkForCompatibleServant( cachedInfo, expectedType ))
            return cachedInfo ;
        else
            return null ;
    }

    public void servant_postinvoke(org.omg.CORBA.Object self,
                                   ServantObject servantobj)
    {
    }
}
