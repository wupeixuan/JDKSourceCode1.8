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

package com.sun.corba.se.impl.protocol.giopmsgheaders;

import org.omg.CORBA.SystemException;
import com.sun.corba.se.spi.ior.IOR;

public interface LocateReplyOrReplyMessage extends Message {

    int getRequestId();
    int getReplyStatus();
    SystemException getSystemException(String message);
    IOR getIOR();
    short getAddrDisposition();
}

// End of file.
