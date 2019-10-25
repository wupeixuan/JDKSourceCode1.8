/*
 * Copyright (c) 1998, 2009, Oracle and/or its affiliates. All rights reserved.
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

package java.beans.beancontext;

import java.beans.beancontext.BeanContextChild;
import java.beans.beancontext.BeanContextEvent;

import java.beans.beancontext.BeanContextServices;

import java.util.Iterator;

/**
 * <p>
 * This event type is used by the BeanContextServicesListener in order to
 * identify the service being registered.
 * </p>
 */

public class BeanContextServiceAvailableEvent extends BeanContextEvent {
    private static final long serialVersionUID = -5333985775656400778L;

    /**
     * Construct a <code>BeanContextAvailableServiceEvent</code>.
     * @param bcs The context in which the service has become available
     * @param sc A <code>Class</code> reference to the newly available service
     */
    public BeanContextServiceAvailableEvent(BeanContextServices bcs, Class sc) {
        super((BeanContext)bcs);

        serviceClass = sc;
    }

    /**
     * Gets the source as a reference of type <code>BeanContextServices</code>.
     * @return The context in which the service has become available
     */
    public BeanContextServices getSourceAsBeanContextServices() {
        return (BeanContextServices)getBeanContext();
    }

    /**
     * Gets the service class that is the subject of this notification.
     * @return A <code>Class</code> reference to the newly available service
     */
    public Class getServiceClass() { return serviceClass; }

    /**
     * Gets the list of service dependent selectors.
     * @return the current selectors available from the service
     */
    public Iterator getCurrentServiceSelectors() {
        return ((BeanContextServices)getSource()).getCurrentServiceSelectors(serviceClass);
    }

    /*
     * fields
     */

    /**
     * A <code>Class</code> reference to the newly available service
     */
    protected Class                      serviceClass;
}
