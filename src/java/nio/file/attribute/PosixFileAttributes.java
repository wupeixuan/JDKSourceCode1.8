/*
 * Copyright (c) 2007, 2011, Oracle and/or its affiliates. All rights reserved.
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

import java.util.Set;

/**
 * File attributes associated with files on file systems used by operating systems
 * that implement the Portable Operating System Interface (POSIX) family of
 * standards.
 *
 * <p> The POSIX attributes of a file are retrieved using a {@link
 * PosixFileAttributeView} by invoking its {@link
 * PosixFileAttributeView#readAttributes readAttributes} method.
 *
 * @since 1.7
 */

public interface PosixFileAttributes
    extends BasicFileAttributes
{
    /**
     * Returns the owner of the file.
     *
     * @return  the file owner
     *
     * @see PosixFileAttributeView#setOwner
     */
    UserPrincipal owner();

    /**
     * Returns the group owner of the file.
     *
     * @return  the file group owner
     *
     * @see PosixFileAttributeView#setGroup
     */
    GroupPrincipal group();

    /**
     * Returns the permissions of the file. The file permissions are returned
     * as a set of {@link PosixFilePermission} elements. The returned set is a
     * copy of the file permissions and is modifiable. This allows the result
     * to be modified and passed to the {@link PosixFileAttributeView#setPermissions
     * setPermissions} method to update the file's permissions.
     *
     * @return  the file permissions
     *
     * @see PosixFileAttributeView#setPermissions
     */
    Set<PosixFilePermission> permissions();
}
