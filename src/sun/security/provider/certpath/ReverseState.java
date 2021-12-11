/*
 * Copyright (c) 2000, 2013, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */

package sun.security.provider.certpath;

import java.io.IOException;
import java.security.PublicKey;
import java.security.cert.CertificateException;
import java.security.cert.CertPathValidatorException;
import java.security.cert.PKIXCertPathChecker;
import java.security.cert.PKIXRevocationChecker;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.ListIterator;
import java.util.Set;
import javax.security.auth.x500.X500Principal;

import sun.security.provider.certpath.PKIX.BuilderParams;
import sun.security.util.Debug;
import sun.security.x509.NameConstraintsExtension;
import sun.security.x509.SubjectKeyIdentifierExtension;
import sun.security.x509.X509CertImpl;

/**
 * A specification of a reverse PKIX validation state
 * which is initialized by each build and updated each time a
 * certificate is added to the current path.
 * @since       1.4
 * @author      Sean Mullan
 * @author      Yassir Elley
 */

class ReverseState implements State {

    private static final Debug debug = Debug.getInstance("certpath");

    /* The subject DN of the last cert in the path */
    X500Principal subjectDN;

    /* The subject public key of the last cert */
    PublicKey pubKey;

    /* The subject key identifier extension (if any) of the last cert */
    SubjectKeyIdentifierExtension subjKeyId;

    /* The PKIX constrained/excluded subtrees state variable */
    NameConstraintsExtension nc;

    /* The PKIX explicit policy, policy mapping, and inhibit_any-policy
       state variables */
    int explicitPolicy;
    int policyMapping;
    int inhibitAnyPolicy;
    int certIndex;
    PolicyNodeImpl rootNode;

    /* The number of remaining CA certs which may follow in the path.
     * -1: previous cert was an EE cert
     * 0: only EE certs may follow.
     * >0 and <Integer.MAX_VALUE:no more than this number of CA certs may follow
     * Integer.MAX_VALUE: unlimited
     */
    int remainingCACerts;

    /* The list of user-defined checkers retrieved from the PKIXParameters
     * instance */
    ArrayList<PKIXCertPathChecker> userCheckers;

    /* Flag indicating if state is initial (path is just starting) */
    private boolean init = true;

    /* the checker used for revocation status */
    RevocationChecker revChecker;

    /* the algorithm checker */
    AlgorithmChecker algorithmChecker;

    /* the untrusted certificates checker */
    UntrustedChecker untrustedChecker;

    /* the trust anchor used to validate the path */
    TrustAnchor trustAnchor;

    /* Flag indicating if current cert can vouch for the CRL for
     * the next cert
     */
    boolean crlSign = true;

    /**
     * Returns a boolean flag indicating if the state is initial
     * (just starting)
     *
     * @return boolean flag indicating if the state is initial (just starting)
     */
    @Override
    public boolean isInitial() {
        return init;
    }

    /**
     * Display state for debugging purposes
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("State [");
        sb.append("\n  subjectDN of last cert: ").append(subjectDN);
        sb.append("\n  subjectKeyIdentifier: ").append
                 (String.valueOf(subjKeyId));
        sb.append("\n  nameConstraints: ").append(String.valueOf(nc));
        sb.append("\n  certIndex: ").append(certIndex);
        sb.append("\n  explicitPolicy: ").append(explicitPolicy);
        sb.append("\n  policyMapping:  ").append(policyMapping);
        sb.append("\n  inhibitAnyPolicy:  ").append(inhibitAnyPolicy);
        sb.append("\n  rootNode: ").append(rootNode);
        sb.append("\n  remainingCACerts: ").append(remainingCACerts);
        sb.append("\n  crlSign: ").append(crlSign);
        sb.append("\n  init: ").append(init);
        sb.append("\n]\n");
        return sb.toString();
    }

    /**
     * Initialize the state.
     *
     * @param buildParams builder parameters
     */
    public void initState(BuilderParams buildParams)
        throws CertPathValidatorException
    {
        /*
         * Initialize number of remainingCACerts.
         * Note that -1 maxPathLen implies unlimited.
         * 0 implies only an EE cert is acceptable.
         */
        int maxPathLen = buildParams.maxPathLength();
        remainingCACerts = (maxPathLen == -1) ? Integer.MAX_VALUE
                                              : maxPathLen;

        /* Initialize explicit policy state variable */
        if (buildParams.explicitPolicyRequired()) {
            explicitPolicy = 0;
        } else {
            // unconstrained if maxPathLen is -1,
            // otherwise, we want to initialize this to the value of the
            // longest possible path + 1 (i.e. maxpathlen + finalcert + 1)
            explicitPolicy = (maxPathLen == -1) ? maxPathLen : maxPathLen + 2;
        }

        /* Initialize policy mapping state variable */
        if (buildParams.policyMappingInhibited()) {
            policyMapping = 0;
        } else {
            policyMapping = (maxPathLen == -1) ? maxPathLen : maxPathLen + 2;
        }

        /* Initialize inhibit any policy state variable */
        if (buildParams.anyPolicyInhibited()) {
            inhibitAnyPolicy = 0;
        } else {
            inhibitAnyPolicy = (maxPathLen == -1) ? maxPathLen : maxPathLen + 2;
        }

        /* Initialize certIndex */
        certIndex = 1;

        /* Initialize policy tree */
        Set<String> initExpPolSet = new HashSet<>(1);
        initExpPolSet.add(PolicyChecker.ANY_POLICY);

        rootNode = new PolicyNodeImpl(null, PolicyChecker.ANY_POLICY, null,
                                      false, initExpPolSet, false);

        /*
         * Initialize each user-defined checker
         * Shallow copy the checkers
         */
        userCheckers = new ArrayList<>(buildParams.certPathCheckers());
        /* initialize each checker (just in case) */
        for (PKIXCertPathChecker checker : userCheckers) {
            checker.init(false);
        }

        /* Start by trusting the cert to sign CRLs */
        crlSign = true;

        init = true;
    }

    /**
     * Update the state with the specified trust anchor.
     *
     * @param anchor the most-trusted CA
     * @param buildParams builder parameters
     */
    public void updateState(TrustAnchor anchor, BuilderParams buildParams)
        throws CertificateException, IOException, CertPathValidatorException
    {
        trustAnchor = anchor;
        X509Certificate trustedCert = anchor.getTrustedCert();
        if (trustedCert != null) {
            updateState(trustedCert);
        } else {
            X500Principal caName = anchor.getCA();
            updateState(anchor.getCAPublicKey(), caName);
        }

        // The user specified AlgorithmChecker and RevocationChecker may not be
        // able to set the trust anchor until now.
        boolean revCheckerAdded = false;
        for (PKIXCertPathChecker checker : userCheckers) {
            if (checker instanceof AlgorithmChecker) {
                ((AlgorithmChecker)checker).trySetTrustAnchor(anchor);
            } else if (checker instanceof PKIXRevocationChecker) {
                if (revCheckerAdded) {
                    throw new CertPathValidatorException(
                        "Only one PKIXRevocationChecker can be specified");
                }
                // if it's our own, initialize it
                if (checker instanceof RevocationChecker) {
                    ((RevocationChecker)checker).init(anchor, buildParams);
                }
                ((PKIXRevocationChecker)checker).init(false);
                revCheckerAdded = true;
            }
        }

        // only create a RevocationChecker if revocation is enabled and
        // a PKIXRevocationChecker has not already been added
        if (buildParams.revocationEnabled() && !revCheckerAdded) {
            revChecker = new RevocationChecker(anchor, buildParams);
            revChecker.init(false);
        }

        init = false;
    }

    /**
     * Update the state. This method is used when the most-trusted CA is
     * a trusted public-key and caName, instead of a trusted cert.
     *
     * @param pubKey the public key of the trusted CA
     * @param subjectDN the subject distinguished name of the trusted CA
     */
    private void updateState(PublicKey pubKey, X500Principal subjectDN) {

        /* update subject DN */
        this.subjectDN = subjectDN;

        /* update subject public key */
        this.pubKey = pubKey;
    }

    /**
     * Update the state with the next certificate added to the path.
     *
     * @param cert the certificate which is used to update the state
     */
    public void updateState(X509Certificate cert)
        throws CertificateException, IOException, CertPathValidatorException {

        if (cert == null) {
            return;
        }

        /* update subject DN */
        subjectDN = cert.getSubjectX500Principal();

        /* check for key needing to inherit alg parameters */
        X509CertImpl icert = X509CertImpl.toImpl(cert);
        PublicKey newKey = cert.getPublicKey();
        if (PKIX.isDSAPublicKeyWithoutParams(newKey)) {
            newKey = BasicChecker.makeInheritedParamsKey(newKey, pubKey);
        }

        /* update subject public key */
        pubKey = newKey;

        /*
         * if this is a trusted cert (init == true), then we
         * don't update any of the remaining fields
         */
        if (init) {
            init = false;
            return;
        }

        /* update subject key identifier */
        subjKeyId = icert.getSubjectKeyIdentifierExtension();

        /* update crlSign */
        crlSign = RevocationChecker.certCanSignCrl(cert);

        /* update current name constraints */
        if (nc != null) {
            nc.merge(icert.getNameConstraintsExtension());
        } else {
            nc = icert.getNameConstraintsExtension();
            if (nc != null) {
                // Make sure we do a clone here, because we're probably
                // going to modify this object later and we don't want to
                // be sharing it with a Certificate object!
                nc = (NameConstraintsExtension) nc.clone();
            }
        }

        /* update policy state variables */
        explicitPolicy =
            PolicyChecker.mergeExplicitPolicy(explicitPolicy, icert, false);
        policyMapping =
            PolicyChecker.mergePolicyMapping(policyMapping, icert);
        inhibitAnyPolicy =
            PolicyChecker.mergeInhibitAnyPolicy(inhibitAnyPolicy, icert);
        certIndex++;

        /*
         * Update remaining CA certs
         */
        remainingCACerts =
            ConstraintsChecker.mergeBasicConstraints(cert, remainingCACerts);

        init = false;
    }

    /**
     * Returns a boolean flag indicating if a key lacking necessary key
     * algorithm parameters has been encountered.
     *
     * @return boolean flag indicating if key lacking parameters encountered.
     */
    @Override
    public boolean keyParamsNeeded() {
        /* when building in reverse, we immediately get parameters needed
         * or else throw an exception
         */
        return false;
    }

    /*
     * Clone current state. The state is cloned as each cert is
     * added to the path. This is necessary if backtracking occurs,
     * and a prior state needs to be restored.
     *
     * Note that this is a SMART clone. Not all fields are fully copied,
     * because some of them (e.g., subjKeyId) will
     * not have their contents modified by subsequent calls to updateState.
     */
    @Override
    @SuppressWarnings("unchecked") // Safe casts assuming clone() works correctly
    public Object clone() {
        try {
            ReverseState clonedState = (ReverseState) super.clone();

            /* clone checkers, if cloneable */
            clonedState.userCheckers =
                        (ArrayList<PKIXCertPathChecker>)userCheckers.clone();
            ListIterator<PKIXCertPathChecker> li =
                        clonedState.userCheckers.listIterator();
            while (li.hasNext()) {
                PKIXCertPathChecker checker = li.next();
                if (checker instanceof Cloneable) {
                    li.set((PKIXCertPathChecker)checker.clone());
                }
            }

            /* make copy of name constraints */
            if (nc != null) {
                clonedState.nc = (NameConstraintsExtension) nc.clone();
            }

            /* make copy of policy tree */
            if (rootNode != null) {
                clonedState.rootNode = rootNode.copyTree();
            }

            return clonedState;
        } catch (CloneNotSupportedException e) {
            throw new InternalError(e.toString(), e);
        }
    }
}
