/*
 * Copyright (c) 2003, 2004, Oracle and/or its affiliates. All rights reserved.
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

package javax.sql.rowset.spi;

import java.sql.SQLException;

/**
 * Indicates an error with <code>SyncFactory</code> mechanism. A disconnected
 * RowSet implementation cannot be used  without a <code>SyncProvider</code>
 * being successfully instantiated
 *
 * @author Jonathan Bruce
 * @see javax.sql.rowset.spi.SyncFactory
 * @see javax.sql.rowset.spi.SyncFactoryException
 */
public class SyncFactoryException extends java.sql.SQLException {

    /**
     * Creates new <code>SyncFactoryException</code> without detail message.
     */
    public SyncFactoryException() {
    }

    /**
     * Constructs an <code>SyncFactoryException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public SyncFactoryException(String msg) {
        super(msg);
    }

    static final long serialVersionUID = -4354595476433200352L;
}
