/*
 * Copyright (c) 1997, 1998, Oracle and/or its affiliates. All rights reserved.
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

package java.awt.image;


/**
 * The <code>ImagingOpException</code> is thrown if one of the
 * {@link BufferedImageOp} or {@link RasterOp} filter methods cannot
 * process the image.
 */
public class ImagingOpException extends java.lang.RuntimeException {

    /**
     * Constructs an <code>ImagingOpException</code> object with the
     * specified message.
     * @param s the message to generate when a
     * <code>ImagingOpException</code> is thrown
     */
    public ImagingOpException(String s) {
        super (s);
    }
}
