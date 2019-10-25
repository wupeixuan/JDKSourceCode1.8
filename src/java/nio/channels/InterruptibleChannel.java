/*
 * Copyright (c) 2001, Oracle and/or its affiliates. All rights reserved.
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

/*
 */

package java.nio.channels;

import java.io.IOException;


/**
 * A channel that can be asynchronously closed and interrupted.
 *
 * <p> A channel that implements this interface is <i>asynchronously
 * closeable:</i> If a thread is blocked in an I/O operation on an
 * interruptible channel then another thread may invoke the channel's {@link
 * #close close} method.  This will cause the blocked thread to receive an
 * {@link AsynchronousCloseException}.
 *
 * <p> A channel that implements this interface is also <i>interruptible:</i>
 * If a thread is blocked in an I/O operation on an interruptible channel then
 * another thread may invoke the blocked thread's {@link Thread#interrupt()
 * interrupt} method.  This will cause the channel to be closed, the blocked
 * thread to receive a {@link ClosedByInterruptException}, and the blocked
 * thread's interrupt status to be set.
 *
 * <p> If a thread's interrupt status is already set and it invokes a blocking
 * I/O operation upon a channel then the channel will be closed and the thread
 * will immediately receive a {@link ClosedByInterruptException}; its interrupt
 * status will remain set.
 *
 * <p> A channel supports asynchronous closing and interruption if, and only
 * if, it implements this interface.  This can be tested at runtime, if
 * necessary, via the <tt>instanceof</tt> operator.
 *
 *
 * @author Mark Reinhold
 * @author JSR-51 Expert Group
 * @since 1.4
 */

public interface InterruptibleChannel
    extends Channel
{

    /**
     * Closes this channel.
     *
     * <p> Any thread currently blocked in an I/O operation upon this channel
     * will receive an {@link AsynchronousCloseException}.
     *
     * <p> This method otherwise behaves exactly as specified by the {@link
     * Channel#close Channel} interface.  </p>
     *
     * @throws  IOException  If an I/O error occurs
     */
    public void close() throws IOException;

}
