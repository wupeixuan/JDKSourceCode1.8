/*
 * Copyright (c) 2000, 2004, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.corba.se.impl.encoding;

import com.sun.corba.se.impl.encoding.BufferManagerRead;
import com.sun.corba.se.impl.encoding.BufferManagerReadGrow;
import com.sun.corba.se.impl.encoding.BufferManagerReadStream;
import com.sun.corba.se.impl.encoding.BufferManagerWrite;
import com.sun.corba.se.impl.protocol.giopmsgheaders.Message;
import com.sun.corba.se.impl.logging.ORBUtilSystemException;
import com.sun.corba.se.spi.logging.CORBALogDomains;
import com.sun.corba.se.spi.ior.iiop.GIOPVersion;
import com.sun.corba.se.spi.orb.ORB;

import org.omg.CORBA.INTERNAL;

/**
 * Creates read/write buffer managers to handle over/under flow
 * in CDR*putStream.
 */

public class BufferManagerFactory
{
    public static final int GROW    = 0;
    public static final int COLLECT = 1;
    public static final int STREAM  = 2;

    // The next two methods allow creation of BufferManagers based on GIOP version.
    // We may want more criteria to be involved in this decision.
    // These are only used for sending messages (so could be fragmenting)
    public static BufferManagerRead newBufferManagerRead(
            GIOPVersion version, byte encodingVersion, ORB orb) {

        // REVISIT - On the reading side, shouldn't we monitor the incoming
        // fragments on a given connection to determine what fragment size
        // they're using, then use that ourselves?

        if (encodingVersion != Message.CDR_ENC_VERSION) {
            return new BufferManagerReadGrow(orb);
        }

        switch (version.intValue())
        {
            case GIOPVersion.VERSION_1_0:
                return new BufferManagerReadGrow(orb);
            case GIOPVersion.VERSION_1_1:
            case GIOPVersion.VERSION_1_2:
                // The stream reader can handle fragmented and
                // non fragmented messages
                return new BufferManagerReadStream(orb);
            default:
                // REVISIT - what is appropriate?
                throw new INTERNAL("Unknown GIOP version: "
                                   + version);
        }
    }

    public static BufferManagerRead newBufferManagerRead(
            int strategy, byte encodingVersion, ORB orb) {

        if (encodingVersion != Message.CDR_ENC_VERSION) {
            if (strategy != BufferManagerFactory.GROW) {
                ORBUtilSystemException wrapper =
                    ORBUtilSystemException.get((ORB)orb,
                                               CORBALogDomains.RPC_ENCODING);
                throw wrapper.invalidBuffMgrStrategy("newBufferManagerRead");
            }
            return new BufferManagerReadGrow(orb);
        }
        switch (strategy) {
            case BufferManagerFactory.GROW:
                return new BufferManagerReadGrow(orb);
            case BufferManagerFactory.COLLECT:
                throw new INTERNAL("Collect strategy invalid for reading");
            case BufferManagerFactory.STREAM:
                return new BufferManagerReadStream(orb);
            default:
                throw new INTERNAL("Unknown buffer manager read strategy: "
                                   + strategy);
        }
    }

    public static BufferManagerWrite newBufferManagerWrite(
            int strategy, byte encodingVersion, ORB orb) {
        if (encodingVersion != Message.CDR_ENC_VERSION) {
            if (strategy != BufferManagerFactory.GROW) {
                ORBUtilSystemException wrapper =
                    ORBUtilSystemException.get((ORB)orb,
                                               CORBALogDomains.RPC_ENCODING);
                throw wrapper.invalidBuffMgrStrategy("newBufferManagerWrite");
            }
            return new BufferManagerWriteGrow(orb);
        }
        switch (strategy) {
            case BufferManagerFactory.GROW:
                return new BufferManagerWriteGrow(orb);
            case BufferManagerFactory.COLLECT:
                return new BufferManagerWriteCollect(orb);
            case BufferManagerFactory.STREAM:
                return new BufferManagerWriteStream(orb);
            default:
                throw new INTERNAL("Unknown buffer manager write strategy: "
                                   + strategy);
        }
    }

    public static BufferManagerWrite newBufferManagerWrite(
        GIOPVersion version, byte encodingVersion, ORB orb) {
        if (encodingVersion != Message.CDR_ENC_VERSION) {
            return new BufferManagerWriteGrow(orb);
        }
        return BufferManagerFactory.newBufferManagerWrite(
            orb.getORBData().getGIOPBuffMgrStrategy(version),
            encodingVersion, orb);
    }

    public static BufferManagerRead defaultBufferManagerRead(ORB orb) {
        return new BufferManagerReadGrow(orb);
    }
}
