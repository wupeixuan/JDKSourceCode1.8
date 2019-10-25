/*
 * Copyright (c) 1999, 2002, Oracle and/or its affiliates. All rights reserved.
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

package javax.sound.sampled;

/**
 * An <code>UnsupportedAudioFileException</code> is an exception indicating that an
 * operation failed because a file did not contain valid data of a recognized file
 * type and format.
 *
 * @author Kara Kytle
 * @since 1.3
 */
/*
 * An <code>UnsupportedAudioFileException</code> is an exception indicating that an
 * operation failed because a file did not contain valid data of a recognized file
 * type and format.
 *
 * @author Kara Kytle
 */

public class UnsupportedAudioFileException extends Exception {

    /**
     * Constructs a <code>UnsupportedAudioFileException</code> that has
     * <code>null</code> as its error detail message.
     */
    public UnsupportedAudioFileException() {

        super();
    }


    /**
     * Constructs a <code>UnsupportedAudioFileException</code> that has
     * the specified detail message.
     *
     * @param message a string containing the error detail message
     */
    public UnsupportedAudioFileException(String message) {

        super(message);
    }
}
