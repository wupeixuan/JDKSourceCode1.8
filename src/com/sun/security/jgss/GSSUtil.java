/*
 * Copyright (c) 2000, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.security.jgss;

import javax.security.auth.Subject;
import org.ietf.jgss.GSSName;
import org.ietf.jgss.GSSCredential;

/**
 * GSS-API Utilities for using in conjunction with Sun Microsystem's
 * implementation of Java GSS-API.
 */
@jdk.Exported
public class GSSUtil {

    /**
     * Use this method to convert a GSSName and GSSCredential into a
     * Subject. Typically this would be done by a server that wants to
     * impersonate a client thread at the Java level by setting a client
     * Subject in the current access control context. If the server is merely
     * interested in using a principal based policy in its local JVM, then
     * it only needs to provide the GSSName of the client.
     *
     * The elements from the GSSName are placed in the principals set of this
     * Subject and those from the GSSCredential are placed in the private
     * credentials set of the Subject. Any Kerberos specific elements that
     * are added to the subject will be instances of the standard Kerberos
     * implementation classes defined in javax.security.auth.kerberos.
     *
     * @return a Subject with the entries that contain elements from the
     * given GSSName and GSSCredential.
     *
     * @param principals a GSSName containing one or more mechanism specific
     * representations of the same entity. These mechanism specific
     * representations will be populated in the returned Subject's principal
     * set.
     *
     * @param credentials a GSSCredential containing one or more mechanism
     * specific credentials for the same entity. These mechanism specific
     * credentials will be populated in the returned Subject's private
     * credential set. Passing in a value of null will imply that the private
     * credential set should be left empty.
     */
    public static Subject createSubject(GSSName principals,
                                     GSSCredential credentials) {

        return  sun.security.jgss.GSSUtil.getSubject(principals,
                                                     credentials);
    }
}
