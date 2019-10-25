/*
 * Copyright (c) 1999, 2003, Oracle and/or its affiliates. All rights reserved.
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


package javax.management;


/**
 * The format of the string does not correspond to a valid ObjectName.
 *
 * @since 1.5
 */
public class MalformedObjectNameException extends OperationsException   {

    /* Serial version */
    private static final long serialVersionUID = -572689714442915824L;

    /**
     * Default constructor.
     */
    public MalformedObjectNameException() {
        super();
    }

    /**
     * Constructor that allows a specific error message to be specified.
     *
     * @param message the detail message.
     */
    public MalformedObjectNameException(String message) {
        super(message);
    }
}
