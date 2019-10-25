/*
 * Copyright (c) 1999, 2013, Oracle and/or its affiliates. All rights reserved.
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

package javax.management;

import java.io.IOException;
import java.io.ObjectInputStream;


/**
 * Thrown when an invalid MBean attribute is passed to a query
 * constructing method.  This exception is used internally by JMX
 * during the evaluation of a query.  User code does not usually
 * see it.
 *
 * @since 1.5
 */
public class BadAttributeValueExpException extends Exception   {


    /* Serial version */
    private static final long serialVersionUID = -3105272988410493376L;

    /**
     * @serial A string representation of the attribute that originated this exception.
     * for example, the string value can be the return of {@code attribute.toString()}
     */
    private Object val;

    /**
     * Constructs a BadAttributeValueExpException using the specified Object to
     * create the toString() value.
     *
     * @param val the inappropriate value.
     */
    public BadAttributeValueExpException (Object val) {
        this.val = val == null ? null : val.toString();
    }


    /**
     * Returns the string representing the object.
     */
    public String toString()  {
        return "BadAttributeValueException: " + val;
    }

    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        ObjectInputStream.GetField gf = ois.readFields();
        Object valObj = gf.get("val", null);

        if (valObj == null) {
            val = null;
        } else if (valObj instanceof String) {
            val= valObj;
        } else if (System.getSecurityManager() == null
                || valObj instanceof Long
                || valObj instanceof Integer
                || valObj instanceof Float
                || valObj instanceof Double
                || valObj instanceof Byte
                || valObj instanceof Short
                || valObj instanceof Boolean) {
            val = valObj.toString();
        } else { // the serialized object is from a version without JDK-8019292 fix
            val = System.identityHashCode(valObj) + "@" + valObj.getClass().getName();
        }
    }
 }
