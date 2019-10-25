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
package javax.swing.table;

/**
 * TableStringConverter is used to convert objects from the model into
 * strings.  This is useful in filtering and searching when the model returns
 * objects that do not have meaningful <code>toString</code> implementations.
 *
 * @since 1.6
 */
public abstract class TableStringConverter {
    /**
     * Returns the string representation of the value at the specified
     * location.
     *
     * @param model the <code>TableModel</code> to fetch the value from
     * @param row the row the string is being requested for
     * @param column the column the string is being requested for
     * @return the string representation.  This should never return null.
     * @throws NullPointerException if <code>model</code> is null
     * @throws IndexOutOfBoundsException if the arguments are outside the
     *         bounds of the model
     */
    public abstract String toString(TableModel model, int row, int column);
}
