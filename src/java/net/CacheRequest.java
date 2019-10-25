/*
 * Copyright (c) 2003, 2004, Oracle and/or its affiliates. All rights reserved.
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

import java.io.OutputStream;
import java.io.IOException;

/**
 * Represents channels for storing resources in the
 * ResponseCache. Instances of such a class provide an
 * OutputStream object which is called by protocol handlers to
 * store the resource data into the cache, and also an abort() method
 * which allows a cache store operation to be interrupted and
 * abandoned. If an IOException is encountered while reading the
 * response or writing to the cache, the current cache store operation
 * will be aborted.
 *
 * @author Yingxian Wang
 * @since 1.5
 */
public abstract class CacheRequest {

    /**
     * Returns an OutputStream to which the response body can be
     * written.
     *
     * @return an OutputStream to which the response body can
     *         be written
     * @throws IOException if an I/O error occurs while
     *         writing the response body
     */
    public abstract OutputStream getBody() throws IOException;

    /**
     * Aborts the attempt to cache the response. If an IOException is
     * encountered while reading the response or writing to the cache,
     * the current cache store operation will be abandoned.
     */
    public abstract void abort();
}
