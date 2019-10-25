/*
 * Copyright (c) 1999, 2003, Oracle and/or its affiliates. All rights reserved.
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

package javax.sound.sampled.spi;

import javax.sound.sampled.Mixer;

/**
 * A provider or factory for a particular mixer type.
 * This mechanism allows the implementation to determine
 * how resources are managed in creation / management of
 * a mixer.
 *
 * @author Kara Kytle
 * @since 1.3
 */
public abstract class MixerProvider {


    /**
     * Indicates whether the mixer provider supports the mixer represented by
     * the specified mixer info object.
     * <p>
     * The full set of mixer info objects that represent the mixers supported
     * by this {@code MixerProvider} may be obtained
     * through the {@code getMixerInfo} method.
     *
     * @param info an info object that describes the mixer for which support is queried
     * @return {@code true} if the specified mixer is supported,
     *     otherwise {@code false}
     * @see #getMixerInfo()
     */
    public boolean isMixerSupported(Mixer.Info info) {

        Mixer.Info infos[] = getMixerInfo();

        for(int i=0; i<infos.length; i++){
            if( info.equals( infos[i] ) ) {
                return true;
            }
        }
        return false;
    }


    /**
     * Obtains the set of info objects representing the mixer
     * or mixers provided by this MixerProvider.
     * <p>
     * The {@code isMixerSupported} method returns {@code true}
     * for all the info objects returned by this method.
     * The corresponding mixer instances for the info objects
     * are returned by the {@code getMixer} method.
     *
     * @return a set of mixer info objects
     * @see #getMixer(javax.sound.sampled.Mixer.Info) getMixer(Mixer.Info)
     * @see #isMixerSupported(javax.sound.sampled.Mixer.Info) isMixerSupported(Mixer.Info)
     */
    public abstract Mixer.Info[] getMixerInfo();


    /**
     * Obtains an instance of the mixer represented by the info object.
     * <p>
     * The full set of the mixer info objects that represent the mixers
     * supported by this {@code MixerProvider} may be obtained
     * through the {@code getMixerInfo} method.
     * Use the {@code isMixerSupported} method to test whether
     * this {@code MixerProvider} supports a particular mixer.
     *
     * @param info an info object that describes the desired mixer
     * @return mixer instance
     * @throws IllegalArgumentException if the info object specified does not
     *     match the info object for a mixer supported by this MixerProvider.
     * @see #getMixerInfo()
     * @see #isMixerSupported(javax.sound.sampled.Mixer.Info) isMixerSupported(Mixer.Info)
     */
    public abstract Mixer getMixer(Mixer.Info info);
}
