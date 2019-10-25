/*
 * Copyright (c) 2005, 2010, Oracle and/or its affiliates. All rights reserved.
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

package javax.xml.ws.handler;

/** The <code>LogicalHandler</code> extends
 *  Handler to provide typesafety for the message context parameter.
 *
 *  @since JAX-WS 2.0
**/
public interface LogicalHandler<C extends LogicalMessageContext> extends Handler<C> {
}
