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
import javax.naming.*;

/**
  * This interface represents a factory that creates an initial context.
  *<p>
  * The JNDI framework allows for different initial context implementations
  * to be specified at runtime.  The initial context is created using
  * an <em>initial context factory</em>.
  * An initial context factory must implement the InitialContextFactory
  * interface, which provides a method for creating instances of initial
  * context that implement the Context interface.
  * In addition, the factory class must be public and must have a public
  * constructor that accepts no arguments.
  *
  * @author Rosanna Lee
  * @author Scott Seligman
  *
  * @see InitialContextFactoryBuilder
  * @see NamingManager#getInitialContext
  * @see javax.naming.InitialContext
  * @see javax.naming.directory.InitialDirContext
  * @since 1.3
  */

public interface InitialContextFactory {
        /**
          * Creates an Initial Context for beginning name resolution.
          * Special requirements of this context are supplied
          * using <code>environment</code>.
          *<p>
          * The environment parameter is owned by the caller.
          * The implementation will not modify the object or keep a reference
          * to it, although it may keep a reference to a clone or copy.
          *
          * @param environment The possibly null environment
          *             specifying information to be used in the creation
          *             of the initial context.
          * @return A non-null initial context object that implements the Context
          *             interface.
          * @exception NamingException If cannot create an initial context.
          */
        public Context getInitialContext(Hashtable<?,?> environment)
            throws NamingException;
}
