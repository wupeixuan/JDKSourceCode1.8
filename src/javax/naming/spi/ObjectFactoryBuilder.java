/*
 * Copyright (c) 1999, 2004, Oracle and/or its affiliates. All rights reserved.
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

package javax.naming.spi;

import java.util.Hashtable;
import javax.naming.NamingException;

 /**
  * This interface represents a builder that creates object factories.
  *<p>
  * The JNDI framework allows for object implementations to
  * be loaded in dynamically via <em>object factories</em>.
  * For example, when looking up a printer bound in the name space,
  * if the print service binds printer names to References, the printer
  * Reference could be used to create a printer object, so that
  * the caller of lookup can directly operate on the printer object
  * after the lookup.  An ObjectFactory is responsible for creating
  * objects of a specific type.  JNDI uses a default policy for using
  * and loading object factories.  You can override this default policy
  * by calling <tt>NamingManager.setObjectFactoryBuilder()</tt> with an ObjectFactoryBuilder,
  * which contains the program-defined way of creating/loading
  * object factories.
  * Any <tt>ObjectFactoryBuilder</tt> implementation must implement this
  * interface that for creating object factories.
  *
  * @author Rosanna Lee
  * @author Scott Seligman
  *
  * @see ObjectFactory
  * @see NamingManager#getObjectInstance
  * @see NamingManager#setObjectFactoryBuilder
  * @since 1.3
  */
public interface ObjectFactoryBuilder {
    /**
      * Creates a new object factory using the environment supplied.
      *<p>
      * The environment parameter is owned by the caller.
      * The implementation will not modify the object or keep a reference
      * to it, although it may keep a reference to a clone or copy.
      *
      * @param obj The possibly null object for which to create a factory.
      * @param environment Environment to use when creating the factory.
      *                 Can be null.
      * @return A non-null new instance of an ObjectFactory.
      * @exception NamingException If an object factory cannot be created.
      *
      */
    public ObjectFactory createObjectFactory(Object obj,
                                             Hashtable<?,?> environment)
        throws NamingException;
}
