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


package org.omg.CORBA.portable;

/**
 * Defines the base type for all non-boxed IDL valuetypes
 * that are not custom marshaled.
 *
 * All value types implement ValueBase either directly or
 * indirectly by implementing either the
 * StreamableValue or CustomValue interface.
 *
 * @author OMG
 */
public interface StreamableValue extends Streamable, ValueBase {

}
