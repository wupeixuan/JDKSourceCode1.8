/*
 * Copyright (c) 1998, 2013, Oracle and/or its affiliates. All rights reserved.
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

package javax.swing.plaf.metal;

import sun.awt.AppContext;

import javax.swing.*;
import javax.swing.plaf.basic.BasicCheckBoxUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.plaf.*;
import java.io.Serializable;


/**
 * CheckboxUI implementation for MetalCheckboxUI
 * <p>
 * <strong>Warning:</strong>
 * Serialized objects of this class will not be compatible with
 * future Swing releases. The current serialization support is
 * appropriate for short term storage or RMI between applications running
 * the same version of Swing.  As of 1.4, support for long term storage
 * of all JavaBeans&trade;
 * has been added to the <code>java.beans</code> package.
 * Please see {@link java.beans.XMLEncoder}.
 *
 * @author Michael C. Albers
 *
 */
public class MetalCheckBoxUI extends MetalRadioButtonUI {

    // NOTE: MetalCheckBoxUI inherts from MetalRadioButtonUI instead
    // of BasicCheckBoxUI because we want to pick up all the
    // painting changes made in MetalRadioButtonUI.

    private static final Object METAL_CHECK_BOX_UI_KEY = new Object();

    private final static String propertyPrefix = "CheckBox" + ".";

    private boolean defaults_initialized = false;

    // ********************************
    //         Create PlAF
    // ********************************
    public static ComponentUI createUI(JComponent b) {
        AppContext appContext = AppContext.getAppContext();
        MetalCheckBoxUI checkboxUI =
                (MetalCheckBoxUI) appContext.get(METAL_CHECK_BOX_UI_KEY);
        if (checkboxUI == null) {
            checkboxUI = new MetalCheckBoxUI();
            appContext.put(METAL_CHECK_BOX_UI_KEY, checkboxUI);
        }
        return checkboxUI;
    }

    public String getPropertyPrefix() {
        return propertyPrefix;
    }

    // ********************************
    //          Defaults
    // ********************************
    public void installDefaults(AbstractButton b) {
        super.installDefaults(b);
        if(!defaults_initialized) {
            icon = UIManager.getIcon(getPropertyPrefix() + "icon");
            defaults_initialized = true;
        }
    }

    protected void uninstallDefaults(AbstractButton b) {
        super.uninstallDefaults(b);
        defaults_initialized = false;
    }

}
