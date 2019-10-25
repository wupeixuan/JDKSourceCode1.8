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

package com.sun.corba.se.impl.ior ;

import java.util.Iterator ;

import org.omg.CORBA_2_3.portable.OutputStream ;

import com.sun.corba.se.spi.ior.ObjectAdapterId ;

abstract class ObjectAdapterIdBase implements ObjectAdapterId {
    public boolean equals( Object other )
    {
        if (!(other instanceof ObjectAdapterId))
            return false ;

        ObjectAdapterId theOther = (ObjectAdapterId)other ;

        Iterator iter1 = iterator() ;
        Iterator iter2 = theOther.iterator() ;

        while (iter1.hasNext() && iter2.hasNext()) {
            String str1 = (String)(iter1.next()) ;
            String str2 = (String)(iter2.next()) ;

            if (!str1.equals( str2 ))
                return false ;
        }

        return iter1.hasNext() == iter2.hasNext() ;
    }

    public int hashCode()
    {
        int result = 17 ;
        Iterator iter = iterator() ;
        while (iter.hasNext()) {
            String str = (String)(iter.next()) ;
            result = 37*result + str.hashCode() ;
        }
        return result ;
    }

    public String toString()
    {
        StringBuffer buff = new StringBuffer() ;
        buff.append( "ObjectAdapterID[" ) ;
        Iterator iter = iterator() ;
        boolean first = true ;
        while (iter.hasNext()) {
            String str = (String)(iter.next()) ;

            if (first)
                first = false ;
            else
                buff.append( "/" ) ;

            buff.append( str ) ;
        }

        buff.append( "]" ) ;

        return buff.toString() ;
    }

    public void write( OutputStream os )
    {
        os.write_long( getNumLevels() ) ;
        Iterator iter = iterator() ;
        while (iter.hasNext()) {
            String str = (String)(iter.next()) ;
            os.write_string( str ) ;
        }
    }
}
