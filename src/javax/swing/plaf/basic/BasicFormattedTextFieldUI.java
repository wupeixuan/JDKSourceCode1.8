/*
 * Copyright (c) 2000, Oracle and/or its affiliates. All rights reserved.
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
package javax.swing.plaf.basic;

import javax.swing.*;
import javax.swing.plaf.ComponentUI;

/**
 * Provides the look and feel implementation for
 * <code>JFormattedTextField</code>.
 *
 * @since 1.4
 */
public class BasicFormattedTextFieldUI extends BasicTextFieldUI {
    /**
     * Creates a UI for a JFormattedTextField.
     *
     * @param c the formatted text field
     * @return the UI
     */
    public static ComponentUI createUI(JComponent c) {
        return new BasicFormattedTextFieldUI();
    }

    /**
     * Fetches the name used as a key to lookup properties through the
     * UIManager.  This is used as a prefix to all the standard
     * text properties.
     *
     * @return the name "FormattedTextField"
     */
    protected String getPropertyPrefix() {
        return "FormattedTextField";
    }
}
