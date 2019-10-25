/*
 * Copyright (c) 2003, 2004, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.corba.se.spi.presentation.rmi ;

import java.lang.reflect.Method ;

/** Translates between methods on an interface and RMI-IIOP encodings
 * of those methods as names.
 */
public interface IDLNameTranslator
{
    /** Get the interfaces that this IDLNameTranslator describes.
     */
    Class[] getInterfaces() ;

    /** Get all methods for this remote interface.
     * The methods are returned in a canonical order, that is,
     * they are always in the same order for a particular interface.
     */
    Method[] getMethods() ;

    /** Get the method from this IDLNameTranslator's interfaces that
     * corresponds to the mangled name idlName.  Returns null
     * if there is no matching method.
     */
    Method getMethod( String idlName )  ;

    /** Get the mangled name that corresponds to the given method
     * on this IDLNameTranslator's interface.  Returns null
     * if there is no matching name.
     */
    String getIDLName( Method method )  ;
}
