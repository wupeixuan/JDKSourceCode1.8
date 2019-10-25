/*
 * Copyright (c) 1999, 2003, Oracle and/or its affiliates. All rights reserved.
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
package org.omg.PortableServer;

/**
 * Allows dynamic handling of object invocations.  POA-based DSI
 * servants inherit from the
 * standard <code>DynamicImplementation</code> class, this class inherits
 * from the <code>Servant</code> class. Based on IDL to Java spec.
 * CORBA V 2.3.1 ptc/00-01-08.pdf.
 */
abstract public class DynamicImplementation extends Servant {

/**
 * Receives requests issued to any CORBA object
 * incarnated by the DSI servant and performs the processing
 * necessary to execute the request.
 * @param request the request issued to the CORBA object.
 */
    abstract public void invoke(org.omg.CORBA.ServerRequest request);
}
