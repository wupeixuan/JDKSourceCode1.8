/*
 * Copyright (c) 2002, 2009, Oracle and/or its affiliates. All rights reserved.
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

import java.util.*;

import sun.security.provider.certpath.CertPathHelper;

import sun.security.x509.GeneralNameInterface;

/**
 * Helper class that allows the Sun CertPath provider to access
 * implementation dependent APIs in CertPath framework.
 *
 * @author Andreas Sterbenz
 */
class CertPathHelperImpl extends CertPathHelper {

    private CertPathHelperImpl() {
        // empty
    }

    /**
     * Initialize the helper framework. This method must be called from
     * the static initializer of each class that is the target of one of
     * the methods in this class. This ensures that the helper is initialized
     * prior to a tunneled call from the Sun provider.
     */
    synchronized static void initialize() {
        if (CertPathHelper.instance == null) {
            CertPathHelper.instance = new CertPathHelperImpl();
        }
    }

    protected void implSetPathToNames(X509CertSelector sel,
            Set<GeneralNameInterface> names) {
        sel.setPathToNamesInternal(names);
    }

    protected void implSetDateAndTime(X509CRLSelector sel, Date date, long skew) {
        sel.setDateAndTime(date, skew);
    }
}
