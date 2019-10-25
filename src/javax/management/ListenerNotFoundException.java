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
 * The specified MBean listener does not exist in the repository.
 *
 * @since 1.5
 */
public class ListenerNotFoundException extends OperationsException   {

    /* Serial version */
    private static final long serialVersionUID = -7242605822448519061L;

    /**
     * Default constructor.
     */
    public ListenerNotFoundException() {
        super();
    }

    /**
     * Constructor that allows a specific error message to be specified.
     *
     * @param message the detail message.
     */
    public ListenerNotFoundException(String message) {
        super(message);
    }

}
