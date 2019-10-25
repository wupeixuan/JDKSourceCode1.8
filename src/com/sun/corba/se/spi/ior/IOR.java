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

package com.sun.corba.se.spi.ior;

import java.util.List ;
import java.util.Iterator ;

import com.sun.corba.se.spi.orb.ORBVersion ;

import com.sun.corba.se.spi.ior.iiop.GIOPVersion ;
import com.sun.corba.se.spi.ior.iiop.IIOPProfile ;

import com.sun.corba.se.spi.orb.ORB ;

/** An IOR is represented as a list of profiles.
* Only instances of TaggedProfile are contained in the list.
*/
public interface IOR extends List, Writeable, MakeImmutable
{
    ORB getORB() ;

    /** Return the type id string from the IOR.
    */
    String getTypeId() ;

    /** Return an iterator that iterates over tagged profiles with
    * identifier id.  It is not possible to modify the list through this
    * iterator.
    */
    Iterator iteratorById( int id ) ;

    /** Return a representation of this IOR in the standard GIOP stringified
     * format that begins with "IOR:".
     */
    String stringify() ;

    /** Return a representation of this IOR in the standard GIOP marshalled
     * form.
     */
    org.omg.IOP.IOR getIOPIOR() ;

    /** Return true if this IOR has no profiles.
     */
    boolean isNil() ;

    /** Return true if this IOR is equivalent to ior.  Here equivalent means
     * that the typeids are the same, they have the same number of profiles,
     * and each profile is equivalent to the corresponding profile.
     */
    boolean isEquivalent(IOR ior) ;

    /** Return the IORTemplate for this IOR.  This is simply a list
     * of all TaggedProfileTemplates derived from the TaggedProfiles
     * of the IOR.
     */
    IORTemplateList getIORTemplates() ;

    /** Return the first IIOPProfile in this IOR.
     * XXX THIS IS TEMPORARY FOR BACKWARDS COMPATIBILITY AND WILL BE REMOVED
     * SOON!
     */
    IIOPProfile getProfile() ;
}
