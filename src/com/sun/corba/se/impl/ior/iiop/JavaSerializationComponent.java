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
package com.sun.corba.se.impl.ior.iiop;

import org.omg.CORBA_2_3.portable.OutputStream;

import com.sun.corba.se.impl.orbutil.ORBConstants;
import com.sun.corba.se.impl.orbutil.ORBUtility;
import com.sun.corba.se.impl.protocol.giopmsgheaders.Message;

import com.sun.corba.se.spi.orb.ORB;
import com.sun.corba.se.spi.ior.TaggedComponentBase;

/**
 * Tagged component that contains a value that indicates the Java
 * serialization version supported by the ORB.
 *
 * ORB Java serialization uses IIOP as the transport protocol, but uses
 * Java serialization mechanism and its accompanying encodings, instead
 * of IIOP CDR serialization mechanism. Java serialization is generally
 * observed to be faster than CDR.
 */
public class JavaSerializationComponent extends TaggedComponentBase {

    private byte version;

    private static JavaSerializationComponent singleton;

    public static JavaSerializationComponent singleton() {
        if (singleton == null) {
            synchronized (JavaSerializationComponent.class) {
                singleton =
                    new JavaSerializationComponent(Message.JAVA_ENC_VERSION);
            }
        }
        return singleton;
    }

    public JavaSerializationComponent(byte version) {
        this.version = version;
    }

    public byte javaSerializationVersion() {
        return this.version;
    }

    public void writeContents(OutputStream os) {
        os.write_octet(version);
    }

    public int getId() {
        return ORBConstants.TAG_JAVA_SERIALIZATION_ID;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof JavaSerializationComponent)) {
            return false;
        }
        JavaSerializationComponent other = (JavaSerializationComponent) obj;
        return this.version == other.version;
    }

    public int hashCode() {
        return this.version;
    }
}
