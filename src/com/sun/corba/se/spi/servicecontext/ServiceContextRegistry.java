/*
 * Copyright (c) 1999, 2004, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.corba.se.spi.servicecontext;

import org.omg.CORBA.BAD_PARAM;
import java.util.Vector ;
import java.util.Enumeration ;
import com.sun.corba.se.spi.servicecontext.ServiceContext ;
import com.sun.corba.se.spi.servicecontext.ServiceContextData ;
import com.sun.corba.se.spi.orb.ORB ;
import com.sun.corba.se.impl.orbutil.ORBUtility ;

public class ServiceContextRegistry {
    private ORB orb ;
    private Vector scCollection ;

    private void dprint( String msg )
    {
        ORBUtility.dprint( this, msg ) ;
    }

    public ServiceContextRegistry( ORB orb )
    {
        scCollection = new Vector() ;
        this.orb = orb ;
    }

    /** Register the ServiceContext class so that it will be recognized
     * by the read method.
     * Class cls must have the following properties:
     * <ul>
     * <li>It must derive from com.sun.corba.se.spi.servicecontext.ServiceContext.</li>
     * <li>It must have a public static final int SERVICE_CONTEXT_ID
     * member.</li>
     * <li>It must implement a constructor that takes a
     * org.omg.CORBA_2_3.portable.InputStream argument.</li>
     * </ul>
     */
    public void register( Class cls )
    {
        if (ORB.ORBInitDebug)
            dprint( "Registering service context class " + cls ) ;

        ServiceContextData scd = new ServiceContextData( cls ) ;

        if (findServiceContextData(scd.getId()) == null)
            scCollection.addElement( scd ) ;
        else
            throw new BAD_PARAM( "Tried to register duplicate service context" ) ;
    }

    public ServiceContextData findServiceContextData( int scId )
    {
        if (ORB.ORBInitDebug)
            dprint( "Searching registry for service context id " + scId ) ;

        Enumeration enumeration = scCollection.elements() ;
        while (enumeration.hasMoreElements()) {
            ServiceContextData scd =
                (ServiceContextData)(enumeration.nextElement()) ;
            if (scd.getId() == scId) {
                if (ORB.ORBInitDebug)
                    dprint( "Service context data found: " + scd ) ;

                return scd ;
            }
        }

        if (ORB.ORBInitDebug)
            dprint( "Service context data not found" ) ;

        return null ;
    }
}
