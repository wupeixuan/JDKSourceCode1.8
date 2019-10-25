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

import com.sun.corba.se.spi.ior.iiop.GIOPVersion;
import com.sun.corba.se.spi.orb.ORB;

import com.sun.corba.se.spi.ior.ObjectKey;

/**
 * This implements the GIOP 1.0 LocateRequest header.
 *
 * @author Ram Jeyaraman 05/14/2000
 */

public final class LocateRequestMessage_1_0 extends Message_1_0
        implements LocateRequestMessage {

    // Instance variables

    private ORB orb = null;
    private int request_id = (int) 0;
    private byte[] object_key = null;
    private ObjectKey objectKey = null;

    // Constructor

    LocateRequestMessage_1_0(ORB orb) {
        this.orb = orb;
    }

    LocateRequestMessage_1_0(ORB orb, int _request_id, byte[] _object_key) {
        super(Message.GIOPBigMagic, false, Message.GIOPLocateRequest, 0);
        this.orb = orb;
        request_id = _request_id;
        object_key = _object_key;
    }

    // Accessor methods (LocateRequestMessage interface)

    public int getRequestId() {
        return this.request_id;
    }

    public ObjectKey getObjectKey() {
        if (this.objectKey == null) {
            // this will raise a MARSHAL exception upon errors.
            this.objectKey = MessageBase.extractObjectKey(object_key, orb);
        }

        return this.objectKey;
    }

    // IO methods

    public void read(org.omg.CORBA.portable.InputStream istream) {
        super.read(istream);;
        this.request_id = istream.read_ulong();
        int _len0 = istream.read_long();
        this.object_key = new byte[_len0];
        istream.read_octet_array (this.object_key, 0, _len0);
    }

    public void write(org.omg.CORBA.portable.OutputStream ostream) {
        super.write(ostream);
        ostream.write_ulong(this.request_id);
        nullCheck(this.object_key);
        ostream.write_long(this.object_key.length);
        ostream.write_octet_array(this.object_key, 0, this.object_key.length);
    }

    public void callback(MessageHandler handler)
        throws java.io.IOException
    {
        handler.handleInput(this);
    }
} // class LocateRequestMessage_1_0
