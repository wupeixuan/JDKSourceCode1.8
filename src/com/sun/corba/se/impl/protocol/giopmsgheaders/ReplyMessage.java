/*
 * Copyright (c) 2000, 2003, Oracle and/or its affiliates. All rights reserved.
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

import com.sun.corba.se.spi.servicecontext.ServiceContexts;
import org.omg.CORBA.SystemException;
import com.sun.corba.se.spi.ior.IOR;

/**
 * This interface captures the ReplyMessage contract.
 *
 * @author Ram Jeyaraman 05/14/2000
 */

public interface ReplyMessage extends Message, LocateReplyOrReplyMessage {

    // Note: If the value, order, or number of these constants change,
    // please update the REPLY_MESSAGE_TO_PI_REPLY_STATUS table in PIHandlerImpl.
    int NO_EXCEPTION = 0;
    int USER_EXCEPTION = 1;
    int SYSTEM_EXCEPTION = 2;
    int LOCATION_FORWARD = 3;
    int LOCATION_FORWARD_PERM = 4;  // 1.2
    int NEEDS_ADDRESSING_MODE = 5;  // 1.2

    ServiceContexts getServiceContexts();
    void setServiceContexts( ServiceContexts sc );
    void setIOR( IOR newIOR );
}
