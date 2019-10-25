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
 * $Id: HMACParameterSpec.java,v 1.4 2005/05/10 16:40:17 mullan Exp $
 */
package javax.xml.crypto.dsig.spec;

import javax.xml.crypto.dsig.SignatureMethod;

/**
 * Parameters for the <a href="http://www.w3.org/TR/xmldsig-core/#sec-MACs">
 * XML Signature HMAC Algorithm</a>. The parameters include an optional output
 * length which specifies the MAC truncation length in bits. The resulting
 * HMAC will be truncated to the specified number of bits. If the parameter is
 * not specified, then this implies that all the bits of the hash are to be
 * output. The XML Schema Definition of the <code>HMACOutputLength</code>
 * element is defined as:
 * <pre><code>
 * &lt;element name="HMACOutputLength" minOccurs="0" type="ds:HMACOutputLengthType"/&gt;
 * &lt;simpleType name="HMACOutputLengthType"&gt;
 *   &lt;restriction base="integer"/&gt;
 * &lt;/simpleType&gt;
 * </code></pre>
 *
 * @author Sean Mullan
 * @author JSR 105 Expert Group
 * @since 1.6
 * @see SignatureMethod
 * @see <a href="http://www.ietf.org/rfc/rfc2104.txt">RFC 2104</a>
 */
public final class HMACParameterSpec implements SignatureMethodParameterSpec {

    private int outputLength;

    /**
     * Creates an <code>HMACParameterSpec</code> with the specified truncation
     * length.
     *
     * @param outputLength the truncation length in number of bits
     */
    public HMACParameterSpec(int outputLength) {
        this.outputLength = outputLength;
    }

    /**
     * Returns the truncation length.
     *
     * @return the truncation length in number of bits
     */
    public int getOutputLength() {
        return outputLength;
    }
}
