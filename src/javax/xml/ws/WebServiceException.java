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

/** The <code>WebServiceException</code> class is the base
 *  exception class for all JAX-WS API runtime exceptions.
 *
 *  @since JAX-WS 2.0
**/

public class WebServiceException extends java.lang.RuntimeException {

  /** Constructs a new exception with <code>null</code> as its
   *  detail message. The cause is not initialized.
  **/
  public WebServiceException() {
    super();
  }

  /** Constructs a new exception with the specified detail
   *  message.  The cause is not initialized.
   *  @param message The detail message which is later
   *                 retrieved using the getMessage method
  **/
  public WebServiceException(String message) {
    super(message);
  }

  /** Constructs a new exception with the specified detail
   *  message and cause.
   *
   *  @param message The detail message which is later retrieved
   *                 using the getMessage method
   *  @param cause   The cause which is saved for the later
   *                 retrieval throw by the getCause method
  **/
  public WebServiceException(String message, Throwable cause) {
    super(message,cause);
  }

  /** Constructs a new WebServiceException with the specified cause
   *  and a detail message of <tt>(cause==null ? null :
   *  cause.toString())</tt> (which typically contains the
   *  class and detail message of <tt>cause</tt>).
   *
   *  @param cause   The cause which is saved for the later
   *                 retrieval throw by the getCause method.
   *                 (A <tt>null</tt> value is permitted, and
   *                 indicates that the cause is nonexistent or
     *               unknown.)
  **/
  public WebServiceException(Throwable cause) {
    super(cause);
  }

}
