/*
 * Copyright (c) 2001, 2013, Oracle and/or its affiliates. All rights reserved.
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

package java.nio.charset;


/**
 * Checked exception thrown when an input character (or byte) sequence
 * is valid but cannot be mapped to an output byte (or character)
 * sequence.
 *
 * @since 1.4
 */

public class UnmappableCharacterException
    extends CharacterCodingException
{

    private static final long serialVersionUID = -7026962371537706123L;

    private int inputLength;

    /**
     * Constructs an {@code UnmappableCharacterException} with the
     * given length.
     * @param inputLength the length of the input
     */
    public UnmappableCharacterException(int inputLength) {
        this.inputLength = inputLength;
    }

    /**
     * Returns the length of the input.
     * @return the length of the input
     */
    public int getInputLength() {
        return inputLength;
    }

    /**
     * Returns the message.
     * @return the message
     */
    public String getMessage() {
        return "Input length = " + inputLength;
    }

}
