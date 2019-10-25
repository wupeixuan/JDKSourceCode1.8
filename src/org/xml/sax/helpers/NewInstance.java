/*
 * Copyright (c) 2001, 2013, Oracle and/or its affiliates. All rights reserved.
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

// NewInstance.java - create a new instance of a class by name.
// http://www.saxproject.org
// Written by Edwin Goei, edwingo@apache.org
// and by David Brownell, dbrownell@users.sourceforge.net
// NO WARRANTY!  This class is in the Public Domain.
// $Id: NewInstance.java,v 1.2 2005/06/10 03:50:50 jeffsuttor Exp $

package org.xml.sax.helpers;

import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;

/**
 * Create a new instance of a class by name.
 *
 * <blockquote>
 * <em>This module, both source code and documentation, is in the
 * Public Domain, and comes with <strong>NO WARRANTY</strong>.</em>
 * See <a href='http://www.saxproject.org'>http://www.saxproject.org</a>
 * for further information.
 * </blockquote>
 *
 * <p>This class contains a static method for creating an instance of a
 * class from an explicit class name.  It tries to use the thread's context
 * ClassLoader if possible and falls back to using
 * Class.forName(String).</p>
 *
 * <p>This code is designed to compile and run on JDK version 1.1 and later
 * including versions of Java 2.</p>
 *
 * @author Edwin Goei, David Brownell
 * @version 2.0.1 (sax2r2)
 */
class NewInstance {
    private static final String DEFAULT_PACKAGE = "com.sun.org.apache.xerces.internal";
    /**
     * Creates a new instance of the specified class name
     *
     * Package private so this code is not exposed at the API level.
     */
    static Object newInstance (ClassLoader classLoader, String className)
        throws ClassNotFoundException, IllegalAccessException,
            InstantiationException
    {
        // make sure we have access to restricted packages
        boolean internal = false;
        if (System.getSecurityManager() != null) {
            if (className != null && className.startsWith(DEFAULT_PACKAGE)) {
                internal = true;
            }
        }

        Class driverClass;
        if (classLoader == null || internal) {
            driverClass = Class.forName(className);
        } else {
            driverClass = classLoader.loadClass(className);
        }
        return driverClass.newInstance();
    }

}
