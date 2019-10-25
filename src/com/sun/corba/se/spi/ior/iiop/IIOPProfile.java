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

package com.sun.corba.se.spi.ior.iiop;

import com.sun.corba.se.spi.ior.TaggedProfile ;

import com.sun.corba.se.spi.orb.ORB ;
import com.sun.corba.se.spi.orb.ORBVersion ;

import com.sun.corba.se.spi.ior.iiop.GIOPVersion ;

/** IIOPProfile represents an IIOP tagged profile.
* It is essentially composed of an object identifier and
* a template.  The template contains all of the
* IIOP specific information in the profile.
* Templates are frequently shared between many different profiles,
* while the object identifiy is unique to each profile.
*/
public interface IIOPProfile extends TaggedProfile
{
    ORBVersion getORBVersion() ;

    /** Return the servant for this profile, if it is local
     * AND if the OA that implements this objref supports direct access to servants
     * outside of an invocation.
     * XXX move this to the ObjectKeyTemplate
     */
    java.lang.Object getServant() ;

    /** Return the GIOPVersion of this profile.  Caches the result.
     */
    GIOPVersion getGIOPVersion() ;

    /** Return the Codebase of this profile.  Caches the result.
     */
    String getCodebase() ;
}
