/*
 * Copyright (c) 2000, 2001, Oracle and/or its affiliates. All rights reserved.
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

package javax.print.event;

/**
  * Implementations of this listener interface are attached to a
  * {@link javax.print.PrintService PrintService} to monitor
  * the status of the print service.
  * <p>
  * To monitor a particular job see {@link PrintJobListener} and
  * {@link PrintJobAttributeListener}.
  */

public interface PrintServiceAttributeListener {

    /**
     * Called to notify a listener of an event in the print service.
     * The service will call this method on an event notification thread.
     * The client should not perform lengthy processing in this callback
     * or subsequent event notifications may be blocked.
     * @param psae the event being notified
     */
    public void attributeUpdate(PrintServiceAttributeEvent psae) ;

}
