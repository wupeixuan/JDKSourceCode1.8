/*
 * Copyright (c) 2005, Oracle and/or its affiliates. All rights reserved.
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
/*
 * $Id: XMLStructure.java,v 1.3 2005/05/10 15:47:42 mullan Exp $
 */
package javax.xml.crypto;

/**
 * A representation of an XML structure from any namespace. The purpose of
 * this interface is to group (and provide type safety for) all
 * representations of XML structures.
 *
 * @author Sean Mullan
 * @author JSR 105 Expert Group
 * @since 1.6
 */
public interface XMLStructure {

    /**
     * Indicates whether a specified feature is supported.
     *
     * @param feature the feature name (as an absolute URI)
     * @return <code>true</code> if the specified feature is supported,
     *    <code>false</code> otherwise
     * @throws NullPointerException if <code>feature</code> is <code>null</code>
     */
    boolean isFeatureSupported(String feature);
}
