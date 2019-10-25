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

package com.sun.corba.se.spi.copyobject ;

import com.sun.corba.se.spi.orb.ORB ;

import com.sun.corba.se.impl.copyobject.ReferenceObjectCopierImpl ;
import com.sun.corba.se.impl.copyobject.FallbackObjectCopierImpl ;
import com.sun.corba.se.impl.copyobject.ORBStreamObjectCopierImpl ;
import com.sun.corba.se.impl.copyobject.JavaStreamObjectCopierImpl ;

public abstract class CopyobjectDefaults
{
    private CopyobjectDefaults() { }

    /** Obtain the ORB stream copier factory.  Note that this version behaves differently
     * than the others: each ObjectCopier produced by the factory only preserves aliasing
     * within a single call to copy.  The others copiers all preserve aliasing across
     * all calls to copy (on the same ObjectCopier instance).
     */
    public static ObjectCopierFactory makeORBStreamObjectCopierFactory( final ORB orb )
    {
        return new ObjectCopierFactory() {
            public ObjectCopier make( )
            {
                return new ORBStreamObjectCopierImpl( orb ) ;
            }
        } ;
    }

    public static ObjectCopierFactory makeJavaStreamObjectCopierFactory( final ORB orb )
    {
        return new ObjectCopierFactory() {
            public ObjectCopier make( )
            {
                return new JavaStreamObjectCopierImpl( orb ) ;
            }
        } ;
    }

    private static final ObjectCopier referenceObjectCopier = new ReferenceObjectCopierImpl() ;

    private static ObjectCopierFactory referenceObjectCopierFactory =
        new ObjectCopierFactory() {
            public ObjectCopier make()
            {
                return referenceObjectCopier ;
            }
        } ;

    /** Obtain the reference object "copier".  This does no copies: it just
     * returns whatever is passed to it.
     */
    public static ObjectCopierFactory getReferenceObjectCopierFactory()
    {
        return referenceObjectCopierFactory ;
    }

    /** Create a fallback copier factory from the two ObjectCopierFactory
     * arguments.  This copier makes an ObjectCopierFactory that creates
     * instances of a fallback copier that first tries an ObjectCopier
     * created from f1, then tries one created from f2, if the first
     * throws a ReflectiveCopyException.
     */
    public static ObjectCopierFactory makeFallbackObjectCopierFactory(
        final ObjectCopierFactory f1, final ObjectCopierFactory f2 )
    {
        return new ObjectCopierFactory() {
            public ObjectCopier make()
            {
                ObjectCopier c1 = f1.make() ;
                ObjectCopier c2 = f2.make() ;
                return new FallbackObjectCopierImpl( c1, c2 ) ;
            }
        } ;
    }
}
