/*
 * Copyright (c) 1997, 1999, Oracle and/or its affiliates. All rights reserved.
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

package java.beans.beancontext;

import java.beans.beancontext.BeanContextMembershipEvent;

import java.util.EventListener;

/**
 * <p>
 * Compliant BeanContexts fire events on this interface when the state of
 * the membership of the BeanContext changes.
 * </p>
 *
 * @author      Laurence P. G. Cable
 * @since       1.2
 * @see         java.beans.beancontext.BeanContext
 */

public interface BeanContextMembershipListener extends EventListener {

    /**
     * Called when a child or list of children is added to a
     * <code>BeanContext</code> that this listener is registered with.
     * @param bcme The <code>BeanContextMembershipEvent</code>
     * describing the change that occurred.
     */
    void childrenAdded(BeanContextMembershipEvent bcme);

    /**
     * Called when a child or list of children is removed
     * from a <code>BeanContext</code> that this listener
     * is registered with.
     * @param bcme The <code>BeanContextMembershipEvent</code>
     * describing the change that occurred.
     */
    void childrenRemoved(BeanContextMembershipEvent bcme);
}
