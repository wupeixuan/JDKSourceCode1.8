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

/** Manager of ObjectCopier implementations used to support javax.rmi.CORBA.Util.copyObject(s).
 * This provides simple methods for registering all supported ObjectCopier factories.
 * A default copier is also supported, for use in contexts where no specific copier id
 * is available.
 */
public interface CopierManager
{
    /** Set the Id of the copier to use if no other copier has been set.
     */
    void setDefaultId( int id ) ;

    /** Return the copier for the default copier id.  Throws a BAD_PARAM exception
     * if no default copier id has been set.
     */
    int getDefaultId() ;

    ObjectCopierFactory getObjectCopierFactory( int id ) ;

    ObjectCopierFactory getDefaultObjectCopierFactory() ;

    /** Register an ObjectCopierFactory under a particular id.  This can be retrieved
     * later by getObjectCopierFactory.
     */
    void registerObjectCopierFactory( ObjectCopierFactory factory, int id ) ;
}
