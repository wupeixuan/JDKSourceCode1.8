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

package com.sun.corba.se.impl.encoding;

import java.nio.ByteBuffer;
import com.sun.corba.se.spi.orb.ORB;
import com.sun.corba.se.spi.logging.CORBALogDomains;
import com.sun.corba.se.impl.protocol.giopmsgheaders.FragmentMessage;
import com.sun.corba.se.impl.protocol.giopmsgheaders.Message;
import com.sun.corba.se.impl.logging.ORBUtilSystemException;

public class BufferManagerReadGrow
    implements BufferManagerRead, MarkAndResetHandler
{
    // REVISIT - This should go in an abstract class called
    //           BufferManagerReadBase which should implement
    //           BufferManagerRead. Then, this class should extend
    //           BufferManagerReadBase.
    private ORB orb ;

    private ORBUtilSystemException wrapper ;

    BufferManagerReadGrow( ORB orb )
    {
        this.orb = orb ;
        this.wrapper = ORBUtilSystemException.get( orb,
            CORBALogDomains.RPC_ENCODING ) ;
    }

    public void processFragment (ByteBuffer byteBuffer, FragmentMessage header)
    {
        // REVISIT - should we consider throwing an exception similar to what's
        //           done for underflow()???
    }

    public void init(Message msg) {}

    public ByteBufferWithInfo underflow (ByteBufferWithInfo bbwi)
    {
        throw wrapper.unexpectedEof() ;
    }

    public void cancelProcessing(int requestId) {}

    // Mark and reset handler -------------------------

    private Object streamMemento;
    private RestorableInputStream inputStream;
    private boolean markEngaged = false;

    public MarkAndResetHandler getMarkAndResetHandler() {
        return this;
    }

    public void mark(RestorableInputStream is) {
        markEngaged = true;
        inputStream = is;
        streamMemento = inputStream.createStreamMemento();
    }

    // This will never happen
    public void fragmentationOccured(ByteBufferWithInfo newFragment) {}

    public void reset() {

        if (!markEngaged)
            return;

        markEngaged = false;
        inputStream.restoreInternalState(streamMemento);
        streamMemento = null;
    }

    // Nothing to close and cleanup.
    public void close(ByteBufferWithInfo bbwi) {}
}
