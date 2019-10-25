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
import javax.management.Notification;

/**
 * <p>A (Notification, Listener ID) pair.</p>
 * <p>This class is used to associate an emitted notification
 *    with the listener ID to which it is targeted.</p>
 *
 * @since 1.5
 */
public class TargetedNotification implements Serializable {

    private static final long serialVersionUID = 7676132089779300926L;

// If we replace Integer with int...
//     /**
//      * <p>Constructs a <code>TargetedNotification</code> object.  The
//      * object contains a pair (Notification, Listener ID).
//      * The Listener ID identifies the client listener to which that
//      * notification is targeted. The client listener ID is one
//      * previously returned by the connector server in response to an
//      * <code>addNotificationListener</code> request.</p>
//      * @param notification Notification emitted from the MBean server.
//      * @param listenerID   The ID of the listener to which this
//      *        notification is targeted.
//      */
//     public TargetedNotification(Notification notification,
//                              int listenerID) {
//      this.notif = notification;
//      this.id = listenerID;
//     }

    /**
     * <p>Constructs a <code>TargetedNotification</code> object.  The
     * object contains a pair (Notification, Listener ID).
     * The Listener ID identifies the client listener to which that
     * notification is targeted. The client listener ID is one
     * previously returned by the connector server in response to an
     * <code>addNotificationListener</code> request.</p>
     * @param notification Notification emitted from the MBean server.
     * @param listenerID   The ID of the listener to which this
     *        notification is targeted.
     * @exception IllegalArgumentException if the <var>listenerID</var>
     *        or <var>notification</var> is null.
     */
    public TargetedNotification(Notification notification,
                                Integer listenerID) {
        validate(notification, listenerID);
        // If we replace integer with int...
        // this(notification,intValue(listenerID));
        this.notif = notification;
        this.id = listenerID;
    }

    /**
     * <p>The emitted notification.</p>
     *
     * @return The notification.
     */
    public Notification getNotification() {
        return notif;
    }

    /**
     * <p>The ID of the listener to which the notification is
     *    targeted.</p>
     *
     * @return The listener ID.
     */
    public Integer getListenerID() {
        return id;
    }

    /**
     * Returns a textual representation of this Targeted Notification.
     *
     * @return a String representation of this Targeted Notification.
     **/
    public String toString() {
        return "{" + notif + ", " + id + "}";
    }

    /**
     * @serial A notification to transmit to the other side.
     * @see #getNotification()
     **/
    private Notification notif;
    /**
     * @serial The ID of the listener to which the notification is
     *         targeted.
     * @see #getListenerID()
     **/
    private Integer id;
    //private final int id;

// Needed if we use int instead of Integer...
//     private static int intValue(Integer id) {
//      if (id == null) throw new
//          IllegalArgumentException("Invalid listener ID: null");
//      return id.intValue();
//     }

    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        ois.defaultReadObject();
        try {
            validate(this.notif, this.id);
        } catch (IllegalArgumentException e) {
            throw new InvalidObjectException(e.getMessage());
        }
    }

    private static void validate(Notification notif, Integer id) throws IllegalArgumentException {
        if (notif == null) {
            throw new IllegalArgumentException("Invalid notification: null");
        }
        if (id == null) {
            throw new IllegalArgumentException("Invalid listener ID: null");
        }
    }
}
