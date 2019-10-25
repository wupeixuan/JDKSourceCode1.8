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


public interface ThreadPoolChooser
{
    /**
     * This method is used to return an instance of ThreadPool based on the
     * strategy/policy implemented in the ThreadPoolChooser from the set of
     * ThreadPools allowed to be used by the ORB. Typically, the set of
     * ThreadPools would be specified by passing the threadpool-ids
     * configured in the ORB element of the domain.xml of the appserver.
     */
    public ThreadPool getThreadPool();

    /**
     * This method is used to return an instance of ThreadPool that is obtained
     * by using the id argument passed to it. This method will be used in
     * situations where the threadpool id is known to the caller e.g. by the
     * connection object or looking at the high order bits of the request id
     */
    public ThreadPool getThreadPool(int id);

    /**
     * This method is a convenience method to see what threadpool-ids are being
     * used by the ThreadPoolChooser
     */
    public String[] getThreadPoolIds();
}
