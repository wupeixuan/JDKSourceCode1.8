/*
 * Copyright (c) 2001, 2008, Oracle and/or its affiliates. All rights reserved.
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
package javax.swing.text;

import java.util.ArrayList;
import java.util.List;

/**
 * SegmentCache caches <code>Segment</code>s to avoid continually creating
 * and destroying of <code>Segment</code>s. A common use of this class would
 * be:
 * <pre>
 *   Segment segment = segmentCache.getSegment();
 *   // do something with segment
 *   ...
 *   segmentCache.releaseSegment(segment);
 * </pre>
 *
 */
class SegmentCache {
    /**
     * A global cache.
     */
    private static SegmentCache sharedCache = new SegmentCache();

    /**
     * A list of the currently unused Segments.
     */
    private List<Segment> segments;


    /**
     * Returns the shared SegmentCache.
     */
    public static SegmentCache getSharedInstance() {
        return sharedCache;
    }

    /**
     * A convenience method to get a Segment from the shared
     * <code>SegmentCache</code>.
     */
    public static Segment getSharedSegment() {
        return getSharedInstance().getSegment();
    }

    /**
     * A convenience method to release a Segment to the shared
     * <code>SegmentCache</code>.
     */
    public static void releaseSharedSegment(Segment segment) {
        getSharedInstance().releaseSegment(segment);
    }



    /**
     * Creates and returns a SegmentCache.
     */
    public SegmentCache() {
        segments = new ArrayList<Segment>(11);
    }

    /**
     * Returns a <code>Segment</code>. When done, the <code>Segment</code>
     * should be recycled by invoking <code>releaseSegment</code>.
     */
    public Segment getSegment() {
        synchronized(this) {
            int size = segments.size();

            if (size > 0) {
                return segments.remove(size - 1);
            }
        }
        return new CachedSegment();
    }

    /**
     * Releases a Segment. You should not use a Segment after you release it,
     * and you should NEVER release the same Segment more than once, eg:
     * <pre>
     *   segmentCache.releaseSegment(segment);
     *   segmentCache.releaseSegment(segment);
     * </pre>
     * Will likely result in very bad things happening!
     */
    public void releaseSegment(Segment segment) {
        if (segment instanceof CachedSegment) {
            synchronized(this) {
                segment.array = null;
                segment.count = 0;
                segments.add(segment);
            }
        }
    }


    /**
     * CachedSegment is used as a tagging interface to determine if
     * a Segment can successfully be shared.
     */
    private static class CachedSegment extends Segment {
    }
}
