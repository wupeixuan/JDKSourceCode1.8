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

import javax.xml.namespace.QName;

/**
 *  The <code>PortInfo</code> interface is used by a
 *  <code>HandlerResolver</code> to query information about
 *  the port it is being asked to create a handler chain for.
 *  <p>
 *  This interface is never implemented by an application,
 *  only by a JAX-WS implementation.
 *
 *  @since JAX-WS 2.0
**/
public interface PortInfo {

  /**
   *  Gets the qualified name of the WSDL service name containing
   *  the port being accessed.
   *
   *  @return javax.xml.namespace.QName The qualified name of the WSDL service.
  **/
  public QName getServiceName();

  /**
   *  Gets the qualified name of the WSDL port being accessed.
   *
   *  @return javax.xml.namespace.QName The qualified name of the WSDL port.
  **/
  public QName getPortName();

  /**
   *  Gets the URI identifying the binding used by the port being accessed.
   *
   *  @return String The binding identifier for the port.
   *
   *  @see javax.xml.ws.Binding
  **/
  public String getBindingID();

}
