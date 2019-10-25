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
 *  Used to annotate a generated service interface.
 *
 *  <p>The information specified in this annotation is sufficient
 *  to uniquely identify a <code>wsdl:service</code>
 *  element inside a WSDL document. This <code>wsdl:service</code>
 *  element represents the Web service for which the generated
 *  service interface provides a client view.
 *
 *  @since JAX-WS 2.0
**/
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface WebServiceClient {
  /**
   *  The local name of the Web service.
  **/
  String name() default "";

  /**
   *  The namespace for the Web service.
  **/
  String targetNamespace() default "";

  /**
   *  The location of the WSDL document for the service (a URL).
  **/
  String wsdlLocation() default "";
}
