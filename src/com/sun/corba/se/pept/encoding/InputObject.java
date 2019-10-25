/*
 * Copyright (c) 2001, 2003, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.corba.se.pept.encoding;

import java.io.IOException;

import com.sun.corba.se.pept.protocol.MessageMediator;

/**
 * <p> An <code>InputObject</code> is the interface used by the
 * presentation block to get programming language typed data from data
 *  encoded in a message. </p>
 *
 * <p> The implementation of an <code>InputObject</code> contains the
 * encoded data.  When the presentation block asks for data the
 * implementation of <code>InputObject</code> is responsible for converting
 * the encoded representation of the data to the types expected by the
 * programming language.</p>
 *
 * <p>A particular <em>encoding</em> would subclass
 * <code>InputObject</code>.  The subclass would provide methods to get
 * the data types appropriate to the presentation block (e.g., simple
 * types such as int or boolean, all the way to any type derived from
 * <code>java.io.Serializable</code>.).</p>
 *
 * <p>Note: the protocol block may also use the <code>InputObject</code> to
 * obtain header metadata.</p>
 *
 * @author Harold Carr
*/
public interface InputObject
{
    public void setMessageMediator(MessageMediator messageMediator);

    public MessageMediator getMessageMediator();

    public void close() throws IOException;
}

// End of file.
