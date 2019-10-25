/*
 * Copyright (c) 1997, 2013, Oracle and/or its affiliates. All rights reserved.
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

import javax.swing.undo.*;

/**
 * An event indicating that an operation which can be undone has occurred.
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
 * @author Ray Ryan
 */
public class UndoableEditEvent extends java.util.EventObject {
    private UndoableEdit myEdit;

    /**
     * Constructs an UndoableEditEvent object.
     *
     * @param source  the Object that originated the event
     *                (typically <code>this</code>)
     * @param edit    an UndoableEdit object
     */
    public UndoableEditEvent(Object source, UndoableEdit edit) {
        super(source);
        myEdit = edit;
    }

    /**
     * Returns the edit value.
     *
     * @return the UndoableEdit object encapsulating the edit
     */
    public UndoableEdit getEdit() {
        return myEdit;
    }
}
