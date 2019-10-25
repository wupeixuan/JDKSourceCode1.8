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


/**



 * A read-only HeapCharBuffer.  This class extends the corresponding
 * read/write class, overriding the mutation methods to throw a {@link
 * ReadOnlyBufferException} and overriding the view-buffer methods to return an
 * instance of this class rather than of the superclass.

 */

class HeapCharBufferR
    extends HeapCharBuffer
{

    // For speed these fields are actually declared in X-Buffer;
    // these declarations are here as documentation
    /*




    */

    HeapCharBufferR(int cap, int lim) {            // package-private







        super(cap, lim);
        this.isReadOnly = true;

    }

    HeapCharBufferR(char[] buf, int off, int len) { // package-private







        super(buf, off, len);
        this.isReadOnly = true;

    }

    protected HeapCharBufferR(char[] buf,
                                   int mark, int pos, int lim, int cap,
                                   int off)
    {







        super(buf, mark, pos, lim, cap, off);
        this.isReadOnly = true;

    }

    public CharBuffer slice() {
        return new HeapCharBufferR(hb,
                                        -1,
                                        0,
                                        this.remaining(),
                                        this.remaining(),
                                        this.position() + offset);
    }

    public CharBuffer duplicate() {
        return new HeapCharBufferR(hb,
                                        this.markValue(),
                                        this.position(),
                                        this.limit(),
                                        this.capacity(),
                                        offset);
    }

    public CharBuffer asReadOnlyBuffer() {








        return duplicate();

    }




































    public boolean isReadOnly() {
        return true;
    }

    public CharBuffer put(char x) {




        throw new ReadOnlyBufferException();

    }

    public CharBuffer put(int i, char x) {




        throw new ReadOnlyBufferException();

    }

    public CharBuffer put(char[] src, int offset, int length) {








        throw new ReadOnlyBufferException();

    }

    public CharBuffer put(CharBuffer src) {























        throw new ReadOnlyBufferException();

    }

    public CharBuffer compact() {







        throw new ReadOnlyBufferException();

    }








































































































































































































































































































































    String toString(int start, int end) {               // package-private
        try {
            return new String(hb, start + offset, end - start);
        } catch (StringIndexOutOfBoundsException x) {
            throw new IndexOutOfBoundsException();
        }
    }


    // --- Methods to support CharSequence ---

    public CharBuffer subSequence(int start, int end) {
        if ((start < 0)
            || (end > length())
            || (start > end))
            throw new IndexOutOfBoundsException();
        int pos = position();
        return new HeapCharBufferR(hb,
                                      -1,
                                      pos + start,
                                      pos + end,
                                      capacity(),
                                      offset);
    }






    public ByteOrder order() {
        return ByteOrder.nativeOrder();
    }



}
