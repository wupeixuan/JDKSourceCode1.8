/*
 * Copyright (c) 1998, 2006, Oracle and/or its affiliates. All rights reserved.
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


package com.sun.java.swing.plaf.windows;

import java.beans.PropertyChangeEvent;

import javax.swing.*;
import javax.swing.plaf.basic.*;

/**
 * Button Listener
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
public class WindowsButtonListener extends BasicButtonListener {
    public WindowsButtonListener(AbstractButton b) {
        super(b);
    }
    /*
     This class is currently not used, but exists in case customers
     were subclassing it.
     */
}
