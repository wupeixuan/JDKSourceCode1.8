/*
 * Copyright (c) 2003, 2004, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.corba.se.spi.presentation.rmi ;

import java.rmi.RemoteException ;

import org.omg.CORBA.portable.Delegate ;
import org.omg.CORBA.portable.OutputStream ;

import org.omg.CORBA.ORB ;

/** Interface used to support dynamically generated stubs.
 * This supplies some methods that are found in
 * org.omg.CORBA.portable.ObjectImpl that are not available
 * in org.omg.CORBA.Object.
 */
public interface DynamicStub extends org.omg.CORBA.Object
{
    /** Similar to ObjectImpl._set_delegate
     */
    void setDelegate( Delegate delegate ) ;

    /** Similar to ObjectImpl._get_delegate
     */
    Delegate getDelegate() ;

    /** Similar to ObjectImpl._orb()
     */
    ORB getORB() ;

    /** Similar to ObjectImpl._ids
     */
    String[] getTypeIds() ;

    /** Connect this dynamic stub to an ORB.
     * Just as in standard RMI-IIOP, this is required after
     * a dynamic stub is deserialized from an ObjectInputStream.
     * It is not needed when unmarshalling from a
     * org.omg.CORBA.portable.InputStream.
     */
    void connect( ORB orb ) throws RemoteException ;

    boolean isLocal() ;

    OutputStream request( String operation, boolean responseExpected ) ;
}
