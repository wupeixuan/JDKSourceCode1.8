/*
 * Copyright (c) 1997, 2013, Oracle and/or its affiliates. All rights reserved.
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

package java.awt.dnd;

/**
 * This exception is thrown by various methods in the java.awt.dnd package.
 * It is usually thrown to indicate that the target in question is unable
 * to undertake the requested operation that the present time, since the
 * underlying DnD system is not in the appropriate state.
 *
 * @since 1.2
 */

public class InvalidDnDOperationException extends IllegalStateException {

    private static final long serialVersionUID = -6062568741193956678L;

    static private String dft_msg = "The operation requested cannot be performed by the DnD system since it is not in the appropriate state";

    /**
     * Create a default Exception
     */

    public InvalidDnDOperationException() { super(dft_msg); }

    /**
     * Create an Exception with its own descriptive message
     * <P>
     * @param msg the detail message
     */

    public InvalidDnDOperationException(String msg) { super(msg); }

}
