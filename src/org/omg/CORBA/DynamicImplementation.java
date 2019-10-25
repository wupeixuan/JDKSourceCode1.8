/*
 * Copyright (c) 1997, 2004, Oracle and/or its affiliates. All rights reserved.
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

package org.omg.CORBA;

import org.omg.CORBA.portable.ObjectImpl;

/**
 * @deprecated org.omg.CORBA.DynamicImplementation
 */
@Deprecated
public class DynamicImplementation extends org.omg.CORBA.portable.ObjectImpl {

    /**
      * @deprecated Deprecated by Portable Object Adapter
      */
    @Deprecated
    public void invoke(ServerRequest request) {
        throw new org.omg.CORBA.NO_IMPLEMENT();
    }

    public String[] _ids() {
        throw new org.omg.CORBA.NO_IMPLEMENT();
    }
}
