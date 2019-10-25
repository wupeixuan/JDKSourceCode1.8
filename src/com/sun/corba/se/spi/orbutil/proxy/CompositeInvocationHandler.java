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

package com.sun.corba.se.spi.orbutil.proxy ;

import java.io.Serializable ;
import java.lang.reflect.InvocationHandler ;

public interface CompositeInvocationHandler extends InvocationHandler,
    Serializable
{
    /** Add an invocation handler for all methods on interface interf.
     */
    void addInvocationHandler( Class interf, InvocationHandler handler ) ;

    /** Set the default invocation handler to use if none of the
     * invocation handlers added by calls to addInvocationHandler apply.
     */
    void setDefaultHandler( InvocationHandler handler ) ;
}
