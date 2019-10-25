/*
 * Copyright (c) 2007, 2013, Oracle and/or its affiliates. All rights reserved.
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

package java.security.cert;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;

/**
 * This interface represents an X.509 extension.
 *
 * <p>
 * Extensions provide a means of associating additional attributes with users
 * or public keys and for managing a certification hierarchy.  The extension
 * format also allows communities to define private extensions to carry
 * information unique to those communities.
 *
 * <p>
 * Each extension contains an object identifier, a criticality setting
 * indicating whether it is a critical or a non-critical extension, and
 * and an ASN.1 DER-encoded value. Its ASN.1 definition is:
 *
 * <pre>
 *
 *     Extension ::= SEQUENCE {
 *         extnId        OBJECT IDENTIFIER,
 *         critical      BOOLEAN DEFAULT FALSE,
 *         extnValue     OCTET STRING
 *                 -- contains a DER encoding of a value
 *                 -- of the type registered for use with
 *                 -- the extnId object identifier value
 *     }
 *
 * </pre>
 *
 * <p>
 * This interface is designed to provide access to a single extension,
 * unlike {@link java.security.cert.X509Extension} which is more suitable
 * for accessing a set of extensions.
 *
 * @since 1.7
 */
public interface Extension {

    /**
     * Gets the extensions's object identifier.
     *
     * @return the object identifier as a String
     */
    String getId();

    /**
     * Gets the extension's criticality setting.
     *
     * @return true if this is a critical extension.
     */
    boolean isCritical();

    /**
     * Gets the extensions's DER-encoded value. Note, this is the bytes
     * that are encoded as an OCTET STRING. It does not include the OCTET
     * STRING tag and length.
     *
     * @return a copy of the extension's value, or {@code null} if no
     *    extension value is present.
     */
    byte[] getValue();

    /**
     * Generates the extension's DER encoding and writes it to the output
     * stream.
     *
     * @param out the output stream
     * @exception IOException on encoding or output error.
     * @exception NullPointerException if {@code out} is {@code null}.
     */
    void encode(OutputStream out) throws IOException;
}
