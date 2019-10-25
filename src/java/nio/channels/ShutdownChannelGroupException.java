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
 * Unchecked exception thrown when an attempt is made to construct a channel in 
 * a group that is shutdown or the completion handler for an I/O operation 
 * cannot be invoked because the channel group has terminated.
 *
 * @since 1.7
 */

public class ShutdownChannelGroupException
    extends IllegalStateException
{

    private static final long serialVersionUID = -3903801676350154157L;

    /**
     * Constructs an instance of this class.
     */
    public ShutdownChannelGroupException() { }

}
