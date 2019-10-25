/*
 * Copyright (c) 1996, 2004, Oracle and/or its affiliates. All rights reserved.
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

package java.rmi.server;

/**
 * An <code>Operation</code> contains a description of a Java method.
 * <code>Operation</code> objects were used in JDK1.1 version stubs and
 * skeletons. The <code>Operation</code> class is not needed for 1.2 style
 * stubs (stubs generated with <code>rmic -v1.2</code>); hence, this class
 * is deprecated.
 *
 * @since JDK1.1
 * @deprecated no replacement
 */
@Deprecated
public class Operation {
    private String operation;

    /**
     * Creates a new Operation object.
     * @param op method name
     * @deprecated no replacement
     * @since JDK1.1
     */
    @Deprecated
    public Operation(String op) {
        operation = op;
    }

    /**
     * Returns the name of the method.
     * @return method name
     * @deprecated no replacement
     * @since JDK1.1
     */
    @Deprecated
    public String getOperation() {
        return operation;
    }

    /**
     * Returns the string representation of the operation.
     * @deprecated no replacement
     * @since JDK1.1
     */
    @Deprecated
    public String toString() {
        return operation;
    }
}
