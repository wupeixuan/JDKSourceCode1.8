/*
 * Copyright (c) 2004, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.corba.se.spi.transport;

import java.util.List;

import com.sun.corba.se.spi.ior.IOR;

public interface IORToSocketInfo
{
    /**
     * Used to extract socket address information from an IOR.
     *
     * @param ior.
     *
     * @return List - a list of SocketInfo.
     *
     */
    public List getSocketInfo(IOR ior);
}

// End of file.
