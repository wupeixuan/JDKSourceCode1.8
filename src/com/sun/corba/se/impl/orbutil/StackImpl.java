/*
 * Copyright (c) 2001, 2003, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.corba.se.impl.orbutil ;

import java.util.EmptyStackException ;

// We implement a Stack here instead of using java.util.Stack because
// java.util.Stack is thread-safe, negatively impacting performance.
// We use an ArrayList instead since it is not thread-safe.
// RequestInfoStack is used quite frequently.
public class StackImpl {
    // The stack for RequestInfo objects.
    private Object[] data = new Object[3] ;
    private int top = -1 ;

    // Tests if this stack is empty.
    public final boolean empty() {
        return top == -1;
    }

    // Looks at the object at the top of this stack without removing it
    // from the stack.
    public final Object peek() {
        if (empty())
            throw new EmptyStackException();

        return data[ top ];
    }

    // Removes the object at the top of this stack and returns that
    // object as the value of this function.
    public final Object pop() {
        Object obj = peek() ;
        data[top] = null ;
        top-- ;
        return obj;
    }

    private void ensure()
    {
        if (top == (data.length-1)) {
            int newSize = 2*data.length ;
            Object[] newData = new Object[ newSize ] ;
            System.arraycopy( data, 0, newData, 0, data.length ) ;
            data = newData ;
        }
    }

    // Pushes an item onto the top of the stack
    public final Object push( Object item ) {
        ensure() ;
        top++ ;
        data[top] = item;
        return item;
    }
}
