/*
 * Copyright (c) 2000, 2010, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.corba.se.impl.orbutil;

import java.util.ResourceBundle;
import java.util.MissingResourceException;

public class CorbaResourceUtil {
    public static String getString(String key) {
        if (!resourcesInitialized) {
            initResources();
        }

        try {
            return resources.getString(key);
        } catch (MissingResourceException ignore) {
        }
        return null;
    }

    public static String getText(String key) {
        String message = getString(key);
        if (message == null) {
            message = "no text found: \"" + key + "\"";
        }
        return message;
    }

    public static String getText(String key, int num) {
        return getText(key, Integer.toString(num), null, null);
    }

    public static String getText(String key, String arg0) {
        return getText(key, arg0, null, null);
    }

    public static String getText(String key, String arg0, String arg1) {
        return getText(key, arg0, arg1, null);
    }

    public static String getText(String key,
                                 String arg0, String arg1, String arg2)
    {
        String format = getString(key);
        if (format == null) {
            format = "no text found: key = \"" + key + "\", " +
                "arguments = \"{0}\", \"{1}\", \"{2}\"";
        }

        String[] args = new String[3];
        args[0] = (arg0 != null ? arg0.toString() : "null");
        args[1] = (arg1 != null ? arg1.toString() : "null");
        args[2] = (arg2 != null ? arg2.toString() : "null");

        return java.text.MessageFormat.format(format, (Object[]) args);
    }

    private static boolean resourcesInitialized = false;
    private static ResourceBundle resources;

    private static void initResources() {
        try {
            resources =
                ResourceBundle.getBundle("com.sun.corba.se.impl.orbutil.resources.sunorb");
            resourcesInitialized = true;
        } catch (MissingResourceException e) {
            throw new Error("fatal: missing resource bundle: " +
                            e.getClassName());
        }
    }

}
