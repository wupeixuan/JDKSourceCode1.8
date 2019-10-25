/*
 * Copyright (c) 1998, 2011, Oracle and/or its affiliates. All rights reserved.
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
 * A mutable version of <code>ComboBoxModel</code>.
 *
 * @param <E> the type of the elements of this model
 *
 * @author Tom Santos
 */

public interface MutableComboBoxModel<E> extends ComboBoxModel<E> {

    /**
     * Adds an item at the end of the model. The implementation of this method
     * should notify all registered <code>ListDataListener</code>s that the
     * item has been added.
     *
     * @param item the item to be added
     */
    public void addElement( E item );

    /**
     * Removes an item from the model. The implementation of this method should
     * should notify all registered <code>ListDataListener</code>s that the
     * item has been removed.
     *
     * @param obj the <code>Object</code> to be removed
     */
    public void removeElement( Object obj );

    /**
     * Adds an item at a specific index.  The implementation of this method
     * should notify all registered <code>ListDataListener</code>s that the
     * item has been added.
     *
     * @param item  the item to be added
     * @param index  location to add the object
     */
    public void insertElementAt( E item, int index );

    /**
     * Removes an item at a specific index. The implementation of this method
     * should notify all registered <code>ListDataListener</code>s that the
     * item has been removed.
     *
     * @param index  location of the item to be removed
     */
    public void removeElementAt( int index );
}
