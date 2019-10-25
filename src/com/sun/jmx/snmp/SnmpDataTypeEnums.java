/*
 *
 * Copyright (c) 2007, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
// Copyright (c) 1995-96 by Cisco Systems, Inc.

package com.sun.jmx.snmp;

/**
 * Contains SNMP data type constants.
 * All members are static and can be used by any application.
 *
 *
 * <p><b>This API is a Sun Microsystems internal API  and is subject
 * to change without notice.</b></p>
 */

public interface SnmpDataTypeEnums  {

  // ASN1 Type definitions.
  //-----------------------

  /**
   * ASN.1 tag for representing the boolean type.
   */
  static public final int BooleanTag= 1;

  /**
   * ASN.1 tag for representing the integer type.
   */
  static public final int IntegerTag= 2;

   /**
   * ASN.1 tag for representing the bit string type.
   */
  static public final int BitStringTag= 2;

   /**
   * ASN.1 tag for representing the octet string type.
   */
  static public final int OctetStringTag= 4;

   /**
   * ASN.1 tag for representing the null type.
   */
  static public final int NullTag= 5;

   /**
   * ASN.1 tag for representing the Object Identifier type.
   */
  static public final int ObjectIdentiferTag= 6;


 /**
  * Represents a unknown syntax type. No meaning in an ASN.1 context.
  */
  final public static int  UnknownSyntaxTag     =  0xFF ;

 /**
  * ASN.1 tag for a <CODE>SEQUENCE</CODE> or <CODE>SEQUENCE OF</CODE>.
  */
  final public static int  SequenceTag     =  0x30 ;

 /**
  * Represents an SNMP table. No meaning in an ASN.1 context.
  */
  final public static int  TableTag     =  0xFE ;

  // SNMP definitions.
  //------------------

  /**
   * ASN.1 Tag for application context.
   */
  static public final int ApplFlag = 64 ;

 /**
  * ASN.1 tag for implicit context.
  */
  static public final int CtxtFlag = 128 ;

  /**
   * ASN.1 tag for representing an IP address as defined in RFC 1155.
   */
  static public final int IpAddressTag  = ApplFlag | 0 ;

  /**
   * ASN.1 tag for representing a <CODE>Counter32</CODE> as defined in RFC 1155.
   */
  static public final int CounterTag    = ApplFlag | 1 ;

  /**
   * ASN.1 tag for representing a <CODE>Gauge32</CODE> as defined in RFC 1155.
   */
  static public final int GaugeTag      = ApplFlag | 2 ;

  /**
   * ASN.1 tag for representing a <CODE>Timeticks</CODE> as defined in RFC 1155.
   */
  static public final int TimeticksTag  = ApplFlag | 3 ;

  /**
   * ASN.1 tag for representing an <CODE>Opaque</CODE> type as defined in RFC 1155.
   */
  static public final int OpaqueTag     = ApplFlag | 4 ;

  /**
   * ASN.1 tag for representing a <CODE>Counter64</CODE> as defined in RFC 1155.
   */
  static public final int Counter64Tag  = ApplFlag | 6 ;

  /**
   * ASN.1 tag for representing an <CODE>Nsap</CODE> as defined in RFC 1902.
   */
  static final public int NsapTag       = ApplFlag | 5 ;

  /**
   * ASN.1 tag for representing an <CODE>Unsigned32</CODE> integer as defined in RFC 1902.
   */
  static final public int UintegerTag      = ApplFlag | 7 ;

  /**
   * ASN.1 tag for representing a <CODE>NoSuchObject</CODE> as defined in RFC 1902.
   */
  static final public int errNoSuchObjectTag    = CtxtFlag | 0 ;

   /**
   * ASN.1 tag for representing a <CODE>NoSuchInstance</CODE> as defined in RFC 1902.
   */
  static final public int errNoSuchInstanceTag  = CtxtFlag | 1 ;

  /**
   * ASN.1 tag for representing an <CODE>EndOfMibView</CODE> as defined in RFC 1902.
   */
  static final public int errEndOfMibViewTag    = CtxtFlag | 2 ;


}
