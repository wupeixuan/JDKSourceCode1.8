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

public interface WorkQueue
{

    /**
    * This method is used to add work to the WorkQueue
    */
    public void addWork(Work aWorkItem);

    /**
    * This method will return the name of the WorkQueue.
    */
    public String getName();

    /**
    * Returns the total number of Work items added to the Queue.
    */
    public long totalWorkItemsAdded();

    /**
    * Returns the total number of Work items in the Queue to be processed.
    */
    public int workItemsInQueue();

    /**
    * Returns the average time a work item is waiting in the queue before
    * getting processed.
    */
    public long averageTimeInQueue();

    /**
     * Set the ThreadPool instance servicing this WorkQueue
     */
    public void setThreadPool(ThreadPool aThreadPool);

    /**
     * Get the ThreadPool instance servicing this WorkQueue
     */
    public ThreadPool getThreadPool();
}

// End of file.
