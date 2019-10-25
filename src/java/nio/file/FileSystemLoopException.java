/*
 * Copyright (c) 2010, Oracle and/or its affiliates. All rights reserved.
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
 * Checked exception thrown when a file system loop, or cycle, is encountered.
 *
 * @since 1.7
 * @see Files#walkFileTree
 */

public class FileSystemLoopException
    extends FileSystemException
{
    private static final long serialVersionUID = 4843039591949217617L;

    /**
     * Constructs an instance of this class.
     *
     * @param   file
     *          a string identifying the file causing the cycle or {@code null} if
     *          not known
     */
    public FileSystemLoopException(String file) {
        super(file);
    }
}
