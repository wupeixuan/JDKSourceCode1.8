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

/**
  Provides HTTP SPI that is used for portable deployment of JAX-WS
  web services in containers(for e.g. servlet containers). This SPI
  is not for end developers but provides a way for the container
  developers to deploy JAX-WS services portably.

  <p>
  The portable deployment is done as below:
  <ol>
  <li>Container creates {@link javax.xml.ws.Endpoint} objects for an
  application. The necessary information to create Endpoint objects
  may be got from web service deployment descriptor files.</li>
  <li>Container needs to create {@link javax.xml.ws.spi.http.HttpContext}
  objects for the deployment. For example, a HttpContext could be
  created using servlet configuration(for e.g url-pattern) for the
  web service in servlet container case.</li>
  <li>Then publishes all the endpoints using
  {@link javax.xml.ws.Endpoint#publish(HttpContext)}. During publish(),
  JAX-WS runtime registers a {@link javax.xml.ws.spi.http.HttpHandler}
  callback to handle incoming requests or
  {@link javax.xml.ws.spi.http.HttpExchange} objects. The HttpExchange
  object encapsulates a HTTP request and a response.
  </ol>

  <pre>
  Container                               JAX-WS runtime
  ---------                               --------------
  1. Creates Invoker1, ... InvokerN
  2. Provider.createEndpoint(...)     --> 3. creates Endpoint1
     configures Endpoint1
     ...
  4. Provider.createEndpoint(...)     --> 5. creates EndpointN
     configures EndpointN
  6. Creates ApplicationContext
  7. creates HttpContext1, ... HttpContextN
  8. Endpoint1.publish(HttpContext1)  --> 9. creates HttpHandler1
                                          HttpContext1.setHandler(HttpHandler1)
     ...
 10. EndpointN.publish(HttpContextN)  --> 11. creates HttpHandlerN
                                         HttpContextN.setHandler(HttpHandlerN)

  </pre>

  The request processing is done as below(for every request):
  <pre>
  Container                               JAX-WS runtime
  ---------                               --------------
  1. Creates a HttpExchange
  2. Gets handler from HttpContext
  3. HttpHandler.handle(HttpExchange) --> 4. reads request from HttpExchange
                                      <-- 5. Calls Invoker
  6. Invokes the actual instance
                                          7. Writes the response to HttpExchange
  </pre>

  <p>
  The portable undeployment is done as below:
  <pre>
  Container
  ---------
  1. @preDestroy on instances
  2. Endpoint1.stop()
  ...
  3. EndpointN.stop()
  </pre>

  @author Jitendra Kotamraju
  @since JAX-WS 2.2
 */
package javax.xml.ws.spi.http;
