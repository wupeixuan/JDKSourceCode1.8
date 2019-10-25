/*
 * Copyright (c) 1997, 2011, Oracle and/or its affiliates. All rights reserved.
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
 * A data model for a combo box. This interface extends <code>ListDataModel</code>
 * and adds the concept of a <i>selected item</i>. The selected item is generally
 * the item which is visible in the combo box display area.
 * <p>
 * The selected item may not necessarily be managed by the underlying
 * <code>ListModel</code>. This disjoint behavior allows for the temporary
 * storage and retrieval of a selected item in the model.
 *
 * @param <E> the type of the elements of this model
 *
 * @author Arnaud Weber
 */
public interface ComboBoxModel<E> extends ListModel<E> {

  /**
   * Set the selected item. The implementation of this  method should notify
   * all registered <code>ListDataListener</code>s that the contents
   * have changed.
   *
   * @param anItem the list object to select or <code>null</code>
   *        to clear the selection
   */
  void setSelectedItem(Object anItem);

  /**
   * Returns the selected item
   * @return The selected item or <code>null</code> if there is no selection
   */
  Object getSelectedItem();
}
