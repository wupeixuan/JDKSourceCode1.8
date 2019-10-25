/*
 * Copyright (c) 2005, 2010, Oracle and/or its affiliates. All rights reserved.
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

package javax.xml.ws;

/** The <code>AsyncHandler</code> interface is implemented by
 * clients that wish to receive callback notification of the completion of
 * service endpoint operations invoked asynchronously.
 *
 *  @since JAX-WS 2.0
**/
public interface AsyncHandler<T> {

    /** Called when the response to an asynchronous operation is available.
     *
     * @param res The response to the operation invocation.
     *
    **/
    void handleResponse(Response<T> res);
}
