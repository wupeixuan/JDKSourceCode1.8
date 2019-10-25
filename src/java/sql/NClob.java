/*
 * Copyright (c) 2005, 2013, Oracle and/or its affiliates. All rights reserved.
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

package java.sql;

import java.sql.Clob;

/**
 * The mapping in the Java&trade; programming language
 * for the SQL <code>NCLOB</code> type.
 * An SQL <code>NCLOB</code> is a built-in type
 * that stores a Character Large Object using the National Character Set
 *  as a column value in a row of  a database table.
 * <P>The <code>NClob</code> interface extends the <code>Clob</code> interface
 * which provides provides methods for getting the
 * length of an SQL <code>NCLOB</code> value,
 * for materializing a <code>NCLOB</code> value on the client, and for
 * searching for a substring or <code>NCLOB</code> object within a
 * <code>NCLOB</code> value. A <code>NClob</code> object, just like a <code>Clob</code> object, is valid for the duration
 * of the transaction in which it was created.
 * Methods in the interfaces {@link ResultSet},
 * {@link CallableStatement}, and {@link PreparedStatement}, such as
 * <code>getNClob</code> and <code>setNClob</code> allow a programmer to
 * access an SQL <code>NCLOB</code> value.  In addition, this interface
 * has methods for updating a <code>NCLOB</code> value.
 * <p>
 * All methods on the <code>NClob</code> interface must be fully implemented if the
 * JDBC driver supports the data type.
 *
 * @since 1.6
 */

public interface NClob extends Clob { }
