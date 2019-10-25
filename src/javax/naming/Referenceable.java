/*
 * Copyright (c) 1999, Oracle and/or its affiliates. All rights reserved.
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

package javax.naming;

/**
  * This interface is implemented by an object that can provide a
  * Reference to itself.
  *<p>
  * A Reference represents a way of recording address information about
  * objects which themselves are not directly bound to the naming system.
  * Such objects can implement the Referenceable interface as a way
  * for programs that use that object to determine what its Reference is.
  * For example, when binding a object, if an object implements the
  * Referenceable interface, getReference() can be invoked on the object to
  * get its Reference to use for binding.
  *
  * @author Rosanna Lee
  * @author Scott Seligman
  * @author R. Vasudevan
  *
  * @see Context#bind
  * @see javax.naming.spi.NamingManager#getObjectInstance
  * @see Reference
  * @since 1.3
  */
public interface Referenceable {
    /**
      * Retrieves the Reference of this object.
      *
      * @return The non-null Reference of this object.
      * @exception NamingException If a naming exception was encountered
      *         while retrieving the reference.
      */
    Reference getReference() throws NamingException;
}
