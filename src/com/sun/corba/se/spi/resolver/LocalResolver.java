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

package com.sun.corba.se.spi.resolver ;

import com.sun.corba.se.spi.orbutil.closure.Closure ;

/** A LocalResolver is a Resolver that allows registration of (name, CORBA object)
 * bindings.
 */
public interface LocalResolver extends Resolver {
    /** Register the Closure with the given name.
     * The Closure must evaluate to an org.omg.CORBA.Object.
     */
    void register( String name, Closure closure ) ;
}
