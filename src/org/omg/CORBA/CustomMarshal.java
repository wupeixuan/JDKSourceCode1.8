/*
 * Copyright (c) 1999, 2003, Oracle and/or its affiliates. All rights reserved.
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

import org.omg.CORBA.DataOutputStream;
import org.omg.CORBA.DataInputStream;

/**
 * An abstract value type that is meant to
 * be used by the ORB, not the user. Semantically it is treated
 * as a custom value type's implicit base class, although the custom
 * valuetype does not actually inherit it in IDL. The implementer
 * of a custom value type shall provide an implementation of the
 * <tt>CustomMarshal</tt> operations. The manner in which this is done is
 * specified in the IDL to Java langauge mapping. Each custom
 * marshaled value type shall have its own implementation.
 * @see DataInputStream
 */
public interface CustomMarshal {
    /**
     * Marshal method has to be implemented by the Customized Marshal class.
     * This is the method invoked for Marshalling.
     *
     * @param os a DataOutputStream
     */
    void marshal(DataOutputStream os);
    /**
     * Unmarshal method has to be implemented by the Customized Marshal class.
     * This is the method invoked for Unmarshalling.
     *
     * @param is a DataInputStream
     */
    void unmarshal(DataInputStream is);
}
