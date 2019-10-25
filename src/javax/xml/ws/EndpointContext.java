/*
 * Copyright (c) 2009, Oracle and/or its affiliates. All rights reserved.
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

import javax.xml.ws.Endpoint;
import java.util.Set;

/**
 * <code>EndpointContext</code> allows multiple endpoints in an application
 * to share any information. For example, servlet application's war may
 * contain multiple endpoints and these endpoints can get addresses of each
 * other by sharing this context. If multiple endpoints share different
 * ports of a WSDL, then the multiple port addresses can be patched
 * when the WSDL is accessed. It also allows all endpoints to share any
 * other runtime information.
 *
 * <p>
 * This needs to be set by using {@link Endpoint#setEndpointContext}
 * before {@link Endpoint#publish} methods.
 *
 * @author Jitendra Kotamraju
 * @since JAX-WS 2.2
 */
public abstract class EndpointContext {

    /**
     * This gives list of endpoints in an application. For e.g in
     * servlet container, a war file may contain multiple endpoints.
     * In case of http, these endpoints are hosted on the same http
     * server.
     *
     * @return list of all endpoints in an application
     */
    public abstract Set<Endpoint> getEndpoints();

}
