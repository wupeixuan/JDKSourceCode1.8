/*
 * Copyright (c) 2002, 2003, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.corba.se.impl.protocol;

import org.omg.CORBA.INTERNAL;
import org.omg.CORBA.portable.ServantObject;

import com.sun.corba.se.spi.protocol.LocalClientRequestDispatcher ;

/**
 * @author Harold Carr
 */

public class NotLocalLocalCRDImpl implements LocalClientRequestDispatcher
{
    public boolean useLocalInvocation(org.omg.CORBA.Object self)
    {
        return false;
    }

    public boolean is_local(org.omg.CORBA.Object self)
    {
        return false;
    }

    public ServantObject servant_preinvoke(org.omg.CORBA.Object self,
                                           String operation,
                                           Class expectedType)
    {
        // REVISIT: Rewrite rmic.HelloTest and rmic.LocalStubTest
        // (which directly call servant_preinvoke)
        // then revert to exception again.
        return null;
        //throw new INTERNAL();
    }

    public void servant_postinvoke(org.omg.CORBA.Object self,
                                   ServantObject servant)
    {
        //throw new INTERNAL();
    }
}

// End of file.
