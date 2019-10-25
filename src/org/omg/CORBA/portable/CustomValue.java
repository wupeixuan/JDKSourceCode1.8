/*
 * Copyright (c) 1999, 2000, Oracle and/or its affiliates. All rights reserved.
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

/**
 * Defines the base interface for all custom value types
 * generated from IDL.
 *
 * All value types implement ValueBase either directly
 * or indirectly by implementing either the StreamableValue
 * or CustomValue interface.
 * @author OMG
 */

package org.omg.CORBA.portable;

import org.omg.CORBA.CustomMarshal;
/**
 * An extension of <code>ValueBase</code> that is implemented by custom value
 * types.
 */
public interface CustomValue extends ValueBase, CustomMarshal {

}
