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

final class LifespanPolicyImpl
    extends org.omg.CORBA.LocalObject implements LifespanPolicy {

    public LifespanPolicyImpl(LifespanPolicyValue value) {
        this.value = value;
    }

    public LifespanPolicyValue value() {
        return value;
    }

    public int policy_type()
    {
        return LIFESPAN_POLICY_ID.value ;
    }

    public Policy copy() {
        return new LifespanPolicyImpl(value);
    }

    public void destroy() {
        value = null;
    }

    private LifespanPolicyValue value;

    public String toString()
    {
        return "LifespanPolicy[" +
            ((value.value() == LifespanPolicyValue._TRANSIENT) ?
                "TRANSIENT" : "PERSISTENT" + "]") ;
    }
}
