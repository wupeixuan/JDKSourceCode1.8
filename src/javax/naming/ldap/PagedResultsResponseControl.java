/*
 * Copyright (c) 2003, Oracle and/or its affiliates. All rights reserved.
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

package javax.naming.ldap;

import java.io.IOException;
import com.sun.jndi.ldap.Ber;
import com.sun.jndi.ldap.BerDecoder;

/**
 * Indicates the end of a batch of search results.
 * Contains an estimate of the total number of entries in the result set
 * and an opaque cookie. The cookie must be supplied to the next search
 * operation in order to get the next batch of results.
 * <p>
 * The code sample in {@link PagedResultsControl} shows how this class may
 * be used.
 * <p>
 * This class implements the LDAPv3 Response Control for
 * paged-results as defined in
 * <a href="http://www.ietf.org/rfc/rfc2696">RFC 2696</a>.
 *
 * The control's value has the following ASN.1 definition:
 * <pre>
 *
 *     realSearchControlValue ::= SEQUENCE {
 *         size      INTEGER (0..maxInt),
 *                           -- requested page size from client
 *                           -- result set size estimate from server
 *         cookie    OCTET STRING
 *     }
 *
 * </pre>
 *
 * @since 1.5
 * @see PagedResultsControl
 * @author Vincent Ryan
 */
final public class PagedResultsResponseControl extends BasicControl {

    /**
     * The paged-results response control's assigned object identifier
     * is 1.2.840.113556.1.4.319.
     */
    public static final String OID = "1.2.840.113556.1.4.319";

    private static final long serialVersionUID = -8819778744844514666L;

    /**
     * An estimate of the number of entries in the search result.
     *
     * @serial
     */
    private int resultSize;

    /**
     * A server-generated cookie.
     *
     * @serial
     */
    private byte[] cookie;

    /**
     * Constructs a paged-results response control.
     *
     * @param   id              The control's object identifier string.
     * @param   criticality     The control's criticality.
     * @param   value           The control's ASN.1 BER encoded value.
     *                          It is not cloned - any changes to value
     *                          will affect the contents of the control.
     * @exception IOException   If an error was encountered while decoding
     *                          the control's value.
     */
    public PagedResultsResponseControl(String id, boolean criticality,
        byte[] value) throws IOException {

        super(id, criticality, value);

        // decode value
        BerDecoder ber = new BerDecoder(value, 0, value.length);

        ber.parseSeq(null);
        resultSize = ber.parseInt();
        cookie = ber.parseOctetString(Ber.ASN_OCTET_STR, null);
    }

    /**
     * Retrieves (an estimate of) the number of entries in the search result.
     *
     * @return The number of entries in the search result, or zero if unknown.
     */
    public int getResultSize() {
        return resultSize;
    }

    /**
     * Retrieves the server-generated cookie. Null is returned when there are
     * no more entries for the server to return.
     *
     * @return A possibly null server-generated cookie. It is not cloned - any
     *         changes to the cookie will update the control's state and thus
     *         are not recommended.
     */
    public byte[] getCookie() {
        if (cookie.length == 0) {
            return null;
        } else {
            return cookie;
        }
    }
}
