/*
 *
 * Copyright (c) 2007, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

/**********************************************************************
 **********************************************************************
 **********************************************************************
 *** COPYRIGHT (c) 1997-1998 Eastman Kodak Company.                 ***
 *** As  an unpublished  work pursuant to Title 17 of the United    ***
 *** States Code.  All rights reserved.                             ***
 **********************************************************************
 **********************************************************************
 **********************************************************************/

package com.sun.image.codec.jpeg;


/**
 * JPEGImageDecoder Interface
 *
 * JPEGImageDecoder decompresses an JPEG InputStream into a Raster or
 * a BufferedImage depending upon the method invoked. Decoding the
 * JPEG input stream is controlled by the parameters in the
 * JPEGDecodeParam object.  If no JPEGDecodeParam object has been
 * specified then one is created to contain information about a
 * decompressed JPEG stream.<P>
 *
 * The JPEGDecodeParam object is updated with information from the
 * file header during decompression. If the input stream contains
 * tables only information (no image data), the JPEGDecodeParam object
 * will be updated and NULL returned for the output image. If the
 * input stream contains only image data, the parameters and tables in
 * the current JPEGDecodeParam object will be used to decode in
 * decoding the JPEG stream. If no tables are set in the
 * JPEGDecodeParam object, an exception will be thrown.<P>
 *
 * ColorSpace comments: First off JPEG by specification is color
 * blind!  That said, some color space conversion is done in the name
 * of better compression ratios.  If a BufferedImage is requested
 * common color conversions will be applied. Some updates to the
 * standard color space designations have been made to allow this
 * decoder to handle alpha channels.  See the JPEGDecodeParam
 * description for more details on additional color space
 * designations ( @see JPEGDecodeParam ).<P>
 *
 * This decoder can process interchange, abbreviated and progressive
 * jpeg streams.  However, progressive jpeg streams are treated as
 * interchange streams.  They return once with the entire image in the
 * image buffer.
 */

import java.io.InputStream;
import java.io.IOException;
import java.awt.Point;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.DirectColorModel;
import java.awt.image.DataBuffer;
import java.awt.image.DataBufferByte;
import java.awt.image.DataBufferInt;
import java.awt.image.Raster;
import java.awt.image.SampleModel;
import java.awt.image.WritableRaster;

/**
 * This interface describes a JPEG data stream decoder.  This decoder
 * takes an InputStream that contains JPEG encoded image data.  The
 * JPEGImageDecoder will decode the JPEG image data according to the
 * parameters set in a JPEGDecodeParam object.  The resulting image
 * data is returned in either a Raster or a BufferedImage.
 * <p>
 * Note that the classes in the com.sun.image.codec.jpeg package are not
 * part of the core Java APIs.  They are a part of Sun's JDK and JRE
 * distributions.  Although other licensees may choose to distribute these
 * classes, developers cannot depend on their availability in non-Sun
 * implementations.  We expect that equivalent functionality will eventually
 * be available in a core API or standard extension.
 * <p>
 *
 * @see JPEGCodec
 * @see JPEGDecodeParam
 * @see Raster
 * @see BufferedImage
 */

public interface JPEGImageDecoder {

    /**
     * Returns the JPEGDecodeParam object that resulted from the most
     * recent decoding event.
     */
    public JPEGDecodeParam getJPEGDecodeParam();

    /**
     * Sets the JPEGDecodeParam object used to determine the features
     * of the decompression performed on the JPEG encoded data.  This
     * is ussually only needed for decoding abbreviated JPEG data
     * streams.
     * @param jdp JPEGDecodeParam object
     */
    public void setJPEGDecodeParam(JPEGDecodeParam jdp);

        /**
         * Get the input stream that decoding will occur from.
         * @return The stream that the decoder is currently assciated with.
         */
        public InputStream getInputStream();

    /**
     * Decode the JPEG stream that was passed as part of
     * construction.  The JPEG decompression will be performed
     * according to the current settings of the JPEGDecodeParam
     * object.  For a tables only stream this will return null.
     * @return Raster containg the image data.  Colorspace and other
     *         pertinent information can be obtained from the
     *         JPEGDecodeParam object.
     * @exception ImageFormatException if irregularities in the JPEG
     *            stream or an unknown condition is encountered.
     */
    public Raster decodeAsRaster()
                throws IOException, ImageFormatException;

    /**
     * Decodes the current JPEG data stream.  The result of decoding
     * this InputStream is a BufferedImage the ColorModel associated
     * with this BufferedImage is determined based on the encoded
     * COLOR_ID of the JPEGDecodeParam object.  For a tables only
     * stream this will return null.
     * @return BufferedImage containing the image data.
     * @exception ImageFormatException if irregularities in the JPEG
     *            stream or an unknown condition is encountered.
     */
    public BufferedImage decodeAsBufferedImage()
                throws IOException, ImageFormatException;

} // end class JPEGImageDecoder
