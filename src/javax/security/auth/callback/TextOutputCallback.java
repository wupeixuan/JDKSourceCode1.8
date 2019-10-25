/*
 * Copyright (c) 1999, 2013, Oracle and/or its affiliates. All rights reserved.
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

package javax.security.auth.callback;

/**
 * <p> Underlying security services instantiate and pass a
 * {@code TextOutputCallback} to the {@code handle}
 * method of a {@code CallbackHandler} to display information messages,
 * warning messages and error messages.
 *
 * @see javax.security.auth.callback.CallbackHandler
 */
public class TextOutputCallback implements Callback, java.io.Serializable {

    private static final long serialVersionUID = 1689502495511663102L;

    /** Information message. */
    public static final int INFORMATION         = 0;
    /** Warning message. */
    public static final int WARNING             = 1;
    /** Error message. */
    public static final int ERROR               = 2;

    /**
     * @serial
     * @since 1.4
     */
    private int messageType;
    /**
     * @serial
     * @since 1.4
     */
    private String message;

    /**
     * Construct a TextOutputCallback with a message type and message
     * to be displayed.
     *
     * <p>
     *
     * @param messageType the message type ({@code INFORMATION},
     *                  {@code WARNING} or {@code ERROR}). <p>
     *
     * @param message the message to be displayed. <p>
     *
     * @exception IllegalArgumentException if {@code messageType}
     *                  is not either {@code INFORMATION},
     *                  {@code WARNING} or {@code ERROR},
     *                  if {@code message} is null,
     *                  or if {@code message} has a length of 0.
     */
    public TextOutputCallback(int messageType, String message) {
        if ((messageType != INFORMATION &&
                messageType != WARNING && messageType != ERROR) ||
            message == null || message.length() == 0)
            throw new IllegalArgumentException();

        this.messageType = messageType;
        this.message = message;
    }

    /**
     * Get the message type.
     *
     * <p>
     *
     * @return the message type ({@code INFORMATION},
     *                  {@code WARNING} or {@code ERROR}).
     */
    public int getMessageType() {
        return messageType;
    }

    /**
     * Get the message to be displayed.
     *
     * <p>
     *
     * @return the message to be displayed.
     */
    public String getMessage() {
        return message;
    }
}
