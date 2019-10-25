/*
 * Copyright (c) 1995, 2008, Oracle and/or its affiliates. All rights reserved.
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

package java.lang;

/**
 * An instance of {@code ThreadDeath} is thrown in the victim thread
 * when the (deprecated) {@link Thread#stop()} method is invoked.
 *
 * <p>An application should catch instances of this class only if it
 * must clean up after being terminated asynchronously.  If
 * {@code ThreadDeath} is caught by a method, it is important that it
 * be rethrown so that the thread actually dies.
 *
 * <p>The {@linkplain ThreadGroup#uncaughtException top-level error
 * handler} does not print out a message if {@code ThreadDeath} is
 * never caught.
 *
 * <p>The class {@code ThreadDeath} is specifically a subclass of
 * {@code Error} rather than {@code Exception}, even though it is a
 * "normal occurrence", because many applications catch all
 * occurrences of {@code Exception} and then discard the exception.
 *
 * @since   JDK1.0
 */

public class ThreadDeath extends Error {
    private static final long serialVersionUID = -4417128565033088268L;
}
