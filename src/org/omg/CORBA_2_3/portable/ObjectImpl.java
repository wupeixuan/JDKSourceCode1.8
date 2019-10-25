/*
 * Copyright (c) 1999, Oracle and/or its affiliates. All rights reserved.
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
 * Licensed Materials - Property of IBM
 * RMI-IIOP v1.0
 * Copyright IBM Corp. 1998 1999  All Rights Reserved
 *
 */

package org.omg.CORBA_2_3.portable;

import org.omg.CORBA_2_3.portable.Delegate;

/**
 * ObjectImpl class is the base class for all stubs.  It provides the
 * basic delegation mechanism.  It extends org.omg.CORBA.portable.ObjectImpl
 * and provides new methods defined by CORBA 2.3.
 *
 * @see org.omg.CORBA.portable.ObjectImpl
 * @author  OMG
 * @since   JDK1.2
 */


public abstract class ObjectImpl extends org.omg.CORBA.portable.ObjectImpl {

    /** Returns the codebase for this object reference.
     * @return the codebase as a space delimited list of url strings or
     * null if none.
     */
    public java.lang.String _get_codebase() {
        org.omg.CORBA.portable.Delegate delegate = _get_delegate();
        if (delegate instanceof Delegate)
            return ((Delegate) delegate).get_codebase(this);
        return null;
    }
}
