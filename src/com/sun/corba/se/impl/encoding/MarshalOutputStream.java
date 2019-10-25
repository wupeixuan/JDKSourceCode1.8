/*
 * Copyright (c) 1998, 2003, Oracle and/or its affiliates. All rights reserved.
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
package com.sun.corba.se.impl.encoding;

import java.io.IOException;

import org.omg.CORBA.TypeCode;
import org.omg.CORBA.Principal;
import org.omg.CORBA.Any;

import org.omg.CORBA.portable.InputStream;

public interface MarshalOutputStream {

    public InputStream create_input_stream();

    public void write_boolean(boolean value);
    public void write_char(char value);
    public void write_wchar(char value);
    public void write_octet(byte value);
    public void write_short(short value);
    public void write_ushort(short value);
    public void write_long(int value);
    public void write_ulong(int value);
    public void write_longlong(long value);
    public void write_ulonglong(long value);
    public void write_float(float value);
    public void write_double(double value);
    public void write_string(String value);
    public void write_wstring(String value);

    public void write_boolean_array(boolean[] value, int offset, int length);
    public void write_char_array(char[] value, int offset, int length);
    public void write_wchar_array(char[] value, int offset, int length);
    public void write_octet_array(byte[] value, int offset, int length);
    public void write_short_array(short[] value, int offset, int length);
    public void write_ushort_array(short[] value, int offset, int length);
    public void write_long_array(int[] value, int offset, int length);
    public void write_ulong_array(int[] value, int offset, int length);
    public void write_longlong_array(long[] value, int offset, int length);
    public void write_ulonglong_array(long[] value, int offset, int length);
    public void write_float_array(float[] value, int offset, int length);
    public void write_double_array(double[] value, int offset, int length);

    public void write_Object(org.omg.CORBA.Object value);
    public void write_TypeCode(TypeCode value);
    public void write_any(Any value);
    public void write_Principal(Principal value);


    /*
     * The methods necessary to support RMI
     */
    public void write_value(java.io.Serializable value);
    public void start_block();
    public void end_block();

    /*
     * Additional Methods
     */

    public void   putEndian();
    public void   writeTo(java.io.OutputStream s)
        throws IOException;

    public byte[] toByteArray();
}
