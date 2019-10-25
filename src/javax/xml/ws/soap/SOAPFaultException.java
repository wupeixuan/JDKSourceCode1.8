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

package javax.xml.ws.soap;

import javax.xml.soap.SOAPFault;

/** The <code>SOAPFaultException</code> exception represents a
 *  SOAP 1.1 or 1.2 fault.
 *
 *  <p>A <code>SOAPFaultException</code> wraps a SAAJ <code>SOAPFault</code>
 *  that manages the SOAP-specific representation of faults.
 *  The <code>createFault</code> method of
 *  <code>javax.xml.soap.SOAPFactory</code> may be used to create an instance
 *  of <code>javax.xml.soap.SOAPFault</code> for use with the
 *  constructor. <code>SOAPBinding</code> contains an accessor for the
 *  <code>SOAPFactory</code> used by the binding instance.
 *
 *  <p>Note that the value of <code>getFault</code> is the only part of the
 *  exception used when searializing a SOAP fault.
 *
 *  <p>Refer to the SOAP specification for a complete
 *  description of SOAP faults.
 *
 *  @see javax.xml.soap.SOAPFault
 *  @see javax.xml.ws.soap.SOAPBinding#getSOAPFactory
 *  @see javax.xml.ws.ProtocolException
 *
 *  @since JAX-WS 2.0
 **/
public class SOAPFaultException extends javax.xml.ws.ProtocolException  {

    private SOAPFault fault;

    /** Constructor for SOAPFaultException
     *  @param fault   <code>SOAPFault</code> representing the fault
     *
     *  @see javax.xml.soap.SOAPFactory#createFault
     **/
    public SOAPFaultException(SOAPFault fault) {
        super(fault.getFaultString());
        this.fault = fault;
    }

    /** Gets the embedded <code>SOAPFault</code> instance.
     *
     *  @return <code>javax.xml.soap.SOAPFault</code> SOAP
     *          fault element
     **/
    public javax.xml.soap.SOAPFault getFault() {
        return this.fault;
    }
}
