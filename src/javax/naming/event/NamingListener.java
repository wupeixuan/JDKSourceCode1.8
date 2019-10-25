/*
 * Copyright (c) 1999, Oracle and/or its affiliates. All rights reserved.
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

package javax.naming.event;

/**
  * This interface is the root of listener interfaces that
  * handle <tt>NamingEvent</tt>s.
  * It does not make sense for a listener to implement just this interface.
  * A listener typically implements a subinterface of <tt>NamingListener</tt>,
  * such as <tt>ObjectChangeListener</tt> or <tt>NamespaceChangeListener</tt>.
  *<p>
  * This interface contains a single method, <tt>namingExceptionThrown()</tt>,
  * that must be implemented so that the listener can be notified of
  * exceptions that are thrown (by the service provider) while gathering
  * information about the events that they're interested in.
  * When this method is invoked, the listener has been automatically deregistered
  * from the <tt>EventContext</tt> with which it has registered.
  *<p>
  * For example, suppose a listener implements <tt>ObjectChangeListener</tt> and
  * registers with a <tt>EventContext</tt>.
  * Then, if the connection to the server is subsequently broken,
  * the listener will receive a <tt>NamingExceptionEvent</tt> and may
  * take some corrective action, such as notifying the user of the application.
  *
  * @author Rosanna Lee
  * @author Scott Seligman
  *
  * @see NamingEvent
  * @see NamingExceptionEvent
  * @see EventContext
  * @see EventDirContext
  * @since 1.3
  */
public interface NamingListener extends java.util.EventListener {
    /**
     * Called when a naming exception is thrown while attempting
     * to fire a <tt>NamingEvent</tt>.
     *
     * @param evt The nonnull event.
     */
    void namingExceptionThrown(NamingExceptionEvent evt);
}
