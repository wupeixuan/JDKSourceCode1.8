/*
 * Copyright (c) 2003, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.imageio.plugins.common;

import java.io.InputStream;
import java.util.PropertyResourceBundle;
import java.net.URL;

/**
 * Class to simplify use of internationalization message strings.
 * Property files are constructed in terms of content as for JAI with
 * one "key=value" pair per line. All such files however have the same
 * name "properties". The resource extractor resolves the extraction of
 * the file from the jar as the package name is included automatically.
 *
 * <p>Extenders need only provide a static method
 * <code>getString(String)</code> which calls the static method in this
 * class with the name of the invoking class and returns a
 * <code>String</code>.
 */
public class I18NImpl {
    /**
     * Returns the message string with the specified key from the
     * "properties" file in the package containing the class with
     * the specified name.
     */
    protected static final String getString(String className, String resource_name, String key) {
        PropertyResourceBundle bundle = null;
        try {
            InputStream stream =
                Class.forName(className).getResourceAsStream(resource_name);
            bundle = new PropertyResourceBundle(stream);
        } catch(Throwable e) {
            throw new RuntimeException(e); // Chain the exception.
        }

        return (String)bundle.handleGetObject(key);
    }
}
