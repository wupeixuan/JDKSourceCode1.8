/*
 * Copyright (c) 2002, 2013, Oracle and/or its affiliates. All rights reserved.
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

package javax.swing.plaf.synth;

import javax.swing.plaf.basic.DefaultMenuLayout;
import javax.swing.JPopupMenu;
import java.awt.Container;
import java.awt.Dimension;

/**
 * {@inheritDoc}
 *
 * @author Georges Saab
 */

class SynthMenuLayout extends DefaultMenuLayout {
    public SynthMenuLayout(Container target, int axis) {
        super(target, axis);
    }

    public Dimension preferredLayoutSize(Container target) {
        if (target instanceof JPopupMenu) {
            JPopupMenu popupMenu = (JPopupMenu) target;
            popupMenu.putClientProperty(
                    SynthMenuItemLayoutHelper.MAX_ACC_OR_ARROW_WIDTH, null);
        }

        return super.preferredLayoutSize(target);
    }
}
