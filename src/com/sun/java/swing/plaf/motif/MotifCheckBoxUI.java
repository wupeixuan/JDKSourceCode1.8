/*
 * Copyright (c) 1997, 1998, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.java.swing.plaf.motif;

import sun.awt.AppContext;

import javax.swing.*;

import javax.swing.plaf.*;

import java.awt.*;

/**
 * MotifCheckBox implementation
 * <p>
 * <strong>Warning:</strong>
 * Serialized objects of this class will not be compatible with
 * future Swing releases.  The current serialization support is appropriate
 * for short term storage or RMI between applications running the same
 * version of Swing.  A future release of Swing will provide support for
 * long term persistence.
 *
 * @author Rich Schiavi
 */
public class MotifCheckBoxUI extends MotifRadioButtonUI {

    private static final Object MOTIF_CHECK_BOX_UI_KEY = new Object();

    private final static String propertyPrefix = "CheckBox" + ".";

    private boolean defaults_initialized = false;


    // ********************************
    //         Create PLAF
    // ********************************
    public static ComponentUI createUI(JComponent c) {
        AppContext appContext = AppContext.getAppContext();
        MotifCheckBoxUI motifCheckBoxUI =
                (MotifCheckBoxUI) appContext.get(MOTIF_CHECK_BOX_UI_KEY);
        if (motifCheckBoxUI == null) {
            motifCheckBoxUI = new MotifCheckBoxUI();
            appContext.put(MOTIF_CHECK_BOX_UI_KEY, motifCheckBoxUI);
        }
        return motifCheckBoxUI;
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
