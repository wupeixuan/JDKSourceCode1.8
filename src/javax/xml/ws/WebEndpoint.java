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

import java.lang.annotation.Documented;
import java.lang.annotation.Target;
import java.lang.annotation.Retention;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;

/**
 *  Used to annotate the <code>get<em>PortName</em>()</code>
 *  methods of a generated service interface.
 *
 *  <p>The information specified in this annotation is sufficient
 *  to uniquely identify a <code>wsdl:port</code> element
 *  inside a <code>wsdl:service</code>. The latter is
 *  determined based on the value of the <code>WebServiceClient</code>
 *  annotation on the generated service interface itself.
 *
 *  @since JAX-WS 2.0
 *
 *  @see javax.xml.ws.WebServiceClient
**/
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface WebEndpoint {
  /**
   *  The local name of the endpoint.
  **/
  String name() default "";
}
