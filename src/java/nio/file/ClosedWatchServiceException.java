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
 * Unchecked exception thrown when an attempt is made to invoke an operation on
 * a watch service that is closed.
 */

public class ClosedWatchServiceException
    extends IllegalStateException
{
    static final long serialVersionUID = 1853336266231677732L;

    /**
     * Constructs an instance of this class.
     */
    public ClosedWatchServiceException() {
    }
}
