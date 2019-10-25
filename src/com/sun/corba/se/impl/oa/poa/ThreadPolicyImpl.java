/*
 * Copyright (c) 1997, 2003, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.corba.se.impl.oa.poa;

import org.omg.CORBA.*;
import org.omg.PortableServer.*;

final class ThreadPolicyImpl
    extends org.omg.CORBA.LocalObject implements ThreadPolicy {

    public ThreadPolicyImpl(ThreadPolicyValue value) {
        this.value = value;
    }

    public ThreadPolicyValue value() {
        return value;
    }

    public int policy_type()
    {
        return THREAD_POLICY_ID.value ;
    }

    public Policy copy() {
        return new ThreadPolicyImpl(value);
    }

    public void destroy() {
        value = null;
    }

    private ThreadPolicyValue value;

    public String toString()
    {
        return "ThreadPolicy[" +
            ((value.value() == ThreadPolicyValue._SINGLE_THREAD_MODEL) ?
                "SINGLE_THREAD_MODEL" : "ORB_CTRL_MODEL" + "]") ;
    }
}
