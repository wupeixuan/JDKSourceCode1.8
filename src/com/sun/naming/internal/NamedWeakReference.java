/*
 * Copyright (c) 2001, 2011, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.naming.internal;


/**
 * A NamedWeakReference is a WeakReference with an immutable string name.
 *
 * @author Scott Seligman
 */


class NamedWeakReference<T> extends java.lang.ref.WeakReference<T> {

    private final String name;

    NamedWeakReference(T referent, String name) {
        super(referent);
        this.name = name;
    }

    String getName() {
        return name;
    }
}
