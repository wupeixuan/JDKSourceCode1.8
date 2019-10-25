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
 * Used to annotate a Provider implementation class.
 *
 * @since JAX-WS 2.0
 * @see javax.xml.ws.Provider
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface WebServiceProvider {
    /**
     * Location of the WSDL description for the service.
     */
    String wsdlLocation() default "";

    /**
     * Service name.
     */
    String serviceName() default "";

    /**
     * Target namespace for the service
     */
    String targetNamespace() default "";

    /**
     * Port name.
     */
    String portName() default "";
}
