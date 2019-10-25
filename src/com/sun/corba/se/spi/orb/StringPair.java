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
package com.sun.corba.se.spi.orb ;

public class StringPair {
    private String first ;
    private String second ;

    public boolean equals( Object obj )
    {
        if (this == obj)
            return true ;

        if (!(obj instanceof StringPair))
            return false ;

        StringPair other = (StringPair)obj ;

        return (first.equals( other.first ) &&
            second.equals( other.second )) ;
    }

    public int hashCode()
    {
        return first.hashCode() ^ second.hashCode() ;
    }

    public StringPair( String first, String second )
    {
        this.first = first ;
        this.second = second ;
    }

    public String getFirst()
    {
        return first ;
    }

    public String getSecond()
    {
        return second ;
    }
}
