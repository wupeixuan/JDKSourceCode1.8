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

package com.sun.corba.se.impl.orbutil.fsm ;

import com.sun.corba.se.spi.orbutil.fsm.Action ;
import com.sun.corba.se.spi.orbutil.fsm.State ;
import com.sun.corba.se.spi.orbutil.fsm.Guard ;
import com.sun.corba.se.spi.orbutil.fsm.Input ;

import java.util.StringTokenizer ;

public class NameBase {
    private String name ;
    private String toStringName ;

    // Return just the name of the class, not the full qualified name.
    private String getClassName()
    {
        String fqn = this.getClass().getName() ;
        StringTokenizer st = new StringTokenizer( fqn, "." ) ;
        String token = st.nextToken() ;
        while (st.hasMoreTokens())
            token = st.nextToken() ;
        return token ;
    }

    private String getPreferredClassName()
    {
        if (this instanceof Action)
            return "Action" ;
        if (this instanceof State)
            return "State" ;
        if (this instanceof Guard)
            return "Guard" ;
        if (this instanceof Input)
            return "Input" ;
        return getClassName() ;
    }

    public NameBase( String name )
    {
        this.name = name ;
        toStringName = getPreferredClassName() + "[" + name + "]" ;
    }

    public String getName()
    {
        return name ;
    }

    public String toString() {
        return toStringName ;
    }
}
