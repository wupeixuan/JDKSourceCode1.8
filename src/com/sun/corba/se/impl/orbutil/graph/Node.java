/*
 * Copyright (c) 2003, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.corba.se.impl.orbutil.graph ;

import java.util.Set ;

/** Node in a graph.
*/
public interface Node
{
    /** Get all the children of this node.
     */
    Set /* Set<Node> */ getChildren() ;
}
