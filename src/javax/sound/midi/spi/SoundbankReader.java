/*
 * Copyright (c) 1999, 2014, Oracle and/or its affiliates. All rights reserved.
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

package javax.sound.midi.spi;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.Soundbank;

/**
 * A {@code SoundbankReader} supplies soundbank file-reading services. Concrete
 * subclasses of {@code SoundbankReader} parse a given soundbank file, producing
 * a {@link javax.sound.midi.Soundbank} object that can be loaded into a
 * {@link javax.sound.midi.Synthesizer}.
 *
 * @since 1.3
 * @author Kara Kytle
 */
public abstract class SoundbankReader {

    /**
     * Obtains a soundbank object from the URL provided.
     *
     * @param  url URL representing the soundbank.
     * @return soundbank object
     * @throws InvalidMidiDataException if the URL does not point to valid MIDI
     *         soundbank data recognized by this soundbank reader
     * @throws IOException if an I/O error occurs
     */
    public abstract Soundbank getSoundbank(URL url)
            throws InvalidMidiDataException, IOException;

    /**
     * Obtains a soundbank object from the {@code InputStream} provided.
     *
     * @param  stream {@code InputStream} representing the soundbank
     * @return soundbank object
     * @throws InvalidMidiDataException if the stream does not point to valid
     *         MIDI soundbank data recognized by this soundbank reader
     * @throws IOException if an I/O error occurs
     */
    public abstract Soundbank getSoundbank(InputStream stream)
            throws InvalidMidiDataException, IOException;

    /**
     * Obtains a soundbank object from the {@code File} provided.
     *
     * @param  file the {@code File} representing the soundbank
     * @return soundbank object
     * @throws InvalidMidiDataException if the file does not point to valid MIDI
     *         soundbank data recognized by this soundbank reader
     * @throws IOException if an I/O error occurs
     */
    public abstract Soundbank getSoundbank(File file)
            throws InvalidMidiDataException, IOException;
}
