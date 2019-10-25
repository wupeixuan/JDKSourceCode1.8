/*
 * Copyright (c) 2000, 2003, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.corba.se.impl.ior;

import com.sun.corba.se.spi.ior.Identifiable ;

import com.sun.corba.se.spi.orb.ORB ;

import com.sun.corba.se.impl.ior.IdentifiableFactoryFinderBase ;

import org.omg.CORBA_2_3.portable.InputStream ;

/**
 * @author
 */
public class TaggedProfileFactoryFinderImpl extends
    IdentifiableFactoryFinderBase
{
    public TaggedProfileFactoryFinderImpl( ORB orb )
    {
        super( orb ) ;
    }

    public Identifiable handleMissingFactory( int id, InputStream is)
    {
        return new GenericTaggedProfile( id, is ) ;
    }
}
