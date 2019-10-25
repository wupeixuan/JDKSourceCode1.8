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
 * $Id: KeyName.java,v 1.4 2005/05/10 16:35:35 mullan Exp $
 */
package javax.xml.crypto.dsig.keyinfo;

import javax.xml.crypto.XMLStructure;

/**
 * A representation of the XML <code>KeyName</code> element as
 * defined in the <a href="http://www.w3.org/TR/xmldsig-core/">
 * W3C Recommendation for XML-Signature Syntax and Processing</a>.
 * A <code>KeyName</code> object contains a string value which may be used
 * by the signer to communicate a key identifier to the recipient. The
 * XML Schema Definition is defined as:
 *
 * <pre>
 * &lt;element name="KeyName" type="string"/&gt;
 * </pre>
 *
 * A <code>KeyName</code> instance may be created by invoking the
 * {@link KeyInfoFactory#newKeyName newKeyName} method of the
 * {@link KeyInfoFactory} class, and passing it a <code>String</code>
 * representing the name of the key; for example:
 * <pre>
 * KeyInfoFactory factory = KeyInfoFactory.getInstance("DOM");
 * KeyName keyName = factory.newKeyName("Alice");
 * </pre>
 *
 * @author Sean Mullan
 * @author JSR 105 Expert Group
 * @since 1.6
 * @see KeyInfoFactory#newKeyName(String)
 */
public interface KeyName extends XMLStructure {

    /**
     * Returns the name of this <code>KeyName</code>.
     *
     * @return the name of this <code>KeyName</code> (never
     *    <code>null</code>)
     */
    String getName();
}
