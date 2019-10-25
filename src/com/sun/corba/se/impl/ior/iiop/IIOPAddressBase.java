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

package com.sun.corba.se.impl.ior.iiop ;

import org.omg.CORBA.BAD_PARAM ;

import org.omg.CORBA_2_3.portable.InputStream ;
import org.omg.CORBA_2_3.portable.OutputStream ;

import com.sun.corba.se.spi.ior.iiop.IIOPAddress ;

/**
 * @author
 */
abstract class IIOPAddressBase implements IIOPAddress
{
    // Ports are marshalled as shorts on the wire.  The IDL
    // type is unsigned short, which lacks a convenient representation
    // in Java in the 32768-65536 range.  So, we treat ports as
    // ints throught this code, except that marshalling requires a
    // scaling conversion.  intToShort and shortToInt are provided
    // for this purpose.
    protected short intToShort( int value )
    {
        if (value > 32767)
            return (short)(value - 65536) ;
        return (short)value ;
    }

    protected int shortToInt( short value )
    {
        if (value < 0)
            return value + 65536 ;
        return value ;
    }

    public void write( OutputStream os )
    {
        os.write_string( getHost() ) ;
        int port = getPort() ;
        os.write_short( intToShort( port ) ) ;
    }

    public boolean equals( Object obj )
    {
        if (!(obj instanceof IIOPAddress))
            return false ;

        IIOPAddress other = (IIOPAddress)obj ;

        return getHost().equals(other.getHost()) &&
            (getPort() == other.getPort()) ;
    }

    public int hashCode()
    {
        return getHost().hashCode() ^ getPort() ;
    }

    public String toString()
    {
        return "IIOPAddress[" + getHost() + "," + getPort() + "]" ;
    }
}
