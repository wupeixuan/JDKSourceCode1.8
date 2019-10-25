/*
 * Copyright (c) 2003, 2006, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.jmx.remote.internal;

import java.util.AbstractList;
import java.util.Iterator;

public class ArrayQueue<T> extends AbstractList<T> {
    public ArrayQueue(int capacity) {
        this.capacity = capacity + 1;
        this.queue = newArray(capacity + 1);
        this.head = 0;
        this.tail = 0;
    }

    public void resize(int newcapacity) {
        int size = size();
        if (newcapacity < size)
            throw new IndexOutOfBoundsException("Resizing would lose data");
        newcapacity++;
        if (newcapacity == this.capacity)
            return;
        T[] newqueue = newArray(newcapacity);
        for (int i = 0; i < size; i++)
            newqueue[i] = get(i);
        this.capacity = newcapacity;
        this.queue = newqueue;
        this.head = 0;
        this.tail = size;
    }

    @SuppressWarnings("unchecked")
    private T[] newArray(int size) {
        return (T[]) new Object[size];
    }

    public boolean add(T o) {
        queue[tail] = o;
        int newtail = (tail + 1) % capacity;
        if (newtail == head)
            throw new IndexOutOfBoundsException("Queue full");
        tail = newtail;
        return true; // we did add something
    }

    public T remove(int i) {
        if (i != 0)
            throw new IllegalArgumentException("Can only remove head of queue");
        if (head == tail)
            throw new IndexOutOfBoundsException("Queue empty");
        T removed = queue[head];
        queue[head] = null;
        head = (head + 1) % capacity;
        return removed;
    }

    public T get(int i) {
        int size = size();
        if (i < 0 || i >= size) {
            final String msg = "Index " + i + ", queue size " + size;
            throw new IndexOutOfBoundsException(msg);
        }
        int index = (head + i) % capacity;
        return queue[index];
    }

    public int size() {
        // Can't use % here because it's not mod: -3 % 2 is -1, not +1.
        int diff = tail - head;
        if (diff < 0)
            diff += capacity;
        return diff;
    }

    private int capacity;
    private T[] queue;
    private int head;
    private int tail;
}
