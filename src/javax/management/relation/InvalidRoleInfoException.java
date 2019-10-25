/*
 * Copyright (c) 2000, 2003, Oracle and/or its affiliates. All rights reserved.
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

package javax.management.relation;

/**
 * This exception is raised when, in a role info, its minimum degree is greater
 * than its maximum degree.
 *
 * @since 1.5
 */
public class InvalidRoleInfoException extends RelationException {

    /* Serial version */
    private static final long serialVersionUID = 7517834705158932074L;

    /**
     * Default constructor, no message put in exception.
     */
    public InvalidRoleInfoException() {
        super();
    }

    /**
     * Constructor with given message put in exception.
     *
     * @param message the detail message.
     */
    public InvalidRoleInfoException(String message) {
        super(message);
    }
}
