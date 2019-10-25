/*
 * Copyright (c) 2001, 2002, Oracle and/or its affiliates. All rights reserved.
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
 */
package com.sun.corba.se.impl.orbutil;

import java.io.*;
import java.util.Hashtable;

/**
 * Since ObjectOutputStream.PutField methods specify no exceptions,
 * we are not checking for null parameters on put methods.
 */
class LegacyHookPutFields extends ObjectOutputStream.PutField
{
    private Hashtable fields = new Hashtable();

    /**
     * Put the value of the named boolean field into the persistent field.
     */
    public void put(String name, boolean value){
        fields.put(name, new Boolean(value));
    }

    /**
     * Put the value of the named char field into the persistent fields.
     */
    public void put(String name, char value){
        fields.put(name, new Character(value));
    }

    /**
     * Put the value of the named byte field into the persistent fields.
     */
    public void put(String name, byte value){
        fields.put(name, new Byte(value));
    }

    /**
     * Put the value of the named short field into the persistent fields.
     */
    public void put(String name, short value){
        fields.put(name, new Short(value));
    }

    /**
     * Put the value of the named int field into the persistent fields.
     */
    public void put(String name, int value){
        fields.put(name, new Integer(value));
    }

    /**
     * Put the value of the named long field into the persistent fields.
     */
    public void put(String name, long value){
        fields.put(name, new Long(value));
    }

    /**
     * Put the value of the named float field into the persistent fields.
     *
     */
    public void put(String name, float value){
        fields.put(name, new Float(value));
    }

    /**
     * Put the value of the named double field into the persistent field.
     */
    public void put(String name, double value){
        fields.put(name, new Double(value));
    }

    /**
     * Put the value of the named Object field into the persistent field.
     */
    public void put(String name, Object value){
        fields.put(name, value);
    }

    /**
     * Write the data and fields to the specified ObjectOutput stream.
     */
    public void write(ObjectOutput out) throws IOException {
        out.writeObject(fields);
    }
}
