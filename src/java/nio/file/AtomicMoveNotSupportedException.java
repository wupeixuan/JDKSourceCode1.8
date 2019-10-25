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
 * Checked exception thrown when a file cannot be moved as an atomic file system
 * operation.
 *
 * @since 1.7
 */

public class AtomicMoveNotSupportedException
    extends FileSystemException
{
    static final long serialVersionUID = 5402760225333135579L;

    /**
     * Constructs an instance of this class.
     *
     * @param   source
     *          a string identifying the source file or {@code null} if not known
     * @param   target
     *          a string identifying the target file or {@code null} if not known
     * @param   reason
     *          a reason message with additional information
     */
    public AtomicMoveNotSupportedException(String source,
                                           String target,
                                           String reason)
    {
        super(source, target, reason);
    }
}
