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

import com.sun.corba.se.impl.oa.NullServantImpl ;

/** Implementation of POARequesHandler that provides policy specific
 * operations on the POA in the case:
 * <ul>
 * <li>retain</li>
 * <li>useActiveObjectMapOnly</li>
 * </ul>
 */
public class POAPolicyMediatorImpl_R_AOM extends POAPolicyMediatorBase_R {
    POAPolicyMediatorImpl_R_AOM( Policies policies, POAImpl poa )
    {
        // assert policies.retainServants()
        super( policies, poa ) ;

        // policies.useActiveObjectMapOnly()
        if (!policies.useActiveMapOnly())
            throw poa.invocationWrapper().policyMediatorBadPolicyInFactory() ;
    }

    protected java.lang.Object internalGetServant( byte[] id,
        String operation ) throws ForwardRequest
    {
        java.lang.Object servant = internalIdToServant( id ) ;
        if (servant == null)
            servant = new NullServantImpl(
                poa.invocationWrapper().nullServant() ) ;
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

    public void setServantManager( ServantManager servantManager )
        throws WrongPolicy
    {
        throw new WrongPolicy();
    }

    public Servant getDefaultServant() throws NoServant, WrongPolicy
    {
        throw new WrongPolicy();
    }

    public void setDefaultServant( Servant servant ) throws WrongPolicy
    {
        throw new WrongPolicy();
    }

    public Servant idToServant( byte[] id )
        throws WrongPolicy, ObjectNotActive
    {
        Servant s = internalIdToServant( id ) ;

        if (s == null)
            throw new ObjectNotActive() ;
        else
            return s;
    }
}
