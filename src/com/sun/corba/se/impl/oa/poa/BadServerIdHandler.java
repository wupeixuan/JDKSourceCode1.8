/*
 * Copyright (c) 1997, 2003, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.corba.se.impl.oa.poa;

import com.sun.corba.se.spi.ior.ObjectKey;

/**
 * The bad server id handler is used to locate persistent objects.
 * The Locator object registers the BadServerIdHandler with the ORB
 * and when requests for persistent objects for servers (other than
 * itself) comes, it throws a ForwardException with the IOR pointing
 * to the active server.
 */
public interface BadServerIdHandler
{
    void handle(ObjectKey objectKey) ;
}
