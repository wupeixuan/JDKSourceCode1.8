/*
 * Copyright (c) 2005, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.imageio.stream;

import java.io.IOException;
import javax.imageio.stream.ImageInputStream;

/**
 * Small class to assist in properly closing an ImageInputStream instance
 * prior to garbage collection.  The ImageInputStreamImpl class defines a
 * finalize() method, but in a number of its public subclasses
 * (e.g. FileImageInputStream) we override the finalize() method to be
 * empty for performance reasons, and instead rely on the Disposer mechanism
 * for closing/disposing resources.  This is fine when one of these classes
 * is instantiated directly (e.g. new FileImageInputStream()) but in the
 * unlikely case where a user defines their own subclass of one of those
 * streams, we need some way to get back to the behavior of
 * ImageInputStreamImpl, which will call close() as part of finalization.
 *
 * Typically an Image{Input,Output}Stream will construct an instance of
 * StreamFinalizer in its constructor if it detects that it has been
 * subclassed by the user.  The ImageInputStream instance will hold a
 * reference to the StreamFinalizer, and the StreamFinalizer will hold a
 * reference back to the ImageInputStream from which it was created.  When
 * both are no longer reachable, the StreamFinalizer.finalize() method will
 * be called, which will take care of closing down the ImageInputStream.
 *
 * Clearly this is a bit of a hack, but it will likely only be used in the
 * rarest of circumstances: when a user has subclassed one of the public
 * stream classes.  (It should be no worse than the old days when the public
 * stream classes had non-empty finalize() methods.)
 */
public class StreamFinalizer {
    private ImageInputStream stream;

    public StreamFinalizer(ImageInputStream stream) {
        this.stream = stream;
    }

    protected void finalize() throws Throwable {
        try {
            stream.close();
        } catch (IOException e) {
        } finally {
            stream = null;
            super.finalize();
        }
    }
}
