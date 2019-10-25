/*
 * Copyright (c) 2005, 2013, Oracle and/or its affiliates. All rights reserved.
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

import javax.xml.ws.ProtocolException;
import javax.xml.ws.handler.MessageContext;

/** The <code>Handler</code> interface
 *  is the base interface for JAX-WS handlers.
 *
 *  @since JAX-WS 2.0
**/
public interface Handler<C extends MessageContext> {

  /** The <code>handleMessage</code> method is invoked for normal processing
   *  of inbound and outbound messages. Refer to the description of the handler
   *  framework in the JAX-WS specification for full details.
   *
   *  @param context the message context.
   *  @return An indication of whether handler processing should continue for
   *  the current message
   *                 <ul>
   *                 <li>Return <code>true</code> to continue
   *                     processing.</li>
   *                 <li>Return <code>false</code> to block
   *                     processing.</li>
   *                  </ul>
   *  @throws RuntimeException Causes the JAX-WS runtime to cease
   *    handler processing and generate a fault.
   *  @throws ProtocolException Causes the JAX-WS runtime to switch to
   *    fault message processing.
  **/
  public boolean handleMessage(C context);

  /** The <code>handleFault</code> method is invoked for fault message
   *  processing.  Refer to the description of the handler
   *  framework in the JAX-WS specification for full details.
   *
   *  @param context the message context
   *  @return An indication of whether handler fault processing should continue
   *  for the current message
   *                 <ul>
   *                 <li>Return <code>true</code> to continue
   *                     processing.</li>
   *                 <li>Return <code>false</code> to block
   *                     processing.</li>
   *                  </ul>
   *  @throws RuntimeException Causes the JAX-WS runtime to cease
   *    handler fault processing and dispatch the fault.
   *  @throws ProtocolException Causes the JAX-WS runtime to cease
   *    handler fault processing and dispatch the fault.
  **/
  public boolean handleFault(C context);

  /**
   * Called at the conclusion of a message exchange pattern just prior to
   * the JAX-WS runtime dispatching a message, fault or exception.  Refer to
   * the description of the handler
   * framework in the JAX-WS specification for full details.
   *
   * @param context the message context
  **/
  public void close(MessageContext context);
}
