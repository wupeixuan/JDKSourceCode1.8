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
  * This exception is thrown when no initial context implementation
  * can be created.  The policy of how an initial context implementation
  * is selected is described in the documentation of the InitialContext class.
  *<p>
  * This exception can be thrown during any interaction with the
  * InitialContext, not only when the InitialContext is constructed.
  * For example, the implementation of the initial context might lazily
  * retrieve the context only when actual methods are invoked on it.
  * The application should not have any dependency on when the existence
  * of an initial context is determined.
  * <p>
  * Synchronization and serialization issues that apply to NamingException
  * apply directly here.
  *
  * @author Rosanna Lee
  * @author Scott Seligman
  *
  * @see InitialContext
  * @see javax.naming.directory.InitialDirContext
  * @see javax.naming.spi.NamingManager#getInitialContext
  * @see javax.naming.spi.NamingManager#setInitialContextFactoryBuilder
  * @since 1.3
  */
public class NoInitialContextException extends NamingException {
    /**
      * Constructs an instance of NoInitialContextException.
      * All fields are initialized to null.
      */
    public NoInitialContextException() {
        super();
    }

    /**
      * Constructs an instance of NoInitialContextException with an
      * explanation. All other fields are initialized to null.
      * @param  explanation     Possibly null additional detail about this exception.
      * @see java.lang.Throwable#getMessage
      */
    public NoInitialContextException(String explanation) {
        super(explanation);
    }

    /**
     * Use serialVersionUID from JNDI 1.1.1 for interoperability
     */
    private static final long serialVersionUID = -3413733186901258623L;
}
