/*
 * Copyright (c) 2005, 2013, Oracle and/or its affiliates. All rights reserved.
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

/**
 * Used by XmlAccessorOrder to control the ordering of properties and
 * fields in a JAXB bound class.
 *
 * @author Sekhar Vajjhala, Sun Microsystems, Inc.
 * @since JAXB2.0
 * @see XmlAccessorOrder
 */

public enum XmlAccessOrder {
    /**
     * The ordering of fields and properties in a class is undefined.
     */
    UNDEFINED,
    /**
     * The ordering of fields and properties in a class is in
     * alphabetical order as determined by the
     * method java.lang.String.compareTo(String anotherString).
     */
    ALPHABETICAL
}
