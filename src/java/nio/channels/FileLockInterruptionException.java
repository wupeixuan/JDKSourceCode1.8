/*
 * Copyright (c) 2000, 2007, Oracle and/or its affiliates. All rights reserved.
 *
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
 *
 */

// -- This file was mechanically generated: Do not edit! -- //

package java.nio.channels;


/**
 * Checked exception received by a thread when another thread interrupts it
 * while it is waiting to acquire a file lock.  Before this exception is thrown
 * the interrupt status of the previously-blocked thread will have been set.
 *
 * @since 1.4
 */

public class FileLockInterruptionException
    extends java.io.IOException
{

    private static final long serialVersionUID = 7104080643653532383L;

    /**
     * Constructs an instance of this class.
     */
    public FileLockInterruptionException() { }

}
