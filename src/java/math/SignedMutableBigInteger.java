/*
 * Copyright (c) 1999, 2007, Oracle and/or its affiliates. All rights reserved.
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

package java.math;

/**
 * A class used to represent multiprecision integers that makes efficient
 * use of allocated space by allowing a number to occupy only part of
 * an array so that the arrays do not have to be reallocated as often.
 * When performing an operation with many iterations the array used to
 * hold a number is only increased when necessary and does not have to
 * be the same size as the number it represents. A mutable number allows
 * calculations to occur on the same number without having to create
 * a new number for every step of the calculation as occurs with
 * BigIntegers.
 *
 * Note that SignedMutableBigIntegers only support signed addition and
 * subtraction. All other operations occur as with MutableBigIntegers.
 *
 * @see     BigInteger
 * @author  Michael McCloskey
 * @since   1.3
 */

class SignedMutableBigInteger extends MutableBigInteger {

   /**
     * The sign of this MutableBigInteger.
     */
    int sign = 1;

    // Constructors

    /**
     * The default constructor. An empty MutableBigInteger is created with
     * a one word capacity.
     */
    SignedMutableBigInteger() {
        super();
    }

    /**
     * Construct a new MutableBigInteger with a magnitude specified by
     * the int val.
     */
    SignedMutableBigInteger(int val) {
        super(val);
    }

    /**
     * Construct a new MutableBigInteger with a magnitude equal to the
     * specified MutableBigInteger.
     */
    SignedMutableBigInteger(MutableBigInteger val) {
        super(val);
    }

   // Arithmetic Operations

   /**
     * Signed addition built upon unsigned add and subtract.
     */
    void signedAdd(SignedMutableBigInteger addend) {
        if (sign == addend.sign)
            add(addend);
        else
            sign = sign * subtract(addend);

    }

   /**
     * Signed addition built upon unsigned add and subtract.
     */
    void signedAdd(MutableBigInteger addend) {
        if (sign == 1)
            add(addend);
        else
            sign = sign * subtract(addend);

    }

   /**
     * Signed subtraction built upon unsigned add and subtract.
     */
    void signedSubtract(SignedMutableBigInteger addend) {
        if (sign == addend.sign)
            sign = sign * subtract(addend);
        else
            add(addend);

    }

   /**
     * Signed subtraction built upon unsigned add and subtract.
     */
    void signedSubtract(MutableBigInteger addend) {
        if (sign == 1)
            sign = sign * subtract(addend);
        else
            add(addend);
        if (intLen == 0)
             sign = 1;
    }

    /**
     * Print out the first intLen ints of this MutableBigInteger's value
     * array starting at offset.
     */
    public String toString() {
        return this.toBigInteger(sign).toString();
    }

}
