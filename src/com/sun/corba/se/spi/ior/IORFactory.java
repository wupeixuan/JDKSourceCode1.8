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

package com.sun.corba.se.spi.ior ;

import com.sun.corba.se.spi.orb.ORB ;

/** An IORFactory provides the capability of creating IORs.  It contains
 * some collection of TaggedProfileTemplates, which can be iterated over
 * for portable interceptors.
 */
public interface IORFactory extends Writeable, MakeImmutable {
    /** Construct an IOR containing the given ORB, typeid, and ObjectId.
     * The same ObjectId will be used for all TaggedProfileTemplates in
     * the IORFactory.
     */
    IOR makeIOR( ORB orb, String typeid, ObjectId oid ) ;

    /** Return true iff this.makeIOR(orb,typeid,oid).isEquivalent(
     * other.makeIOR(orb,typeid,oid) for all orb, typeid, and oid.
     */
    boolean isEquivalent( IORFactory other ) ;
}
