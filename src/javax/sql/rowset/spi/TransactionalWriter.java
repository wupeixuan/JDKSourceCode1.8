/*
 * Copyright (c) 2003, 2013, Oracle and/or its affiliates. All rights reserved.
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
import java.io.Reader;

import javax.sql.RowSetWriter;
import javax.sql.rowset.*;
import java.sql.Savepoint;

/**
 * A specialized interface that facilitates an extension of the standard
 * <code>SyncProvider</code> abstract class so that it has finer grained
 * transaction control.
 * <p>
 * If one or more disconnected <code>RowSet</code> objects are participating
 * in a global transaction, they may wish to coordinate their synchronization
 * commits to preserve data integrity and reduce the number of
 * synchronization exceptions. If this is the case, an application should set
 * the <code>CachedRowSet</code> constant <code>COMMIT_ON_ACCEPT_CHANGES</code>
 * to <code>false</code> and use the <code>commit</code> and <code>rollback</code>
 * methods defined in this interface to manage transaction boundaries.
 */
public interface TransactionalWriter extends RowSetWriter {

    /**
     * Makes permanent all changes that have been performed by the
     * <code>acceptChanges</code> method since the last call to either the
     * <code>commit</code> or <code>rollback</code> methods.
     * This method should be used only when auto-commit mode has been disabled.
     *
     * @throws SQLException  if a database access error occurs or the
     *         <code>Connection</code> object within this <code>CachedRowSet</code>
     *         object is in auto-commit mode
     */
    public void commit() throws SQLException;

    /**
     * Undoes all changes made in the current transaction. This method should be
     * used only when auto-commit mode has been disabled.
     *
     * @throws SQLException if a database access error occurs or the <code>Connection</code>
     *         object within this <code>CachedRowSet</code> object is in auto-commit mode
     */
    public void rollback() throws SQLException;

    /**
     * Undoes all changes made in the current transaction made prior to the given
     * <code>Savepoint</code> object.  This method should be used only when auto-commit
     * mode has been disabled.
     *
     * @param s a <code>Savepoint</code> object marking a savepoint in the current
     *        transaction.  All changes made before <i>s</i> was set will be undone.
     *        All changes made after <i>s</i> was set will be made permanent.
     * @throws SQLException if a database access error occurs or the <code>Connection</code>
     *         object within this <code>CachedRowSet</code> object is in auto-commit mode
     */
    public void rollback(Savepoint s) throws SQLException;
}
