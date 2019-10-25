/*
 * Copyright (c) 1997, 2007, Oracle and/or its affiliates. All rights reserved.
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

package java.awt.dnd.peer;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.DropTarget;
import java.awt.dnd.InvalidDnDOperationException;

/**
 * <p>
 * This interface is exposed by the underlying window system platform to
 * enable control of platform DnD operations
 * </p>
 *
 * @since 1.2
 *
 */

public interface DropTargetContextPeer {

    /**
     * update the peer's notion of the Target's actions
     */

    void setTargetActions(int actions);

    /**
     * get the current Target actions
     */

    int getTargetActions();

    /**
     * get the DropTarget associated with this peer
     */

    DropTarget getDropTarget();

    /**
     * get the (remote) DataFlavors from the peer
     */

    DataFlavor[] getTransferDataFlavors();

    /**
     * get an input stream to the remote data
     */

    Transferable getTransferable() throws InvalidDnDOperationException;

    /**
     * @return if the DragSource Transferable is in the same JVM as the Target
     */

    boolean isTransferableJVMLocal();

    /**
     * accept the Drag
     */

    void acceptDrag(int dragAction);

    /**
     * reject the Drag
     */

    void rejectDrag();

    /**
     * accept the Drop
     */

    void acceptDrop(int dropAction);

    /**
     * reject the Drop
     */

    void rejectDrop();

    /**
     * signal complete
     */

    void dropComplete(boolean success);

}
