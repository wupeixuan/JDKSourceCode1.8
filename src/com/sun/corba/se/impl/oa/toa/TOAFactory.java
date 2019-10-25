/*
 * Copyright (c) 2002, 2012, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.corba.se.impl.oa.toa ;

import java.util.Map ;
import java.util.HashMap ;

import org.omg.CORBA.INTERNAL ;
import org.omg.CORBA.CompletionStatus ;

import com.sun.corba.se.spi.oa.ObjectAdapterFactory ;
import com.sun.corba.se.spi.oa.ObjectAdapter ;

import com.sun.corba.se.spi.orb.ORB ;

import com.sun.corba.se.spi.ior.ObjectAdapterId ;

import com.sun.corba.se.impl.oa.toa.TOAImpl ;
import com.sun.corba.se.impl.oa.toa.TransientObjectManager ;

import com.sun.corba.se.impl.javax.rmi.CORBA.Util ;

import com.sun.corba.se.impl.ior.ObjectKeyTemplateBase ;

import com.sun.corba.se.spi.logging.CORBALogDomains ;
import com.sun.corba.se.impl.logging.ORBUtilSystemException ;

public class TOAFactory implements ObjectAdapterFactory
{
    private ORB orb ;
    private ORBUtilSystemException wrapper ;

    private TOAImpl toa ;
    private Map codebaseToTOA ;
    private TransientObjectManager tom ;

    public ObjectAdapter find ( ObjectAdapterId oaid )
    {
        if (oaid.equals( ObjectKeyTemplateBase.JIDL_OAID )  )
            // Return the dispatch-only TOA, which can dispatch
            // request for objects created by any TOA.
            return getTOA() ;
        else
            throw wrapper.badToaOaid() ;
    }

    public void init( ORB orb )
    {
        this.orb = orb ;
        wrapper = ORBUtilSystemException.get( orb,
            CORBALogDomains.OA_LIFECYCLE ) ;
        tom = new TransientObjectManager( orb ) ;
        codebaseToTOA = new HashMap() ;
    }

    public void shutdown( boolean waitForCompletion )
    {
        if (Util.isInstanceDefined()) {
            Util.getInstance().unregisterTargetsForORB(orb);
        }
    }

    public synchronized TOA getTOA( String codebase )
    {
        TOA toa = (TOA)(codebaseToTOA.get( codebase )) ;
        if (toa == null) {
            toa = new TOAImpl( orb, tom, codebase ) ;

            codebaseToTOA.put( codebase, toa ) ;
        }

        return toa ;
    }

    public synchronized TOA getTOA()
    {
        if (toa == null)
            // The dispatch-only TOA is not used for creating
            // objrefs, so its codebase can be null (and must
            // be, since we do not have a servant at this point)
            toa = new TOAImpl( orb, tom, null ) ;

        return toa ;
    }

    public ORB getORB()
    {
        return orb ;
    }
} ;
