/*
 * Copyright (c) 2000, Oracle and/or its affiliates. All rights reserved.
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

package javax.print;

/**
 * Class PrintException encapsulates a printing-related error condition that
 * occurred while using a Print Service instance. This base class
 * furnishes only a string description of the error. Subclasses furnish more
 * detailed information if applicable.
 *
 */
public class PrintException extends Exception {


    /**
     * Construct a print exception with no detail message.
     */
    public PrintException() {
        super();
    }

    /**
     * Construct a print exception with the given detail message.
     *
     * @param  s  Detail message, or null if no detail message.
     */
    public PrintException (String s) {
        super (s);
    }

    /**
     * Construct a print exception chaining the supplied exception.
     *
     * @param  e  Chained exception.
     */
    public PrintException (Exception e) {
        super ( e);
    }

    /**
     * Construct a print exception with the given detail message
     * and chained exception.
     * @param  s  Detail message, or null if no detail message.
     * @param  e  Chained exception.
     */
    public PrintException (String s, Exception e) {
        super (s, e);
    }

}
