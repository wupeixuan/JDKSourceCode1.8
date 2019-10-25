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

import com.sun.corba.se.spi.protocol.CorbaServerRequestDispatcher ;

import com.sun.corba.se.spi.orb.ORB ;

/** The full object key, which is contained in an IIOPProfile.
* The object identifier corresponds to the information passed into
* POA::create_reference_with_id and POA::create_reference
* (in the POA case).  The template
* represents the information that is object adapter specific and
* shared across multiple ObjectKey instances.
*/
public interface ObjectKey extends Writeable
{
    /** Return the object identifier for this Object key.
    */
    ObjectId getId() ;

    /** Return the template for this object key.
    */
    ObjectKeyTemplate getTemplate()  ;

    byte[] getBytes( org.omg.CORBA.ORB orb ) ;

    CorbaServerRequestDispatcher getServerRequestDispatcher( ORB orb ) ;
}
