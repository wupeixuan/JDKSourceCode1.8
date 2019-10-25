/*
 * Copyright (c) 1998, 2007, Oracle and/or its affiliates. All rights reserved.
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


package com.sun.jmx.snmp;


/**
 * Is used internally to signal that the size of a PDU exceeds the packet size limitation.
 * <p>
 * You will not usually need to use this class, except if you
 * decide to implement your own
 * {@link com.sun.jmx.snmp.SnmpPduFactory SnmPduFactory} object.
 * <p>
 * The <CODE>varBindCount</CODE> property contains the
 * number of <CODE>SnmpVarBind</CODE> successfully encoded
 * before the exception was thrown. Its value is 0
 * when this number is unknown.
 *
 * <p><b>This API is a Sun Microsystems internal API  and is subject
 * to change without notice.</b></p>
 */

public class SnmpTooBigException extends Exception {
  private static final long serialVersionUID = 4754796246674803969L;

  /**
   * Builds an <CODE>SnmpTooBigException</CODE> with
   * <CODE>varBindCount</CODE> set to 0.
   */
  public SnmpTooBigException() {
    varBindCount = 0 ;
  }

  /**
   * Builds an <CODE>SnmpTooBigException</CODE> with
   * <CODE>varBindCount</CODE> set to the specified value.
   * @param n The <CODE>varBindCount</CODE> value.
   */
  public SnmpTooBigException(int n) {
    varBindCount = n ;
  }


  /**
   * Returns the number of <CODE>SnmpVarBind</CODE> successfully
   * encoded before the exception was thrown.
   *
   * @return A positive integer (0 means the number is unknown).
   */
  public int getVarBindCount() {
    return varBindCount ;
  }

  /**
   * The <CODE>varBindCount</CODE>.
   * @serial
   */
  private int varBindCount ;
}
