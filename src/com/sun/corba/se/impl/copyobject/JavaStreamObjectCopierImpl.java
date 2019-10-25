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

package com.sun.corba.se.impl.copyobject ;

import java.util.logging.Level;
import java.util.logging.Logger;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.MarshalException;

import java.io.InputStream ;
import java.io.OutputStream ;
import java.io.ByteArrayInputStream ;
import java.io.ByteArrayOutputStream ;
import java.io.ObjectInputStream ;
import java.io.ObjectOutputStream ;

import org.omg.CORBA.ORB ;

import com.sun.corba.se.spi.copyobject.ObjectCopier ;
import com.sun.corba.se.impl.util.Utility;

public class JavaStreamObjectCopierImpl implements ObjectCopier {

    public JavaStreamObjectCopierImpl( ORB orb )
    {
        this.orb = orb ;
    }

    public Object copy(Object obj) {
        if (obj instanceof Remote) {
            // Yes, so make sure it is connected and converted
            // to a stub (if needed)...
            return Utility.autoConnect(obj,orb,true);
        }

        try {
            ByteArrayOutputStream os = new ByteArrayOutputStream( 10000 ) ;
            ObjectOutputStream oos = new ObjectOutputStream( os ) ;
            oos.writeObject( obj ) ;

            byte[] arr = os.toByteArray() ;
            InputStream is = new ByteArrayInputStream( arr ) ;
            ObjectInputStream ois = new ObjectInputStream( is ) ;

            return ois.readObject();
        } catch (Exception exc) {
            System.out.println( "Failed with exception:" + exc ) ;
            return null ;
        }
    }

    private ORB orb;
}
