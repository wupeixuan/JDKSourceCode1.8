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
 * The specified attribute does not exist or cannot be retrieved.
 *
 * @since 1.5
 */
public class AttributeNotFoundException extends OperationsException {

    /* Serial version */
    private static final long serialVersionUID = 6511584241791106926L;

    /**
     * Default constructor.
     */
    public AttributeNotFoundException() {
        super();
    }

    /**
     * Constructor that allows a specific error message to be specified.
     *
     * @param message detail message.
     */
    public AttributeNotFoundException(String message) {
        super(message);
    }

}
