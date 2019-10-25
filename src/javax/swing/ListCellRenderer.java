/*
 * Copyright (c) 1997, 2005, Oracle and/or its affiliates. All rights reserved.
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

import java.awt.Component;


/**
 * Identifies components that can be used as "rubber stamps" to paint
 * the cells in a JList.  For example, to use a JLabel as a
 * ListCellRenderer, you would write something like this:
 * <pre>
 * {@code
 * class MyCellRenderer extends JLabel implements ListCellRenderer<Object> {
 *     public MyCellRenderer() {
 *         setOpaque(true);
 *     }
 *
 *     public Component getListCellRendererComponent(JList<?> list,
 *                                                   Object value,
 *                                                   int index,
 *                                                   boolean isSelected,
 *                                                   boolean cellHasFocus) {
 *
 *         setText(value.toString());
 *
 *         Color background;
 *         Color foreground;
 *
 *         // check if this cell represents the current DnD drop location
 *         JList.DropLocation dropLocation = list.getDropLocation();
 *         if (dropLocation != null
 *                 && !dropLocation.isInsert()
 *                 && dropLocation.getIndex() == index) {
 *
 *             background = Color.BLUE;
 *             foreground = Color.WHITE;
 *
 *         // check if this cell is selected
 *         } else if (isSelected) {
 *             background = Color.RED;
 *             foreground = Color.WHITE;
 *
 *         // unselected, and not the DnD drop location
 *         } else {
 *             background = Color.WHITE;
 *             foreground = Color.BLACK;
 *         };
 *
 *         setBackground(background);
 *         setForeground(foreground);
 *
 *         return this;
 *     }
 * }
 * }
 * </pre>
 *
 * @param <E> the type of values this renderer can be used for
 *
 * @see JList
 * @see DefaultListCellRenderer
 *
 * @author Hans Muller
 */
public interface ListCellRenderer<E>
{
    /**
     * Return a component that has been configured to display the specified
     * value. That component's <code>paint</code> method is then called to
     * "render" the cell.  If it is necessary to compute the dimensions
     * of a list because the list cells do not have a fixed size, this method
     * is called to generate a component on which <code>getPreferredSize</code>
     * can be invoked.
     *
     * @param list The JList we're painting.
     * @param value The value returned by list.getModel().getElementAt(index).
     * @param index The cells index.
     * @param isSelected True if the specified cell was selected.
     * @param cellHasFocus True if the specified cell has the focus.
     * @return A component whose paint() method will render the specified value.
     *
     * @see JList
     * @see ListSelectionModel
     * @see ListModel
     */
    Component getListCellRendererComponent(
        JList<? extends E> list,
        E value,
        int index,
        boolean isSelected,
        boolean cellHasFocus);
}
