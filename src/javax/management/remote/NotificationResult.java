/*
 * Copyright (c) 2003, 2013, Oracle and/or its affiliates. All rights reserved.
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

package javax.management.remote;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/**
 * <p>Result of a query for buffered notifications.  Notifications in
 * a notification buffer have positive, monotonically increasing
 * sequence numbers.  The result of a notification query contains the
 * following elements:</p>
 *
 * <ul>
 *
 * <li>The sequence number of the earliest notification still in
 * the buffer.
 *
 * <li>The sequence number of the next notification available for
 * querying.  This will be the starting sequence number for the next
 * notification query.
 *
 * <li>An array of (Notification,listenerID) pairs corresponding to
 * the returned notifications and the listeners they correspond to.
 *
 * </ul>
 *
 * <p>It is possible for the <code>nextSequenceNumber</code> to be less
 * than the <code>earliestSequenceNumber</code>.  This signifies that
 * notifications between the two might have been lost.</p>
 *
 * @since 1.5
 */
public class NotificationResult implements Serializable {

    private static final long serialVersionUID = 1191800228721395279L;

    /**
     * <p>Constructs a notification query result.</p>
     *
     * @param earliestSequenceNumber the sequence number of the
     * earliest notification still in the buffer.
     * @param nextSequenceNumber the sequence number of the next
     * notification available for querying.
     * @param targetedNotifications the notifications resulting from
     * the query, and the listeners they correspond to.  This array
     * can be empty.
     *
     * @exception IllegalArgumentException if
     * <code>targetedNotifications</code> is null or if
     * <code>earliestSequenceNumber</code> or
     * <code>nextSequenceNumber</code> is negative.
     */
    public NotificationResult(long earliestSequenceNumber,
                              long nextSequenceNumber,
                              TargetedNotification[] targetedNotifications) {
        validate(targetedNotifications, earliestSequenceNumber, nextSequenceNumber);
        this.earliestSequenceNumber = earliestSequenceNumber;
        this.nextSequenceNumber = nextSequenceNumber;
        this.targetedNotifications = (targetedNotifications.length == 0 ? targetedNotifications : targetedNotifications.clone());
    }

    /**
     * Returns the sequence number of the earliest notification still
     * in the buffer.
     *
     * @return the sequence number of the earliest notification still
     * in the buffer.
     */
    public long getEarliestSequenceNumber() {
        return earliestSequenceNumber;
    }

    /**
     * Returns the sequence number of the next notification available
     * for querying.
     *
     * @return the sequence number of the next notification available
     * for querying.
     */
    public long getNextSequenceNumber() {
        return nextSequenceNumber;
    }

    /**
     * Returns the notifications resulting from the query, and the
     * listeners they correspond to.
     *
     * @return the notifications resulting from the query, and the
     * listeners they correspond to.  This array can be empty.
     */
    public TargetedNotification[] getTargetedNotifications() {
        return targetedNotifications.length == 0 ? targetedNotifications : targetedNotifications.clone();
    }

    /**
     * Returns a string representation of the object.  The result
     * should be a concise but informative representation that is easy
     * for a person to read.
     *
     * @return a string representation of the object.
     */
    public String toString() {
        return "NotificationResult: earliest=" + getEarliestSequenceNumber() +
            "; next=" + getNextSequenceNumber() + "; nnotifs=" +
            getTargetedNotifications().length;
    }

    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        ois.defaultReadObject();
        try {
            validate(
                this.targetedNotifications,
                this.earliestSequenceNumber,
                this.nextSequenceNumber
            );

            this.targetedNotifications = this.targetedNotifications.length == 0 ?
                                            this.targetedNotifications :
                                            this.targetedNotifications.clone();
        } catch (IllegalArgumentException e) {
            throw new InvalidObjectException(e.getMessage());
        }
    }

    private long earliestSequenceNumber;
    private long nextSequenceNumber;
    private TargetedNotification[] targetedNotifications;

    private static void validate(TargetedNotification[] targetedNotifications,
                                 long earliestSequenceNumber,
                                 long nextSequenceNumber)
        throws IllegalArgumentException {
        if (targetedNotifications == null) {
            final String msg = "Notifications null";
            throw new IllegalArgumentException(msg);
        }

        if (earliestSequenceNumber < 0 || nextSequenceNumber < 0)
            throw new IllegalArgumentException("Bad sequence numbers");
        /* We used to check nextSequenceNumber >= earliestSequenceNumber
           here.  But in fact the opposite can legitimately be true if
           notifications have been lost.  */
    }
}
