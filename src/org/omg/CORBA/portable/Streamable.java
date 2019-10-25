/*
 * Copyright (c) 1997, 1999, Oracle and/or its affiliates. All rights reserved.
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
package org.omg.CORBA.portable;

import org.omg.CORBA.TypeCode;

/**
 * The base class for the Holder classess of all complex
 * IDL types. The ORB treats all generated Holders as Streamable to invoke
 * the methods for marshalling and unmarshalling.
 *
 * @since   JDK1.2
 */

public interface Streamable {
    /**
     * Reads data from <code>istream</code> and initalizes the
     * <code>value</code> field of the Holder with the unmarshalled data.
     *
     * @param     istream   the InputStream that represents the CDR data from the wire.
     */
    void _read(InputStream istream);
    /**
     * Marshals to <code>ostream</code> the value in the
     * <code>value</code> field of the Holder.
     *
     * @param     ostream   the CDR OutputStream
     */
    void _write(OutputStream ostream);

    /**
     * Retrieves the <code>TypeCode</code> object corresponding to the value
     * in the <code>value</code> field of the Holder.
     *
     * @return    the <code>TypeCode</code> object for the value held in the holder
     */
    TypeCode _type();
}
