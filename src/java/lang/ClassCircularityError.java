/*
 * Copyright (c) 1995, 2008, Oracle and/or its affiliates. All rights reserved.
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

package java.lang;

/**
 * Thrown when the Java Virtual Machine detects a circularity in the
 * superclass hierarchy of a class being loaded.
 *
 * @author     unascribed
 * @since      JDK1.0
 */
public class ClassCircularityError extends LinkageError {
    private static final long serialVersionUID = 1054362542914539689L;

    /**
     * Constructs a {@code ClassCircularityError} with no detail message.
     */
    public ClassCircularityError() {
        super();
    }

    /**
     * Constructs a {@code ClassCircularityError} with the specified detail
     * message.
     *
     * @param  s
     *         The detail message
     */
    public ClassCircularityError(String s) {
        super(s);
    }
}
