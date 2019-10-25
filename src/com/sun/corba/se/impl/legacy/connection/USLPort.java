/*
 * Copyright (c) 2002, 2003, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.corba.se.impl.legacy.connection;

public class USLPort
{
    private String type;
    private int    port;

    public USLPort (String type, int port)
    {
        this.type = type;
        this.port = port;
    }

    public String getType  () { return type; }
    public int    getPort  () { return port; }
    public String toString () { return type + ":" + port; }
}

// End of file.
