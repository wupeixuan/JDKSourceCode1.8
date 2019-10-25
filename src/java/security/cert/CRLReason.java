/*
 * Copyright (c) 2007, Oracle and/or its affiliates. All rights reserved.
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

/**
 * The CRLReason enumeration specifies the reason that a certificate
 * is revoked, as defined in <a href="http://www.ietf.org/rfc/rfc3280.txt">
 * RFC 3280: Internet X.509 Public Key Infrastructure Certificate and CRL
 * Profile</a>.
 *
 * @author Sean Mullan
 * @since 1.7
 * @see X509CRLEntry#getRevocationReason
 * @see CertificateRevokedException#getRevocationReason
 */
public enum CRLReason {
    /**
     * This reason indicates that it is unspecified as to why the
     * certificate has been revoked.
     */
    UNSPECIFIED,

    /**
     * This reason indicates that it is known or suspected that the
     * certificate subject's private key has been compromised. It applies
     * to end-entity certificates only.
     */
    KEY_COMPROMISE,

    /**
     * This reason indicates that it is known or suspected that the
     * certificate subject's private key has been compromised. It applies
     * to certificate authority (CA) certificates only.
     */
    CA_COMPROMISE,

    /**
     * This reason indicates that the subject's name or other information
     * has changed.
     */
    AFFILIATION_CHANGED,

    /**
     * This reason indicates that the certificate has been superseded.
     */
    SUPERSEDED,

    /**
     * This reason indicates that the certificate is no longer needed.
     */
    CESSATION_OF_OPERATION,

    /**
     * This reason indicates that the certificate has been put on hold.
     */
    CERTIFICATE_HOLD,

    /**
     * Unused reason.
     */
    UNUSED,

    /**
     * This reason indicates that the certificate was previously on hold
     * and should be removed from the CRL. It is for use with delta CRLs.
     */
    REMOVE_FROM_CRL,

    /**
     * This reason indicates that the privileges granted to the subject of
     * the certificate have been withdrawn.
     */
    PRIVILEGE_WITHDRAWN,

    /**
     * This reason indicates that it is known or suspected that the
     * certificate subject's private key has been compromised. It applies
     * to authority attribute (AA) certificates only.
     */
    AA_COMPROMISE
}
