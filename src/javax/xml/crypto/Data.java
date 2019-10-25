/*
 * Copyright (c) 2005, Oracle and/or its affiliates. All rights reserved.
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
 * $Id: Data.java,v 1.4 2005/05/10 15:47:41 mullan Exp $
 */
package javax.xml.crypto;

import javax.xml.crypto.dsig.Transform;

/**
 * An abstract representation of the result of dereferencing a
 * {@link URIReference} or the input/output of subsequent {@link Transform}s.
 * The primary purpose of this interface is to group and provide type safety
 * for all <code>Data</code> subtypes.
 *
 * @author Sean Mullan
 * @author JSR 105 Expert Group
 * @since 1.6
 */
public interface Data { }
