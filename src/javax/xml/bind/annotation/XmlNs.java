/*
 * Copyright (c) 2004, 2013, Oracle and/or its affiliates. All rights reserved.
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

package javax.xml.bind.annotation;

import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Target;

/**
 * <p>
 * Associates a namespace prefix with a XML namespace URI.
 *
 * <p><b>Usage</b></p>
 * <p><tt>@XmlNs</tt> annotation is intended for use from other
 * program annotations.
 *
 * <p>See "Package Specification" in javax.xml.bind.package javadoc for
 * additional common information.</p>
 *
 * <p><b>Example:</b>See <tt>XmlSchema</tt> annotation type for an example.
 * @author Sekhar Vajjhala, Sun Microsystems, Inc.
 * @since JAXB2.0
 */

@Retention(RUNTIME) @Target({})
public @interface XmlNs {
    /**
     * Namespace prefix
     */
    String prefix();

    /**
     * Namespace URI
     */
    String namespaceURI();
}
