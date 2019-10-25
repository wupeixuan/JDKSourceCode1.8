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

import java.io.InputStream;
import java.util.Map;
import java.util.List;
import java.io.IOException;

/**
 * Represent channels for retrieving resources from the
 * ResponseCache. Instances of such a class provide an
 * InputStream that returns the entity body, and also a
 * getHeaders() method which returns the associated response headers.
 *
 * @author Yingxian Wang
 * @since 1.5
 */
public abstract class CacheResponse {

    /**
     * Returns the response headers as a Map.
     *
     * @return An immutable Map from response header field names to
     *         lists of field values. The status line has null as its
     *         field name.
     * @throws IOException if an I/O error occurs
     *            while getting the response headers
     */
    public abstract Map<String, List<String>> getHeaders() throws IOException;

    /**
     * Returns the response body as an InputStream.
     *
     * @return an InputStream from which the response body can
     *         be accessed
     * @throws IOException if an I/O error occurs while
     *         getting the response body
     */
    public abstract InputStream getBody() throws IOException;
}
