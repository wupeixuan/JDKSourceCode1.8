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
package javax.swing;

/**
 * Drop modes, used to determine the method by which a component
 * tracks and indicates a drop location during drag and drop.
 *
 * @author Shannon Hickey
 * @see JTable#setDropMode
 * @see JList#setDropMode
 * @see JTree#setDropMode
 * @see javax.swing.text.JTextComponent#setDropMode
 * @since 1.6
 */
public enum DropMode {

    /**
     * A component's own internal selection mechanism (or caret for text
     * components) should be used to track the drop location.
     */
    USE_SELECTION,

    /**
     * The drop location should be tracked in terms of the index of
     * existing items. Useful for dropping on items in tables, lists,
     * and trees.
     */
    ON,

    /**
     * The drop location should be tracked in terms of the position
     * where new data should be inserted. For components that manage
     * a list of items (list and tree for example), the drop location
     * should indicate the index where new data should be inserted.
     * For text components the location should represent a position
     * between characters. For components that manage tabular data
     * (table for example), the drop location should indicate
     * where to insert new rows, columns, or both, to accommodate
     * the dropped data.
     */
    INSERT,

    /**
     * The drop location should be tracked in terms of the row index
     * where new rows should be inserted to accommodate the dropped
     * data. This is useful for components that manage tabular data.
     */
    INSERT_ROWS,

    /**
     * The drop location should be tracked in terms of the column index
     * where new columns should be inserted to accommodate the dropped
     * data. This is useful for components that manage tabular data.
     */
    INSERT_COLS,

    /**
     * This mode is a combination of <code>ON</code>
     * and <code>INSERT</code>, specifying that data can be
     * dropped on existing items, or in insert locations
     * as specified by <code>INSERT</code>.
     */
    ON_OR_INSERT,

    /**
     * This mode is a combination of <code>ON</code>
     * and <code>INSERT_ROWS</code>, specifying that data can be
     * dropped on existing items, or as insert rows
     * as specified by <code>INSERT_ROWS</code>.
     */
    ON_OR_INSERT_ROWS,

    /**
     * This mode is a combination of <code>ON</code>
     * and <code>INSERT_COLS</code>, specifying that data can be
     * dropped on existing items, or as insert columns
     * as specified by <code>INSERT_COLS</code>.
     */
    ON_OR_INSERT_COLS
}
