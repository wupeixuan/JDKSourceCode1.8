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

package com.sun.corba.se.spi.orb ;

import org.omg.CORBA.portable.OutputStream ;

public interface ORBVersion extends Comparable
{
    byte FOREIGN = 0 ;          // ORB from another vendor
    byte OLD = 1 ;              // JDK 1.3.0 or earlier
    byte NEW = 2 ;              // JDK 1.3.1 FCS
    byte JDK1_3_1_01 = 3;       // JDK1_3_1_01 patch
    byte NEWER = 10 ;           // JDK 1.4.x
    byte PEORB = 20 ;           // PEORB in JDK 1.5, S1AS 8, J2EE 1.4

    byte getORBType() ;

    void write( OutputStream os ) ;

    public boolean lessThan( ORBVersion version ) ;
}
