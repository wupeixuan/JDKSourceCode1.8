/*
 * Copyright (c) 1998, 2004, Oracle and/or its affiliates. All rights reserved.
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
 * The representation of a <code>DynAny</code> object that is associated
 * with an IDL sequence.
 * @deprecated Use the new <a href="../DynamicAny/DynSequence.html">DynSequence</a> instead
 */
@Deprecated
public interface DynSequence extends org.omg.CORBA.Object, org.omg.CORBA.DynAny
{

    /**
     * Returns the length of the sequence represented by this
     * <code>DynFixed</code> object.
     *
     * @return the length of the sequence
     */
    public int length();

    /**
     * Sets the length of the sequence represented by this
     * <code>DynFixed</code> object to the given argument.
     *
     * @param arg the length of the sequence
     */
    public void length(int arg);

    /**
     * Returns the value of every element in this sequence.
     *
     * @return an array of <code>Any</code> objects containing the values in
         *         the sequence
         * @see #set_elements
     */
    public org.omg.CORBA.Any[] get_elements();

    /**
     * Sets the values of all elements in this sequence with the given
         * array.
     *
     * @param value the array of <code>Any</code> objects to be set
     * @exception InvalidSeq if the array of values is bad
         * @see #get_elements
     */
    public void set_elements(org.omg.CORBA.Any[] value)
        throws org.omg.CORBA.DynAnyPackage.InvalidSeq;
}
