/*
 * Copyright (c) 2005, 2011, Oracle and/or its affiliates. All rights reserved.
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
 * $Id: SignatureProperty.java,v 1.4 2005/05/10 16:03:46 mullan Exp $
 */
package javax.xml.crypto.dsig;

import javax.xml.crypto.XMLStructure;
import java.util.List;

/**
 * A representation of the XML <code>SignatureProperty</code> element as
 * defined in the <a href="http://www.w3.org/TR/xmldsig-core/">
 * W3C Recommendation for XML-Signature Syntax and Processing</a>.
 * The XML Schema Definition is defined as:
 * <pre><code>
 *&lt;element name="SignatureProperty" type="ds:SignaturePropertyType"/&gt;
 *   &lt;complexType name="SignaturePropertyType" mixed="true"&gt;
 *     &lt;choice maxOccurs="unbounded"&gt;
 *       &lt;any namespace="##other" processContents="lax"/&gt;
 *       &lt;!-- (1,1) elements from (1, unbounded) namespaces --&gt;
 *     &lt;/choice&gt;
 *     &lt;attribute name="Target" type="anyURI" use="required"/&gt;
 *     &lt;attribute name="Id" type="ID" use="optional"/&gt;
 *   &lt;/complexType&gt;
 * </code></pre>
 *
 * A <code>SignatureProperty</code> instance may be created by invoking the
 * {@link XMLSignatureFactory#newSignatureProperty newSignatureProperty}
 * method of the {@link XMLSignatureFactory} class; for example:
 *
 * <pre>
 *   XMLSignatureFactory factory = XMLSignatureFactory.getInstance("DOM");
 *   SignatureProperty property = factory.newSignatureProperty
 *      (Collections.singletonList(content), "#Signature-1", "TimeStamp");
 * </pre>
 *
 * @author Sean Mullan
 * @author JSR 105 Expert Group
 * @since 1.6
 * @see XMLSignatureFactory#newSignatureProperty(List, String, String)
 * @see SignatureProperties
 */
public interface SignatureProperty extends XMLStructure {

    /**
     * Returns the target URI of this <code>SignatureProperty</code>.
     *
     * @return the target URI of this <code>SignatureProperty</code> (never
     *    <code>null</code>)
     */
    String getTarget();

    /**
     * Returns the Id of this <code>SignatureProperty</code>.
     *
     * @return the Id of this <code>SignatureProperty</code> (or
     *    <code>null</code> if not specified)
     */
    String getId();

    /**
     * Returns an {@link java.util.Collections#unmodifiableList unmodifiable
     * list} of one or more {@link XMLStructure}s that are contained in
     * this <code>SignatureProperty</code>. These represent additional
     * information items concerning the generation of the {@link XMLSignature}
     * (i.e. date/time stamp or serial numbers of cryptographic hardware used
     * in signature generation).
     *
     * @return an unmodifiable list of one or more <code>XMLStructure</code>s
     */
    @SuppressWarnings("rawtypes")
    List getContent();
}
