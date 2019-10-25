/*
 * Copyright (c) 1998, 2001, Oracle and/or its affiliates. All rights reserved.
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

package org.omg.CORBA;

/** Provides mechanisms for establishing and navigating relationships to
 *  superior and subordinate domains, as well as for creating and accessing
 *  policies. The <tt>DomainManager</tt> has associated with it the policy
 *  objects for a
 *  particular domain. The domain manager also records the membership of
 *  the domain and provides the means to add and remove members. The domain
 *  manager is itself a member of a domain, possibly the domain it manages.
 *  The domain manager provides mechanisms for establishing and navigating
 *  relationships to superior and subordinate domains and
 *  creating and accessing policies.
 */

public interface DomainManager extends DomainManagerOperations,
    org.omg.CORBA.Object, org.omg.CORBA.portable.IDLEntity
{
}
