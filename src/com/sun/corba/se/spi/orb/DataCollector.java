/*
 * Copyright (c) 2002, Oracle and/or its affiliates. All rights reserved.
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
package com.sun.corba.se.spi.orb ;

import java.applet.Applet ;
import java.util.Properties ;
import java.util.Vector ;

/** Interface for collecting all sources of ORB configuration properties
 * into a single properties object.   A PropertyParser is needed so that
 * the set of property names of interest is known.
 */
public interface DataCollector {
    /** Return true iff this DataCollector was created from
     * applet data.
     */
    boolean isApplet() ;

    /** Return true iff the local host and ORB initial host are the same.
    * This is provided to avoid exposing the local host in insecure
    * contexts.
    */
    boolean initialHostIsLocal() ;

    /** Set the parser which is used to obtain property names.
     * This must be called before getProperties
     * may be called.  It may be called multiple times if different
     * sets of properties are needed for the same data sources.
     */
    void setParser( PropertyParser parser ) ;

    /** Return the consolidated property information to be used
     * for ORB configuration.  Note that -ORBInitRef arguments are
     * handled specially: all -ORBInitRef name=value arguments are
     * converted into ( org.omg.CORBA.ORBInitRef.name, value )
     * mappings in the resulting properties.  Also, -ORBInitialServices
     * is handled specially in applet mode: they are converted from
     * relative to absolute URLs.
     * @raises IllegalStateException if setPropertyNames has not
     * been called.
     */
    Properties getProperties() ;
}
