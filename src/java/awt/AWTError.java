/*
 * Copyright (c) 1995, 1997, Oracle and/or its affiliates. All rights reserved.
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

package java.awt;

/**
 * Thrown when a serious Abstract Window Toolkit error has occurred.
 *
 * @author      Arthur van Hoff
 */
public class AWTError extends Error {

    /*
     * JDK 1.1 serialVersionUID
     */
     private static final long serialVersionUID = -1819846354050686206L;

    /**
     * Constructs an instance of <code>AWTError</code> with the specified
     * detail message.
     * @param   msg   the detail message.
     * @since   JDK1.0
     */
    public AWTError(String msg) {
        super(msg);
    }
}
