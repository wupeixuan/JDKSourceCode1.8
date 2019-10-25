/*
 * Copyright (c) 1995, 2013, Oracle and/or its affiliates. All rights reserved.
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

package java.net;

import java.io.IOException;

/**
 * Thrown to indicate that an unknown service exception has
 * occurred. Either the MIME type returned by a URL connection does
 * not make sense, or the application is attempting to write to a
 * read-only URL connection.
 *
 * @author  unascribed
 * @since   JDK1.0
 */
public class UnknownServiceException extends IOException {
    private static final long serialVersionUID = -4169033248853639508L;

    /**
     * Constructs a new {@code UnknownServiceException} with no
     * detail message.
     */
    public UnknownServiceException() {
    }

    /**
     * Constructs a new {@code UnknownServiceException} with the
     * specified detail message.
     *
     * @param   msg   the detail message.
     */
    public UnknownServiceException(String msg) {
        super(msg);
    }
}
