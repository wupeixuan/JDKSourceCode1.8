/*
 * Copyright (c) 2003, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.corba.se.spi.orbutil.threadpool;

public interface Work
{

    /**
     * This method denotes the actual work that is done by the work item.
     */
    public void doWork();

    /**
     * This methods sets the time in millis in the work item, when this
     * work item was enqueued in the work queue.
     */
    public void setEnqueueTime(long timeInMillis);

    /**
     * This methods gets the time in millis in the work item, when this
     * work item was enqueued in the work queue.
     */
    public long getEnqueueTime();

    /**
    * This method will return the name of the work item.
    */
    public String getName();

}

// End of file.
