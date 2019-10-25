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
  * This class is thrown when an attempt is
  * made to add to an attribute a value that conflicts with the attribute's
  * schema definition.  This could happen, for example, if attempting
  * to add an attribute with no value when the attribute is required
  * to have at least one value, or if attempting to add more than
  * one value to a single valued-attribute, or if attempting to
  * add a value that conflicts with the syntax of the attribute.
  * <p>
  * Synchronization and serialization issues that apply to NamingException
  * apply directly here.
  *
  * @author Rosanna Lee
  * @author Scott Seligman
  * @since 1.3
  */

public class InvalidAttributeValueException extends NamingException {
    /**
     * Constructs a new instance of InvalidAttributeValueException using
     * an explanation. All other fields are set to null.
     * @param   explanation     Additional detail about this exception. Can be null.
     * @see java.lang.Throwable#getMessage
     */
    public InvalidAttributeValueException(String explanation) {
        super(explanation);
    }

    /**
      * Constructs a new instance of InvalidAttributeValueException.
      * All fields are set to null.
      */
    public InvalidAttributeValueException() {
        super();
    }

    /**
     * Use serialVersionUID from JNDI 1.1.1 for interoperability
     */
    private static final long serialVersionUID = 8720050295499275011L;
}
