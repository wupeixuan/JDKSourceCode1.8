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

 * JPEGDecodeParam encapsulates tables and options necessary to
 * control decoding JPEG datastreams. Parameters are either set explicitly
 * by the application for encoding, or read from the JPEG header for
 * decoding.  In the case of decoding abbreviated data streams the
 * application may need to set some/all of the values it's self.  <p>

 * When working with BufferedImages ({@link
 * com.sun.image.codec.jpeg.JPEGImageDecoder#decodeAsBufferedImage}),
 * the codec will attempt to
 * generate an appropriate ColorModel for the JPEG COLOR_ID. This is
 * not always possible (example mappings are listed below) .  In cases
 * where unsupported conversions are required, or unknown encoded
 * COLOR_ID's are in use, the user must request the data as a Raster
 * and perform the transformations themselves.  When decoding into a
 * raster ({@link com.sun.image.codec.jpeg.JPEGImageDecoder#decodeAsRaster})
 * no ColorSpace adjustments are made.

 * Note: The color ids described herein are simply enumerated values
 * that influence data processing by the JPEG codec.  JPEG compression
 * is by definition color blind.  These values are used as hints when
 * decompressing JPEG data.  Of particular interest is the default
 * conversion from YCbCr to sRGB when decoding buffered Images.<P>

 * Note: because JPEG is mostly color-blind color fidelity can not be
 * garunteed.  This will hopefully be rectified in the near future by
 * the wide spread inclusion of ICC-profiles in the JPEG data stream
 * (as a special marker).

 * The following is an example of the conversions that take place.
 * This is only a guide to the types of conversions that are allowed.
 * This list is likely to change in the future so it is
 * <B>strongly</B> recommended that you check for thrown
 * ImageFormatExceptions and check the actual ColorModel associated
 * with the BufferedImage returned rather than make assumtions.
 * <pre>
    DECODING:

    JPEG (Encoded) Color ID         BufferedImage ColorSpace
    =======================         ========================
    COLOR_ID_UNKNOWN                ** Invalid **
    COLOR_ID_GRAY                   CS_GRAY
    COLOR_ID_RGB                    CS_sRGB
    COLOR_ID_YCbCr                  CS_sRGB
    COLOR_ID_CMYK                   ** Invalid **
    COLOR_ID_PYCC                   CS_PYCC
    COLOR_ID_RGBA                   CS_sRGB (w/ alpha)
    COLOR_ID_YCbCrA                 CS_sRGB (w/ alpha)
    COLOR_ID_RGBA_INVERTED          ** Invalid **
    COLOR_ID_YCbCrA_INVERTED        ** Invalid **
    COLOR_ID_PYCCA                  CS_PYCC (w/ alpha)
    COLOR_ID_YCCK                   ** Invalid **
        </pre>

 * If the user needs better control over conversion, the user must
 * request the data as a Raster and handle the conversion of the image
 * data themselves.<p>

 * When decoding JFIF files the encoded COLOR_ID will always be one
 * of: COLOR_ID_UNKNOWN, COLOR_ID_GRAY, COLOR_ID_RGB, COLOR_ID_YCbCr,
 * COLOR_ID_CMYK, or COLOR_ID_YCCK
 * <p>
 * Note that the classes in the com.sun.image.codec.jpeg package are not
 * part of the core Java APIs.  They are a part of Sun's JDK and JRE
 * distributions.  Although other licensees may choose to distribute these
 * classes, developers cannot depend on their availability in non-Sun
 * implementations.  We expect that equivalent functionality will eventually
 * be available in a core API or standard extension.
 * <p>
 */

public interface JPEGDecodeParam extends Cloneable {
    /** Unknown or Undefined Color ID */
    public final static int COLOR_ID_UNKNOWN = 0;

    /** Monochrome */
    public final static int COLOR_ID_GRAY = 1;

    /** Red, Green, and Blue */
    public final static int COLOR_ID_RGB = 2;

    /** YCbCr */
    public final static int COLOR_ID_YCbCr = 3;

    /** CMYK */
    public final static int COLOR_ID_CMYK = 4;

    /** PhotoYCC */
    public final static int COLOR_ID_PYCC = 5;

    /** RGB-Alpha */
        public final static int COLOR_ID_RGBA = 6;

    /** YCbCr-Alpha */
    public final static int COLOR_ID_YCbCrA = 7;

    /** RGB-Alpha with R, G, and B inverted.*/
    public final static int COLOR_ID_RGBA_INVERTED = 8;

    /** YCbCr-Alpha with Y, Cb, and Cr inverted.*/
    public final static int COLOR_ID_YCbCrA_INVERTED = 9;

    /** PhotoYCC-Alpha */
    public final static int COLOR_ID_PYCCA = 10;

    /** YCbCrK */
    public final static int COLOR_ID_YCCK = 11;

    /** Number of color ids defined. */
    final static int NUM_COLOR_ID = 12;

        /** Number of allowed Huffman and Quantization Tables */
    final static int  NUM_TABLES = 4;

        /** The X and Y units simply indicate the aspect ratio of the pixels. */
        public  final static int DENSITY_UNIT_ASPECT_RATIO = 0;
        /** Pixel density is in pixels per inch. */
        public  final static int DENSITY_UNIT_DOTS_INCH    = 1;
        /** Pixel density is in pixels per centemeter. */
        public  final static int DENSITY_UNIT_DOTS_CM      = 2;
        /** The max known value for DENSITY_UNIT */
        final static int NUM_DENSITY_UNIT = 3;

        /** APP0 marker - JFIF info */
        public final static int APP0_MARKER  = 0xE0;
        /** APP1 marker */
        public final static int APP1_MARKER  = 0xE1;
        /** APP2 marker */
        public final static int APP2_MARKER  = 0xE2;
        /** APP3 marker */
        public final static int APP3_MARKER  = 0xE3;
        /** APP4 marker */
        public final static int APP4_MARKER  = 0xE4;
        /** APP5 marker */
        public final static int APP5_MARKER  = 0xE5;
        /** APP6 marker */
        public final static int APP6_MARKER  = 0xE6;
        /** APP7 marker */
        public final static int APP7_MARKER  = 0xE7;
        /** APP8 marker */
        public final static int APP8_MARKER  = 0xE8;
        /** APP9 marker */
        public final static int APP9_MARKER  = 0xE9;
        /** APPA marker */
        public final static int APPA_MARKER  = 0xEA;
        /** APPB marker */
        public final static int APPB_MARKER  = 0xEB;
        /** APPC marker */
        public final static int APPC_MARKER  = 0xEC;
        /** APPD marker */
        public final static int APPD_MARKER  = 0xED;
        /** APPE marker - Adobe info */
        public final static int APPE_MARKER  = 0xEE;
        /** APPF marker */
        public final static int APPF_MARKER  = 0xEF;

        /** Adobe marker indicates presence/need for Adobe marker. */
        public final static int COMMENT_MARKER = 0XFE;

        public Object clone();

        /**
         * Get the image width
         * @return int the width of the image data in pixels.
         */
        public int  getWidth();
        /** Get the image height
         * @return The height of the image data in pixels.
         */
        public int  getHeight();

        /**
         * Return the Horizontal subsampling factor for requested
         * Component.  The Subsample factor is the number of input pixels
         * that contribute to each output pixel.  This is distinct from
         * the way the JPEG to each output pixel.  This is distinct from
         * the way the JPEG standard defines this quantity, because
         * fractional subsampling factors are not allowed, and it was felt
         * @param component The component of the encoded image to return
         * the subsampling factor for.
         * @return The subsample factor.
         */
        public int getHorizontalSubsampling(int component);

        /**
         * Return the Vertical subsampling factor for requested
         * Component.  The Subsample factor is the number of input pixels
         * that contribute to each output pixel.  This is distinct from
         * the way the JPEG to each output pixel.  This is distinct from
         * the way the JPEG standard defines this quantity, because
         * fractional subsampling factors are not allowed, and it was felt
         * @param component The component of the encoded image to return
         * the subsampling factor for.
         * @return The subsample factor.
         */
        public int getVerticalSubsampling(int component);


        /**
         * Returns the coefficient quantization tables or NULL if not
         * defined. tableNum must range in value from 0 - 3.
         * @param tableNum the index of the table to be returned.
         * @return Quantization table stored at index tableNum.
         */
        public JPEGQTable  getQTable(int tableNum );

        /**
         * Returns the Quantization table for the requested component.
         * @param component the image component of interest.
         * @return Quantization table associated with component
         */
        public JPEGQTable getQTableForComponent(int component);

        /**
         * Returns the DC Huffman coding table requested or null if
         * not defined
         * @param tableNum the index of the table to be returned.
         * @return Huffman table stored at index tableNum.
         */
        public JPEGHuffmanTable getDCHuffmanTable( int tableNum );
        /**
         * Returns the DC Huffman coding table for the requested component.
         * @param component the image component of interest.
         * @return Huffman table associated with component
         */
        public JPEGHuffmanTable getDCHuffmanTableForComponent(int component);


        /**
         * Returns the AC Huffman coding table requested or null if
         * not defined
         * @param tableNum the index of the table to be returned.
         * @return Huffman table stored at index tableNum.
         */
        public JPEGHuffmanTable getACHuffmanTable( int tableNum );
        /**
         * Returns the AC Huffman coding table for the requested component.
         * @param component the image component of interest.
         * @return Huffman table associated with component
         */
        public JPEGHuffmanTable getACHuffmanTableForComponent(int component);



        /**
         * Get the number of the DC Huffman table that will be used for
         * a particular component.
         * @param component The Component of interest.
         * @return The table number of the DC Huffman table for component.
         */
        public int getDCHuffmanComponentMapping(int component);
        /**
         * Get the number of the AC Huffman table that will be used for
         * a particular component.
         * @param component The Component of interest.
         * @return The table number of the AC Huffman table for component.
         */
        public int getACHuffmanComponentMapping(int component);
        /**
         * Get the number of the quantization table that will be used for
         * a particular component.
         * @param component The Component of interest.
         * @return The table number of the Quantization table for component.
         */
        public int getQTableComponentMapping(int component);

        /**
         * Returns true if the image information in the ParamBlock is
         * currently valid.  This indicates if image data was read from
         * the stream for decoding and weather image data should be
         * written when encoding.
         */
        public boolean isImageInfoValid();

        /**
         * Returns true if the tables in the ParamBlock are currently
         * valid.  This indicates that tables were read from the stream
         * for decoding. When encoding this indicates wether tables should
         * be written to the stream.
         */
        public boolean isTableInfoValid();

        /**
         * Returns true if at least one instance of the marker is present
         * in the Parameter object.  For encoding returns true if there
         * is at least one instance of the marker to be written.
         * @param marker The marker of interest.
         */
        public boolean getMarker(int marker);

        /**
         * Returns a 'byte[][]' associated with the requested marker in
         * the parameter object.  Each entry in the 'byte[][]' is the data
         * associated with one instance of the marker (each marker can
         * theoretically appear any number of times in a stream).
         * @param marker The marker of interest.
         * @return The 'byte[][]' for this marker or null if none
         *         available.
         */
        public byte[][] getMarkerData(int marker);

        /**
         * Returns the JPEG Encoded color id. This is generally
         * speaking only used if you are decoding into Rasters.  Note
         * that when decoding into a Raster no color conversion is
         * performed.
         * @return The value of the JPEG encoded data's color id.
         */
    public int getEncodedColorID();

        /**
         * Returns the number of components for the current encoding
         * COLOR_ID.
         * @return the number of Components
         */
        public int getNumComponents();

        /**
         * Get the MCUs per restart marker.
         * @return The number of MCUs between restart markers.
         */
        public int getRestartInterval();

        /**
         * Get the code for pixel size units This value is copied from the
         * APP0 marker. It isn't used by the JPEG codec.  If the APP0
         * marker wasn't present then you can not rely on this value.
         * @return Value indicating the density unit one of the
         * DENSITY_UNIT_* constants.
         */
        public int getDensityUnit();

        /**
         * Get the horizontal pixel density This value is copied from the
         * APP0 marker. It isn't used by the JPEG code.  If the APP0
         * marker wasn't present then you can not rely on this value.
         * @return The horizontal pixel density, in units described by
         * @see #getDensityUnit()
         */
        public int getXDensity();
        /**
         * Get the vertical pixel density This value is copied into the
         * APP0 marker. It isn't used by the JPEG code. If the APP0 marker
         * wasn't present then you can not rely on this value.
         * @return The verticle pixel density, in units described by
         * @see #getDensityUnit()
         */
        public int getYDensity();


}
