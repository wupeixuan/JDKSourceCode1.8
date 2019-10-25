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

package com.sun.corba.se.impl.oa.poa ;

import java.util.Enumeration ;

import org.omg.PortableServer.Servant ;
import org.omg.PortableServer.ServantManager ;
import org.omg.PortableServer.ForwardRequest ;
import org.omg.PortableServer.POAPackage.WrongPolicy ;
import org.omg.PortableServer.POAPackage.ObjectNotActive ;
import org.omg.PortableServer.POAPackage.ServantNotActive ;
import org.omg.PortableServer.POAPackage.ObjectAlreadyActive ;
import org.omg.PortableServer.POAPackage.ServantAlreadyActive ;
import org.omg.PortableServer.POAPackage.NoServant ;

import com.sun.corba.se.impl.orbutil.concurrent.SyncUtil ;
import com.sun.corba.se.impl.orbutil.ORBUtility ;
import com.sun.corba.se.impl.orbutil.ORBConstants ;

/** Implementation of POARequesHandler that provides policy specific
 * operations on the POA.
 */
public class POAPolicyMediatorImpl_R_UDS extends POAPolicyMediatorBase_R {
    private Servant defaultServant ;

    POAPolicyMediatorImpl_R_UDS( Policies policies, POAImpl poa )
    {
        // assert policies.retainServants()
        super( policies, poa ) ;
        defaultServant = null ;

        // policies.useDefaultServant()
        if (!policies.useDefaultServant())
            throw poa.invocationWrapper().policyMediatorBadPolicyInFactory() ;
    }

    protected java.lang.Object internalGetServant( byte[] id,
        String operation ) throws ForwardRequest
    {
        Servant servant = internalIdToServant( id ) ;
        if (servant == null)
            servant = defaultServant ;

        if (servant == null)
            throw poa.invocationWrapper().poaNoDefaultServant() ;

        return servant ;
    }

    public void etherealizeAll()
    {
        // NO-OP
    }

    public ServantManager getServantManager() throws WrongPolicy
    {
        throw new WrongPolicy();
    }

    public void setServantManager( ServantManager servantManager ) throws WrongPolicy
    {
        throw new WrongPolicy();
    }

    public Servant getDefaultServant() throws NoServant, WrongPolicy
    {
        if (defaultServant == null)
            throw new NoServant();
        else
            return defaultServant;
    }

    public void setDefaultServant( Servant servant ) throws WrongPolicy
    {
        defaultServant = servant;
        setDelegate(defaultServant, "DefaultServant".getBytes());
    }

    public Servant idToServant( byte[] id )
        throws WrongPolicy, ObjectNotActive
    {
        ActiveObjectMap.Key key = new ActiveObjectMap.Key( id ) ;
        Servant s = internalKeyToServant(key);

        if (s == null)
            if (defaultServant != null)
                s = defaultServant;

        if (s == null)
            throw new ObjectNotActive() ;

        return s;
    }
}
