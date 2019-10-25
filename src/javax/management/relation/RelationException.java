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

import javax.management.JMException;

/**
 * This class is the superclass of any exception which can be raised during
 * relation management.
 *
 * @since 1.5
 */
public class RelationException extends JMException {

    /* Serial version */
    private static final long serialVersionUID = 5434016005679159613L;

    /**
     * Default constructor, no message put in exception.
     */
    public RelationException() {
        super();
    }

    /**
     * Constructor with given message put in exception.
     *
     * @param message the detail message.
     */
    public RelationException(String message) {
        super(message);
    }
}
