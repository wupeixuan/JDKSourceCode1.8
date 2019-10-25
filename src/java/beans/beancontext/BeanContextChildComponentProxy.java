/*
 * Copyright (c) 1998, 2002, Oracle and/or its affiliates. All rights reserved.
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

import java.awt.Component;

/**
 * <p>
 * This interface is implemented by
 * <code>BeanContextChildren</code> that have an AWT <code>Component</code>
 * associated with them.
 * </p>
 *
 * @author Laurence P. G. Cable
 * @since 1.2
 *
 * @see java.beans.beancontext.BeanContext
 * @see java.beans.beancontext.BeanContextSupport
 */

public interface BeanContextChildComponentProxy {

    /**
     * Gets the <code>java.awt.Component</code> associated with
     * this <code>BeanContextChild</code>.
     * @return the AWT <code>Component</code> associated with
     * this <code>BeanContextChild</code>
     */

    Component getComponent();
}
