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
  * This exception is thrown when attempting to destroy a context that
  * is not empty.
  *<p>
  * If the program wants to handle this exception in particular, it
  * should catch ContextNotEmptyException explicitly before attempting to
  * catch NamingException. For example, after catching ContextNotEmptyException,
  * the program might try to remove the contents of the context before
  * reattempting the destroy.
  * <p>
  * Synchronization and serialization issues that apply to NamingException
  * apply directly here.
  *
  * @author Rosanna Lee
  * @author Scott Seligman
  *
  * @see Context#destroySubcontext
  * @since 1.3
  */
public class ContextNotEmptyException extends NamingException {
    /**
     * Constructs a new instance of ContextNotEmptyException using an
     * explanation. All other fields default to null.
     *
     * @param   explanation     Possibly null string containing
     * additional detail about this exception.
     * @see java.lang.Throwable#getMessage
     */
    public ContextNotEmptyException(String explanation) {
        super(explanation);
    }

    /**
      * Constructs a new instance of ContextNotEmptyException with
      * all name resolution fields and explanation initialized to null.
      */
    public ContextNotEmptyException() {
        super();
    }

    /**
     * Use serialVersionUID from JNDI 1.1.1 for interoperability
     */
    private static final long serialVersionUID = 1090963683348219877L;
}
