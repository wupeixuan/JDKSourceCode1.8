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

/*
 * Created on Apr 28, 2005
 */
package javax.sql;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.EventObject;

/**
 * A <code>StatementEvent</code> is sent to all <code>StatementEventListener</code>s which were
 * registered with a <code>PooledConnection</code>. This occurs when the driver determines that a
 * <code>PreparedStatement</code> that is associated with the <code>PooledConnection</code> has been closed or the driver determines
 * is invalid.
 * <p>
 * @since 1.6
 */
public class StatementEvent extends EventObject {

        static final long serialVersionUID = -8089573731826608315L;
        private SQLException            exception;
        private PreparedStatement       statement;

        /**
         * Constructs a <code>StatementEvent</code> with the specified <code>PooledConnection</code> and
         * <code>PreparedStatement</code>.  The <code>SQLException</code> contained in the event defaults to
         * null.
         * <p>
         * @param con                   The <code>PooledConnection</code> that the closed or invalid
         * <code>PreparedStatement</code>is associated with.
         * @param statement             The <code>PreparedStatement</code> that is being closed or is invalid
         * <p>
         * @throws IllegalArgumentException if <code>con</code> is null.
         *
         * @since 1.6
         */
        public StatementEvent(PooledConnection con,
                                                  PreparedStatement statement) {

                super(con);

                this.statement = statement;
                this.exception = null;
        }

        /**
         * Constructs a <code>StatementEvent</code> with the specified <code>PooledConnection</code>,
         * <code>PreparedStatement</code> and <code>SQLException</code>
         * <p>
         * @param con                   The <code>PooledConnection</code> that the closed or invalid <code>PreparedStatement</code>
         * is associated with.
         * @param statement             The <code>PreparedStatement</code> that is being closed or is invalid
         * @param exception             The <code>SQLException </code>the driver is about to throw to
         *                                              the application
         *
         * @throws IllegalArgumentException if <code>con</code> is null.
         * <p>
         * @since 1.6
         */
        public StatementEvent(PooledConnection con,
                                                  PreparedStatement statement,
                                                  SQLException exception) {

                super(con);

                this.statement = statement;
                this.exception = exception;
        }

        /**
         * Returns the <code>PreparedStatement</code> that is being closed or is invalid
         * <p>
         * @return      The <code>PreparedStatement</code> that is being closed or is invalid
         * <p>
         * @since 1.6
         */
        public PreparedStatement getStatement() {

                return this.statement;
        }

        /**
         * Returns the <code>SQLException</code> the driver is about to throw
         * <p>
         * @return      The <code>SQLException</code> the driver is about to throw
         * <p>
         * @since 1.6
         */
        public SQLException getSQLException() {

                return this.exception;
        }
}
