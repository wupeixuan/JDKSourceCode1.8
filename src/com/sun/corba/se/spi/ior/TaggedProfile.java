/*
 * Copyright (c) 2002, 2003, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.corba.se.spi.ior;

import com.sun.corba.se.spi.orb.ORB ;

/** TaggedProfile represents a tagged profile in an IOR.
 * A profile contains all of the information necessary for an invocation.
 * It contains one or more endpoints that may be used for an invocation.
 * A TaggedProfile conceptually has three parts: A TaggedProfileTemplate,
 * an ObjectKeyTemplate, and an ObjectId.
 */
public interface TaggedProfile extends Identifiable, MakeImmutable
{
    TaggedProfileTemplate getTaggedProfileTemplate() ;

    ObjectId getObjectId() ;

    ObjectKeyTemplate getObjectKeyTemplate() ;

    ObjectKey getObjectKey() ;

    /** Return true is prof is equivalent to this TaggedProfile.
     * This means that this and prof are indistinguishable for
     * the purposes of remote invocation.  Typically this means that
     * the profile data is identical and both profiles contain exactly
     * the same components (if components are applicable).
     * isEquivalent( prof ) should imply that getObjectId().equals(
     * prof.getObjectId() ) is true, and so is
     * getObjectKeyTemplate().equals( prof.getObjectKeyTemplate() ).
     */
    boolean isEquivalent( TaggedProfile prof ) ;

    /** Return the TaggedProfile as a CDR encapsulation in the standard
     * format.  This is required for Portable interceptors.
     */
    org.omg.IOP.TaggedProfile getIOPProfile();

    /** Return true if this TaggedProfile was created in orb.
     *  Caches the result.
     */
    boolean isLocal() ;
}
