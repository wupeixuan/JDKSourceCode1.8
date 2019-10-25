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
 * Runtime exception thrown when an attempt is made to create a file system that
 * already exists.
 */

public class FileSystemAlreadyExistsException
    extends RuntimeException
{
    static final long serialVersionUID = -5438419127181131148L;

    /**
     * Constructs an instance of this class.
     */
    public FileSystemAlreadyExistsException() {
    }

    /**
     * Constructs an instance of this class.
     *
     * @param   msg
     *          the detail message
     */
    public FileSystemAlreadyExistsException(String msg) {
        super(msg);
    }
}
