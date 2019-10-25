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

import com.sun.corba.se.spi.ior.ObjectKey;

import com.sun.corba.se.spi.ior.iiop.GIOPVersion;
import com.sun.corba.se.spi.orb.ORB;

/**
 * This implements the GIOP 1.2 LocateRequest header.
 *
 * @author Ram Jeyaraman 05/14/2000
 */

public final class LocateRequestMessage_1_2 extends Message_1_2
        implements LocateRequestMessage {

    // Instance variables

    private ORB orb = null;
    private ObjectKey objectKey = null;
    private TargetAddress target = null;

    // Constructors

    LocateRequestMessage_1_2(ORB orb) {
        this.orb = orb;
    }

    LocateRequestMessage_1_2(ORB orb, int _request_id, TargetAddress _target) {
        super(Message.GIOPBigMagic, GIOPVersion.V1_2, FLAG_NO_FRAG_BIG_ENDIAN,
            Message.GIOPLocateRequest, 0);
        this.orb = orb;
        request_id = _request_id;
        target = _target;
    }

    // Accessor methods (LocateRequestMessage interface)

    public int getRequestId() {
        return this.request_id;
    }

    public ObjectKey getObjectKey() {
        if (this.objectKey == null) {
            // this will raise a MARSHAL exception upon errors.
            this.objectKey = MessageBase.extractObjectKey(target, orb);
        }

        return this.objectKey;
    }

    // IO methods

    public void read(org.omg.CORBA.portable.InputStream istream) {
        super.read(istream);
        this.request_id = istream.read_ulong();
        this.target = TargetAddressHelper.read(istream);
        getObjectKey(); // this does AddressingDisposition check
    }

    public void write(org.omg.CORBA.portable.OutputStream ostream) {
        super.write(ostream);
        ostream.write_ulong (this.request_id);
        nullCheck(this.target);
        TargetAddressHelper.write(ostream, this.target);
    }

    public void callback(MessageHandler handler)
        throws java.io.IOException
    {
        handler.handleInput(this);
    }
} // class LocateRequestMessage_1_2
