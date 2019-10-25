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

/**
 * Defines the flags for used by the flags component of an ACL {@link AclEntry
 * entry}.
 *
 * <p> In this release, this class does not define flags related to {@link
 * AclEntryType#AUDIT} and {@link AclEntryType#ALARM} entry types.
 *
 * @since 1.7
 */

public enum AclEntryFlag {

    /**
     * Can be placed on a directory and indicates that the ACL entry should be
     * added to each new non-directory file created.
     */
    FILE_INHERIT,

    /**
     * Can be placed on a directory and indicates that the ACL entry should be
     * added to each new directory created.
     */
    DIRECTORY_INHERIT,

    /**
     * Can be placed on a directory to indicate that the ACL entry should not
     * be placed on the newly created directory which is inheritable by
     * subdirectories of the created directory.
     */
    NO_PROPAGATE_INHERIT,

    /**
     * Can be placed on a directory but does not apply to the directory,
     * only to newly created files/directories as specified by the
     * {@link #FILE_INHERIT} and {@link #DIRECTORY_INHERIT} flags.
     */
    INHERIT_ONLY;
}
