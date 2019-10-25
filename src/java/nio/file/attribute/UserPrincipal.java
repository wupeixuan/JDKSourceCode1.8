/*
 * Copyright (c) 2007, 2009, Oracle and/or its affiliates. All rights reserved.
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

package java.nio.file.attribute;

import java.security.Principal;

/**
 * A {@code Principal} representing an identity used to determine access rights
 * to objects in a file system.
 *
 * <p> On many platforms and file systems an entity requires appropriate access
 * rights or permissions in order to access objects in a file system. The
 * access rights are generally performed by checking the identity of the entity.
 * For example, on implementations that use Access Control Lists (ACLs) to
 * enforce privilege separation then a file in the file system may have an
 * associated ACL that determines the access rights of identities specified in
 * the ACL.
 *
 * <p> A {@code UserPrincipal} object is an abstract representation of an
 * identity. It has a {@link #getName() name} that is typically the username or
 * account name that it represents. User principal objects may be obtained using
 * a {@link UserPrincipalLookupService}, or returned by {@link
 * FileAttributeView} implementations that provide access to identity related
 * attributes. For example, the {@link AclFileAttributeView} and {@link
 * PosixFileAttributeView} provide access to a file's {@link
 * PosixFileAttributes#owner owner}.
 *
 * @since 1.7
 */

public interface UserPrincipal extends Principal { }
