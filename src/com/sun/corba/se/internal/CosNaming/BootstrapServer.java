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

package com.sun.corba.se.internal.CosNaming;

import java.util.Enumeration;
import java.util.Properties;

import java.io.File;
import java.io.FileInputStream;

import com.sun.corba.se.spi.orb.ORB ;

import com.sun.corba.se.spi.resolver.Resolver ;
import com.sun.corba.se.spi.resolver.LocalResolver ;
import com.sun.corba.se.spi.resolver.ResolverDefault ;

import com.sun.corba.se.impl.orbutil.CorbaResourceUtil;
import com.sun.corba.se.impl.orbutil.ORBConstants;

/**
 * Class BootstrapServer is the main entry point for the bootstrap server
 * implementation.  The BootstrapServer makes all object references
 * defined in a configurable file available using the old
 * naming bootstrap protocol.
 */
public class BootstrapServer
{
    private ORB orb;

     /**
     * Main startup routine for the bootstrap server.
     * It first determines the port on which to listen, checks that the
     * specified file is available, and then creates the resolver
     * that will be used to service the requests in the
     * BootstrapServerRequestDispatcher.
     * @param args the command-line arguments to the main program.
     */
    public static final void main(String[] args)
    {
        String propertiesFilename = null;
        int initialPort = ORBConstants.DEFAULT_INITIAL_PORT;

        // Process arguments
        for (int i=0;i<args.length;i++) {
            // Look for the filename
            if (args[i].equals("-InitialServicesFile") && i < args.length -1) {
                propertiesFilename = args[i+1];
            }

            // Was the initial port specified? If so, override
            // This property normally is applied for the client side
            // configuration of resolvers.  Here we are using it to
            // define the server port that the with which the resolvers
            // communicate.
            if (args[i].equals("-ORBInitialPort") && i < args.length-1) {
                initialPort = java.lang.Integer.parseInt(args[i+1]);
            }
        }

        if (propertiesFilename == null) {
            System.out.println( CorbaResourceUtil.getText("bootstrap.usage",
                "BootstrapServer"));
            return;
        }

        // Create a file
        File file = new File(propertiesFilename);

        // Verify that if it exists, it is readable
        if (file.exists() == true && file.canRead() == false) {
            System.err.println(CorbaResourceUtil.getText(
                "bootstrap.filenotreadable", file.getAbsolutePath()));
            return;
        }

        // Success: start up
        System.out.println(CorbaResourceUtil.getText(
            "bootstrap.success", Integer.toString(initialPort),
            file.getAbsolutePath()));

        Properties props = new Properties() ;

        // Use the SERVER_PORT to create an Acceptor using the
        // old legacy code in ORBConfiguratorImpl.  When (if?)
        // the legacy support is removed, this code will need
        // to create an Acceptor directly.
        props.put( ORBConstants.SERVER_PORT_PROPERTY,
            Integer.toString( initialPort ) ) ;

        ORB orb = (ORB) org.omg.CORBA.ORB.init(args,props);

        LocalResolver lres = orb.getLocalResolver() ;
        Resolver fres = ResolverDefault.makeFileResolver( orb, file ) ;
        Resolver cres = ResolverDefault.makeCompositeResolver( fres, lres ) ;
        LocalResolver sres = ResolverDefault.makeSplitLocalResolver( cres, lres ) ;

        orb.setLocalResolver( sres ) ;

        try {
            // This causes the acceptors to start listening.
            orb.resolve_initial_references(ORBConstants.ROOT_POA_NAME);
        } catch (org.omg.CORBA.ORBPackage.InvalidName e) {
            RuntimeException rte = new RuntimeException("This should not happen");
            rte.initCause(e);
            throw rte;
        }

        orb.run() ;
    }
}
