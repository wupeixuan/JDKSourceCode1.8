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

import com.sun.corba.se.spi.logging.CORBALogDomains;

import com.sun.corba.se.spi.orb.ORB;

import com.sun.corba.se.impl.encoding.ByteBufferWithInfo;

import com.sun.corba.se.impl.logging.ORBUtilSystemException;

/**
 * Defines the contract between the BufferManager and
 * CDR stream on the writing side.  The CDR stream
 * calls back to the BufferManagerWrite when it needs
 * more room in the output buffer to continue.  The
 * BufferManager can then grow the output buffer or
 * use some kind of fragmentation technique.
 */
public abstract class BufferManagerWrite
{
    protected ORB orb ;
    protected ORBUtilSystemException wrapper ;

    BufferManagerWrite( ORB orb )
    {
        this.orb = orb ;
        this.wrapper = ORBUtilSystemException.get( orb,
            CORBALogDomains.RPC_ENCODING ) ;
    }

    /**
     * Has the stream sent out any fragments so far?
     */
    public abstract boolean sentFragment();

    /**
     * Has the entire message been sent?  (Has
     * sendMessage been called?)
     */
    public boolean sentFullMessage() {
        return sentFullMessage;
    }

    /**
     * Returns the correct buffer size for this type of
     * buffer manager as set in the ORB.
     */
    public abstract int getBufferSize();

    /*
     * Called from CDROutputStream.grow.
     *
     * bbwi.buf contains a byte array which needs to grow by bbwi.needed bytes.
     *
     * This can be handled in several ways:
     *
     * 1. Resize the bbwi.buf like the current implementation of
     *    CDROutputStream.grow.
     *
     * 2. Collect the buffer for a later send:
     *    this.bufQ.put(bbwi);
     *    return new ByteBufferWithInfo(bbwi.length);
     *
     * 3. Send buffer as fragment:
     *    Backpatch fragment size field in bbwi.buf.
     *    Set more fragments bit in bbwi.buf.
     *    this.connection.send(bbwi);
     *    return reinitialized bbwi.buf with fragment header
     *
     * All cases should adjust the returned bbwi.* appropriately.
     *
     * Should set the bbwi.fragmented flag to true only in cases 2 and 3.
     */

    public abstract void overflow (ByteBufferWithInfo bbwi);

    /**
     * Called after Stub._invoke (i.e., before complete message has been sent).
     *
     * IIOPOutputStream.writeTo called from IIOPOutputStream.invoke
     *
     * Case: overflow was never called (bbwi.buf contains complete message).
     *       Backpatch size field.
     *       If growing or collecting:
     *          this.bufQ.put(bbwi).
     *          this.bufQ.iterate // However, see comment in getBufferQ
     *             this.connection.send(fragment)
     *       If streaming:
     *          this.connection.send(bbwi).
     *
     * Case: overflow was called N times (bbwi.buf contains last buffer).
     *       If growing or collecting:
     *          this.bufQ.put(bbwi).
     *          backpatch size field in first buffer.
     *          this.bufQ.iterate // However, see comment in getBufferQ
     *             this.connection.send(fragment)
     *       If streaming:
     *          backpatch fragment size field in bbwi.buf.
     *          Set no more fragments bit.
     *          this.connection.send(bbwi).
     */

    public abstract void sendMessage ();

    /**
     * A reference to the connection level stream will be required when
     * sending fragments.
     */
    public void setOutputObject(Object outputObject) {
        this.outputObject = outputObject;
    }

    /**
     * Close the BufferManagerWrite and do any outstanding cleanup.
     */
     abstract public void close();


    // XREVISIT - Currently a java.lang.Object during
    // the rip-int-generic transition.  Should eventually
    // become a GIOPOutputObject.
    protected Object outputObject;

    protected boolean sentFullMessage = false;
}
