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

import javax.sound.midi.MidiDevice;

/**
 * A {@code MidiDeviceProvider} is a factory or provider for a particular type
 * of MIDI device. This mechanism allows the implementation to determine how
 * resources are managed in the creation and management of a device.
 *
 * @author Kara Kytle
 */
public abstract class MidiDeviceProvider {

    /**
     * Indicates whether the device provider supports the device represented by
     * the specified device info object.
     *
     * @param  info an info object that describes the device for which support
     *         is queried
     * @return {@code true} if the specified device is supported, otherwise
     *         {@code false}
     */
    public boolean isDeviceSupported(MidiDevice.Info info) {

        MidiDevice.Info infos[] = getDeviceInfo();

        for(int i=0; i<infos.length; i++) {
            if( info.equals( infos[i] ) ) {
                return true;
            }
        }
        return false;
    }

    /**
     * Obtains the set of info objects representing the device or devices
     * provided by this {@code MidiDeviceProvider}.
     *
     * @return set of device info objects
     */
    public abstract MidiDevice.Info[] getDeviceInfo();

    /**
     * Obtains an instance of the device represented by the info object.
     *
     * @param  info an info object that describes the desired device
     * @return device instance
     * @throws IllegalArgumentException if the info object specified does not
     *         match the info object for a device supported by this
     *         {@code MidiDeviceProvider}
     */
    public abstract MidiDevice getDevice(MidiDevice.Info info);
}
