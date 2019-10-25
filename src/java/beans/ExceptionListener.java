/*
 * Copyright (c) 2000, Oracle and/or its affiliates. All rights reserved.
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
package java.beans;

/**
 * An ExceptionListener is notified of internal exceptions.
 *
 * @since 1.4
 *
 * @author Philip Milne
 */
public interface ExceptionListener {
    /**
     * This method is called when a recoverable exception has
     * been caught.
     *
     * @param e The exception that was caught.
     *
     */
    public void exceptionThrown(Exception e);
}
