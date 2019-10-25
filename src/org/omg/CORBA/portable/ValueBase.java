/*
 * Copyright (c) 1999, Oracle and/or its affiliates. All rights reserved.
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

package org.omg.CORBA.portable;
/**
 * The generated Java classes corresponding to valuetype IDL types
 * implement this interface. In other words, the Java mapping of
 * valuetype objects implement the ValueBase interface. The generated
 * Java class for valuetype's shall provide an implementation of the
 * ValueBase interface for the corresponding value type.
 * For value types that are streamable (i.e. non-custom),
 * the generated Java class shall also provide an implementation
 * for the org.omg.CORBA.portable.Streamable interface.
 * (CORBA::ValueBase is mapped to java.io.Serializable.)
 */
public interface ValueBase extends IDLEntity {
    /**
     * Provides truncatable repository ids.
     * @return a String array--list of truncatable repository ids.
     */
    String[] _truncatable_ids();
}
