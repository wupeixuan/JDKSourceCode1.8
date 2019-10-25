/*
 * Copyright (c) 2002, 2007, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.jmx.mbeanserver;


// JMX import
import javax.management.ObjectName;
import javax.management.loading.ClassLoaderRepository;

/**
 * This interface keeps the list of Class Loaders registered in the
 * MBean Server.
 * It provides the necessary methods to load classes using the
 * registered Class Loaders, and to add/remove class loaders from the
 * list.
 *
 * @since 1.5
 */
public interface ModifiableClassLoaderRepository
    extends ClassLoaderRepository {

    /**
     * Add an anonymous ClassLoader to the repository.
     **/
    public void addClassLoader(ClassLoader loader);

    /**
     * Remove the specified ClassLoader to the repository.
     * The class loader may or may not be anonymous.
     **/
    public void removeClassLoader(ClassLoader loader);

    /**
     * Add a named ClassLoader to the repository.
     **/
    public void addClassLoader(ObjectName name, ClassLoader loader);

    /**
     * Remove a named ClassLoader from the repository.
     **/
    public void removeClassLoader(ObjectName name);

    /**
     * Get a named ClassLoader from the repository.
     **/
    public ClassLoader getClassLoader(ObjectName name);
}
