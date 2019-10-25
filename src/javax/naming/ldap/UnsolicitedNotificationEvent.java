/*
 * Copyright (c) 1999, 2000, Oracle and/or its affiliates. All rights reserved.
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

package javax.naming.ldap;

/**
 * This class represents an event fired in response to an unsolicited
 * notification sent by the LDAP server.
 *
 * @author Rosanna Lee
 * @author Scott Seligman
 * @author Vincent Ryan
 *
 * @see UnsolicitedNotification
 * @see UnsolicitedNotificationListener
 * @see javax.naming.event.EventContext#addNamingListener
 * @see javax.naming.event.EventDirContext#addNamingListener
 * @see javax.naming.event.EventContext#removeNamingListener
 * @since 1.3
 */

public class UnsolicitedNotificationEvent extends java.util.EventObject {
    /**
     * The notification that caused this event to be fired.
     * @serial
     */
    private UnsolicitedNotification notice;

    /**
     * Constructs a new instance of <tt>UnsolicitedNotificationEvent</tt>.
     *
     * @param src The non-null source that fired the event.
     * @param notice The non-null unsolicited notification.
     */
    public UnsolicitedNotificationEvent(Object src,
        UnsolicitedNotification notice) {
        super(src);
        this.notice = notice;
    }


    /**
     * Returns the unsolicited notification.
     * @return The non-null unsolicited notification that caused this
     * event to be fired.
     */
    public UnsolicitedNotification getNotification() {
        return notice;
    }

    /**
     * Invokes the <tt>notificationReceived()</tt> method on
     * a listener using this event.
     * @param listener The non-null listener on which to invoke
     * <tt>notificationReceived</tt>.
     */
    public void dispatch(UnsolicitedNotificationListener listener) {
        listener.notificationReceived(this);
    }

    private static final long serialVersionUID = -2382603380799883705L;
}
