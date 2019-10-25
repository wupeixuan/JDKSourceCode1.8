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

import javax.naming.Name;

/**
 * This exception is thrown when a method
 * does not terminate within the specified time limit.
 * This can happen, for example, if the user specifies that
 * the method should take no longer than 10 seconds, and the
 * method fails to complete with 10 seconds.
 *
 * <p> Synchronization and serialization issues that apply to NamingException
 * apply directly here.
 *
 * @author Rosanna Lee
 * @author Scott Seligman
 *
 * @since 1.3
 */
public class TimeLimitExceededException extends LimitExceededException {
    /**
     * Constructs a new instance of TimeLimitExceededException.
     * All fields default to null.
     */
    public TimeLimitExceededException() {
        super();
    }

    /**
     * Constructs a new instance of TimeLimitExceededException
     * using the argument supplied.
     * @param explanation possibly null detail about this exception.
     * @see java.lang.Throwable#getMessage
     */
    public TimeLimitExceededException(String explanation) {
        super(explanation);
    }

    /**
     * Use serialVersionUID from JNDI 1.1.1 for interoperability
     */
    private static final long serialVersionUID = -3597009011385034696L;
}
