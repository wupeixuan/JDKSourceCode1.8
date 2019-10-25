/*
 * Copyright (c) 1998, Oracle and/or its affiliates. All rights reserved.
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

package java.awt.print;

/**
 * The <code>PrinterAbortException</code> class is a subclass of
 * {@link PrinterException} and is used to indicate that a user
 * or application has terminated the print job while it was in
 * the process of printing.
 */

public class PrinterAbortException extends PrinterException {

    /**
     * Constructs a new <code>PrinterAbortException</code> with no
     * detail message.
     */
    public PrinterAbortException() {
        super();
    }

    /**
     * Constructs a new <code>PrinterAbortException</code> with
     * the specified detail message.
     * @param msg the message to be generated when a
     * <code>PrinterAbortException</code> is thrown
     */
    public PrinterAbortException(String msg) {
        super(msg);
    }

}
