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
  * Specifies the method that a listener of a <tt>NamingEvent</tt>
  * with event type of <tt>OBJECT_CHANGED</tt> must implement.
  *<p>
  * An <tt>OBJECT_CHANGED</tt> event type is fired when (the contents of)
  * an object has changed. This might mean that its attributes have been modified,
  * added, or removed, and/or that the object itself has been replaced.
  * How the object has changed can be determined by examining the
  * <tt>NamingEvent</tt>'s old and new bindings.
  *<p>
  * A listener interested in <tt>OBJECT_CHANGED</tt> event types must:
  *<ol>
  *
  *<li>Implement this interface and its method (<tt>objectChanged()</tt>)
  *<li>Implement <tt>NamingListener.namingExceptionThrown()</tt> so that
  * it will be notified of exceptions thrown while attempting to
  * collect information about the events.
  *<li>Register with the source using the source's <tt>addNamingListener()</tt>
  *    method.
  *</ol>
  * A listener that wants to be notified of namespace change events
  * should also implement the <tt>NamespaceChangeListener</tt>
  * interface.
  *
  * @author Rosanna Lee
  * @author Scott Seligman
  *
  * @see NamingEvent
  * @see NamespaceChangeListener
  * @see EventContext
  * @see EventDirContext
  * @since 1.3
  */
public interface ObjectChangeListener extends NamingListener {

    /**
     * Called when an object has been changed.
     *<p>
     * The binding of the changed object can be obtained using
     * <tt>evt.getNewBinding()</tt>. Its old binding (before the change)
     * can be obtained using <tt>evt.getOldBinding()</tt>.
     * @param evt The nonnull naming event.
     * @see NamingEvent#OBJECT_CHANGED
     */
    void objectChanged(NamingEvent evt);
}
