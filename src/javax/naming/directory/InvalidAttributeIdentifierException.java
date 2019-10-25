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
  * This exception is thrown when an attempt is
  * made to add to create an attribute with an invalid attribute identifier.
  * The validity of an attribute identifier is directory-specific.
  * <p>
  * Synchronization and serialization issues that apply to NamingException
  * apply directly here.
  *
  * @author Rosanna Lee
  * @author Scott Seligman
  * @since 1.3
  */

public class InvalidAttributeIdentifierException extends NamingException {
    /**
     * Constructs a new instance of InvalidAttributeIdentifierException using the
     * explanation supplied. All other fields set to null.
     * @param   explanation     Possibly null string containing additional detail about this exception.
     * @see java.lang.Throwable#getMessage
     */
    public InvalidAttributeIdentifierException(String explanation) {
        super(explanation);
    }

    /**
      * Constructs a new instance of InvalidAttributeIdentifierException.
      * All fields are set to null.
      */
    public InvalidAttributeIdentifierException() {
        super();
    }

    /**
     * Use serialVersionUID from JNDI 1.1.1 for interoperability
     */
    private static final long serialVersionUID = -9036920266322999923L;
}
