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

import com.sun.corba.se.spi.orb.ORB ;

/** ObjectCopier factory interface used for registration.
 */
public interface ObjectCopierFactory {
    /** Create a new instance of an ObjectCopier.
    */
    ObjectCopier make() ;
}
