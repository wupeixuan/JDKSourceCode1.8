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

import java.util.EventObject;


/**
 * ChangeEvent is used to notify interested parties that
 * state has changed in the event source.
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
 * @author Jeff Dinkins
 */
@SuppressWarnings("serial")
public class ChangeEvent extends EventObject {
    /**
     * Constructs a ChangeEvent object.
     *
     * @param source  the Object that is the source of the event
     *                (typically <code>this</code>)
     */
    public ChangeEvent(Object source) {
        super(source);
    }
}
