/*
 * Copyright (c) 2000, 2007, Oracle and/or its affiliates. All rights reserved.
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

package javax.management.openmbean;

/**
 * This runtime exception is thrown to indicate that the <i>open type</i> of an <i>open data</i> value
 * is not the one expected.
 *
 *
 * @since 1.5
 */
public class InvalidOpenTypeException extends IllegalArgumentException {

    private static final long serialVersionUID = -2837312755412327534L;

    /** An InvalidOpenTypeException with no detail message.  */
    public InvalidOpenTypeException() {
        super();
    }

    /**
     * An InvalidOpenTypeException with a detail message.
     *
     * @param msg the detail message.
     */
    public InvalidOpenTypeException(String msg) {
        super(msg);
    }

}
