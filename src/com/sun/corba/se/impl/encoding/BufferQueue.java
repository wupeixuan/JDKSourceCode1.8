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
package com.sun.corba.se.impl.encoding;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.LinkedList;

/**
 * Simple unsynchronized queue implementation for ByteBufferWithInfos.
 */
// XREVISIT - Should be in orbutil or package private
public class BufferQueue
{
    private LinkedList list = new LinkedList();

    public void enqueue(ByteBufferWithInfo item)
    {
        list.addLast(item);
    }

    public ByteBufferWithInfo dequeue() throws NoSuchElementException
    {
        return (ByteBufferWithInfo)list.removeFirst();
    }

    public int size()
    {
        return list.size();
    }

    // Adds the given ByteBufferWithInfo to the front
    // of the queue.
    public void push(ByteBufferWithInfo item)
    {
        list.addFirst(item);
    }
}
