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

package com.sun.corba.se.impl.orbutil.closure ;

import com.sun.corba.se.spi.orbutil.closure.Closure ;

public class Future implements Closure {
    private boolean evaluated ;
    private Closure closure ;
    private Object value ;

    public Future( Closure value )
    {
        this.evaluated = false ;
        this.closure = (Closure)value ;
        this.value = null ;
    }

    public synchronized Object evaluate()
    {
        if (!evaluated) {
            evaluated = true ;
            value = closure.evaluate() ;
        }

        return value ;
    }
}
