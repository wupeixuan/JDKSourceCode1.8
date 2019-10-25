/*
 * Copyright (c) 2013, Oracle and/or its affiliates. All rights reserved.
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

package java.nio;

import java.util.Comparator;
import java.util.Spliterator;
import java.util.function.IntConsumer;

/**
 * A Spliterator.OfInt for sources that traverse and split elements
 * maintained in a CharBuffer.
 *
 * @implNote
 * The implementation is based on the code for the Array-based spliterators.
 */
class CharBufferSpliterator implements Spliterator.OfInt {
    private final CharBuffer buffer;
    private int index;   // current index, modified on advance/split
    private final int limit;

    CharBufferSpliterator(CharBuffer buffer) {
        this(buffer, buffer.position(), buffer.limit());
    }

    CharBufferSpliterator(CharBuffer buffer, int origin, int limit) {
        assert origin <= limit;
        this.buffer = buffer;
        this.index = (origin <= limit) ? origin : limit;
        this.limit = limit;
    }

    @Override
    public OfInt trySplit() {
        int lo = index, mid = (lo + limit) >>> 1;
        return (lo >= mid)
               ? null
               : new CharBufferSpliterator(buffer, lo, index = mid);
    }

    @Override
    public void forEachRemaining(IntConsumer action) {
        if (action == null)
            throw new NullPointerException();
        CharBuffer cb = buffer;
        int i = index;
        int hi = limit;
        index = hi;
        while (i < hi) {
            action.accept(cb.getUnchecked(i++));
        }
    }

    @Override
    public boolean tryAdvance(IntConsumer action) {
        if (action == null)
            throw new NullPointerException();
        if (index >= 0 && index < limit) {
            action.accept(buffer.getUnchecked(index++));
            return true;
        }
        return false;
    }

    @Override
    public long estimateSize() {
        return (long)(limit - index);
    }

    @Override
    public int characteristics() {
        return Buffer.SPLITERATOR_CHARACTERISTICS;
    }
}
