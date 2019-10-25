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

import java.io.IOException;

/**
 * A file attribute view that supports reading or updating the owner of a file.
 * This file attribute view is intended for file system implementations that
 * support a file attribute that represents an identity that is the owner of
 * the file. Often the owner of a file is the identity of the entity that
 * created the file.
 *
 * <p> The {@link #getOwner getOwner} or {@link #setOwner setOwner} methods may
 * be used to read or update the owner of the file.
 *
 * <p> The {@link java.nio.file.Files#getAttribute getAttribute} and
 * {@link java.nio.file.Files#setAttribute setAttribute} methods may also be
 * used to read or update the owner. In that case, the owner attribute is
 * identified by the name {@code "owner"}, and the value of the attribute is
 * a {@link UserPrincipal}.
 *
 * @since 1.7
 */

public interface FileOwnerAttributeView
    extends FileAttributeView
{
    /**
     * Returns the name of the attribute view. Attribute views of this type
     * have the name {@code "owner"}.
     */
    @Override
    String name();

    /**
     * Read the file owner.
     *
     * <p> It it implementation specific if the file owner can be a {@link
     * GroupPrincipal group}.
     *
     * @return  the file owner
     *
     * @throws  IOException
     *          if an I/O error occurs
     * @throws  SecurityException
     *          In the case of the default provider, a security manager is
     *          installed, and it denies {@link
     *          RuntimePermission}<tt>("accessUserInformation")</tt> or its
     *          {@link SecurityManager#checkRead(String) checkRead} method
     *          denies read access to the file.
     */
    UserPrincipal getOwner() throws IOException;

    /**
     * Updates the file owner.
     *
     * <p> It it implementation specific if the file owner can be a {@link
     * GroupPrincipal group}. To ensure consistent and correct behavior
     * across platforms it is recommended that this method should only be used
     * to set the file owner to a user principal that is not a group.
     *
     * @param   owner
     *          the new file owner
     *
     * @throws  IOException
     *          if an I/O error occurs, or the {@code owner} parameter is a
     *          group and this implementation does not support setting the owner
     *          to a group
     * @throws  SecurityException
     *          In the case of the default provider, a security manager is
     *          installed, and it denies {@link
     *          RuntimePermission}<tt>("accessUserInformation")</tt> or its
     *          {@link SecurityManager#checkWrite(String) checkWrite} method
     *          denies write access to the file.
     */
    void setOwner(UserPrincipal owner) throws IOException;
}
