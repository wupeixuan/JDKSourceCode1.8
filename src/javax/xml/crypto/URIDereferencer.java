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
 * ===========================================================================
 *
 * (C) Copyright IBM Corp. 2003 All Rights Reserved.
 *
 * ===========================================================================
 */
/*
 * $Id: URIDereferencer.java,v 1.5 2005/05/10 15:47:42 mullan Exp $
 */
package javax.xml.crypto;

/**
 * A dereferencer of {@link URIReference}s.
 * <p>
 * The result of dereferencing a <code>URIReference</code> is either an
 * instance of {@link OctetStreamData} or {@link NodeSetData}. Unless the
 * <code>URIReference</code> is a <i>same-document reference</i> as defined
 * in section 4.2 of the W3C Recommendation for XML-Signature Syntax and
 * Processing, the result of dereferencing the <code>URIReference</code>
 * MUST be an <code>OctetStreamData</code>.
 *
 * @author Sean Mullan
 * @author Joyce Leung
 * @author JSR 105 Expert Group
 * @since 1.6
 * @see XMLCryptoContext#setURIDereferencer(URIDereferencer)
 * @see XMLCryptoContext#getURIDereferencer
 */
public interface URIDereferencer {

    /**
     * Dereferences the specified <code>URIReference</code> and returns the
     * dereferenced data.
     *
     * @param uriReference the <code>URIReference</code>
     * @param context an <code>XMLCryptoContext</code> that may
     *    contain additional useful information for dereferencing the URI. This
     *    implementation should dereference the specified
     *    <code>URIReference</code> against the context's <code>baseURI</code>
     *    parameter, if specified.
     * @return the dereferenced data
     * @throws NullPointerException if <code>uriReference</code> or
     *    <code>context</code> are <code>null</code>
     * @throws URIReferenceException if an exception occurs while
     *    dereferencing the specified <code>uriReference</code>
     */
    Data dereference(URIReference uriReference, XMLCryptoContext context)
        throws URIReferenceException;
}
