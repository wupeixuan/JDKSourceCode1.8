/*
 * Copyright (c) 1995, 2010, Oracle and/or its affiliates. All rights reserved.
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

package java.util.zip;

import java.io.IOException;

/**
 * Signals that a Zip exception of some sort has occurred.
 *
 * @author  unascribed
 * @see     java.io.IOException
 * @since   JDK1.0
 */

public
class ZipException extends IOException {
    private static final long serialVersionUID = 8000196834066748623L;

    /**
     * Constructs a <code>ZipException</code> with <code>null</code>
     * as its error detail message.
     */
    public ZipException() {
        super();
    }

    /**
     * Constructs a <code>ZipException</code> with the specified detail
     * message.
     *
     * @param   s   the detail message.
     */

    public ZipException(String s) {
        super(s);
    }
}
