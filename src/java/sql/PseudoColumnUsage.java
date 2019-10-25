/*
 * Copyright (c) 2010, Oracle and/or its affiliates. All rights reserved.
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


/**
 * Enumeration for pseudo/hidden column usage.
 *
 * @since 1.7
 * @see DatabaseMetaData#getPseudoColumns
 */
public enum PseudoColumnUsage {

    /**
     * The pseudo/hidden column may only be used in a SELECT list.
     */
    SELECT_LIST_ONLY,

    /**
     * The pseudo/hidden column may only be used in a WHERE clause.
     */
    WHERE_CLAUSE_ONLY,

    /**
     * There are no restrictions on the usage of the pseudo/hidden columns.
     */
    NO_USAGE_RESTRICTIONS,

    /**
     * The usage of the pseudo/hidden column cannot be determined.
     */
    USAGE_UNKNOWN

}
