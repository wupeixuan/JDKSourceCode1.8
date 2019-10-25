/*
 * Copyright (c) 1997, 1999, Oracle and/or its affiliates. All rights reserved.
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

/**
 * A constant that signifies an "output" argument to an invocation,
 * meaning that the argument is being passed from the server to
 * the client.
 * <code>ARG_OUT.value</code> is one of the possible values used
 * to indicate the direction in
 * which a parameter is being passed during a dynamic invocation
 * using the Dynamic Invocation Interface (DII).
 * <P>
 * The code fragment below shows a typical usage:
 * <PRE>
 *  ORB orb = ORB.init(args, null);
 *  org.omg.CORBA.NamedValue nv = orb.create_named_value(
 *        "argumentIdentifier", myAny, org.omg.CORBA.ARG_OUT.value);
 * </PRE>
 *
 * @see     org.omg.CORBA.NamedValue
 * @since   JDK1.2
 */
public interface ARG_OUT {

/**
 * The constant value indicating an output argument.
 */
  int value = 2;
}
