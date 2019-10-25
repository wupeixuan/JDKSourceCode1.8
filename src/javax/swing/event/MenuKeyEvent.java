/*
 * Copyright (c) 1998, 2013, Oracle and/or its affiliates. All rights reserved.
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
package javax.swing.event;

import javax.swing.MenuElement;
import javax.swing.MenuSelectionManager;
import java.util.EventObject;
import java.awt.event.KeyEvent;
import java.awt.Component;


/**
 * MenuKeyEvent is used to notify interested parties that
 * the menu element has received a KeyEvent forwarded to it
 * in a menu tree.
 * <p>
 * <strong>Warning:</strong>
 * Serialized objects of this class will not be compatible with
 * future Swing releases. The current serialization support is
 * appropriate for short term storage or RMI between applications running
 * the same version of Swing.  As of 1.4, support for long term storage
 * of all JavaBeans&trade;
 * has been added to the <code>java.beans</code> package.
 * Please see {@link java.beans.XMLEncoder}.
 *
 * @author Georges Saab
 */
@SuppressWarnings("serial")
public class MenuKeyEvent extends KeyEvent {
    private MenuElement path[];
    private MenuSelectionManager manager;

    /**
     * Constructs a MenuKeyEvent object.
     *
     * @param source     the Component that originated the event
     *                     (typically <code>this</code>)
     * @param id         an int specifying the type of event, as defined
     *                     in {@link java.awt.event.KeyEvent}
     * @param when       a long identifying the time the event occurred
     * @param modifiers     an int specifying any modifier keys held down,
     *                      as specified in {@link java.awt.event.InputEvent}
     * @param keyCode    an int specifying the specific key that was pressed
     * @param keyChar    a char specifying the key's character value, if any
     *                   -- null if the key has no character value
     * @param p          an array of MenuElement objects specifying a path
     *                     to a menu item affected by the drag
     * @param m          a MenuSelectionManager object that handles selections
     */
    public MenuKeyEvent(Component source, int id, long when, int modifiers,
                        int keyCode, char keyChar,
                        MenuElement p[], MenuSelectionManager m) {
        super(source, id, when, modifiers, keyCode, keyChar);
        path = p;
        manager = m;
    }

    /**
     * Returns the path to the menu item referenced by this event.
     *
     * @return an array of MenuElement objects representing the path value
     */
    public MenuElement[] getPath() {
        return path;
    }

    /**
     * Returns the current menu selection manager.
     *
     * @return a MenuSelectionManager object
     */
    public MenuSelectionManager getMenuSelectionManager() {
        return manager;
    }
}
