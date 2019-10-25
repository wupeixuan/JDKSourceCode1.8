/*
 * Copyright (c) 2000, 2010, Oracle and/or its affiliates. All rights reserved.
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

import java.nio.ByteBuffer;

import com.sun.corba.se.impl.orbutil.ORBConstants;
import com.sun.corba.se.impl.protocol.giopmsgheaders.Message;
import com.sun.corba.se.impl.protocol.giopmsgheaders.MessageBase;
import com.sun.corba.se.impl.protocol.giopmsgheaders.FragmentMessage;
import com.sun.corba.se.impl.protocol.giopmsgheaders.ReplyMessage;
import com.sun.corba.se.impl.encoding.BufferManagerWrite;
import com.sun.corba.se.impl.encoding.ByteBufferWithInfo;
import com.sun.corba.se.impl.encoding.CDROutputObject;
import com.sun.corba.se.spi.orb.ORB;
import com.sun.corba.se.pept.transport.Connection;
import com.sun.corba.se.pept.encoding.OutputObject;
import org.omg.CORBA.SystemException;

/**
 * Streaming buffer manager.
 */
public class BufferManagerWriteStream extends BufferManagerWrite
{
    private int fragmentCount = 0;

    BufferManagerWriteStream( ORB orb )
    {
        super(orb) ;
    }

    public boolean sentFragment() {
        return fragmentCount > 0;
    }

    /**
     * Returns the correct buffer size for this type of
     * buffer manager as set in the ORB.
     */
    public int getBufferSize() {
        return orb.getORBData().getGIOPFragmentSize();
    }

    public void overflow (ByteBufferWithInfo bbwi)
    {
        // Set the fragment's moreFragments field to true
        MessageBase.setFlag(bbwi.byteBuffer, Message.MORE_FRAGMENTS_BIT);

        try {
           sendFragment(false);
        } catch(SystemException se){
                orb.getPIHandler().invokeClientPIEndingPoint(
                        ReplyMessage.SYSTEM_EXCEPTION, se);
                throw se;
        }

        // Reuse the old buffer

        // REVISIT - need to account for case when needed > available
        // even after fragmenting.  This is the large array case, so
        // the caller should retry when it runs out of space.
        bbwi.position(0);
        bbwi.buflen = bbwi.byteBuffer.limit();
        bbwi.fragmented = true;

        // Now we must marshal in the fragment header/GIOP header

        // REVISIT - we can optimize this by not creating the fragment message
        // each time.

        FragmentMessage header = ((CDROutputObject)outputObject).getMessageHeader().createFragmentMessage();

        header.write(((CDROutputObject)outputObject));
    }

    private void sendFragment(boolean isLastFragment)
    {
        Connection conn = ((OutputObject)outputObject).getMessageMediator().getConnection();

        // REVISIT: need an ORB
        //System.out.println("sendFragment: last?: " + isLastFragment);
        conn.writeLock();

        try {
            // Send the fragment
            conn.sendWithoutLock(((OutputObject)outputObject));

            fragmentCount++;

        } finally {

            conn.writeUnlock();
        }

    }

    // Sends the last fragment
    public void sendMessage ()
    {
        sendFragment(true);

        sentFullMessage = true;
    }

    /**
     * Close the BufferManagerWrite and do any outstanding cleanup.
     *
     * No work to do for a BufferManagerWriteStream
     */
    public void close(){};

}
