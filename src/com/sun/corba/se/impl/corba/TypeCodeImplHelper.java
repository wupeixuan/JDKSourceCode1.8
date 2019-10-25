/*
 * Copyright (c) 1999, 2004, Oracle and/or its affiliates. All rights reserved.
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
/*
 * Licensed Materials - Property of IBM
 * RMI-IIOP v1.0
 * Copyright IBM Corp. 1998 1999  All Rights Reserved
 *
 */

package com.sun.corba.se.impl.corba;

abstract public class TypeCodeImplHelper
{
    private static String  _id = "IDL:omg.org/CORBA/TypeCode:1.0";

    public static void insert (org.omg.CORBA.Any a, org.omg.CORBA.TypeCode that)
    {
        org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
        a.type (type ());
        write (out, that);
        a.read_value (out.create_input_stream (), type ());
    }

    public static org.omg.CORBA.TypeCode extract (org.omg.CORBA.Any a)
    {
        return read (a.create_input_stream ());
    }

    private static org.omg.CORBA.TypeCode __typeCode = null;
    synchronized public static org.omg.CORBA.TypeCode type ()
    {
        if (__typeCode == null)
            {
                __typeCode = org.omg.CORBA.ORB.init ().get_primitive_tc (org.omg.CORBA.TCKind.tk_TypeCode);
            }
        return __typeCode;
    }

    public static String id ()
    {
        return _id;
    }

    public static org.omg.CORBA.TypeCode read (org.omg.CORBA.portable.InputStream istream)
    {
        return istream.read_TypeCode ();
    }

    public static void write (org.omg.CORBA.portable.OutputStream ostream, org.omg.CORBA.TypeCode value)
    {
        ostream.write_TypeCode (value);
    }

    public static void write (org.omg.CORBA.portable.OutputStream ostream, TypeCodeImpl value)
    {
        ostream.write_TypeCode (value);
    }

}
