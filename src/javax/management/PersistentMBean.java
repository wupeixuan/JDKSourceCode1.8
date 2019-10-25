/*
 * Copyright (c) 2000, 2013, Oracle and/or its affiliates. All rights reserved.
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
/*
 * @author    IBM Corp.
 *
 * Copyright IBM Corp. 1999-2000.  All rights reserved.
 */

package javax.management;

import javax.management.MBeanException;
import javax.management.RuntimeOperationsException;
import javax.management.InstanceNotFoundException;

/**
 *  This class is the interface to be implemented by MBeans that are meant to be
 *  persistent.  MBeans supporting this interface should call the load method during
 *  construction in order to prime the MBean from the persistent store.
 *  In the case of a ModelMBean, the store method should be called by the MBeanServer based on the descriptors in
 *  the ModelMBean or by the MBean itself during normal processing of the ModelMBean.
 *
 * @since 1.5
 */
public interface PersistentMBean {


    /**
     * Instantiates thisMBean instance with the data found for
     * the MBean in the persistent store.  The data loaded could include
     * attribute and operation values.
     *
     * This method should be called during construction or initialization of this instance,
     * and before the MBean is registered with the MBeanServer.
     *
     * @exception MBeanException Wraps another exception or persistence is not supported
     * @exception RuntimeOperationsException Wraps exceptions from the persistence mechanism
     * @exception InstanceNotFoundException Could not find or load this MBean from persistent
     *                                      storage
     */
    public void load()
    throws MBeanException, RuntimeOperationsException, InstanceNotFoundException;

    /**
     * Captures the current state of this MBean instance and
     * writes it out to the persistent store.  The state stored could include
     * attribute and operation values. If one of these methods of persistence is
     * not supported a "serviceNotFound" exception will be thrown.
     * <P>
     * Persistence policy from the MBean and attribute descriptor is used to guide execution
     * of this method. The MBean should be stored if 'persistPolicy' field is:
     * <PRE>{@literal  != "never"
     *   = "always"
     *   = "onTimer" and now > 'lastPersistTime' + 'persistPeriod'
     *   = "NoMoreOftenThan" and now > 'lastPersistTime' + 'persistPeriod'
     *   = "onUnregister"
     * }</PRE>
     * <p>
     * Do not store the MBean if 'persistPolicy' field is:
     * <PRE>{@literal
     *    = "never"
     *    = "onUpdate"
     *    = "onTimer" && now < 'lastPersistTime' + 'persistPeriod'
     * }</PRE>
     *
     * @exception MBeanException Wraps another exception or persistence is not supported
     * @exception RuntimeOperationsException Wraps exceptions from the persistence mechanism
     * @exception InstanceNotFoundException Could not find/access the persistent store
     */
    public void store()
    throws MBeanException, RuntimeOperationsException, InstanceNotFoundException;

}
