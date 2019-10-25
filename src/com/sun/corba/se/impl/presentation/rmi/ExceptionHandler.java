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

package com.sun.corba.se.impl.presentation.rmi ;

import org.omg.CORBA_2_3.portable.InputStream ;
import org.omg.CORBA_2_3.portable.OutputStream ;

import org.omg.CORBA.portable.ApplicationException ;

public interface ExceptionHandler
{
    /** Return true iff cls is an exception class that is
     * assignment compatible with an exception declared
     * on the method used to create this ExceptionHandler.
     */
    boolean isDeclaredException( Class cls ) ;

    /** Write the exception ex to os.  ex must be assignment
     * compatible with an exception
     * declared on the method used to create this
     * ExceptionHandler.
     */
    void writeException( OutputStream os, Exception ex ) ;

    /** Read the exception contained in the InputStream
     * in the ApplicationException.  If ae represents
     * an exception that is assignment compatible with
     * an exception on the method used to create this
     * exception handler, return the exception,
     * otherwise return an UnexpectedException wrapping
     * the exception in ae.
     */
    Exception readException( ApplicationException ae ) ;
}
