/*
 * Copyright (c) 1995, 2008, Oracle and/or its affiliates. All rights reserved.
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

package java.lang;

/**
 * An IllegalAccessException is thrown when an application tries
 * to reflectively create an instance (other than an array),
 * set or get a field, or invoke a method, but the currently
 * executing method does not have access to the definition of
 * the specified class, field, method or constructor.
 *
 * @author  unascribed
 * @see     Class#newInstance()
 * @see     java.lang.reflect.Field#set(Object, Object)
 * @see     java.lang.reflect.Field#setBoolean(Object, boolean)
 * @see     java.lang.reflect.Field#setByte(Object, byte)
 * @see     java.lang.reflect.Field#setShort(Object, short)
 * @see     java.lang.reflect.Field#setChar(Object, char)
 * @see     java.lang.reflect.Field#setInt(Object, int)
 * @see     java.lang.reflect.Field#setLong(Object, long)
 * @see     java.lang.reflect.Field#setFloat(Object, float)
 * @see     java.lang.reflect.Field#setDouble(Object, double)
 * @see     java.lang.reflect.Field#get(Object)
 * @see     java.lang.reflect.Field#getBoolean(Object)
 * @see     java.lang.reflect.Field#getByte(Object)
 * @see     java.lang.reflect.Field#getShort(Object)
 * @see     java.lang.reflect.Field#getChar(Object)
 * @see     java.lang.reflect.Field#getInt(Object)
 * @see     java.lang.reflect.Field#getLong(Object)
 * @see     java.lang.reflect.Field#getFloat(Object)
 * @see     java.lang.reflect.Field#getDouble(Object)
 * @see     java.lang.reflect.Method#invoke(Object, Object[])
 * @see     java.lang.reflect.Constructor#newInstance(Object[])
 * @since   JDK1.0
 */
public class IllegalAccessException extends ReflectiveOperationException {
    private static final long serialVersionUID = 6616958222490762034L;

    /**
     * Constructs an <code>IllegalAccessException</code> without a
     * detail message.
     */
    public IllegalAccessException() {
        super();
    }

    /**
     * Constructs an <code>IllegalAccessException</code> with a detail message.
     *
     * @param   s   the detail message.
     */
    public IllegalAccessException(String s) {
        super(s);
    }
}
