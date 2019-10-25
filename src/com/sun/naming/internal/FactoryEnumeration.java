/*
 * Copyright (c) 1999, 2011, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.naming.internal;

import java.util.List;
import javax.naming.NamingException;

/**
  * The FactoryEnumeration is used for returning factory instances.
  *
  * @author Rosanna Lee
  * @author Scott Seligman
 */

// no need to implement Enumeration since this is only for internal use
public final class FactoryEnumeration {
    // List<NamedWeakReference<Class | Object>>
    private List<NamedWeakReference<Object>> factories;
    private int posn = 0;
    private ClassLoader loader;

    /**
     * Records the input list and uses it directly to satisfy
     * hasMore()/next() requests. An alternative would have been to use
     * an enumeration/iterator from the list, but we want to update the
     * list so we keep the
     * original list. The list initially contains Class objects.
     * As each element is used, the Class object is replaced by an
     * instance of the Class itself; eventually, the list contains
     * only a list of factory instances and no more updates are required.
     *
     * <p> Both Class objects and factories are wrapped in weak
     * references so as not to prevent GC of the class loader.  Each
     * weak reference is tagged with the factory's class name so the
     * class can be reloaded if the reference is cleared.
     *
     * @param factories A non-null list
     * @param loader    The class loader of the list's contents
     *
     * This internal method is used with Thread Context Class Loader (TCCL),
     * please don't expose this method as public.
     */
    FactoryEnumeration(List<NamedWeakReference<Object>> factories,
                       ClassLoader loader) {
        this.factories = factories;
        this.loader = loader;
    }

    public Object next() throws NamingException {
        synchronized (factories) {

            NamedWeakReference<Object> ref = factories.get(posn++);
            Object answer = ref.get();
            if ((answer != null) && !(answer instanceof Class)) {
                return answer;
            }

            String className = ref.getName();

            try {
                if (answer == null) {   // reload class if weak ref cleared
                    Class<?> cls = Class.forName(className, true, loader);
                    answer = cls;
                }
                // Instantiate Class to get factory
                answer = ((Class) answer).newInstance();
                ref = new NamedWeakReference<>(answer, className);
                factories.set(posn-1, ref);  // replace Class object or null
                return answer;
            } catch (ClassNotFoundException e) {
                NamingException ne =
                    new NamingException("No longer able to load " + className);
                ne.setRootCause(e);
                throw ne;
            } catch (InstantiationException e) {
                NamingException ne =
                    new NamingException("Cannot instantiate " + answer);
                ne.setRootCause(e);
                throw ne;
            } catch (IllegalAccessException e) {
                NamingException ne = new NamingException("Cannot access " + answer);
                ne.setRootCause(e);
                throw ne;
            }
        }
    }

    public boolean hasMore() {
        synchronized (factories) {
            return posn < factories.size();
        }
    }
}
