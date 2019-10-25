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


package com.sun.corba.se.impl.protocol;

import org.omg.CORBA.portable.ServantObject ;

import com.sun.corba.se.spi.protocol.LocalClientRequestDispatcherFactory ;
import com.sun.corba.se.spi.protocol.LocalClientRequestDispatcher ;

import com.sun.corba.se.spi.orb.ORB ;

import com.sun.corba.se.spi.oa.OAInvocationInfo ;
import com.sun.corba.se.spi.oa.OADestroyed ;

import com.sun.corba.se.spi.ior.IOR;

import com.sun.corba.se.spi.logging.CORBALogDomains;

import com.sun.corba.se.impl.logging.POASystemException ;

public class FullServantCacheLocalCRDImpl extends ServantCacheLocalCRDBase
{
    public FullServantCacheLocalCRDImpl( ORB orb, int scid, IOR ior )
    {
        super( (com.sun.corba.se.spi.orb.ORB)orb, scid, ior ) ;
    }

    public ServantObject servant_preinvoke( org.omg.CORBA.Object self,
        String operation, Class expectedType )
    {
        OAInvocationInfo cachedInfo = getCachedInfo() ;
        if (!checkForCompatibleServant( cachedInfo, expectedType ))
            return null ;

        // Note that info is shared across multiple threads
        // using the same subcontract, each of which may
        // have its own operation.  Therefore we need to clone it.
        OAInvocationInfo info = new OAInvocationInfo( cachedInfo, operation ) ;
        orb.pushInvocationInfo( info ) ;

        try {
            info.oa().enter() ;
        } catch (OADestroyed pdes) {
            throw wrapper.preinvokePoaDestroyed( pdes ) ;
        }

        return info ;
    }

    public void servant_postinvoke(org.omg.CORBA.Object self,
                                   ServantObject servantobj)
    {
        OAInvocationInfo cachedInfo = getCachedInfo() ;
        cachedInfo.oa().exit() ;
        orb.popInvocationInfo() ;
    }
}
