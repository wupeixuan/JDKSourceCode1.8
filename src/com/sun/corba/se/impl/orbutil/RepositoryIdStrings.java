/*
 * Copyright (c) 2000, 2002, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.corba.se.impl.orbutil;

import java.io.Serializable;
import com.sun.corba.se.impl.io.TypeMismatchException;

/**
 * Factory methods for creating various repository ID strings
 * and instances.
 */
public interface RepositoryIdStrings
{
    String createForAnyType(Class type);

    String createForJavaType(Serializable ser)
        throws TypeMismatchException;

    String createForJavaType(Class clz)
        throws TypeMismatchException;

    String createSequenceRepID(java.lang.Object ser);

    String createSequenceRepID(java.lang.Class clazz);

    RepositoryIdInterface getFromString(String repIdString);

    String getClassDescValueRepId();
    String getWStringValueRepId();
}
