/*
 * Copyright (c) 1998, 2013, Oracle and/or its affiliates. All rights reserved.
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

package java.security;

/**
 * This class defines the <i>Service Provider Interface</i> (<b>SPI</b>)
 * for the {@code SecureRandom} class.
 * All the abstract methods in this class must be implemented by each
 * service provider who wishes to supply the implementation
 * of a cryptographically strong pseudo-random number generator.
 *
 *
 * @see SecureRandom
 * @since 1.2
 */

public abstract class SecureRandomSpi implements java.io.Serializable {

    private static final long serialVersionUID = -2991854161009191830L;

    /**
     * Reseeds this random object. The given seed supplements, rather than
     * replaces, the existing seed. Thus, repeated calls are guaranteed
     * never to reduce randomness.
     *
     * @param seed the seed.
     */
    protected abstract void engineSetSeed(byte[] seed);

    /**
     * Generates a user-specified number of random bytes.
     *
     * <p> If a call to {@code engineSetSeed} had not occurred previously,
     * the first call to this method forces this SecureRandom implementation
     * to seed itself.  This self-seeding will not occur if
     * {@code engineSetSeed} was previously called.
     *
     * @param bytes the array to be filled in with random bytes.
     */
    protected abstract void engineNextBytes(byte[] bytes);

    /**
     * Returns the given number of seed bytes.  This call may be used to
     * seed other random number generators.
     *
     * @param numBytes the number of seed bytes to generate.
     *
     * @return the seed bytes.
     */
     protected abstract byte[] engineGenerateSeed(int numBytes);
}
