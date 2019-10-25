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
package javax.swing;

import java.awt.*;
import java.awt.event.*;
import java.beans.*;
import java.util.Set;


/**
 * Provides a javax.swing.DefaultFocusManager view onto an arbitrary
 * java.awt.KeyboardFocusManager. We subclass DefaultFocusManager instead of
 * FocusManager because it seems more backward-compatible. It is likely that
 * some pre-1.4 code assumes that the object returned by
 * FocusManager.getCurrentManager is an instance of DefaultFocusManager unless
 * set explicitly.
 */
final class DelegatingDefaultFocusManager extends DefaultFocusManager {
    private final KeyboardFocusManager delegate;

    DelegatingDefaultFocusManager(KeyboardFocusManager delegate) {
        this.delegate = delegate;
        setDefaultFocusTraversalPolicy(gluePolicy);
    }

    KeyboardFocusManager getDelegate() {
        return delegate;
    }

    // Legacy methods which first appeared in javax.swing.FocusManager.
    // Client code is most likely to invoke these methods.

    public void processKeyEvent(Component focusedComponent, KeyEvent e) {
        delegate.processKeyEvent(focusedComponent, e);
    }
    public void focusNextComponent(Component aComponent) {
        delegate.focusNextComponent(aComponent);
    }
    public void focusPreviousComponent(Component aComponent) {
        delegate.focusPreviousComponent(aComponent);
    }

    // Make sure that we delegate all new methods in KeyboardFocusManager
    // as well as the legacy methods from Swing. It is theoretically possible,
    // although unlikely, that a client app will treat this instance as a
    // new-style KeyboardFocusManager. We might as well be safe.
    //
    // The JLS won't let us override the protected methods in
    // KeyboardFocusManager such that they invoke the corresponding methods on
    // the delegate. However, since client code would never be able to call
    // those methods anyways, we don't have to worry about that problem.

    public Component getFocusOwner() {
        return delegate.getFocusOwner();
    }
    public void clearGlobalFocusOwner() {
        delegate.clearGlobalFocusOwner();
    }
    public Component getPermanentFocusOwner() {
        return delegate.getPermanentFocusOwner();
    }
    public Window getFocusedWindow() {
        return delegate.getFocusedWindow();
    }
    public Window getActiveWindow() {
        return delegate.getActiveWindow();
    }
    public FocusTraversalPolicy getDefaultFocusTraversalPolicy() {
        return delegate.getDefaultFocusTraversalPolicy();
    }
    public void setDefaultFocusTraversalPolicy(FocusTraversalPolicy
                                               defaultPolicy) {
        if (delegate != null) {
            // Will be null when invoked from supers constructor.
            delegate.setDefaultFocusTraversalPolicy(defaultPolicy);
        }
    }
    public void
        setDefaultFocusTraversalKeys(int id,
                                     Set<? extends AWTKeyStroke> keystrokes)
    {
        delegate.setDefaultFocusTraversalKeys(id, keystrokes);
    }
    public Set<AWTKeyStroke> getDefaultFocusTraversalKeys(int id) {
        return delegate.getDefaultFocusTraversalKeys(id);
    }
    public Container getCurrentFocusCycleRoot() {
        return delegate.getCurrentFocusCycleRoot();
    }
    public void setGlobalCurrentFocusCycleRoot(Container newFocusCycleRoot) {
        delegate.setGlobalCurrentFocusCycleRoot(newFocusCycleRoot);
    }
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        delegate.addPropertyChangeListener(listener);
    }
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        delegate.removePropertyChangeListener(listener);
    }
    public void addPropertyChangeListener(String propertyName,
                                          PropertyChangeListener listener) {
        delegate.addPropertyChangeListener(propertyName, listener);
    }
    public void removePropertyChangeListener(String propertyName,
                                             PropertyChangeListener listener) {
        delegate.removePropertyChangeListener(propertyName, listener);
    }
    public void addVetoableChangeListener(VetoableChangeListener listener) {
        delegate.addVetoableChangeListener(listener);
    }
    public void removeVetoableChangeListener(VetoableChangeListener listener) {
        delegate.removeVetoableChangeListener(listener);
    }
    public void addVetoableChangeListener(String propertyName,
                                          VetoableChangeListener listener) {
        delegate.addVetoableChangeListener(propertyName, listener);
    }
    public void removeVetoableChangeListener(String propertyName,
                                             VetoableChangeListener listener) {
        delegate.removeVetoableChangeListener(propertyName, listener);
    }
    public void addKeyEventDispatcher(KeyEventDispatcher dispatcher) {
        delegate.addKeyEventDispatcher(dispatcher);
    }
    public void removeKeyEventDispatcher(KeyEventDispatcher dispatcher) {
        delegate.removeKeyEventDispatcher(dispatcher);
    }
    public boolean dispatchEvent(AWTEvent e) {
        return delegate.dispatchEvent(e);
    }
    public boolean dispatchKeyEvent(KeyEvent e) {
        return delegate.dispatchKeyEvent(e);
    }
    public void upFocusCycle(Component aComponent) {
        delegate.upFocusCycle(aComponent);
    }
    public void downFocusCycle(Container aContainer) {
        delegate.downFocusCycle(aContainer);
    }
}
