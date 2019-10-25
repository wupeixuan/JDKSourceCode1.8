/*
 * Copyright (c) 2005, 2013, Oracle and/or its affiliates. All rights reserved.
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


package javax.security.auth.login;

/**
 * This class defines the <i>Service Provider Interface</i> (<b>SPI</b>)
 * for the {@code Configuration} class.
 * All the abstract methods in this class must be implemented by each
 * service provider who wishes to supply a Configuration implementation.
 *
 * <p> Subclass implementations of this abstract class must provide
 * a public constructor that takes a {@code Configuration.Parameters}
 * object as an input parameter.  This constructor also must throw
 * an IllegalArgumentException if it does not understand the
 * {@code Configuration.Parameters} input.
 *
 *
 * @since 1.6
 */

public abstract class ConfigurationSpi {
    /**
     * Retrieve the AppConfigurationEntries for the specified <i>name</i>.
     *
     * <p>
     *
     * @param name the name used to index the Configuration.
     *
     * @return an array of AppConfigurationEntries for the specified
     *          <i>name</i>, or null if there are no entries.
     */
    protected abstract AppConfigurationEntry[] engineGetAppConfigurationEntry
                                                        (String name);

    /**
     * Refresh and reload the Configuration.
     *
     * <p> This method causes this Configuration object to refresh/reload its
     * contents in an implementation-dependent manner.
     * For example, if this Configuration object stores its entries in a file,
     * calling {@code refresh} may cause the file to be re-read.
     *
     * <p> The default implementation of this method does nothing.
     * This method should be overridden if a refresh operation is supported
     * by the implementation.
     *
     * @exception SecurityException if the caller does not have permission
     *          to refresh its Configuration.
     */
    protected void engineRefresh() { }
}
