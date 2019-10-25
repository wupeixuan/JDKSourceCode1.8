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

package com.sun.corba.se.impl.protocol;

import org.omg.CORBA.portable.ServantObject;

import com.sun.corba.se.spi.protocol.LocalClientRequestDispatcher;
import com.sun.corba.se.spi.protocol.RequestDispatcherRegistry;

import com.sun.corba.se.spi.orb.ORB;
import com.sun.corba.se.spi.ior.IOR ;
import com.sun.corba.se.spi.oa.ObjectAdapterFactory;

import com.sun.corba.se.spi.ior.ObjectAdapterId;
import com.sun.corba.se.spi.ior.TaggedProfile;
import com.sun.corba.se.spi.ior.ObjectKeyTemplate;
import com.sun.corba.se.spi.ior.ObjectId;

public abstract class LocalClientRequestDispatcherBase implements LocalClientRequestDispatcher
{
    protected ORB orb;
    int scid;

    // Cached information needed for local dispatch
    protected boolean servantIsLocal ;
    protected ObjectAdapterFactory oaf ;
    protected ObjectAdapterId oaid ;
    protected byte[] objectId ;

    // If isNextIsLocalValid.get() == Boolean.TRUE,
    // the next call to isLocal should be valid
    private static final ThreadLocal isNextCallValid = new ThreadLocal() {
            protected synchronized Object initialValue() {
                return Boolean.TRUE;
            }
        };

    protected LocalClientRequestDispatcherBase(ORB orb, int scid, IOR ior)
    {
        this.orb = orb ;

        TaggedProfile prof = ior.getProfile() ;
        servantIsLocal = orb.getORBData().isLocalOptimizationAllowed() &&
            prof.isLocal();

        ObjectKeyTemplate oktemp = prof.getObjectKeyTemplate() ;
        this.scid = oktemp.getSubcontractId() ;
        RequestDispatcherRegistry sreg = orb.getRequestDispatcherRegistry() ;
        oaf = sreg.getObjectAdapterFactory( scid ) ;
        oaid = oktemp.getObjectAdapterId() ;
        ObjectId oid = prof.getObjectId() ;
        objectId = oid.getId() ;
    }

    public byte[] getObjectId()
    {
        return objectId ;
    }

    public boolean is_local(org.omg.CORBA.Object self)
    {
        return false;
    }

    /*
    * Possible paths through
    * useLocalInvocation/servant_preinvoke/servant_postinvoke:
    *
    * A: call useLocalInvocation
    * If useLocalInvocation returns false, servant_preinvoke is not called.
    * If useLocalInvocation returns true,
    * call servant_preinvoke
    *   If servant_preinvoke returns null,
    *       goto A
    *   else
    *       (local invocation proceeds normally)
    *       servant_postinvoke is called
    *
    */
    public boolean useLocalInvocation( org.omg.CORBA.Object self )
    {
        if (isNextCallValid.get() == Boolean.TRUE)
            return servantIsLocal ;
        else
            isNextCallValid.set( Boolean.TRUE ) ;

        return false ;
    }

    /** Check that the servant in info (which must not be null) is
    * an instance of the expectedType.  If not, set the thread local flag
    * and return false.
    */
    protected boolean checkForCompatibleServant( ServantObject so,
        Class expectedType )
    {
        if (so == null)
            return false ;

        // Normally, this test will never fail.  However, if the servant
        // and the stub were loaded in different class loaders, this test
        // will fail.
        if (!expectedType.isInstance( so.servant )) {
            isNextCallValid.set( Boolean.FALSE ) ;

            // When servant_preinvoke returns null, the stub will
            // recursively re-invoke itself.  Thus, the next call made from
            // the stub is another useLocalInvocation call.
            return false ;
        }

        return true ;
    }

}

// End of file.
