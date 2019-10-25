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

package javax.naming.directory;

import javax.naming.NamingException;

/**
  * This exception is thrown when attempting to access
  * an attribute that does not exist.
  * <p>
  * Synchronization and serialization issues that apply to NamingException
  * apply directly here.
  *
  * @author Rosanna Lee
  * @author Scott Seligman
  * @since 1.3
  */

public class NoSuchAttributeException extends NamingException {
    /**
     * Constructs a new instance of NoSuchAttributeException using
     * an explanation. All other fields are set to null.
     * @param   explanation     Additional detail about this exception. Can be null.
     * @see java.lang.Throwable#getMessage
     */
    public NoSuchAttributeException(String explanation) {
        super(explanation);
    }


    /**
     * Constructs a new instance of NoSuchAttributeException.
     * All fields are initialized to null.
     */
    public NoSuchAttributeException() {
        super();
    }

    /**
     * Use serialVersionUID from JNDI 1.1.1 for interoperability
     */
    private static final long serialVersionUID = 4836415647935888137L;
}
