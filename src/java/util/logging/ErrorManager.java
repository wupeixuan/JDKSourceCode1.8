/*
 * Copyright (c) 2001, 2004, Oracle and/or its affiliates. All rights reserved.
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


package java.util.logging;

/**
 * ErrorManager objects can be attached to Handlers to process
 * any error that occurs on a Handler during Logging.
 * <p>
 * When processing logging output, if a Handler encounters problems
 * then rather than throwing an Exception back to the issuer of
 * the logging call (who is unlikely to be interested) the Handler
 * should call its associated ErrorManager.
 */

public class ErrorManager {
   private boolean reported = false;

    /*
     * We declare standard error codes for important categories of errors.
     */

    /**
     * GENERIC_FAILURE is used for failure that don't fit
     * into one of the other categories.
     */
    public final static int GENERIC_FAILURE = 0;
    /**
     * WRITE_FAILURE is used when a write to an output stream fails.
     */
    public final static int WRITE_FAILURE = 1;
    /**
     * FLUSH_FAILURE is used when a flush to an output stream fails.
     */
    public final static int FLUSH_FAILURE = 2;
    /**
     * CLOSE_FAILURE is used when a close of an output stream fails.
     */
    public final static int CLOSE_FAILURE = 3;
    /**
     * OPEN_FAILURE is used when an open of an output stream fails.
     */
    public final static int OPEN_FAILURE = 4;
    /**
     * FORMAT_FAILURE is used when formatting fails for any reason.
     */
    public final static int FORMAT_FAILURE = 5;

    /**
     * The error method is called when a Handler failure occurs.
     * <p>
     * This method may be overridden in subclasses.  The default
     * behavior in this base class is that the first call is
     * reported to System.err, and subsequent calls are ignored.
     *
     * @param msg    a descriptive string (may be null)
     * @param ex     an exception (may be null)
     * @param code   an error code defined in ErrorManager
     */
    public synchronized void error(String msg, Exception ex, int code) {
        if (reported) {
            // We only report the first error, to avoid clogging
            // the screen.
            return;
        }
        reported = true;
        String text = "java.util.logging.ErrorManager: " + code;
        if (msg != null) {
            text = text + ": " + msg;
        }
        System.err.println(text);
        if (ex != null) {
            ex.printStackTrace();
        }
    }
}
