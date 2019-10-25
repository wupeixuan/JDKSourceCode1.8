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

package javax.xml.ws;


/** The <code>Binding</code> interface is the base interface
 *  for JAX-WS protocol bindings.
 *
 *  @since JAX-WS 2.0
**/
public interface Binding {

   /**
    * Gets a copy of the handler chain for a protocol binding instance.
    * If the returned chain is modified a call to <code>setHandlerChain</code>
    * is required to configure the binding instance with the new chain.
    *
    *  @return java.util.List&lt;Handler> Handler chain
    */
    public java.util.List<javax.xml.ws.handler.Handler> getHandlerChain();

   /**
    * Sets the handler chain for the protocol binding instance.
    *
    *  @param chain    A List of handler configuration entries
    *  @throws WebServiceException On an error in the configuration of
    *                  the handler chain
    *  @throws java.lang.UnsupportedOperationException If this
    *          operation is not supported. This may be done to
    *          avoid any overriding of a pre-configured handler
    *          chain.
    */
    public void setHandlerChain(java.util.List<javax.xml.ws.handler.Handler> chain);

    /**
     * Get the URI for this binding instance.
     *
     * @return String The binding identifier for the port.
     *    Never returns <code>null</code>
     *
     * @since JAX-WS 2.1
     */
    String getBindingID();
}
