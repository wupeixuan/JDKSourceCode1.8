/*
 * Copyright (c) 2000, 2013, Oracle and/or its affiliates. All rights reserved.
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

// -- This file was mechanically generated: Do not edit! -- //

package java.nio;


class ByteBufferAsLongBufferRB                  // package-private
    extends ByteBufferAsLongBufferB
{








    ByteBufferAsLongBufferRB(ByteBuffer bb) {   // package-private












        super(bb);

    }

    ByteBufferAsLongBufferRB(ByteBuffer bb,
                                     int mark, int pos, int lim, int cap,
                                     int off)
    {





        super(bb, mark, pos, lim, cap, off);

    }

    public LongBuffer slice() {
        int pos = this.position();
        int lim = this.limit();
        assert (pos <= lim);
        int rem = (pos <= lim ? lim - pos : 0);
        int off = (pos << 3) + offset;
        assert (off >= 0);
        return new ByteBufferAsLongBufferRB(bb, -1, 0, rem, rem, off);
    }

    public LongBuffer duplicate() {
        return new ByteBufferAsLongBufferRB(bb,
                                                    this.markValue(),
                                                    this.position(),
                                                    this.limit(),
                                                    this.capacity(),
                                                    offset);
    }

    public LongBuffer asReadOnlyBuffer() {








        return duplicate();

    }























    public LongBuffer put(long x) {




        throw new ReadOnlyBufferException();

    }

    public LongBuffer put(int i, long x) {




        throw new ReadOnlyBufferException();

    }

    public LongBuffer compact() {

















        throw new ReadOnlyBufferException();

    }

    public boolean isDirect() {
        return bb.isDirect();
    }

    public boolean isReadOnly() {
        return true;
    }











































    public ByteOrder order() {

        return ByteOrder.BIG_ENDIAN;




    }

}
