/*
 * Copyright (c) 1999, 2003, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.corba.se.impl.activation;


import java.io.File;

import org.omg.CosNaming.NamingContext;
import com.sun.corba.se.spi.orb.ORB;
import com.sun.corba.se.impl.naming.pcosnaming.NameService;
import com.sun.corba.se.impl.orbutil.ORBConstants;

// REVISIT: After Merlin to see if we can get rid of this Thread and
// make the registration of PNameService for INS and BootStrap neat.
public class NameServiceStartThread extends java.lang.Thread
{
    private ORB orb;
    private File dbDir;

    public NameServiceStartThread( ORB theOrb, File theDir )
    {
        orb = theOrb;
        dbDir = theDir;
    }

    public void run( )
    {
        try {
            // start Name Service
            NameService nameService = new NameService(orb, dbDir );
            NamingContext rootContext = nameService.initialNamingContext();
            orb.register_initial_reference(
                ORBConstants.PERSISTENT_NAME_SERVICE_NAME, rootContext );
        } catch( Exception e ) {
            System.err.println(
                "NameService did not start successfully" );
            e.printStackTrace( );
        }
    }
}
