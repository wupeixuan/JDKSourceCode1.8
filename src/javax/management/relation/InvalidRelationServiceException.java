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
 * This exception is raised when an invalid Relation Service is provided.
 *
 * @since 1.5
 */
public class InvalidRelationServiceException extends RelationException {

    /* Serial version */
    private static final long serialVersionUID = 3400722103759507559L;

    /**
     * Default constructor, no message put in exception.
     */
    public InvalidRelationServiceException() {
        super();
    }

    /**
     * Constructor with given message put in exception.
     *
     * @param message the detail message.
     */
    public InvalidRelationServiceException(String message) {
        super(message);
    }
}
