/*
 * Copyright (c) 1996, 2009, Oracle and/or its affiliates. All rights reserved.
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

package java.beans;


/**
 * A PropertyVetoException is thrown when a proposed change to a
 * property represents an unacceptable value.
 */

public
class PropertyVetoException extends Exception {
    private static final long serialVersionUID = 129596057694162164L;

    /**
     * Constructs a <code>PropertyVetoException</code> with a
     * detailed message.
     *
     * @param mess Descriptive message
     * @param evt A PropertyChangeEvent describing the vetoed change.
     */
    public PropertyVetoException(String mess, PropertyChangeEvent evt) {
        super(mess);
        this.evt = evt;
    }

     /**
     * Gets the vetoed <code>PropertyChangeEvent</code>.
     *
     * @return A PropertyChangeEvent describing the vetoed change.
     */
    public PropertyChangeEvent getPropertyChangeEvent() {
        return evt;
    }

    /**
     * A PropertyChangeEvent describing the vetoed change.
     * @serial
     */
    private PropertyChangeEvent evt;
}
