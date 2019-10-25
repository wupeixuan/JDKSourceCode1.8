/*
 * Copyright (c) 2002, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.corba.se.impl.orb ;

import java.util.Properties ;

public interface ParserAction {
    /** Return the property name or prefix for which this action
     * is applied.
     */
    String getPropertyName() ;

    /** Return whether this action is for an exact match or a prefix
     * match (true).
     */
    boolean isPrefix() ;

    /** Return the field name in an object that is set with the result
     */
    String getFieldName() ;

    /** Apply this action to props and return the result.
    */
    Object apply( Properties props ) ;
}
