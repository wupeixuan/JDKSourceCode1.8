/*
 * Copyright (c) 2010, 2013, Oracle and/or its affiliates. All rights reserved.
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

/**
 * <p>{@code MidiDeviceReceiver} is a {@code Receiver} which represents
 * a MIDI input connector of a {@code MidiDevice}
 * (see {@link MidiDevice#getReceiver()}).
 *
 * @since 1.7
 */
public interface MidiDeviceReceiver extends Receiver {
    /**
     * Obtains a MidiDevice object which is an owner of this Receiver.
     * @return a MidiDevice object which is an owner of this Receiver
     */
    public MidiDevice getMidiDevice();
}
