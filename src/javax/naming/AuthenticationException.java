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
  * This exception is thrown when an authentication error occurs while
  * accessing the naming or directory service.
  * An authentication error can happen, for example, when the credentials
  * supplied by the user program is invalid or otherwise fails to
  * authenticate the user to the naming/directory service.
  *<p>
  * If the program wants to handle this exception in particular, it
  * should catch AuthenticationException explicitly before attempting to
  * catch NamingException. After catching AuthenticationException, the
  * program could reattempt the authentication by updating
  * the resolved context's environment properties with the appropriate
  * appropriate credentials.
  * <p>
  * Synchronization and serialization issues that apply to NamingException
  * apply directly here.
  *
  * @author Rosanna Lee
  * @author Scott Seligman
  * @since 1.3
  */

public class AuthenticationException extends NamingSecurityException {
    /**
     * Constructs a new instance of AuthenticationException using the
     * explanation supplied. All other fields default to null.
     *
     * @param   explanation     A possibly null string containing
     *                          additional detail about this exception.
     * @see java.lang.Throwable#getMessage
     */
    public AuthenticationException(String explanation) {
        super(explanation);
    }

    /**
      * Constructs a new instance of AuthenticationException.
      * All fields are set to null.
      */
    public AuthenticationException() {
        super();
    }

    /**
     * Use serialVersionUID from JNDI 1.1.1 for interoperability
     */
    private static final long serialVersionUID = 3678497619904568096L;
}
