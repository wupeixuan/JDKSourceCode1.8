/*
 * Copyright (c) 2001, 2013, Oracle and/or its affiliates. All rights reserved.
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

package javax.print;

/**
 * This interface is used by a printing application to cancel a
 * print job.  This interface extends {@link DocPrintJob}.  A
 * <code>DocPrintJob</code> implementation returned from a print
 * service implements this interface if the print job can be
 * cancelled.  Before trying to cancel
 * a print job, the client needs to test if the
 * <code>DocPrintJob</code> object returned from the print service
 * actually implements this interface.  Clients should never assume
 * that a <code>DocPrintJob</code> implements this interface.  A
 * print service might support cancellation only for certain types
 * of print data and representation class names.  This means that
 * only some of the <code>DocPrintJob</code> objects returned from
 * a service will implement this interface.
 * <p>
 * Service implementors are encouraged to implement this optional interface
 * and to deliver a javax.print.event.PrintJobEvent.JOB_CANCELLED event
 * to any listeners if a job is successfully cancelled with an
 * implementation of this interface. Services should also note that an
 * implementation of this method may be made from a separate client thread
 * than that which made the print request.  Thus the implementation of
 * this interface must be made thread safe.
 */

public interface CancelablePrintJob extends DocPrintJob {

    /**
     * Stops further processing of a print job.
     * <p>
     * If a service supports this method it cannot be concluded that
     * job cancellation will always succeed. A job may not be able to be
     * cancelled once it has reached and passed some point in its processing.
     * A successful cancellation means only that the entire job was not
     * printed, some portion may already have printed when cancel returns.
     * <p>
     * The service will throw a PrintException if the cancellation did not
     * succeed. A job which has not yet been submitted for printing should
     * throw this exception.
     * Cancelling an already successfully cancelled Print Job is not
     * considered an error and will always succeed.
     * <p>
     * Cancellation in some services may be a lengthy process, involving
     * requests to a server and processing of its print queue. Clients
     * may wish to execute cancel in a thread which does not affect
     * application execution.
     * @throws PrintException if the job could not be successfully cancelled.
     */
    public void cancel() throws PrintException;

}
