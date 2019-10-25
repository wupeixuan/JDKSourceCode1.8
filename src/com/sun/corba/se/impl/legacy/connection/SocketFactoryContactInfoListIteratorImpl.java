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

package com.sun.corba.se.impl.legacy.connection;

import org.omg.CORBA.CompletionStatus;
import org.omg.CORBA.SystemException;

import com.sun.corba.se.pept.transport.ContactInfo;

import com.sun.corba.se.spi.legacy.connection.GetEndPointInfoAgainException;
import com.sun.corba.se.spi.orb.ORB;
import com.sun.corba.se.spi.transport.CorbaContactInfo;
import com.sun.corba.se.spi.transport.CorbaContactInfoList;
import com.sun.corba.se.spi.transport.SocketInfo;

import com.sun.corba.se.impl.transport.CorbaContactInfoListIteratorImpl;
import com.sun.corba.se.impl.transport.SharedCDRContactInfoImpl;

public class SocketFactoryContactInfoListIteratorImpl
    extends CorbaContactInfoListIteratorImpl
{
    private SocketInfo socketInfoCookie;

    public SocketFactoryContactInfoListIteratorImpl(
        ORB orb,
        CorbaContactInfoList corbaContactInfoList)
    {
        super(orb, corbaContactInfoList, null, null);
    }

    ////////////////////////////////////////////////////
    //
    // java.util.Iterator
    //

    public boolean hasNext()
    {
        return true;
    }

    public Object next()
    {
        if (contactInfoList.getEffectiveTargetIOR().getProfile().isLocal()){
            return new SharedCDRContactInfoImpl(
                orb, contactInfoList,
                contactInfoList.getEffectiveTargetIOR(),
                orb.getORBData().getGIOPAddressDisposition());
        } else {
            // REVISIT:
            // on comm_failure maybe need to give IOR instead of located.
            return new SocketFactoryContactInfoImpl(
                orb, contactInfoList,
                contactInfoList.getEffectiveTargetIOR(),
                orb.getORBData().getGIOPAddressDisposition(),
                socketInfoCookie);
        }
    }

    ////////////////////////////////////////////////////
    //
    // pept.ContactInfoListIterator
    //

    public boolean reportException(ContactInfo contactInfo,
                                   RuntimeException ex)
    {
        this.failureContactInfo = (CorbaContactInfo)contactInfo;
        this.failureException = ex;
        if (ex instanceof org.omg.CORBA.COMM_FAILURE) {

            if (ex.getCause() instanceof GetEndPointInfoAgainException) {
                socketInfoCookie =
                    ((GetEndPointInfoAgainException) ex.getCause())
                    .getEndPointInfo();
                return true;
            }

            SystemException se = (SystemException) ex;
            if (se.completed == CompletionStatus.COMPLETED_NO) {
                if (contactInfoList.getEffectiveTargetIOR() !=
                    contactInfoList.getTargetIOR())
                {
                    // retry from root ior
                    contactInfoList.setEffectiveTargetIOR(
                        contactInfoList.getTargetIOR());
                    return true;
                }
            }
        }
        return false;
    }
}

// End of file.
