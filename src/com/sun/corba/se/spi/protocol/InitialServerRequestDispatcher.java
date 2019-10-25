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

package com.sun.corba.se.spi.protocol;

import com.sun.corba.se.spi.resolver.Resolver ;

/** InitialServerRequestDispatcher is a specialized version of a ServerRequestDispatcher
 * that provides an initialization method.  This delegate is used
 * to implement bootstrapping of initial object references.
 */
public interface InitialServerRequestDispatcher
    extends CorbaServerRequestDispatcher
{
    /** Plug in the resolver that this InitialServerRequestDispatcher should
     * use in order to lookup or list initial name to object reference
     * bindings.
     */
    void init( Resolver resolver ) ;
}
