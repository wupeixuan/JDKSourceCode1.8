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
  * This exception is thrown when a context implementation does not support
  * the operation being invoked.
  * For example, if a server does not support the Context.bind() method
  * it would throw OperationNotSupportedException when the bind() method
  * is invoked on it.
  * <p>
  * Synchronization and serialization issues that apply to NamingException
  * apply directly here.
  *
  * @author Rosanna Lee
  * @author Scott Seligman
  * @since 1.3
  */

public class OperationNotSupportedException extends NamingException {
    /**
      * Constructs a new instance of OperationNotSupportedException.
      * All fields default to null.
      */
    public OperationNotSupportedException() {
        super();
    }

    /**
      * Constructs a new instance of OperationNotSupportedException using an
      * explanation. All other fields default to null.
      *
      * @param  explanation     Possibly null additional detail about this exception
      * @see java.lang.Throwable#getMessage
      */
    public OperationNotSupportedException(String explanation) {
        super(explanation);
    }

    /**
     * Use serialVersionUID from JNDI 1.1.1 for interoperability
     */
    private static final long serialVersionUID = 5493232822427682064L;
}
