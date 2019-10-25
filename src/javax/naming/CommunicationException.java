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
  * This exception is thrown when the client is
  * unable to communicate with the directory or naming service.
  * The inability to communicate with the service might be a result
  * of many factors, such as network partitioning, hardware or interface problems,
  * failures on either the client or server side.
  * This exception is meant to be used to capture such communication problems.
  * <p>
  * Synchronization and serialization issues that apply to NamingException
  * apply directly here.
  *
  * @author Rosanna Lee
  * @author Scott Seligman
  * @since 1.3
  */
public class CommunicationException extends NamingException {
    /**
     * Constructs a new instance of CommunicationException using the
     * arguments supplied.
     *
     * @param   explanation     Additional detail about this exception.
     * @see java.lang.Throwable#getMessage
     */
    public CommunicationException(String explanation) {
        super(explanation);
    }

    /**
      * Constructs a new instance of CommunicationException.
      */
    public CommunicationException() {
        super();
    }

    /**
     * Use serialVersionUID from JNDI 1.1.1 for interoperability
     */
    private static final long serialVersionUID = 3618507780299986611L;
}
