/*
 * Copyright (c) 2005, 2006, Oracle and/or its affiliates. All rights reserved.
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

package javax.xml.validation;

import java.io.IOException;
import java.net.URL;
import java.security.*;
import java.net.*;
import java.io.*;
import java.util.*;

/**
 * This class is duplicated for each JAXP subpackage so keep it in sync.
 * It is package private and therefore is not exposed as part of the JAXP
 * API.
 *
 * Security related methods that only work on J2SE 1.2 and newer.
 */
class SecuritySupport  {


    ClassLoader getContextClassLoader() {
        return (ClassLoader)
        AccessController.doPrivileged(new PrivilegedAction() {
            public Object run() {
                ClassLoader cl = null;
                //try {
                cl = Thread.currentThread().getContextClassLoader();
                //} catch (SecurityException ex) { }
                if (cl == null)
                    cl = ClassLoader.getSystemClassLoader();
                return cl;
            }
        });
    }

    String getSystemProperty(final String propName) {
        return (String)
            AccessController.doPrivileged(new PrivilegedAction() {
                public Object run() {
                    return System.getProperty(propName);
                }
            });
    }

    FileInputStream getFileInputStream(final File file)
        throws FileNotFoundException
    {
        try {
            return (FileInputStream)
                AccessController.doPrivileged(new PrivilegedExceptionAction() {
                    public Object run() throws FileNotFoundException {
                        return new FileInputStream(file);
                    }
                });
        } catch (PrivilegedActionException e) {
            throw (FileNotFoundException)e.getException();
        }
    }

    InputStream getURLInputStream(final URL url)
        throws IOException
    {
        try {
            return (InputStream)
                AccessController.doPrivileged(new PrivilegedExceptionAction() {
                    public Object run() throws IOException {
                        return url.openStream();
                    }
                });
        } catch (PrivilegedActionException e) {
            throw (IOException)e.getException();
        }
    }

    URL getResourceAsURL(final ClassLoader cl,
                                           final String name)
    {
        return (URL)
            AccessController.doPrivileged(new PrivilegedAction() {
                public Object run() {
                    URL url;
                    if (cl == null) {
                        url = Object.class.getResource(name);
                    } else {
                        url = cl.getResource(name);
                    }
                    return url;
                }
            });
    }

    Enumeration getResources(final ClassLoader cl,
                                           final String name) throws IOException
    {
        try{
        return (Enumeration)
            AccessController.doPrivileged(new PrivilegedExceptionAction() {
                public Object run() throws IOException{
                    Enumeration enumeration;
                    if (cl == null) {
                        enumeration = ClassLoader.getSystemResources(name);
                    } else {
                        enumeration = cl.getResources(name);
                    }
                    return enumeration;
                }
            });
        }catch(PrivilegedActionException e){
            throw (IOException)e.getException();
        }
    }

    InputStream getResourceAsStream(final ClassLoader cl,
                                           final String name)
    {
        return (InputStream)
            AccessController.doPrivileged(new PrivilegedAction() {
                public Object run() {
                    InputStream ris;
                    if (cl == null) {
                        ris = Object.class.getResourceAsStream(name);
                    } else {
                        ris = cl.getResourceAsStream(name);
                    }
                    return ris;
                }
            });
    }

    boolean doesFileExist(final File f) {
    return ((Boolean)
            AccessController.doPrivileged(new PrivilegedAction() {
                public Object run() {
                    return new Boolean(f.exists());
                }
            })).booleanValue();
    }

}
