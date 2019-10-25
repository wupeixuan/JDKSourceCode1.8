/*
 * Copyright (c) 1995, 2007, Oracle and/or its affiliates. All rights reserved.
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
package java.awt.peer;

import java.awt.Choice;

/**
 * The peer interface for {@link Choice}.
 *
 * The peer interfaces are intended only for use in porting
 * the AWT. They are not intended for use by application
 * developers, and developers should not implement peers
 * nor invoke any of the peer methods directly on the peer
 * instances.
 */
public interface ChoicePeer extends ComponentPeer {

    /**
     * Adds an item with the string {@code item} to the combo box list
     * at index {@code index}.
     *
     * @param item the label to be added to the list
     * @param index the index where to add the item
     *
     * @see Choice#add(String)
     */
    void add(String item, int index);

    /**
     * Removes the item at index {@code index} from the combo box list.
     *
     * @param index the index where to remove the item
     *
     * @see Choice#remove(int)
     */
    void remove(int index);

    /**
     * Removes all items from the combo box list.
     *
     * @see Choice#removeAll()
     */
    void removeAll();

    /**
     * Selects the item at index {@code index}.
     *
     * @param index the index which should be selected
     *
     * @see Choice#select(int)
     */
    void select(int index);

}
