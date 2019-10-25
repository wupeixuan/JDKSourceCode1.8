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

package com.sun.corba.se.impl.transport;

import java.nio.channels.SelectionKey;

import org.omg.CORBA.INTERNAL;

import com.sun.corba.se.pept.transport.Acceptor;
import com.sun.corba.se.pept.transport.Connection;
import com.sun.corba.se.pept.transport.EventHandler;

import com.sun.corba.se.spi.orb.ORB;
import com.sun.corba.se.spi.orbutil.threadpool.NoSuchThreadPoolException;
import com.sun.corba.se.spi.orbutil.threadpool.NoSuchWorkQueueException;
import com.sun.corba.se.spi.orbutil.threadpool.Work;

import com.sun.corba.se.impl.orbutil.ORBUtility;

public abstract class EventHandlerBase
    implements
        EventHandler
{
    protected ORB orb;
    protected Work work;
    protected boolean useWorkerThreadForEvent;
    protected boolean useSelectThreadToWait;
    protected SelectionKey selectionKey;

    ////////////////////////////////////////////////////
    //
    // EventHandler methods
    //

    public void setUseSelectThreadToWait(boolean x)
    {
        useSelectThreadToWait = x;
    }

    public boolean shouldUseSelectThreadToWait()
    {
        return useSelectThreadToWait;
    }

    public void setSelectionKey(SelectionKey selectionKey)
    {
        this.selectionKey = selectionKey;
    }

    public SelectionKey getSelectionKey()
    {
        return selectionKey;
    }

    /*
     * NOTE:
     * This is not thread-safe by design.
     * Only one thread should call it - a reader/listener/select thread.
     * Not stateless: interest ops, registration.
     */
    public void handleEvent()
    {
        if (orb.transportDebugFlag) {
            dprint(".handleEvent->: " + this);
        }
        getSelectionKey().interestOps(getSelectionKey().interestOps() &
                                      (~ getInterestOps()));
        if (shouldUseWorkerThreadForEvent()) {
            Throwable throwable = null;
            try {
                if (orb.transportDebugFlag) {
                    dprint(".handleEvent: addWork to pool: " + 0);
                }
                orb.getThreadPoolManager().getThreadPool(0)
                    .getWorkQueue(0).addWork(getWork());
            } catch (NoSuchThreadPoolException e) {
                throwable = e;
            } catch (NoSuchWorkQueueException e) {
                throwable = e;
            }
            // REVISIT: need to close connection.
            if (throwable != null) {
                if (orb.transportDebugFlag) {
                    dprint(".handleEvent: " + throwable);
                }
                INTERNAL i = new INTERNAL("NoSuchThreadPoolException");
                i.initCause(throwable);
                throw i;
            }
        } else {
            if (orb.transportDebugFlag) {
                dprint(".handleEvent: doWork");
            }
            getWork().doWork();
        }
        if (orb.transportDebugFlag) {
            dprint(".handleEvent<-: " + this);
        }
    }

    public boolean shouldUseWorkerThreadForEvent()
    {
        return useWorkerThreadForEvent;
    }

    public void setUseWorkerThreadForEvent(boolean x)
    {
        useWorkerThreadForEvent = x;
    }

    public void setWork(Work work)
    {
        this.work = work;
    }

    public Work getWork()
    {
        return work;
    }

    private void dprint(String msg)
    {
        ORBUtility.dprint("EventHandlerBase", msg);
    }
}

// End of file.
