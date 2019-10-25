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
import javax.swing.plaf.basic.BasicLabelUI;
import javax.swing.plaf.ComponentUI;

/**
 * A Motif L&F implementation of LabelUI.
 * This merely sets up new default values in MotifLookAndFeel.
 * <p>
 * <strong>Warning:</strong>
 * Serialized objects of this class will not be compatible with
 * future Swing releases.  The current serialization support is appropriate
 * for short term storage or RMI between applications running the same
 * version of Swing.  A future release of Swing will provide support for
 * long term persistence.
 *
 * @author Amy Fowler
 */
public class MotifLabelUI extends BasicLabelUI
{
    private static final Object MOTIF_LABEL_UI_KEY = new Object();

    public static ComponentUI createUI(JComponent c) {
        AppContext appContext = AppContext.getAppContext();
        MotifLabelUI motifLabelUI =
                (MotifLabelUI) appContext.get(MOTIF_LABEL_UI_KEY);
        if (motifLabelUI == null) {
            motifLabelUI = new MotifLabelUI();
            appContext.put(MOTIF_LABEL_UI_KEY, motifLabelUI);
        }
        return motifLabelUI;
    }
}
