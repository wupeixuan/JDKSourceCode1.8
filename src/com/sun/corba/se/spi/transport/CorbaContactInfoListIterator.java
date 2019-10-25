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

package com.sun.corba.se.spi.transport ;

import com.sun.corba.se.pept.transport.ContactInfoListIterator ;

import com.sun.corba.se.spi.ior.IOR;
import com.sun.corba.se.spi.transport.CorbaContactInfo;

public interface CorbaContactInfoListIterator extends ContactInfoListIterator
{
    // REVISIT: this is GIOP specific.
    public void reportAddrDispositionRetry(CorbaContactInfo contactInfo,
                                           short disposition);

    public void reportRedirect(CorbaContactInfo contactInfo,
                               IOR forwardedIOR);

}

// End of file.
