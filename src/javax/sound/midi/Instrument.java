/*
 * Copyright (c) 1999, 2004, Oracle and/or its affiliates. All rights reserved.
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

package javax.sound.midi;

import java.net.URL;



/**
 * An instrument is a sound-synthesis algorithm with certain parameter
 * settings, usually designed to emulate a specific real-world
 * musical instrument or to achieve a specific sort of sound effect.
 * Instruments are typically stored in collections called soundbanks.
 * Before the instrument can be used to play notes, it must first be loaded
 * onto a synthesizer, and then it must be selected for use on
 * one or more channels, via a program-change command.  MIDI notes
 * that are subsequently received on those channels will be played using
 * the sound of the selected instrument.
 *
 * @see Soundbank
 * @see Soundbank#getInstruments
 * @see Patch
 * @see Synthesizer#loadInstrument(Instrument)
 * @see MidiChannel#programChange(int, int)
 * @author Kara Kytle
 */

public abstract class Instrument extends SoundbankResource {


    /**
     * Instrument patch
     */
    private final Patch patch;


    /**
     * Constructs a new MIDI instrument from the specified <code>Patch</code>.
     * When a subsequent request is made to load the
     * instrument, the sound bank will search its contents for this instrument's <code>Patch</code>,
     * and the instrument will be loaded into the synthesizer at the
     * bank and program location indicated by the <code>Patch</code> object.
     * @param soundbank sound bank containing the instrument
     * @param patch the patch of this instrument
     * @param name the name of this instrument
     * @param dataClass the class used to represent the sample's data.
     *
     * @see Synthesizer#loadInstrument(Instrument)
     */
    protected Instrument(Soundbank soundbank, Patch patch, String name, Class<?> dataClass) {

        super(soundbank, name, dataClass);
        this.patch = patch;
    }


    /**
     * Obtains the <code>Patch</code> object that indicates the bank and program
     * numbers where this instrument is to be stored in the synthesizer.
     * @return this instrument's patch
     */
    public Patch getPatch() {
        return patch;
    }
}
