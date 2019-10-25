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
 * This class represents the string form of the address of
 * a communications end-point.
 * It consists of a type that describes the communication mechanism
 * and a string contents specific to that communication mechanism.
 * The format and interpretation of
 * the address type and the contents of the address are based on
 * the agreement of three parties: the client that uses the address,
 * the object/server that can be reached using the address, and the
 * administrator or program that creates the address.
 *
 * <p> An example of a string reference address is a host name.
 * Another example of a string reference address is a URL.
 *
 * <p> A string reference address is immutable:
 * once created, it cannot be changed.  Multithreaded access to
 * a single StringRefAddr need not be synchronized.
 *
 * @author Rosanna Lee
 * @author Scott Seligman
 *
 * @see RefAddr
 * @see BinaryRefAddr
 * @since 1.3
 */

public class StringRefAddr extends RefAddr {
    /**
     * Contains the contents of this address.
     * Can be null.
     * @serial
     */
    private String contents;
    /**
      * Constructs a new instance of StringRefAddr using its address type
      * and contents.
      *
      * @param addrType A non-null string describing the type of the address.
      * @param addr The possibly null contents of the address in the form of a string.
      */
    public StringRefAddr(String addrType, String addr) {
        super(addrType);
        contents = addr;
    }

    /**
      * Retrieves the contents of this address. The result is a string.
      *
      * @return The possibly null address contents.
      */
    public Object getContent() {
        return contents;
    }

    /**
     * Use serialVersionUID from JNDI 1.1.1 for interoperability
     */
    private static final long serialVersionUID = -8913762495138505527L;
}
