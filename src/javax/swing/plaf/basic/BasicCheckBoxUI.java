/*
 * Copyright (c) 1997, 2013, Oracle and/or its affiliates. All rights reserved.
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

import sun.awt.AppContext;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.plaf.*;
import java.io.Serializable;


/**
 * CheckboxUI implementation for BasicCheckboxUI
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
 * @author Jeff Dinkins
 */
public class BasicCheckBoxUI extends BasicRadioButtonUI {

    private static final Object BASIC_CHECK_BOX_UI_KEY = new Object();

    private final static String propertyPrefix = "CheckBox" + ".";

    // ********************************
    //            Create PLAF
    // ********************************
    public static ComponentUI createUI(JComponent b) {
        AppContext appContext = AppContext.getAppContext();
        BasicCheckBoxUI checkboxUI =
                (BasicCheckBoxUI) appContext.get(BASIC_CHECK_BOX_UI_KEY);
        if (checkboxUI == null) {
            checkboxUI = new BasicCheckBoxUI();
            appContext.put(BASIC_CHECK_BOX_UI_KEY, checkboxUI);
        }
        return checkboxUI;
    }

    public String getPropertyPrefix() {
        return propertyPrefix;
    }

}
