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
  * This interface represents a builder that creates initial context factories.
  *<p>
  * The JNDI framework allows for different initial context implementations
  * to be specified at runtime.  An initial context is created using
  * an initial context factory. A program can install its own builder
  * that creates initial context factories, thereby overriding the
  * default policies used by the framework, by calling
  * NamingManager.setInitialContextFactoryBuilder().
  * The InitialContextFactoryBuilder interface must be implemented by
  * such a builder.
  *
  * @author Rosanna Lee
  * @author Scott Seligman
  *
  * @see InitialContextFactory
  * @see NamingManager#getInitialContext
  * @see NamingManager#setInitialContextFactoryBuilder
  * @see NamingManager#hasInitialContextFactoryBuilder
  * @see javax.naming.InitialContext
  * @see javax.naming.directory.InitialDirContext
  * @since 1.3
  */
public interface InitialContextFactoryBuilder {
    /**
      * Creates an initial context factory using the specified
      * environment.
      *<p>
      * The environment parameter is owned by the caller.
      * The implementation will not modify the object or keep a reference
      * to it, although it may keep a reference to a clone or copy.
      *
      * @param environment Environment used in creating an initial
      *                 context implementation. Can be null.
      * @return A non-null initial context factory.
      * @exception NamingException If an initial context factory could not be created.
      */
    public InitialContextFactory
        createInitialContextFactory(Hashtable<?,?> environment)
        throws NamingException;
}
