/*
 * Copyright (c) 1998, 2001, Oracle and/or its affiliates. All rights reserved.
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

import org.omg.CORBA.portable.Streamable;
import org.omg.CORBA.portable.InputStream;
import org.omg.CORBA.portable.OutputStream;


/**
 * The Holder for <tt>Fixed</tt>.  For more information on
 * Holder files, see <a href="doc-files/generatedfiles.html#holder">
 * "Generated Files: Holder Files"</a>.<P>
 * FixedHolder is a container class for values of IDL type "fixed",
 * which is mapped to the Java class java.math.BigDecimal.
 * It is usually used to store "out" and "inout" IDL method parameters.
 * If an IDL method signature has a fixed as an "out" or "inout" parameter,
 * the programmer must pass an instance of FixedHolder as the corresponding
 * parameter in the method invocation; for "inout" parameters, the programmer
 * must also fill the "in" value to be sent to the server.
 * Before the method invocation returns, the ORB will fill in the contained
 * value corresponding to the "out" value returned from the server.
 *
 */
public final class FixedHolder implements Streamable {
    /**
     * The value held by the FixedHolder
     */
    public java.math.BigDecimal value;

    /**
     * Construct the FixedHolder without initializing the contained value.
     */
    public FixedHolder() {
    }

    /**
     * Construct the FixedHolder and initialize it with the given value.
     * @param initial the value used to initialize the FixedHolder
     */
    public FixedHolder(java.math.BigDecimal initial) {
        value = initial;
    }

    /**
     * Read a fixed point value from the input stream and store it in
     * the value member.
     *
     * @param input the <code>InputStream</code> to read from.
     */
    public void _read(InputStream input) {
        value = input.read_fixed();
    }

    /**
     * Write the fixed point value stored in this holder to an
     * <code>OutputStream</code>.
     *
     * @param output the <code>OutputStream</code> to write into.
     */
    public void _write(OutputStream output) {
        output.write_fixed(value);
    }


    /**
     * Return the <code>TypeCode</code> of this holder object.
     *
     * @return the <code>TypeCode</code> object.
     */
    public org.omg.CORBA.TypeCode _type() {
        return ORB.init().get_primitive_tc(TCKind.tk_fixed);
    }

}
