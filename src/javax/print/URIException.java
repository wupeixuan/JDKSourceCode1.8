/*
 * Copyright (c) 2000, 2001, Oracle and/or its affiliates. All rights reserved.
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

package javax.print;

import java.net.URI;

/**
 * Interface URIException is a mixin interface which a subclass of {@link
 * PrintException PrintException} can implement to report an error condition
 * involving a URI address. The Print Service API does not define any print
 * exception classes that implement interface URIException, that being left to
 * the Print Service implementor's discretion.
 *
 */

public interface URIException {

    /**
     * Indicates that the printer cannot access the URI address.
     * For example, the printer might report this error if it goes to get
     * the print data and cannot even establish a connection to the
     * URI address.
     */
    public static final int URIInaccessible = 1;

    /**
     * Indicates that the printer does not support the URI
     * scheme ("http", "ftp", etc.) in the URI address.
     */
    public static final int URISchemeNotSupported = 2;

    /**
     * Indicates any kind of problem not specifically identified
     * by the other reasons.
     */
    public static final int URIOtherProblem = -1;

    /**
     * Return the URI.
     * @return the URI that is the cause of this exception.
     */
    public URI getUnsupportedURI();

    /**
     * Return the reason for the event.
     * @return one of the predefined reasons enumerated in this interface.
     */
    public int getReason();

}
