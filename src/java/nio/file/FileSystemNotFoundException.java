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
 * Runtime exception thrown when a file system cannot be found.
 */

public class FileSystemNotFoundException
    extends RuntimeException
{
    static final long serialVersionUID = 7999581764446402397L;

    /**
     * Constructs an instance of this class.
     */
    public FileSystemNotFoundException() {
    }

    /**
     * Constructs an instance of this class.
     *
     * @param   msg
     *          the detail message
     */
    public FileSystemNotFoundException(String msg) {
        super(msg);
    }
}
