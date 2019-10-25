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
  * This exception is thrown when a component of the name cannot be resolved
  * because it is not bound.
  * <p>
  * Synchronization and serialization issues that apply to NamingException
  * apply directly here.
  *
  * @author Rosanna Lee
  * @author Scott Seligman
  * @since 1.3
  */

public class NameNotFoundException extends NamingException {
    /**
     * Constructs a new instance of NameNotFoundException using the
     * explanation supplied. All other fields default to null.
     *
     * @param   explanation     Possibly null additional detail about
     *                          this exception.
     * @see java.lang.Throwable#getMessage
     */
    public NameNotFoundException(String explanation) {
        super(explanation);
    }

    /**
      * Constructs a new instance of NameNotFoundException.
      * all name resolution fields and explanation initialized to null.
      */
    public NameNotFoundException() {
        super();
    }

    /**
     * Use serialVersionUID from JNDI 1.1.1 for interoperability
     */
    private static final long serialVersionUID = -8007156725367842053L;
}
