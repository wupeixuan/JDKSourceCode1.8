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

package com.sun.org.apache.xerces.internal.util;

import java.util.Enumeration;
import java.util.Vector;
import javax.xml.namespace.NamespaceContext;

/**
 * Writing a wrapper to re-use most of the namespace functionality
 * already provided by NamespaceSupport, which implements NamespaceContext
 * from XNI. It would be good if we can change the XNI NamespaceContext
 * interface to implement the JAXP NamespaceContext interface.
 *
 * Note that NamespaceSupport assumes the use of symbols. Since this class
 * can be exposed to the application, we must intern all Strings before
 * calling NamespaceSupport methods.
 *
 * @author  Neeraj Bajaj, Sun Microsystems, inc.
 * @author Santiago.PericasGeertsen@sun.com
 *
 */
public class NamespaceContextWrapper implements NamespaceContext {

    private com.sun.org.apache.xerces.internal.xni.NamespaceContext fNamespaceContext;

    public NamespaceContextWrapper(NamespaceSupport namespaceContext) {
        fNamespaceContext = namespaceContext ;
    }

    public String getNamespaceURI(String prefix) {
        if (prefix == null) {
            throw new IllegalArgumentException("Prefix can't be null");
        }
        return fNamespaceContext.getURI(prefix.intern());
    }

    public String getPrefix(String namespaceURI) {
        if (namespaceURI == null) {
            throw new IllegalArgumentException("URI can't be null.");
        }
        return fNamespaceContext.getPrefix(namespaceURI.intern());
    }

    /**
     * TODO: Namespace doesn't give information giving multiple prefixes for
     * the same namespaceURI.
     */
    public java.util.Iterator getPrefixes(String namespaceURI) {
        if (namespaceURI == null) {
            throw new IllegalArgumentException("URI can't be null.");
        }
        else {
            Vector vector =
                ((NamespaceSupport) fNamespaceContext).getPrefixes(namespaceURI.intern());
            return vector.iterator();
        }
    }

    /**
     * This method supports all functions in the NamespaceContext utility class
     */
    public com.sun.org.apache.xerces.internal.xni.NamespaceContext getNamespaceContext() {
        return fNamespaceContext;
    }

}
