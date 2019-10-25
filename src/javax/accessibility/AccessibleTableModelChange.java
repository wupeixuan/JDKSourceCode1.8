/*
 * Copyright (c) 1999, 2013, Oracle and/or its affiliates. All rights reserved.
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

package javax.accessibility;

/**
 * The AccessibleTableModelChange interface describes a change to
 * the table model.  The attributes of the model change can be
 * obtained by the following methods:
 * <ul>
 * <li> public int getType()
 * <li> public int getFirstRow();
 * <li> public int getLastRow();
 * <li> public int getFirstColumn();
 * <li> public int getLastColumn();
 * </ul>
 * The model change type returned by getType() will be one of:
 * <ul>
 * <li> INSERT - one or more rows and/or columns have been inserted
 * <li> UPDATE - some of the table data has changed
 * <li> DELETE - one or more rows and/or columns have been deleted
 * </ul>
 * The affected area of the table can be determined by the other
 * four methods which specify ranges of rows and columns
 *
 * @see Accessible
 * @see Accessible#getAccessibleContext
 * @see AccessibleContext
 * @see AccessibleContext#getAccessibleTable
 *
 * @author      Lynn Monsanto
 * @since 1.3
 */
public interface AccessibleTableModelChange {

    /**
     * Identifies the insertion of new rows and/or columns.
     */
    public static final int INSERT =  1;

    /**
     * Identifies a change to existing data.
     */
    public static final int UPDATE =  0;

    /**
     * Identifies the deletion of rows and/or columns.
     */
    public static final int DELETE = -1;

    /**
     *  Returns the type of event.
     *  @return the type of event
     *  @see #INSERT
     *  @see #UPDATE
     *  @see #DELETE
     */
    public int getType();

    /**
     * Returns the first row that changed.
     * @return the first row that changed
     */
    public int getFirstRow();

    /**
     * Returns the last row that changed.
     * @return the last row that changed
     */
    public int getLastRow();

    /**
     * Returns the first column that changed.
     * @return the first column that changed
     */
    public int getFirstColumn();

    /**
     * Returns the last column that changed.
     * @return the last column that changed
     */
    public int getLastColumn();
}
