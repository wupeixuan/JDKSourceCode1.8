/*
 * Copyright (c) 1997, 2008, Oracle and/or its affiliates. All rights reserved.
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

package java.awt.dnd;

import java.util.EventObject;
import java.awt.dnd.DropTargetContext;

/**
 * The <code>DropTargetEvent</code> is the base
 * class for both the <code>DropTargetDragEvent</code>
 * and the <code>DropTargetDropEvent</code>.
 * It encapsulates the current state of the Drag and
 * Drop operations, in particular the current
 * <code>DropTargetContext</code>.
 *
 * @since 1.2
 *
 */

public class DropTargetEvent extends java.util.EventObject {

    private static final long serialVersionUID = 2821229066521922993L;

    /**
     * Construct a <code>DropTargetEvent</code> object with
     * the specified <code>DropTargetContext</code>.
     * <P>
     * @param dtc The <code>DropTargetContext</code>
     * @throws NullPointerException if {@code dtc} equals {@code null}.
     * @see #getSource()
     * @see #getDropTargetContext()
     */

    public DropTargetEvent(DropTargetContext dtc) {
        super(dtc.getDropTarget());

        context  = dtc;
    }

    /**
     * This method returns the <code>DropTargetContext</code>
     * associated with this <code>DropTargetEvent</code>.
     * <P>
     * @return the <code>DropTargetContext</code>
     */

    public DropTargetContext getDropTargetContext() {
        return context;
    }

    /**
     * The <code>DropTargetContext</code> associated with this
     * <code>DropTargetEvent</code>.
     *
     * @serial
     */
    protected DropTargetContext   context;
}
