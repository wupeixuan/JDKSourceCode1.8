/*
 * Copyright (c) 2003, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.corba.se.spi.copyobject ;

/** Provides an interface for a variety of means to copy an arbitrary
 * object.  Any implementation of this interface must return an exact
 * copy of obj, preserving all aliasing across all objects reachable
 * from obj.  ReflectiveCopyException must be thrown if the implementation
 * cannot copy obj for some reason.  Note that a trivial implementation
 * of this interface is possible (always return obj), but this is often
 * not the desired implementation.
 */
public interface ObjectCopier {
    Object copy( Object obj ) throws ReflectiveCopyException ;
}
