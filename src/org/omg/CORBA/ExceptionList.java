/*
 * Copyright (c) 1996, 1999, Oracle and/or its affiliates. All rights reserved.
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

package org.omg.CORBA;

/**
 * An object used in <code>Request</code> operations to
 * describe the exceptions that can be thrown by a method.  It maintains a
 * modifiable list of <code>TypeCode</code>s of the exceptions.
 * <P>
 * The following code fragment demonstrates creating
 * an <code>ExceptionList</code> object:
 * <PRE>
 *    ORB orb = ORB.init(args, null);
 *    org.omg.CORBA.ExceptionList excList = orb.create_exception_list();
 * </PRE>
 * The variable <code>excList</code> represents an <code>ExceptionList</code>
 * object with no <code>TypeCode</code> objects in it.
 * <P>
 * To add items to the list, you first create a <code>TypeCode</code> object
 * for the exception you want to include, using the <code>ORB</code> method
 * <code>create_exception_tc</code>.  Then you use the <code>ExceptionList</code>
 * method <code>add</code> to add it to the list.
 * The class <code>ExceptionList</code> has a method for getting
 * the number of <code>TypeCode</code> objects in the list, and  after
 * items have been added, it is possible to call methods for accessing
 * or deleting an item at a designated index.
 *
 * @since   JDK1.2
 */

public abstract class ExceptionList {

    /**
     * Retrieves the number of <code>TypeCode</code> objects in this
     * <code>ExceptionList</code> object.
     *
     * @return          the     number of <code>TypeCode</code> objects in this
     * <code>ExceptionList</code> object
     */

    public abstract int count();

    /**
     * Adds a <code>TypeCode</code> object describing an exception
     * to this <code>ExceptionList</code> object.
     *
     * @param exc                       the <code>TypeCode</code> object to be added
     */

    public abstract void add(TypeCode exc);

    /**
     * Returns the <code>TypeCode</code> object at the given index.  The first
     * item is at index 0.
     *
     * @param index             the index of the <code>TypeCode</code> object desired.
     *                    This must be an <code>int</code> between 0 and the
     *                    number of <code>TypeCode</code> objects
     *                    minus one, inclusive.
     * @return                  the <code>TypeCode</code> object  at the given index
     * @exception org.omg.CORBA.Bounds   if the index given is greater than
     *                          or equal to the number of <code>TypeCode</code> objects
     *                in this <code>ExceptionList</code> object
     */

    public abstract TypeCode item(int index)
        throws org.omg.CORBA.Bounds;

    /**
     * Removes the <code>TypeCode</code> object at the given index.
     * Note that the indices of all the <code>TypeCoded</code> objects
     * following the one deleted are shifted down by one.
     *
     * @param index             the index of the <code>TypeCode</code> object to be
     *                    removed.
     *                    This must be an <code>int</code> between 0 and the
     *                    number of <code>TypeCode</code> objects
     *                    minus one, inclusive.
     *
     * @exception org.omg.CORBA.Bounds if the index is greater than
     *                          or equal to the number of <code>TypeCode</code> objects
     *                in this <code>ExceptionList</code> object
     */

    public abstract void remove(int index)
        throws org.omg.CORBA.Bounds;
}
