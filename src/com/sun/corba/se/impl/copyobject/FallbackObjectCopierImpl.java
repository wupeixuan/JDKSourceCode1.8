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

package com.sun.corba.se.impl.copyobject ;

import com.sun.corba.se.spi.copyobject.ObjectCopier ;
import com.sun.corba.se.spi.copyobject.ReflectiveCopyException ;

/** Trys a first ObjectCopier.  If the first throws a ReflectiveCopyException,
 * falls back and tries a second ObjectCopier.
 */
public class FallbackObjectCopierImpl implements ObjectCopier
{
    private ObjectCopier first ;
    private ObjectCopier second ;

    public FallbackObjectCopierImpl( ObjectCopier first,
        ObjectCopier second )
    {
        this.first = first ;
        this.second = second ;
    }

    public Object copy( Object src ) throws ReflectiveCopyException
    {
        try {
            return first.copy( src ) ;
        } catch (ReflectiveCopyException rce ) {
            // XXX log this fallback at a low level
            return second.copy( src ) ;
        }
    }
}
