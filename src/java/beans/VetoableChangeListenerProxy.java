/*
 * Copyright (c) 2000, Oracle and/or its affiliates. All rights reserved.
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

import java.util.EventListenerProxy;

/**
 * A class which extends the {@code EventListenerProxy}
 * specifically for adding a {@code VetoableChangeListener}
 * with a "constrained" property.
 * Instances of this class can be added
 * as {@code VetoableChangeListener}s to a bean
 * which supports firing vetoable change events.
 * <p>
 * If the object has a {@code getVetoableChangeListeners} method
 * then the array returned could be a mixture of {@code VetoableChangeListener}
 * and {@code VetoableChangeListenerProxy} objects.
 *
 * @see java.util.EventListenerProxy
 * @see VetoableChangeSupport#getVetoableChangeListeners
 * @since 1.4
 */
public class VetoableChangeListenerProxy
        extends EventListenerProxy<VetoableChangeListener>
        implements VetoableChangeListener {

    private final String propertyName;

    /**
     * Constructor which binds the {@code VetoableChangeListener}
     * to a specific property.
     *
     * @param propertyName  the name of the property to listen on
     * @param listener      the listener object
     */
    public VetoableChangeListenerProxy(String propertyName, VetoableChangeListener listener) {
        super(listener);
        this.propertyName = propertyName;
    }

    /**
    * Forwards the property change event to the listener delegate.
    *
    * @param event  the property change event
    *
    * @exception PropertyVetoException if the recipient wishes the property
    *                                  change to be rolled back
    */
    public void vetoableChange(PropertyChangeEvent event) throws PropertyVetoException{
        getListener().vetoableChange(event);
    }

    /**
     * Returns the name of the named property associated with the listener.
     *
     * @return the name of the named property associated with the listener
     */
    public String getPropertyName() {
        return this.propertyName;
    }
}
