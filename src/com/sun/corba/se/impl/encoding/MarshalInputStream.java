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

import org.omg.CORBA.TypeCode;
import org.omg.CORBA.Principal;
import org.omg.CORBA.Any;

public interface MarshalInputStream {
    public boolean      read_boolean();
    public char         read_char();
    public char         read_wchar();
    public byte         read_octet();
    public short        read_short();
    public short        read_ushort();
    public int          read_long();
    public int          read_ulong();
    public long         read_longlong();
    public long         read_ulonglong();
    public float        read_float();
    public double       read_double();
    public String       read_string();
    public String       read_wstring();

    public void read_boolean_array(boolean[] value, int offset, int length);
    public void read_char_array(char[] value, int offset, int length);
    public void read_wchar_array(char[] value, int offset, int length);
    public void read_octet_array(byte[] value, int offset, int length);
    public void read_short_array(short[] value, int offset, int length);
    public void read_ushort_array(short[] value, int offset, int length);
    public void read_long_array(int[] value, int offset, int length);
    public void read_ulong_array(int[] value, int offset, int length);
    public void read_longlong_array(long[] value, int offset, int length);
    public void read_ulonglong_array(long[] value, int offset, int length);
    public void read_float_array(float[] value, int offset, int length);
    public void read_double_array(double[] value, int offset, int length);

    public org.omg.CORBA.Object read_Object();
    public TypeCode     read_TypeCode();
    public Any          read_any();
    public Principal    read_Principal();

    /*
     * The methods necessary to support RMI
     */
    public org.omg.CORBA.Object read_Object(Class stubClass);
    public java.io.Serializable read_value() throws Exception;

    /*
     * Additional Methods
     */
    public void consumeEndian();

    // Determines the current byte stream position
    // (also handles fragmented streams)
    public int getPosition();

    // mark/reset from java.io.InputStream
    public void mark(int readAheadLimit);
    public void reset();

    /**
     * This must be called once before unmarshaling valuetypes or anything
     * that uses repository IDs.  The ORB's version should be set
     * to the desired value prior to calling.
     */
    public void performORBVersionSpecificInit();

    /**
     * Tells the input stream to null any code set converter
     * references, forcing it to reacquire them if it needs
     * converters again.  This is used when the server
     * input stream needs to switch the connection's char code set
     * converter to something different after reading the
     * code set service context for the first time.  Initially,
     * we use ISO8859-1 to read the operation name (it can't
     * be more than ASCII).
     */
    public void resetCodeSetConverters();
}
