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

import java.beans.beancontext.BeanContextEvent;

import java.beans.beancontext.BeanContextServices;

/**
 * <p>
 * This event type is used by the
 * <code>BeanContextServiceRevokedListener</code> in order to
 * identify the service being revoked.
 * </p>
 */
public class BeanContextServiceRevokedEvent extends BeanContextEvent {
    private static final long serialVersionUID = -1295543154724961754L;

    /**
     * Construct a <code>BeanContextServiceEvent</code>.
     * @param bcs the <code>BeanContextServices</code>
     * from which this service is being revoked
     * @param sc the service that is being revoked
     * @param invalidate <code>true</code> for immediate revocation
     */
    public BeanContextServiceRevokedEvent(BeanContextServices bcs, Class sc, boolean invalidate) {
        super((BeanContext)bcs);

        serviceClass    = sc;
        invalidateRefs  = invalidate;
    }

    /**
     * Gets the source as a reference of type <code>BeanContextServices</code>
     * @return the <code>BeanContextServices</code> from which
     * this service is being revoked
     */
    public BeanContextServices getSourceAsBeanContextServices() {
        return (BeanContextServices)getBeanContext();
    }

    /**
     * Gets the service class that is the subject of this notification
     * @return A <code>Class</code> reference to the
     * service that is being revoked
     */
    public Class getServiceClass() { return serviceClass; }

    /**
     * Checks this event to determine whether or not
     * the service being revoked is of a particular class.
     * @param service the service of interest (should be non-null)
     * @return <code>true</code> if the service being revoked is of the
     * same class as the specified service
     */
    public boolean isServiceClass(Class service) {
        return serviceClass.equals(service);
    }

    /**
     * Reports if the current service is being forcibly revoked,
     * in which case the references are now invalidated and unusable.
     * @return <code>true</code> if current service is being forcibly revoked
     */
    public boolean isCurrentServiceInvalidNow() { return invalidateRefs; }

    /**
     * fields
     */

    /**
     * A <code>Class</code> reference to the service that is being revoked.
     */
    protected Class                      serviceClass;
    private   boolean                    invalidateRefs;
}
