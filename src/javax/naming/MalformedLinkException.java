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
  * This exception is thrown when a malformed link was encountered while
  * resolving or constructing a link.
  * <p>
  * Synchronization and serialization issues that apply to LinkException
  * apply directly here.
  *
  * @author Rosanna Lee
  * @author Scott Seligman
  *
  * @see LinkRef#getLinkName
  * @see LinkRef
  * @since 1.3
  */

public class MalformedLinkException extends LinkException {
    /**
      * Constructs a new instance of MalformedLinkException with an explanation
      * All the other fields are initialized to null.
      * @param  explanation     A possibly null string containing additional
      *                         detail about this exception.
      */
    public MalformedLinkException(String explanation) {
        super(explanation);
    }


    /**
      * Constructs a new instance of Malformed LinkException.
      * All fields are initialized to null.
      */
    public MalformedLinkException() {
        super();
    }

    /**
     * Use serialVersionUID from JNDI 1.1.1 for interoperability
     */
    private static final long serialVersionUID = -3066740437737830242L;
}
