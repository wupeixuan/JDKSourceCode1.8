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
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.xml.ws.spi.WebServiceFeatureAnnotation;


/**
 * This feature clarifies the use of the <code>wsdl:binding</code>
 * in a JAX-WS runtime.
 * <p>
 * This annotation MUST only be used in conjunction the
 * <code>javax.jws.WebService</code>, {@link WebServiceProvider},
 * {@link WebServiceRef} annotations.
 * When used with the <code>javax.jws.WebService</code> annotation this
 * annotation MUST only be used on the service endpoint implementation
 * class.
 * When used with a <code>WebServiceRef</code> annotation, this annotation
 * MUST only be used when a proxy instance is created. The injected SEI
 * proxy, and endpoint MUST honor the values of the <code>RespectBinding</code>
 * annotation.
 * <p>
 *
 * This annotation's behaviour is defined by the corresponding feature
 * {@link RespectBindingFeature}.
 *
 * @see RespectBindingFeature
 *
 * @since JAX-WS 2.1
 */
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@WebServiceFeatureAnnotation(id=RespectBindingFeature.ID,bean=RespectBindingFeature.class)
public @interface RespectBinding {
    /**
     * Specifies if this feature is enabled or disabled.
     */
    boolean enabled() default true;
}
