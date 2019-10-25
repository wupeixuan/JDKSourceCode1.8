/*
 * Copyright (c) 2000, 2017, Oracle and/or its affiliates. All rights reserved.
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

import com.sun.corba.se.impl.orbutil.ORBConstants;
import com.sun.corba.se.impl.orbutil.ORBUtility;
import com.sun.corba.se.impl.encoding.ByteBufferWithInfo;
import com.sun.corba.se.impl.encoding.BufferManagerWrite;
import com.sun.corba.se.pept.encoding.OutputObject;
import com.sun.corba.se.pept.transport.Connection;
import com.sun.corba.se.spi.orb.ORB;
import com.sun.corba.se.spi.orb.ORBData;

public class BufferManagerWriteGrow extends BufferManagerWrite
{
    BufferManagerWriteGrow( ORB orb )
    {
        super(orb) ;
    }

    public boolean sentFragment() {
        return false;
    }

    /**
     * Returns the correct buffer size for this type of
     * buffer manager as set in the ORB.
     */
    public int getBufferSize() {
        ORBData orbData = null;
        int bufferSize = ORBConstants.GIOP_DEFAULT_BUFFER_SIZE;
        if (orb != null) {
            orbData = orb.getORBData();
            if (orbData != null) {
                bufferSize = orbData.getGIOPBufferSize();
                dprint("BufferManagerWriteGrow.getBufferSize: bufferSize == " + bufferSize);
            } else {
                dprint("BufferManagerWriteGrow.getBufferSize: orbData reference is NULL");
            }
        } else {
            dprint("BufferManagerWriteGrow.getBufferSize: orb reference is NULL");
        }
        return bufferSize;
    }

    public void overflow (ByteBufferWithInfo bbwi)
    {
        // The code that once lived directly in CDROutputStream.grow()
        // has been moved ByteBufferWithInfo.growBuffer().

        // Grow ByteBufferWithInfo to a larger size.
        bbwi.growBuffer(orb);

        // Must be false for the grow case
        bbwi.fragmented = false;
    }

    public void sendMessage ()
    {
        Connection conn =
              ((OutputObject)outputObject).getMessageMediator().getConnection();

        conn.writeLock();

        try {

            conn.sendWithoutLock((OutputObject)outputObject);

            sentFullMessage = true;

        } finally {

            conn.writeUnlock();
        }
    }

    /**
     * Close the BufferManagerWrite and do any outstanding cleanup.
     *
     * No work to do for a BufferManagerWriteGrow.
     */
    public void close() {}

    private void dprint(String msg) {
        if (orb.transportDebugFlag) {
            ORBUtility.dprint(this, msg);
        }
    }
}
