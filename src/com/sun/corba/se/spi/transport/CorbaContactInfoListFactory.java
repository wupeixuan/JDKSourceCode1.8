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

import com.sun.corba.se.spi.transport.CorbaContactInfoList ;

import com.sun.corba.se.spi.ior.IOR ;
import com.sun.corba.se.spi.orb.ORB;

/** Interface used to create a ContactInfoList from an IOR, as required
 * for supporting CORBA semantics using the DCS framework.  This is a
 * natural correspondence since an IOR contains the information for
 * contacting one or more communication endpoints that can be used to
 * invoke a method on an object, along with the necessary information
 * on particular transports, encodings, and protocols to use.
 * Note that the actual implementation may support more than one
 * IOR in the case of GIOP with Location Forward messages.
 */
public interface CorbaContactInfoListFactory {
    /**
     * This will be called after the no-arg constructor before
     * create is called.
     */
    public void setORB(ORB orb);

    public CorbaContactInfoList create( IOR ior ) ;
}
