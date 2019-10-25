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

import org.omg.CORBA_2_3.portable.OutputStream ;

import com.sun.corba.se.spi.orb.ORBVersion ;
import com.sun.corba.se.spi.orb.ORB ;

import com.sun.corba.se.spi.protocol.CorbaServerRequestDispatcher ;

/** An ObjectKeyTemplate represents the part of an Object Key
 * that corresponds to the object adapter used to create an
 * object reference.  The template is shared between many
 * object references.
 */
public interface ObjectKeyTemplate extends Writeable
{
    public ORBVersion getORBVersion() ;

    /** An ID used to determine how to perform operations on this
     * ObjectKeyTemplate.  This id determines how to process requests
     * on this object reference, and what object adapter type to use.
     */
    public int getSubcontractId();

    /** Return the server ID for this template.
    * For CORBA 3.0, this should be a String, but it is currently
    * an int in the object key template.
    */
    public int getServerId() ;

    /** Return the ORB ID for this template.
    */
    public String getORBId() ;

    /** Return the object adapter ID for this template.
    */
    public ObjectAdapterId getObjectAdapterId() ;

    /** Compute an adapter ID for this template than includes
    * all of the template information.
    * This value is cached to avoid the expense of recomputing
    * it.
    */
    public byte[] getAdapterId() ;

    public void write(ObjectId objectId, OutputStream os);

    public CorbaServerRequestDispatcher getServerRequestDispatcher( ORB orb, ObjectId id ) ;
}
