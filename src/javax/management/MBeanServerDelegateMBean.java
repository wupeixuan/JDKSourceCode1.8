/*
 * Copyright (c) 1999, 2003, Oracle and/or its affiliates. All rights reserved.
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

package javax.management;


/**
 * Defines the management interface  of an object of class MBeanServerDelegate.
 *
 * @since 1.5
 */
public interface MBeanServerDelegateMBean   {

    /**
     * Returns the MBean server agent identity.
     *
     * @return the agent identity.
     */
    public String getMBeanServerId();

    /**
     * Returns the full name of the JMX specification implemented
     * by this product.
     *
     * @return the specification name.
     */
    public String getSpecificationName();

    /**
     * Returns the version of the JMX specification implemented
     * by this product.
     *
     * @return the specification version.
     */
    public String getSpecificationVersion();

    /**
     * Returns the vendor of the JMX specification implemented
     * by this product.
     *
     * @return the specification vendor.
     */
    public String getSpecificationVendor();

    /**
     * Returns the JMX implementation name (the name of this product).
     *
     * @return the implementation name.
     */
    public String getImplementationName();

    /**
     * Returns the JMX implementation version (the version of this product).
     *
     * @return the implementation version.
     */
    public String getImplementationVersion();

    /**
     * Returns the JMX implementation vendor (the vendor of this product).
     *
     * @return the implementation vendor.
     */
    public String getImplementationVendor();

}
