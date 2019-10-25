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



/** Class to encapsulate the JPEG quantization tables.
 * <p>
 * Note that the classes in the com.sun.image.codec.jpeg package are not
 * part of the core Java APIs.  They are a part of Sun's JDK and JRE
 * distributions.  Although other licensees may choose to distribute these
 * classes, developers cannot depend on their availability in non-Sun
 * implementations.  We expect that equivalent functionality will eventually
 * be available in a core API or standard extension.
 * <p>
 */
public class JPEGQTable {

        /** Quantization step for each coefficient in zig-zag order */
        private int quantval[];

        /** The number of coefficients in a DCT block */
        private static final byte QTABLESIZE = 64;

        /**
         * This is the sample luminance quantization table given in the
         * JPEG spec section K.1, expressed in zigzag order. The spec says
         * that the values given produce "good" quality, and when divided
         * by 2, "very good" quality.
         */
        public static final JPEGQTable StdLuminance = new JPEGQTable();
        static {
                int [] lumVals = {
                        16,   11,  12,  14,  12,  10,  16,  14,
                        13,   14,  18,  17,  16,  19,  24,  40,
                        26,   24,  22,  22,  24,  49,  35,  37,
                        29,   40,  58,  51,  61,  60,  57,  51,
                        56,   55,  64,  72,  92,  78,  64,  68,
                        87,   69,  55,  56,  80, 109,  81,  87,
                        95,   98, 103, 104, 103,  62,  77, 113,
                        121, 112, 100, 120,  92, 101, 103,  99
                };

                StdLuminance.quantval = lumVals;
        }

        /**
         * This is the sample luminance quantization table given in the
         * JPEG spec section K.1, expressed in zigzag order. The spec says
         * that the values given produce "good" quality, and when divided
         * by 2, "very good" quality.
         */
        public static final JPEGQTable StdChrominance = new JPEGQTable();
        static {
                int [] chromVals = {
                        17,  18,  18,  24,  21,  24,  47,  26,
                        26,  47,  99,  66,  56,  66,  99,  99,
                        99,  99,  99,  99,  99,  99,  99,  99,
                        99,  99,  99,  99,  99,  99,  99,  99,
                        99,  99,  99,  99,  99,  99,  99,  99,
                        99,  99,  99,  99,  99,  99,  99,  99,
                        99,  99,  99,  99,  99,  99,  99,  99,
                        99,  99,  99,  99,  99,  99,  99,  99
                };
                StdChrominance.quantval = chromVals;
        }


        /**
         * Constructs an empty quantization table. This is used to create
         * the Std Q-Tables.
         */
        private JPEGQTable() {
                quantval = new int[QTABLESIZE];
        }

        /**
         * Constructs an quantization table from the array that was
         * passed.  The coefficents must be in zig-zag order. The array
         * must be of length 64.
         *  @param table the quantization table (this is copied).
         */
        public JPEGQTable( int table[] ) {
                if ( table.length != QTABLESIZE ) {
                        throw new IllegalArgumentException
                                ("Quantization table is the wrong size.");
                } else {
                        quantval = new int[QTABLESIZE];
                        System.arraycopy( table, 0, quantval, 0, QTABLESIZE );
                }
        }


        /**
         * Returns the current quantization table as an array of ints in
         * zig zag order.
         *  @return A copy of the contained quantization table.
         */
        public int[] getTable() {
                int[] table = new int[QTABLESIZE];
                System.arraycopy( quantval, 0, table, 0, QTABLESIZE );
                return table;
        }

        /**
         * Returns a new Quantization table where the values are
         * multiplied by scaleFactor and then clamped to the range
         * 1..32767 (or to 1..255 if forceBaseline is 'true'). <P>

         * Values less than one tend to improve the quality level of the
         * table, and values greater than one degrade the quality level of
         * the table.

         * @param scaleFactor the multiplication factor for the table
         * @param forceBaseline if true the values will be clamped
         * to the range  [1 .. 255]
         * @return A new Q-Table that is a linear multiple of this Q-Table
         */
        public JPEGQTable getScaledInstance(float scaleFactor,
                                                                                boolean forceBaseline ) {
                long  max    = (forceBaseline)?255L:32767L;
                int []ret    = new int[QTABLESIZE];

                for (int i=0; i<QTABLESIZE; i++ ) {
                        long holder = (long)((quantval[i] * scaleFactor) + 0.5);

                        // limit to valid range
                        if (holder <= 0L) holder = 1L;

                        // Max quantizer for 12 bits
                        if (holder > max ) holder = max;

                        ret[i] = (int)holder;
                }
                return new JPEGQTable(ret);
        }
}
