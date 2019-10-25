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

package java.nio.file;

/**
 * Checked exception thrown when a file system operation fails because a file
 * is not a symbolic link.
 *
 * @since 1.7
 */

public class NotLinkException
    extends FileSystemException
{
    static final long serialVersionUID = -388655596416518021L;

    /**
     * Constructs an instance of this class.
     *
     * @param   file
     *          a string identifying the file or {@code null} if not known
     */
    public NotLinkException(String file) {
        super(file);
    }

    /**
     * Constructs an instance of this class.
     *
     * @param   file
     *          a string identifying the file or {@code null} if not known
     * @param   other
     *          a string identifying the other file or {@code null} if not known
     * @param   reason
     *          a reason message with additional information or {@code null}
     */
    public NotLinkException(String file, String other, String reason) {
        super(file, other, reason);
    }
}
