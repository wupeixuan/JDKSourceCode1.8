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

/**
 * Requests that referral and other special LDAP objects be manipulated
 * as normal LDAP objects. It enables the requestor to interrogate or
 * update such objects.
 *<p>
 * This class implements the LDAPv3 Request Control for ManageDsaIT
 * as defined in
 * <a href="http://www.ietf.org/rfc/rfc3296.txt">RFC 3296</a>.
 *
 * The control has no control value.
 *
 * @since 1.5
 * @author Vincent Ryan
 */
final public class ManageReferralControl extends BasicControl {

    /**
     * The ManageReferral control's assigned object identifier
     * is 2.16.840.1.113730.3.4.2.
     */
    public static final String OID = "2.16.840.1.113730.3.4.2";

    private static final long serialVersionUID = 3017756160149982566L;

    /**
     * Constructs a critical ManageReferral control.
     */
    public ManageReferralControl() {
        super(OID, true, null);
    }

    /**
     * Constructs a ManageReferral control.
     *
     * @param   criticality The control's criticality setting.
     */
    public ManageReferralControl(boolean criticality) {
        super(OID, criticality, null);
    }
}
