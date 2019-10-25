/*
 * Copyright (c) 2011, 2013, Oracle and/or its affiliates. All rights reserved.
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

package javax.security.auth.kerberos;

import sun.security.krb5.JavaxSecurityAuthKerberosAccess;
import sun.security.krb5.EncryptionKey;
import sun.security.krb5.PrincipalName;

class JavaxSecurityAuthKerberosAccessImpl
        implements JavaxSecurityAuthKerberosAccess {
    public sun.security.krb5.internal.ktab.KeyTab keyTabTakeSnapshot(
            KeyTab ktab) {
        return ktab.takeSnapshot();
    }
}
