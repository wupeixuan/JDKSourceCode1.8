/*
 * Copyright (c) 2000, 2006, Oracle and/or its affiliates. All rights reserved.
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

import java.sql.SQLException;

/**
 * <P>An <code>Event</code> object that provides information about the
 * source of a connection-related event.  <code>ConnectionEvent</code>
 * objects are generated when an application closes a pooled connection
 * and when an error occurs.  The <code>ConnectionEvent</code> object
 * contains two kinds of information:
 * <UL>
 *   <LI>The pooled connection closed by the application
 *   <LI>In the case of an error event, the <code>SQLException</code>
 *       about to be thrown to the application
 * </UL>
 *
 * @since 1.4
 */

public class ConnectionEvent extends java.util.EventObject {

  /**
   * <P>Constructs a <code>ConnectionEvent</code> object initialized with
   * the given <code>PooledConnection</code> object. <code>SQLException</code>
   * defaults to <code>null</code>.
   *
   * @param con the pooled connection that is the source of the event
   * @throws IllegalArgumentException if <code>con</code> is null.
   */
  public ConnectionEvent(PooledConnection con) {
    super(con);
  }

  /**
   * <P>Constructs a <code>ConnectionEvent</code> object initialized with
   * the given <code>PooledConnection</code> object and
   * <code>SQLException</code> object.
   *
   * @param con the pooled connection that is the source of the event
   * @param ex the SQLException about to be thrown to the application
   * @throws IllegalArgumentException if <code>con</code> is null.
   */
  public ConnectionEvent(PooledConnection con, SQLException ex) {
    super(con);
    this.ex = ex;
  }

  /**
   * <P>Retrieves the <code>SQLException</code> for this
   * <code>ConnectionEvent</code> object. May be <code>null</code>.
   *
   * @return the SQLException about to be thrown or <code>null</code>
   */
  public SQLException getSQLException() { return ex; }

  /**
   * The <code>SQLException</code> that the driver will throw to the
   * application when an error occurs and the pooled connection is no
   * longer usable.
   * @serial
   */
  private SQLException ex = null;

  /**
   * Private serial version unique ID to ensure serialization
   * compatibility.
   */
  static final long serialVersionUID = -4843217645290030002L;

 }
