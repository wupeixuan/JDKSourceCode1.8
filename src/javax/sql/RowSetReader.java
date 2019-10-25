/*
 * Copyright (c) 2000, 2001, Oracle and/or its affiliates. All rights reserved.
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

package javax.sql;

import java.sql.*;

/**
 * The facility that a disconnected <code>RowSet</code> object calls on
 * to populate itself with rows of data. A reader (an object implementing the
 * <code>RowSetReader</code> interface) may be registered with
 * a <code>RowSet</code> object that supports the reader/writer paradigm.
 * When the <code>RowSet</code> object's <code>execute</code> method is
 * called, it in turn calls the reader's <code>readData</code> method.
 *
 * @since 1.4
 */

public interface RowSetReader {

  /**
   * Reads the new contents of the calling <code>RowSet</code> object.
   * In order to call this method, a <code>RowSet</code>
   * object must have implemented the <code>RowSetInternal</code> interface
   * and registered this <code>RowSetReader</code> object as its reader.
   * The <code>readData</code>  method is invoked internally
   * by the <code>RowSet.execute</code> method for rowsets that support the
   * reader/writer paradigm.
   *
   * <P>The <code>readData</code> method adds rows to the caller.
   * It can be implemented in a wide variety of ways and can even
   * populate the caller with rows from a nonrelational data source.
   * In general, a reader may invoke any of the rowset's methods,
   * with one exception. Calling the method <code>execute</code> will
   * cause an <code>SQLException</code> to be thrown
   * because <code>execute</code> may not be called recursively.  Also,
   * when a reader invokes <code>RowSet</code> methods, no listeners
   * are notified; that is, no <code>RowSetEvent</code> objects are
   * generated and no <code>RowSetListener</code> methods are invoked.
   * This is true because listeners are already being notified by the method
   * <code>execute</code>.
   *
   * @param caller the <code>RowSet</code> object (1) that has implemented the
   *         <code>RowSetInternal</code> interface, (2) with which this reader is
   *        registered, and (3) whose <code>execute</code> method called this reader
   * @exception SQLException if a database access error occurs or this method
   *            invokes the <code>RowSet.execute</code> method
   */
  void readData(RowSetInternal caller) throws SQLException;

}
